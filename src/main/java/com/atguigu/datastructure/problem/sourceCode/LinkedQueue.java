package com.atguigu.datastructure.problem.sourceCode;

public class LinkedQueue {
    public static void main(String[] args) {
        LinQue queArr = new LinQue();
        queArr.put(new No(2));
        queArr.put(new No(7));
        queArr.put(new No(3));
        queArr.put(new No(1));
        queArr.put(new No(5));
        queArr.put(new No(9));

        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());
        System.out.println(queArr.get());

    }
}

class LinQue{
    private No head=new No(-1);
    private No tmp=head;

    private No pointer=head;
    public void put(No ele){
        tmp.next=ele;
        tmp=tmp.next;
//        pointer=pointer.next;
    }

    public int get(){
        int re=head.next.ele;
        head.next.ele=-1;
        head=head.next;
        return re;
    }
}

class No{
    public No(int ele){
        this.ele=ele;

    }
     int ele;
     No next=null;
}