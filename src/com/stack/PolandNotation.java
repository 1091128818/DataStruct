package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/1 13:16
 * @Description:
 */
public class PolandNotation {
    public static void main (String[] args) {
        //先定义后缀表达式
        //（3+4）*5-6=>3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        //先将字符串放进数组
        //将数组传给一个方法
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rp" + rpnList);
        int res = calculate(rpnList);
        System.out.println(res);
    }

    //将后缀表达式存入数组
    public static List<String> getListString (String suffixExpression) {
        //分割字符串
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split
        ) {
            list.add(ele);
        }
        return list;
    }

    //运算
    public static int calculate (List<String> ls) {
        //创建栈
        Stack<String> stack = new Stack<String>();
        for (String item : ls
        ) {
            if (item.matches("\\d+")) {//\\d+表示[0—9]
                stack.push(item);
            } else {
                // pop出两个数，并运算， 再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}


