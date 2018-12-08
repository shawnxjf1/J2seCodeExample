package com.person.primitive;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xujf on 2017/11/2.
 */
public class TestDouble {

    /**
     * 1.对于 加减乘除运算 一定要用bigdecimal 而不能用double。<br>
     * 2.而对于http rest获取值可以使用 double。比如Doubl.parseDouble();
     */
    @Test
    public void testDoubleAdd()
    {
        double a = 55.57;
        double b = 55.89;
        double c = a + b;
        System.out.println("a+b=" + c);
        //a+b=111.46000000000001 运行结果如下：
    }

    @Test
    public void testNewBigdecimalWithDouble()
    {
        BigDecimal b = new BigDecimal(88.78);
        System.out.println("b={}" + b);
        //88.780000000000001136868377216160297393798828125

        double b1 = 99.78;
        System.out.println("b1=" + Double.toString(99.78));

    }

    @Test
    public void testNewBigDecimalWithString()
    {
        BigDecimal b = new BigDecimal("88.98");
        System.out.println("b={}" + b);
        // b=88.78，注意只有通过string 生成的对象才是精确的。
    }

    @Test
    public void testDoubleCompare()
    {
        System.out.println( "abc=" + (78.0000000008 - 78.0000000007));

        System.out.println( "def=" + (78.006 - 78.003));

    }


}
