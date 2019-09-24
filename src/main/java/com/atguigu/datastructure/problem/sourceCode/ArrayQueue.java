package com.atguigu.datastructure.problem.sourceCode;

public class ArrayQueue {
    public static void main(String[] args) {
        QueArr queArr = new QueArr();
        queArr.put(5);
        queArr.put(4);
        queArr.put(7);
        queArr.put(1);
        queArr.put(3);
        queArr.put(9);

        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
    }
}
class QueArr{
    private int[] i=new int[10];
    int index=0;
    int pointer=0;
    public void put(int ele){
        i[index]=ele;
        index++;
//        pointer=index;
    }

    public int get(){
        int re= i[pointer];
        index--;
        pointer++;
        return re;
    }
}