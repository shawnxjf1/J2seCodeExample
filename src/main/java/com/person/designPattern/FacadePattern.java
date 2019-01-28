package com.person.designPattern;


import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * @描述: 该模式的灵感来源于org.apache.commons.beanutils.converters.ConverterFacade<br>
 *  Provides a facade for {@link org.apache.commons.beanutils.Converter} implementations
 *  * preventing access to any public API in the implementation,
 *  * other than that specified by {@link Converter}.
 *  * <p />
 *  * This implementation can be used to prevent registered {@link Converter}
 *  * implementations that provide configuration options from being
 *  * retrieved and modified.
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 徐建峰
 * @创建日期: 2018-05
 * @创建时间: 30 下午8:20
 */
public class FacadePattern {

    private Logger log = LoggerFactory.getLogger(FacadePattern.class);

    public Map<Class,Converter>  registerMap = new HashMap();

    final class ConverterFacade implements Converter {

        private final Converter converter;

        /**
         * Construct a converter which delegates to the specified
         * {@link Converter} implementation.
         *
         * @param converter The converter to delegate to
         */
        public ConverterFacade(final Converter converter) {
            if (converter == null) {
                throw new IllegalArgumentException("Converter is missing");
            }
            this.converter = converter;
        }

        @Override
        public void convert()
        {
            converter.convert();
        }
    }

    interface Converter
    {
        public void convert();
    }

    /**
     * 1.由于convertFacade中的convert成员为final类型所以其基本不会被改变,所以当你get了之后不可能修改convert的config属性。<br>
     * 2.这种写法经常用于注册机制中。<br>比如注册一个convert,服务，防止别人获取你注册的服务对其配置属性进习惯你修改。<br>
     */
    public void main()
    {
        registerMap.put(Date.class,new ConverterFacade(new StringToDateConverter()));
        Converter t = registerMap.get(Date.class);
        t.convert();
    }

    class StringToDateConverter implements Converter {

        private String format;


        @Override
        public void convert() {
            log.info("convert name:{} is doing.",StringToDateConverter.class.getName());
        }

    }
}
