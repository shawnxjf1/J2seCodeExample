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
        String decodeUrl1 = "2019-05-25+18%3A42%3A50";
        String decodeUrl2 = "2019-05-25+18%3A42%3A50";
        try {
            String fullUrl1 = URLDecoder.decode(decodeUrl1, "UTF-8");

            String fullUrl2 = URLDecoder.decode(decodeUrl2, "UTF-8");

            System.out.println("fullUrl1==" + fullUrl1);
            System.out.println("fullUrl1==" + fullUrl2);

            // --> http://selection.djtest.cn/selection/list

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // orderId=&babyId=&cateId=117&cateAlias=jaundicewatch_new&type=4&labels=lh%2Cyjh&content=%7B%22content%22%3A%22%E4%BD%93%E6%B8%A938%E2%84%83%E4%BB%A5%E4%B8%8A%EF%BC%8C%E6%B5%81%E8%84%93%E3%80%81%E6%B8%97%E8%A1%80%E3%80%81%E6%B8%97%E6%B6%B2%E3%80%81%E5%BC%82%E5%91%B3%E3%80%81%E6%81%B6%E8%87%AD%E3%80%81%E5%97%9C%E7%9D%A1%E6%98%8E%E6%98%BE%E3%80%81%E4%B8%8D%E5%90%83%E5%A5%B6%E3%80%81%E7%BA%A2%E8%82%BF%E3%80%81%E5%87%BA%E8%A1%80%E5%A4%9A%22%2C%22booleanValue%22%3Atrue%2C%22val%22%3A0%2C%22time%22%3A%222019-05-29+18%3A07%22%7D
    @Test
    public void testUrlDecode2() {
        String decodeUrl1 =
            "orderId=&babyId=&cateId=117&cateAlias=jaundicewatch_new&type=4&labels=lh%2Cyjh&content=%7B%22content%22%3A%22%E4%BD%93%E6%B8%A938%E2%84%83%E4%BB%A5%E4%B8%8A%EF%BC%8C%E6%B5%81%E8%84%93%E3%80%81%E6%B8%97%E8%A1%80%E3%80%81%E6%B8%97%E6%B6%B2%E3%80%81%E5%BC%82%E5%91%B3%E3%80%81%E6%81%B6%E8%87%AD%E3%80%81%E5%97%9C%E7%9D%A1%E6%98%8E%E6%98%BE%E3%80%81%E4%B8%8D%E5%90%83%E5%A5%B6%E3%80%81%E7%BA%A2%E8%82%BF%E3%80%81%E5%87%BA%E8%A1%80%E5%A4%9A%22%2C%22booleanValue%22%3Atrue%2C%22val%22%3A0%2C%22time%22%3A%222019-05-29+18%3A07%22%7D";
        try {
            String fullUrl1 = URLDecoder.decode(decodeUrl1, "UTF-8");

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
