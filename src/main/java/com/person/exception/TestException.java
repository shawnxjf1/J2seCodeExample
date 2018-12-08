package com.person.exception;

import org.apache.commons.lang.ObjectUtils;

/**
 * Created by xujf on 2017/11/7.
 */
public class TestException {

    public void add()
    {
        throw new NullPointerException("空指针异常了");
    }

    public void callAdd()
    {
        try{
            add();;
        }catch (Exception e)
        {
            System.out.println("exception ...");
        }
    }

    public static void main(String args[]) {
       new  TestException().callAdd();
        System.out.println("Hello World!");
    }

}
