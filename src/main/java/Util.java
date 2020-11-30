import java.math.BigDecimal;

/**
 * @author wanniwa
 * @date 2018/6/22 17:33
 */
public class Util {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(17) ;
        long d1 =System.currentTimeMillis();
        BigDecimal result = BigDecimal.ONE;
        while (a.compareTo(new BigDecimal(1))>0){
            result = result.multiply(a.multiply(a.subtract(BigDecimal.ONE)));
            a=a.subtract(new BigDecimal(2));
        }
        long d2 =System.currentTimeMillis();
        System.out.println("结果"+result);
        System.out.printf("耗时：%s",d2-d1);
    }
}
