package com.random;

public class PrimeTest {

    public  static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }

        //循环到平方根就可以了<br>
        int sqrt = (int) Math.sqrt(num);
        //过来的都是6x+1,6x+5的形式,这种形式肯定不能被2,3,6整除的.
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        printPrimeResult(8);
        printPrimeResult(5);
        printPrimeResult(11);
        printPrimeResult(13);
    }

    private static void printPrimeResult(int num)
    {
        System.out.println(num + "质数检测" +         isPrime(num));
    }
}
