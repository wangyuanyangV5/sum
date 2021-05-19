package com.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 提示：
 * 1 <= n <= 8
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        builder.append("\"");
        List<StringBuilder> stringBuilders = addTwoKind(new LinkedList<>(),builder,n);
        return stringBuilders.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    private static List<StringBuilder> addTwoKind(LinkedList<String> list,StringBuilder builder,int n){
       if(n==0){
           while (!list.isEmpty()){
               list.removeLast();
               builder.append(")");
           }
           builder.append("\"");
           return Collections.singletonList(builder);
       }
        List<StringBuilder> results = new ArrayList<>();


       if(list.isEmpty()){
           list.addLast("(");
           builder.append("(");
           List<StringBuilder> tmpResults = addTwoKind(list,builder,n -1);
           results.addAll(tmpResults);
       }else {
            LinkedList<String> pullList = new LinkedList<>(list);
            StringBuilder pullBuilder = new StringBuilder(builder);
            pullList.removeLast();
            pullBuilder.append(")");
            List<StringBuilder> pullResults = addTwoKind(pullList,pullBuilder,n);

           LinkedList<String> putList = new LinkedList<>(list);
           StringBuilder putBuilder = new StringBuilder(builder);
           putList.addLast("(");
           putBuilder.append("(");
           List<StringBuilder> putResults = addTwoKind(putList,putBuilder,n - 1);
           results.addAll(pullResults);
           results.addAll(putResults);
       }
        return results;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("\"");
        System.out.println(addTwoKind(new LinkedList<>(),builder,4));
    }
}
