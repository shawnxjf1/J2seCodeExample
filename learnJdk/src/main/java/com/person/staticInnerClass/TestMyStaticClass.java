package com.person.staticInnerClass;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/***
 * 背景：<br>
 * 功能描述： 1.FinalClass 有点像staticclass不能被new，直接使用<br>
 * 参考：http://stackoverflow.com/questions/7486012/static-classes-in-java <br>
 * 
 * @author shawn
 * @date 2019/4/17
 * @param
 * @return
 */
public class TestMyStaticClass {

    @Test
    public void testFinalClass() {
        MyFinalClass.setMyStaticMember(5);// MyFinalClass不能被实例化直接当做静态类相似情况来使用<br>
        // MyFinalClass x = new MyFinalClass(); // 编译报错-results in compile time error,MyStaticClass構造方法是private的
        System.out.println("Static value: " + MyFinalClass.getMyStaticMember());
        System.out.println("Value squared: " + MyFinalClass.squareMyStaticMember());
        //
    }

    @Test
    public void testStaticClass() {
        StaticClass.staticMapExample.put("message",
            "static class must be inner class,and the private member can be access by others");
    }

    private static class StaticClass {
        static {

        }
        private static Map<String, String> staticMapExample = new HashMap<>();
    }

}

// final class 被称做 top-level java class
// A top-level Java class mimicking static class behavior
final class MyFinalClass {
    private MyFinalClass() { // private constructor
        myStaticMember = 1;
    }

    // Make all the members and functions of the class static
    private static int myStaticMember;

    public static void setMyStaticMember(int val) {
        myStaticMember = val;
    }

    public static int getMyStaticMember() {
        return myStaticMember;
    }

    public static int squareMyStaticMember() {
        return myStaticMember * myStaticMember;
    }

}
