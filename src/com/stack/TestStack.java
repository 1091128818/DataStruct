package com.stack;

import java.util.Stack;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/7/31 05:51
 * @Description:
 */
public class TestStack {
    public static void main (String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("yih");
        stack.add("fgd");
        stack.add("dd");
        stack.push("ddd");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
