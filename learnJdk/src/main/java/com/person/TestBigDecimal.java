package com.person;

import org.junit.Test;

import java.math.BigDecimal;

public class TestBigDecimal {

    @Test
    public void test1() {
        System.out.println(new BigDecimal("5"));
        System.out.println(new BigDecimal("5").negate());
        /**
         * 2016-12-08
         * 5
          -5
         */
    }

    @Test
    public void test2() {
        System.out.println(new BigDecimal(3));
        System.out.println(new BigDecimal(4).negate());
        /**
         * 2016-12-08
         *3
        -4
         */
    }

    @Test
    public void testDouble() {
        System.out.println("haa" + new BigDecimal(7.890));

    }

}
