package com.person.serviceloader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ServiceLoader;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 徐建峰
 * @创建日期: 2018-05
 * @创建时间: 30 下午6:11
 */
public class ServiceLoaderTest {

    Logger log = LoggerFactory.getLogger(ServiceLoaderTest.class);
    @Test
    public void testLoader()
    {
        ServiceLoader<ILoader> class1 = ServiceLoader.load(ILoader.class);
                for (ILoader iLoader :class1)
                {
                    iLoader.doLoader();
                }
        /**
         * 执行结果：<br>
         * 2018-05-30 18:41:00,754 INFO  main com.person.serviceloader.LoaderImpl service loaderImple,for classname:com.person.serviceloader.LoaderImpl
         * 2018-05-30 18:41:00,755 INFO  main com.person.serviceloader.LoaderImpl1 service loaderImple,for classname:com.person.serviceloader.LoaderImpl1
         */
    }
}
