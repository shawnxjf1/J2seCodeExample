/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: SpringEventDemoTest Author: 58pc Date: 2019/4/26 20:26 Description:
 * History: <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.shawn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.shawn.springEventDemo.UserServiceNew;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;

/**
 * 〈一句话功能简述〉<br>
 * 〈spring事件demo〉
 *
 * @author 58pc
 * @create 2019/4/26
 * @backgroud
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnDependentBySpringBootApplication.class)
@ComponentScan(basePackages = {"com.shawn"})
@SpringBootConfiguration // 必须要加这个注解，貌似这个用于加载org.apache.ibatis.annotations.Mapper
public class SpringEventDemoTest {
    Log log = LogFactory.get();
    @Autowired
    UserServiceNew userServiceNew;

    @Test
    public void testUserRegister() {
        userServiceNew.register("xjf");
    }
}

/***
 ****
 * java.lang.IllegalStateException: Found multiple @SpringBootConfiguration annotated classes [Generic bean: class
 * [com.shawn.SpringEventDemoTest] 解决办法：@SpringBootTest()改成了@SpringBootTest(classes =
 * LearnDependentBySpringBootApplication.class)，要指定对哪一个springboot容器测试。
 */

// FIXME java.lang.NoClassDefFoundError: org/apache/ibatis/annotations/Mapper 执行测试用例错误<br>