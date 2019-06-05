/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: TestVelocity Author: 58pc Date: 2019/6/5 19:28 Description: History:
 * <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.person;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试模板〉
 *
 * @author 58pc
 * @create 2019/6/5
 * @backgroud
 * @since 1.0.0
 */
public class TestVelocity {

    String tempateStr =
        "#if($record.content.contains(\"蛋花便\")||$record.content.contains(\"绿色便\")||$record.content.contains(\"其他便\"))\n"
            + "true\n" + "#end";

    /***
     * 背景：萌芽日记想处理听过吧vm存放在数据库，对于不同category判断是否已经预警，所以在此吧velocity功能调试一遍以便以后用<br>
     * 功能描述： <br>
     * 
     * @author shawn
     * @date 2019/6/5
     * @param []
     * @return void
     */
    @Test
    public void testVelocityOutput() {
        VelocityEngine velocity = new VelocityEngine();

        Properties p = new Properties();
        p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH,
            "D:\\500-opensource-java\\J2seCodeExample\\learnApache\\src\\test\\java\\com\\person\\");
        velocity.init(p);

        Template template = velocity.getTemplate("ifelse.vm");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("content", "绿色便1122");
        VelocityContext context = new VelocityContext(data);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        String[] result = StringUtils.split(writer.toString(), ",");
        System.out.println("result=" + result.toString());
        /****
         * 1.2019-6-5不报错但是获取通过FileResourceLoader可以获取XXX.vm <br>
         * 2.FIXME writer.toString()结果没有执行出来<br>
         * 3.velocity 换成相对路径<br>
         */
    }
}
