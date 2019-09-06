package offer_pro.caculate;

/**
 * @Auther: 大哥的叔
 * @Date: 2019/8/8 16:33
 * @Description:，要实现一个一百亿的计算器，我们得自己 设计一个类可以用于表示很大的整数，并且提供了与另外一个整数进行加减乘除的功能，大
 * 概功能如下：
 * （1）这个类内部有两个成员变量，一个表示符号，另一个用字节数组表示数值的二进制数
 * （2）有一个构造方法，把一个包含有多位数值的字符串转换到内部的符号和字节数组中
 * （3）提供加减乘除的功能
 */

class BigInteger {
    int sign;
    byte[] val;

    public BigInteger (int sign, byte[] val) {
        this.sign = sign;
        this.val = val;
    }

}

public class Bigcaculate {
    public BigInteger add (BigInteger other) {
        return other;
    }

    public BigInteger subtract (BigInteger other) {
        return other;
    }

    public BigInteger multiply (BigInteger other) {
        return other;
    }

    public BigInteger divide (BigInteger other) {
        return other;
    }
}
