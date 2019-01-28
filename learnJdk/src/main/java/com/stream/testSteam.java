package com.stream;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/   写得很全面<br>
 *
 * http://www.infoq.com/cn/articles/java8-new-features-new-stream-api
 */

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.util.UriEncoder;
import com.person.date.DateUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by xujf on 2017/5/22.
 */
public class testSteam {

    @Test
    public void testBooean()
    {
        System.out.println("nowTime=" + System.currentTimeMillis());

        System.out.println("nowTime1=" + DateUtil.calAddDays(new Date(),1).getTime());

        if (Boolean.FALSE == false) {
            System.out.println("abc..........................");
        }
    }

    /**
     * 对应js的encodeURIComponent （浏览器中console执行）
     */
    @Test
    public void testUriEncode() {
        String url = "https%3A%2F%2Fwww.ceshi113.com%2Fopen%2Fsail%2Findex.html%3F_hash%3D%2Forder%2Fdetail%26orderId%3De6e26f700d63444393faa81900a4b5cf%26ea%3D55732";

        String fullUrl = "https://www.ceshi113.com/fs-er-biz/er/auth/connect?authType=2&context=55732&resourceUrl=https%3A%2F%2Fwww.ceshi113.com%2Fopen%2Fsail%2Findex.html%3F_hash%3D%2Forder%2Fdetail%26orderId%3De6e26f700d63444393faa81900a4b5cf%26ea%3D55732";

        try {
            String url1 = URLEncoder.encode(url,"UTF-8");

            String fullUrl1 = URLEncoder.encode(fullUrl,"UTF-8");
            System.out.println("url1111==" + url1);

            System.out.println("fullUrl1==" + fullUrl1);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    /**
     * @Data
     * SubClass  extends SuperClass
     * {
     *
     * }
     * @Data
     * SuperClass
     * {
     *
     * }
     * //SubClass.toString() 不会把父类的变量输出出啦<br>
     */



}

