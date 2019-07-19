/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: TestFastDateFormat Author: 58pc Date: 2019/4/24 10:11 Description:
 * History: <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.person;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 58pc
 * @create 2019/4/24
 * @backgroud
 * @since 1.0.0
 */
public class TestFastDateFormat {

    public static void showCustom() {

        String pattern = "yyyy-MM-dd HH:mm:ss";

        final FastDateFormat df = FastDateFormat.getInstance(pattern);

        System.out.println(df.format(new Date()));

    }

    @Test
    public void showDateAndTime() {
        final FastDateFormat df =
            FastDateFormat.getDateTimeInstance(FastDateFormat.FULL, FastDateFormat.FULL, Locale.CANADA);
        System.out.println(df.format(new Date()));

    }

    @Test
    public void testFormatDate() {
        String formatedDate = DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.format(new Date());
        System.out.println("formatedDate=" + formatedDate);
    }

    public static void showDate() {
        final FastDateFormat df = FastDateFormat.getDateInstance(FastDateFormat.LONG, Locale.CHINA);

        System.out.println(df.format(new Date()));
    }
}
