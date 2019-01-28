package com.person.Generic;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xujf on 2017/7/20.
 */
public class testGeneric {

    /**
     * Java泛型的目的是为了编译的时候校验，在编译阶段对于集合类似的元素的每个元素类型校验。
     * 防止写代码的时候调用了错误的方法而在运行的时候报错。
     */
    @Test
    public void testPrintGenericType()
    {
        ArrayList<String> arrayList1=new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass()==arrayList2.getClass());
        System.out.println("arrayList1=" + arrayList1.getClass());
        /**
         * true
         * arrayList1=class java.util.ArrayList,请注意打印出来的结果把泛型给去掉了。
         */
    }

    @Test
    public void testAddDiffType()
    {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(123);
        intList.add(456);
        //
        try {
            intList.getClass().getMethod("add", Object.class).invoke(intList,"ceshiString");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("intList=" + intList);
        //intList=[123, 456, ceshiString] 打印结果。
        //FIXME 参考：http://blog.csdn.net/lonelyroamer/article/details/7868820
    }

}
