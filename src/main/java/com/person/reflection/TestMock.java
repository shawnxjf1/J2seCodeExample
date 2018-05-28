package com.person.reflection;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 徐建峰
 * @创建日期: 2018-05
 * @创建时间: 28 下午4:33
 */
public class TestMock {

    static Logger log = LoggerFactory.getLogger(TestReflect.class);


    public static Object generateMockData(Type c) {
        Object object = null;
        try {
            object = ((Class) c).newInstance();
        } catch (Exception e) {
            log.error("exception occure,", e);
        }
        Method[] methods = ((Class) c).getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                log.debug("method.getParameterTypes()[]:{},methodName:{}", method.getParameterTypes()[0].getName(), method.getName());

                //
                if (method.getParameterTypes()[0].getName().equals(Integer.class.getName())) {
                    try {
                        method.invoke(object, 12);
                    } catch (Exception e) {
                        log.debug("exception:{}", e);
                    }
                }

                if (method.getParameterTypes()[0].getName().equals(String.class.getName())) {
                    try {
                        method.invoke(object, "aa");
                    } catch (Exception e) {
                        log.debug("exception:{}", e);
                    }
                }

                //getName:  java.lang.String  BigInteger.class.getName():java.lang.BigInteger
                if (method.getParameterTypes()[0].getName().equals(BigInteger.class.getName())) {
                    try {
                        //method.invoke(workOrderCommentDto, 12345678);
                        method.invoke(object, new BigInteger("12345678"));
                    } catch (Exception e) {
                        log.debug("exception:method.getName:{}", method.getName(), e);
                    }
                }

                if (method.getParameterTypes()[0].getName().equals(List.class.getName())) {
                    try {
                        method.invoke(object, Lists.newArrayList("1", "2", "3"));
                    } catch (Exception e) {
                        log.debug("exception:{}", e);
                    }

                    Type[] entityClass = ((ParameterizedType) method.getGenericParameterTypes()[0]).getActualTypeArguments();
                    Type rawType = ((ParameterizedType) method.getGenericParameterTypes()[0]).getRawType();

                    log.info("generateMockData===entityClass:{},rawType:{}", entityClass, rawType);


                    //返回的是 method.getGenericParameterTypes()[0].getTypeName()为java.util.List<com.lumi.retail.web.dto.provideroutputorder.OutputOrderProductDto>
                    //method.getGenericParameterTypes()[0].equals(OutputOrderProductDto.class.getName());

                    try {
                        method.invoke(object, Lists.newArrayList(generateMockData(entityClass[0])));
                    } catch (Exception e) {
                        log.debug("exception:{}", e);
                    }
                }

            }
        }
        return object;
    }
}
