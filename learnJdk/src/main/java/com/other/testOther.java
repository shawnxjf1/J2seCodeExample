package com.other;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/ 写得很全面<br>
 *
 * http://www.infoq.com/cn/articles/java8-new-features-new-stream-api
 */

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

    @Test
    public void testUrlDecode() {
        String decodeUrl = "http%3a%2f%2fselection.djtest.cn%2fselection%2flist";
        try {
            String fullUrl1 = URLDecoder.decode(decodeUrl, "UTF-8");

            System.out.println("fullUrl1==" + fullUrl1);
            // --> http://selection.djtest.cn/selection/list

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写这个函数的目的：<br>
     * 背景： 对应js的encodeURIComponent （浏览器中console执行）， 注意要把这个的背景写出来<br>
     */
    @Test
    public void testUriEncode() {
        String fullUrl = "http://babywatcher.djtest.cn/h5/user/write-daily";
        try {
            String fullUrl1 = URLEncoder.encode(fullUrl, "UTF-8");

            System.out.println("fullUrl1==" + fullUrl1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
