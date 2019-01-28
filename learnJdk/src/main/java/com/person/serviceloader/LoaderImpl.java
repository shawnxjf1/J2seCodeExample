package com.person.serviceloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 徐建峰
 * @创建日期: 2018-05
 * @创建时间: 30 下午6:09
 */
public class LoaderImpl implements  ILoader {

    static private Logger log = LoggerFactory.getLogger(LoaderImpl.class);

    @Override
    public void doLoader()
    {
        log.info("service loaderImple,for classname:{}",LoaderImpl.class.getName());
    }
}
