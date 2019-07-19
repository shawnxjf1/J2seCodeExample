/**
 * Copyright (C), 2015-2019, XXX有限公司 FileName: TestLong Author: 58pc Date: 2019/4/22 14:55 Description: History:
 * <author> <time> <version> <desc> 作者姓名 修改时间 版本号 描述
 */
package com.person;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 〈一句话功能简述〉<br>
 * 〈long 相关类型操作描述〉
 *
 * @author 58pc
 * @create 2019/4/22
 * @backgroud
 * @since 1.0.0
 */
public class TestNull {

    /***
     * 背景：本测试用例主要测试 for(null)是否抛出有异常，从而决定我们写代码要不要提前判断<br>
     *
     * 功能描述： <br>
     * 结果：如果结果可以看出for(null)会抛出异常，所以我们就有这样一条编码规范，如果函数返回没有结果且需要返回list类型那么直接返回Lists.emptyLsit()比null好<br>
     * 
     * @author shawn
     * @date 2019/4/22
     * @param []
     * @return void
     */
    @Test
    public void testForNull() {
        List<String> strList = new ArrayList<String>();
        for (String str : strList) {
            System.out.println("strList is empty");
        }

        strList = null;
        for (String str : strList) // 这里抛出错误了<br>
        {
            System.out.println("strList is null");
        }
        System.out.println("test is end");
    }
}
