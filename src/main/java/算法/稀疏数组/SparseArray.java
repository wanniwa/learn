package 算法.稀疏数组;

public class SparseArray {
    public static void main(String[] args) {
        int rows = 11;
        int cols = 11;
        int[][] chessArr1 = new int[rows][cols];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        printTwoDimensionalArray("原始的二位数组", chessArr1);
        //将二位数组转换为稀疏数组
        //1.先遍历二位数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = rows;
        sparseArr[0][1] = cols;
        sparseArr[0][2] = sum;
        //遍历二维数组，将非0的值存放到sparseArr
        int count = 1; //用于记录是第几个非0数组
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        //输出稀疏数组
        printTwoDimensionalArray("得到的稀疏数组为~~~~", sparseArr);

        //稀疏数组转原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        printTwoDimensionalArray("输出恢复后的二维数组", chessArr2);
    }

    /**
     * 打印int二维数组方法
     * @param name 输出名称
     * @param array 二维数组
     */
    public static void printTwoDimensionalArray(String name, int[][] array) {
        System.out.println(name);
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();
    }
}
