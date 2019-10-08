package program;

import java.util.Scanner;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/9/27 10:09
 * @Description:
 */
public class fenjie {
    public static void fenjie(int n){
        int a = 2;
        while(n > a){
            if(n % a == 0){
                System.out.println(a);
                n = n / a;
            }else{
                a++;
            }
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fenjie(n);
    }
}
