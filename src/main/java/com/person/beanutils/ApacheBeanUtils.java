package com.person.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2018年05月26日 用例测试OK<br>
 */
public class ApacheBeanUtils {
    Logger log = LoggerFactory.getLogger(ApacheBeanUtils.class);

   public  class Source{
        private String auditTime;
        private String name;
        private int age;
        private String val;


        public String getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(String auditTime) {
            this.auditTime = auditTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Source{" +
                    "auditTime='" + auditTime + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", val='" + val + '\'' +
                    '}';
        }
    }

    public class Dest{
        private Date auditTime;
        private String name;
        private String age;
        private String val;


        public Date getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(Date auditTime) {
            this.auditTime = auditTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Dest{" +
                    "auditTime=" + auditTime +
                    ", name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", val='" + val + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ApacheBeanUtils{}";
    }

    @Test
    public void testCopyPropetes()
    {
        Source s = new Source();
        Dest d = new Dest();
        s.auditTime = "2018-05-06 08:09:05";
        s.age = 5;
        s.val = null;
        s.name = "demoName";

        d.val = "not null val";
        try {
            BeanUtils.copyProperties(d, s);
        }catch(Exception e)
        {
            log.error("error occure when copy properteis",e);
            //org.apache.commons.beanutils.ConversionException: DateConverter does not support default String to 'Date' conversion.报异常了
        }
        log.info("dest:{}",d); // com.person.beanutils.ApacheBeanUtils dest:Dest{auditTime=null}
        //不支持string 到date的转换。

    }

    @Test
    public void testCopyPropetes1WithConverteer()
    {
        Source s = new Source();
        Dest d = new Dest();
        s.auditTime = "2018-05-06 08:09:05";
        s.age = 5;
        s.val = null;
        s.name = "demoName";

        d.val = "demoval";

        try {
            ConvertUtils.register(new StringToDateConverter(),Date.class);
            BeanUtils.copyProperties(d, s);
        }catch(Exception e)
        {
            log.error("error occure when copy properteis",e);
        }
        log.info("dest:{}",d); // com.person.beanutils.ApacheBeanUtils dest:Dest{auditTime=null}

        //问题1：
        //不会进入convert，                    if (!"class".equals(name) && this.getPropertyUtils().isReadable(orig, name) && this.getPropertyUtils().isWriteable(dest, name)) {
        // isReadable 返回false，isWriteable返回false;
        // caused by因为MethodUtils.Modifier.isPublic(clazz.getModifiers()


        //解决办法：把Source,Dest类都加public 修饰符，再次执行该测试用例：
        //2018-05-26 15:56:43,845 INFO  main com.person.beanutils.ApacheBeanUtils dest:Dest{auditTime=Sun May 06 08:09:05 CST 2018, name='demoName', age='5', val='null'}
    }


    /**
     * 什么时候使用该convert？  BeanUtilsBean.convert(final Object value,final Class(?) type){
     *    Convert convert = getConvertUtils().lookup(type)//根据Dest 属性类型来查找convert在此情景下是查找Date auditTime来找convert。
     *     convert.convert(type,value).//所以遇到其他类型转Date类型都会使用该Convert，所以你重写时候请慎重。
     * }
     */
    class StringToDateConverter implements Converter{
        @Override
        public Object convert(Class aClass, Object o) {

            log.info("use convert,for o:{}",o);
            if (o == null)
            {
                return null;
            }

            if (!(o instanceof  String)){
                throw new ConversionException("只支持字符串转换");
            }

            String str = (String) o;
            if (str.trim().equals(""))
            {
                return  null;
            }

            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {
                return sd.parse(str);//必须要强制转化为T
            }catch(ParseException e)
            {
                throw new RuntimeException(e);
            }
        }
    }



    /**
     * 什么时候使用该convert？  BeanUtilsBean.convert(final Object value,final Class(?) type){
     *    Convert convert = getConvertUtils().lookup(type)//根据Dest 属性类型来查找convert在此情景下是查找Date auditTime来找convert。
     *     convert.convert(type,value).//所以遇到其他类型转Date类型都会使用该Convert，所以你重写时候请慎重。
     * }
     */
//    class StringToDateConverter1 extends AbstractConverter{
//        @Override
//        protected <T> T convertToType(Class<T> aClass, Object o) throws Throwable {
//            log.info("use convert,for o:{}",o);
//            if (o == null)
//            {
//                return null;
//            }
//
//            if (!(o instanceof  String)){
//                throw new ConversionException("只支持字符串转换");
//            }
//
//            String str = (String) o;
//            if (str.trim().equals(""))
//            {
//                return  null;
//            }
//
//            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//            try {
//                return sd.parse(str);//必须要强制转化为T
//            }catch(ParseException e)
//            {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    public class Source1{
        private Date nowDate;

        public Date getNowDate() {
            return nowDate;
        }

        public void setNowDate(Date nowDate) {
            this.nowDate = nowDate;
        }

        @Override
        public String toString() {
            return "Source1{" +
                    "nowDate=" + nowDate +
                    '}';
        }
    }

    public class Dest1{
        private Date nowDate;

        public Date getNowDate() {
            return nowDate;
        }

        public void setNowDate(Date nowDate) {
            this.nowDate = nowDate;
        }

        @Override
        public String toString() {
            return "Dest1{" +
                    "nowDate=" + nowDate +
                    '}';
        }
    }

    @Test
    public void testCopyDate()
    {
        Source1 s1 = new Source1();

        s1.nowDate = new Date();

        Dest1 d1 = new Dest1();

        ConvertUtils.register(new StringToDateConverter(),Date.class);

        try {
            BeanUtils.copyProperties(d1, s1);
        }catch (Exception e)
        {
            log.info("copyProperties.",e);
            throw new RuntimeException(e);
        }

        log.info("testCopyDate:{}",d1);
        /**
         * 执行结果：Caused by: org.apache.commons.beanutils.ConversionException: 只支持字符串转换
         at com.person.beanutils.ApacheBeanUtils$StringToDateConverter.convert(ApacheBeanUtils.java:195)
         所以我们写convert的时候一定要慎重，这里注册了date的convert导致source->dest同一类型的都copy不了了。
         */
    }



}
