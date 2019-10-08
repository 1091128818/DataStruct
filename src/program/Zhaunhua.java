package program;

import java.util.Scanner;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/26 19:24
 * @Description:字符串转化char进行冒泡排序
 */

public class Zhaunhua {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        BubbleSort(c);
        str = str.valueOf(c);
        System.out.println(str);
    }


    public static void BubbleSort (char[] ch) {
        char temp = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            for (int x = 0; x < ch.length - 1 - i; x++) {
                if (ch[x] > ch[x + 1]) {
                    temp = ch[x + 1];
                    ch[x + 1] = ch[x];
                    ch[x] = temp;
                }
            }
        }
    }
}
