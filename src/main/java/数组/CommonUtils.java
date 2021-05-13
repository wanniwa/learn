package 数组;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * 通用工具类
 *
 * @author fly
 * Created on 2018/11/2.
 */
public interface CommonUtils {

    /**
     * 提取目标list转换成对应key值的map，保留value值中其中一个值
     *
     * @param function key值生成器
     * @param list     目标列表
     * @param <R>      参数R
     * @param <T>      参数T
     * @return 目标map
     */
    static <T, R> Map<R, T> toMap(Function<T, R> function, List<T> list) {
        Map<R, List<T>> listMap = group(function, list);
        Map<R, T> resultMap = new HashMap<>(listMap.size(), 1);
        for (Map.Entry<R, List<T>> entry : listMap.entrySet()) {
            resultMap.put(entry.getKey(), entry.getValue().get(0));
        }
        return resultMap;
    }

    /**
     * 将目标list转换成对应key值的map
     *
     * @param function key值生成器
     * @param list     目标列表
     * @param <R>      参数R
     * @param <T>      参数T
     * @return 目标map
     */
    static <T, R> Map<R, List<T>> group(Function<T, R> function, List<T> list) {
        return list.stream().collect(Collectors.groupingBy(function));
    }

    /**
     * 将目标list转换成对应key值的map
     *
     * @param predicate key值生成器
     * @param <T>       泛型参数
     * @param list      目标列表
     * @return 结果
     */
    static <T> Map<Boolean, List<T>> partition(Predicate<T> predicate, List<T> list) {
        return list.stream().collect(Collectors.partitioningBy(predicate));
    }

    /**
     * 根据指定字段去重
     *
     * @param function 函数
     * @param list     列表
     * @param <T>      泛型参数
     * @param <R>      泛型参数
     * @return 结果
     */
    static <T, R> Collection<T> distinct(Function<T, R> function, List<T> list) {
        return toMap(function, list).values();
    }

    /**
     * 将目标list转换成对应的list列表
     *
     * @param function 函数
     * @param list     列表
     * @param <T>      泛型参数
     * @param <R>      泛型参数
     * @return 结果
     */
    static <T, R> List<R> map(Function<T, R> function, Collection<T> list) {
        return list.stream().map(function).distinct().collect(Collectors.toList());
    }

