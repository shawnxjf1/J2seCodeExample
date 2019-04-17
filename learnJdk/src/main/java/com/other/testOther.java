package com.other;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/ 写得很全面<br>
 *
 * http://www.infoq.com/cn/articles/java8-new-features-new-stream-api
 */

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

/**
 * Created by xujf on 2017/5/22.
 */
public class testOther {

    @Test
    public void testBooean() {
        if (Boolean.FALSE == false) {
            System.out.println("Boolean.FALSE == false 会自动拆装箱");
        }
    }

    public void test() {

    }

    /**
     * 写这个函数的目的：<br>
     * 背景： 对应js的encodeURIComponent （浏览器中console执行）， 注意要把这个的背景写出来<br>
     */
    @Test
    public void testUriEncode() {
        String url =
            "https%3A%2F%2Fwww.ceshi113.com%2Fopen%2Fsail%2Findex.html%3F_hash%3D%2Forder%2Fdetail%26orderId%3De6e26f700d63444393faa81900a4b5cf%26ea%3D55732";

        String fullUrl =
            "https://www.ceshi113.com/fs-er-biz/er/auth/connect?authType=2&context=55732&resourceUrl=https%3A%2F%2Fwww.ceshi113.com%2Fopen%2Fsail%2Findex.html%3F_hash%3D%2Forder%2Fdetail%26orderId%3De6e26f700d63444393faa81900a4b5cf%26ea%3D55732";

        try {
            String url1 = URLEncoder.encode(url, "UTF-8");

            String fullUrl1 = URLEncoder.encode(fullUrl, "UTF-8");
            System.out.println("url1111==" + url1);

            System.out.println("fullUrl1==" + fullUrl1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
