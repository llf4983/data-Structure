package com.atguigu.datastructure.problem.sourceCode;

public class MethodReplaceAll {
    public static void main(String[] args) {
        String str="Java,Java,Hello,World!";
        String nStr=str.replaceAll("Java","你好");
        System.out.println(nStr);
    }
}
