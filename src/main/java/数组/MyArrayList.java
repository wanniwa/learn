package 数组;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wanniwa
 * @date 2018/7/30 16:27
 */
public class MyArrayList {
    /**
     * The value is used for character storage.
     */
    Object[] value;

    /**
     * The count is the number of characters used.
     */
    int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    size);
        }
        value = new Object[size];
    }

    //public static void main(String[] args) throws Exception {
    //    MyArrayList list = new MyArrayList(2);
    //    list.add("1");
    //    list.add(null);
    //    list.add("3");
    //    list.add("4");
    //    list.add("2");
    //    list.add("6");
    //
    //    System.out.println(Arrays.toString(list.toArray()));
    //}


    public static void main(String[] args) {
        HashMap<Long, List<Long>> ylMap = new HashMap<>();
        ylMap.put(1L, Arrays.asList(2L, 3L));
        ylMap.put(4L, Arrays.asList(1L));
        ylMap.put(1L, Arrays.asList(4L));
        List<Long> list = new ArrayList<>();

        list.add(2L);
        list.add(4L);
        list.add(1L);
        list.add(8L);
        list.add(7L);
        list.add(3L);


        sort(list, ylMap);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void sort(List<Long> result, Map<Long, List<Long>> ylMap) {
        List<DependencyEntity<Long>> entityList = new ArrayList<>(result.size());
        ylMap.forEach((reportId, dependencyNodeReportIds) -> {
            DependencyEntity.DependencyEntityBuilder<Long> builder = DependencyEntity.<Long>builder()
                    .node(reportId)
                    .dependencyNodeList(dependencyNodeReportIds)
                    .parent(new ArrayList<>())
                    .children(new ArrayList<>());
            entityList.add(builder.build());
        });

        generateDependencyRelation(Function.identity(), entityList);
        for (DependencyEntity<Long> dependencyEntity : entityList) {
            dependencyEntity.validateDependency(aLong -> true);
        }
        entityList.sort(Comparator.comparing(DependencyEntity::getOrder));
        List<Long> indexList = entityList.stream().map(DependencyEntity::getNode).collect(Collectors.toList());
        result.sort(Comparator.comparingInt(indexList::indexOf));
    }


    static <T, R> void generateDependencyRelation(Function<T, R> identityFunction, List<DependencyEntity<T>> dependencyEntityList) {
        Map<R, DependencyEntity<T>> entityMap = CommonUtils.toMap(target -> identityFunction.apply(target.getNode()), dependencyEntityList);
        for (DependencyEntity<T> dependencyEntity : dependencyEntityList) {
            if (dependencyEntity.isLeaf()) {
                continue;
            }
            List<T> dependencyNodeList = dependencyEntity.getDependencyNodeList();
            for (T node : dependencyNodeList) {
                R identity = identityFunction.apply(node);
                Optional.ofNullable(entityMap.get(identity)).ifPresent(target -> {
                            dependencyEntity.getChildren().add(target);
                            target.getParent().add(dependencyEntity);
                        }
                );
            }
        }
    }


    public void add(Object obj) {
        value[size] = obj;
        size++;
        if (size >= value.length) {
            //装不下扩容
            int newCapacity = value.length * 2;
            Object[] newList = new Object[newCapacity];
            //System.arraycopy();
            System.arraycopy(value, 0, newList, 0, value.length);
            value = newList;
        }
    }

    public Object get(int index) {
        rangeCheck(index);
        return value[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (value[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(value[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--)
                if (value[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (o.equals(value[i]))
                    return i;
        }
        return -1;
    }

    public Object[] toArray() {
        return Arrays.copyOf(value, size);
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public Object set(int index, Object obj) {
        rangeCheck(index);
        Object old = value[index];
        value[index] = obj;
        return old;
    }

}
