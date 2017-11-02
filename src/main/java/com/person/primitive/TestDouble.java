package com.person.primitive;

import org.junit.Test;

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
}
