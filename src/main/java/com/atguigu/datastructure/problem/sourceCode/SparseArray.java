package com.atguigu.datastructure.problem.sourceCode;

public class SparseArray {
    public static void main(String[] args) {
        int[][] ele=new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0},
                {0,0,0,2,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,9,0,0},
                {0,0,0,0,0,0,0,0,0,0,0},
        };
        int[][] ints = TransFo(ele,ele.length*ele[0].length);
        for (int i=0;i<ints.length;i++){
            for(int j=0;j<ints[i].length;j++){
                System.out.print(ints[i][j]+"\t");
            }
            System.out.println();
        }


        int[][] rever = Rever(ints);
        for (int i=0;i<rever.length;i++){
            for(int j=0;j<rever[i].length;j++){
                System.out.print(rever[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[][] TransFo(int[][] ele,int size){
        int[][] rel=new int[size][3];
        rel[0][0] = ele.length;
        rel[0][1]=ele[0].length;
        int k=0;
        for (int i=0;i<ele.length;i++){
            for (int j=0;j<ele[i].length;j++){
                if(ele[i][j]!=0){
                    k++;
                    rel[k][0]=i;
                    rel[k][1]=j;
                    rel[k][2]=ele[i][j];
                }
            }
        }
        rel[0][2]=k;
        int[][] ints = new int[k + 1][3];
        for (int i=0;i<ints.length;i++){
            for (int j=0;j<ints[i].length;j++){
                ints[i][j]=rel[i][j];
            }
        }

        return ints;

    }


    public static int[][] Rever(int[][] ele){
        int row=ele[0][0];
        int col=ele[0][1];
        int[][] result = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = 0;
            }
        }

        for (int i=1;i<ele.length;i++){
            result[ele[i][0]][ele[i][1]]=ele[i][2];
        }
        return result;
    }
}