    /**
     * 抽取列表集合中的列表
     *
     * @param list 列表集合
     * @param <T>  泛型参数
     * @return 结果
     */
    static <T> List<T> flatMap(Collection<List<T>> list) {
        return list.stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    /**
     * 抽取列表集合并平铺
     *
     * @param function 函数
     * @param list     集合列表
     * @param <T>      泛型参数
     * @param <R>泛型结果
     * @return 结果
     */
    static <T, R> List<R> flatMap(Function<T, List<R>> function, Collection<T> list) {
        return list.stream()
                .map(function)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    /**
     * 将目标list转换成对应的list列表
     *
     * @param function 函数
     * @param list     列表
     * @param <T>      泛型参数
     * @return 结果
     */
    static <T> List<T> operator(Function<T, T> function, List<T> list) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    /**
     * 过滤列表
     *
     * @param predicate 条件
     * @param list      列表
     * @param <T>       泛型参数
     * @return 结果
     */
    static <T> List<T> filter(Predicate<T> predicate, List<T> list) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * 连接字符串
     *
     * @param function  函数
     * @param list      列表
     * @param delimiter 分隔符
     * @param <T>       泛型参数
     * @return 结果
     */
    static <T> String join(Function<T, String> function, List<T> list, String delimiter) {
        return list.stream().map(function).collect(Collectors.joining(delimiter));
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param runnable 可运行函数
     * @return 是否发生异常
     */
    static boolean runStopWhenException(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            // ignore
            return false;
        }
        return true;
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param supplier 生产者
     * @param <T>      泛型参数
     * @return 成功返回值，失败null
     */
    static <T> T callStopWhenException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            // ignore
            return null;
        }
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param runnable 可运行函数
     * @param timeUnit 时间单位
     * @param timeout  超时时间
     * @return 是否发生异常
     */
    static boolean runStopWhenExceptionAndWait(Runnable runnable, TimeUnit timeUnit, long timeout) {
        try {
            runnable.run();
        } catch (Exception e) {
            try {
                timeUnit.sleep(timeout);
            } catch (InterruptedException e1) {
                // ignore
            }
            return false;
        }
        return true;
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param supplier 生产者
     * @param timeUnit 时间单位
     * @param timeout  超时时间
     * @param <T>      泛型参数
     * @return 结果
     */
    static <T> T callStopWhenExceptionAndWait(Supplier<T> supplier, TimeUnit timeUnit, long timeout) {
        try {
            return supplier.get();
        } catch (Exception e) {
            try {
                timeUnit.sleep(timeout);
            } catch (InterruptedException e1) {
                // ignore
            }
        }
        return null;
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param runnable 可运行函数
     * @param timeUnit 时间单位
     * @param timeout  超时时间
     */
    static void runTillDoneWhenException(Runnable runnable, TimeUnit timeUnit, long timeout) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (Exception e) {
                try {
                    timeUnit.sleep(timeout);
                } catch (InterruptedException e1) {
                    // ignore
                }
            }
        }
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param supplier 生产者
     * @param timeUnit 时间单位
     * @param timeout  超时时间
     * @param <T>      泛型参数
     * @return 结果
     */
    static <T> T callTillDoneWhenException(Supplier<T> supplier, TimeUnit timeUnit, long timeout) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                try {
                    timeUnit.sleep(timeout);
                } catch (InterruptedException e1) {
                    // ignore
                }
            }
        }
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param runnable 可运行函数
     * @param timeUnit 时间单位
     * @param timeout  超时时间
     * @param times    次数
     */
    static void runTillTimesWhenException(Runnable runnable, TimeUnit timeUnit, long timeout, int times) {
        while (times-- > 0) {
            try {
                runnable.run();
                break;
            } catch (Exception e) {
                try {
                    timeUnit.sleep(timeout);
                } catch (InterruptedException e1) {
                    // ignore
                }
            }
        }
    }

    /**
     * 执行业务逻辑异常处理
     *
     * @param supplier 生产者
     * @param timeUnit 时间单位
     * @param timeout  超时时间
     * @param times    次数
     * @param <T>      泛型参数
     * @return 结果
     */
    static <T> T callTillTimesWhenException(Supplier<T> supplier, TimeUnit timeUnit, long timeout, int times) {
        while (times-- > 0) {
            try {
                return supplier.get();
            } catch (Exception e) {
                try {
                    timeUnit.sleep(timeout);
                } catch (InterruptedException e1) {
                    // ignore
                }
            }
        }
        return null;
    }

    /**
     * 转换日期
     *
     * @param date 日期
     * @return 日期
     */
    static LocalDate converterDate(Date date) {
        return converterDateTime(date).toLocalDate();
    }

    /**
     * 转换时间
     *
     * @param date 日期
     * @return 结果
     */
    static LocalDateTime converterDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 转换日期
     *
     * @param localDateTime 时间
     * @return 结果
     */
    static Date converterLocalDateTime(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 是否超时
     *
     * @param target 目标超时时间
     * @return 结果
     */
    static boolean isOvertime(Date target) {
        return converterLocalDateTime(LocalDateTime.now()).after(target);
    }

    /**
     * 是否超时
     *
     * @param operator 目标时间
     * @return 结果
     */
    static boolean isOvertime(UnaryOperator<LocalDateTime> operator) {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(operator.apply(now));
    }

    /**
     * 是否超时
     *
     * @param target   目标时间
     * @param operator 目标时间操作
     * @return 结果
     */
    static boolean isOvertime(Date target, UnaryOperator<LocalDateTime> operator) {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(operator.apply(converterDateTime(target)));
    }

    /**
     * 对象转字符串
     *
     * @param o 对象
     * @return 结果
     */
    static String obj2str(Object o) {
        return o == null ? "" : String.valueOf(o);
    }


    /**
     * 比对目标字符是否在分隔字符中
     *
     * @param sourceStr 逗号分隔源字符串
     * @param targetStr 目标匹配字符串
     * @return 结果
     */
    static boolean matchSeparateStr(String sourceStr, String targetStr) {
        return Arrays.asList(StringUtils.split(sourceStr, ",")).contains(targetStr);
    }

}
