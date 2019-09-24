package com.tree;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/6 12:46
 * @Description:
 */
public class TEST {
    public static void main (String[] args) {
        int x=1;
        do{
            x+=x;
            if(x==3)continue;
            if(x==5)break;
        }while (x>30);
        System.out.println(x);
    }
}


