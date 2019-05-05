package com.test.wjq.collection;

/**
 *
 * 八皇后问题
 *
 * Created by wangjianqiang on 2019/3/24.
 */
public class EightQueen {

    //有几个皇后的问题
   static int num = 8;
   //记录有多少种结果
   static int count = 0;
    /**
     *
     * @param a 八皇后数组
\     * @param row 起始行数，从 0 开始
     *
     */
    public static void justDo(int[][] a,int row){
        //定义一个新的棋盘
        int[][] b = new int[num][num];
        for (int i = 0;i< num; i++){
            for (int j = 0 ; j < num;j++){
                b[i][j] = a[i][j];
            }
        }
        //问题结束，打印结果,到最后一行说明都没有冲突
        if (row == num){
            System.out.format("第%d种解决方法\n",++count);
            for (int i = 0 ; i < num ; i++){
                for (int j = 0 ; j < num;j++){
                    System.out.print(b[i][j] + " ");
                }
                System.out.println("");
            }
            return;

        }

        //问题没有结束，判断是否有冲突
        //这里循环是对当前行做的处理，可以想象一下第一行处理
        for (int j = 0 ;j< num;j++){
            if (!isDanger(a,j,row)){
                //这里将这一行置成0 是避免上一次失败过程赋值的处理
                for (int i = 0;i< num;i++){
                    b[row][i] = 0;
                }
                b[row][j] = 1;
                //如果没有冲突继续下一行处理
                justDo(b,row+1);
            }
        }

    }

    /**
     *
     * @param b    数组
     * @param j    当前列数
     * @param row  当前行数
     * @return
     */
    private static boolean isDanger(int[][] b, int j, int row) {

        int i,k;

        //上没有
        for ( k = 0; k < row; k++){
            if (b[k][j] == 1){
                return true;
            }
        }


        //下没有
        for (k = row + 1; k < num; k++){
            if (b[k][j] == 1){
                return true;
            }
        }


        //左没有
        for (i = 0; i < j; i++){
            if (b[row][i] == 1){
                return true;
            }
        }
        //右没有
        for (i = j + 1; i < num; i++){
            if (b[row][i] == 1){
                return true;
            }
        }

        //左上没有
        for (i = j -1,k=row -1;i>=0 && k>=0; i--,k--){
            if (b[k][i] == 1){
                return true;
            }
        }

        //右上没有

        for (i = j - 1 ,k= row +1;i>=0 && k<num; i--,k++){
            if (b[k][i] == 1){
                return true;
            }
        }

        //左下没有
        for (i = j + 1,k=row -1;i<num && k>=0; i++,k--){
            if (b[k][i] == 1){
                return true;
            }
        }

        //右下没有

        for (i = j +1,k=row +1;i<num && k<num; i++,k++){
            if (b[k][i] == 1){
                return true;
            }
        }
    return false;

    }


    public static void main(String[] args) {

        int[][] a  = new int[num][num];

        justDo(a,0);




    }


}
