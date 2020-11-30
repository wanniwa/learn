package 数组;


import java.util.Arrays;

/**
 * @author wanniwa
 * @date 2018/7/31 15:30
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[][] a ={
                {1,2},
                {3,4,0},
                {5,6}
        };
        int[][] b = new int[3][];
        b[0] = new int[2];
        b[1] = new int[3];
        b[2] = new int[2];
        b[0][0] = 1;
        b[0][1] = 2;
        b[1][0] = 3;
        b[1][1] = 4;

        b[2][0] = 5;
        b[2][1] = 6;
        System.out.println(b[1][2]);

    }
}
