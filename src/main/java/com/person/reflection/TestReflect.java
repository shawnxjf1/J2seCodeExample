package com.person.reflection;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

import java.lang.reflect.Proxy;
public class TestReflect {
	
	Logger log = LoggerFactory.getLogger(TestReflect.class);

	/**
	 * 测试invocation handler<br>
	 */
	@Test
	public void testInvokeHanler()
	{
		IUser realUser = new UserImpl("sun");	
		Handler hand = new Handler(realUser); 
		/**
		 * Proxy.newProxyInstance 的方法参数<br>
		 * loader the class loader to define the proxy class
         * @param   interfaces the list of interfaces for the proxy class
         *          to implement
          * @param   h the invocation handler to dispatch method invocations to
		 */
		IUser proxy = (IUser) Proxy.newProxyInstance(realUser.getClass().getClassLoader(), realUser.getClass().getInterfaces(), hand); 
		proxy.getName(); //这里进到具体的实现类去执行了<br>
		/**
		 * 2016年12月08日执行结果<br>
		 * before the function "getName"
         *   sun
         *  after the function "getName"
		 */
	}
	
	/**
	 *  As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
	 */
	@Test
	public void testClassRef()
	{
		log.info("class obj1" + TestReflect.class.hashCode());
		log.info("class obj2" + TestReflect.class.hashCode());
		/**
		 * hashCode是一样，所以地址也是同一个<br>
		 * 2016-12-01 19:20:14,764 INFO  main com.person.reflection.TestReflect class obj11963387170
2016-12-01 19:20:14,766 INFO  main com.person.reflection.TestReflect class obj21963387170
		 */
	}
	
	@Test
	public void testNewObj()
	{
		log.info("new TestReflect1" + new TestReflect());
		log.info("new TestReflect2" + new TestReflect());
		
		log.info("new TestReflect1.hashcode=" + new TestReflect().hashCode());
		log.info("new TestReflect2.hashcode=" + new TestReflect().hashCode());
		/**
		 * 执行结果:<br>
		 *2016-12-01 19:28:24,730 INFO  main com.person.reflection.TestReflect new TestReflect1com.person.reflection.TestReflect@2db0f6b2
2016-12-01 19:28:24,733 INFO  main com.person.reflection.TestReflect new TestReflect2com.person.reflection.TestReflect@3cd1f1c8
2016-12-01 19:28:24,733 INFO  main com.person.reflection.TestReflect new TestReflect1.hashcode=977993101
2016-12-01 19:28:24,734 INFO  main com.person.reflection.TestReflect new TestReflect2.hashcode=429313384
		 */
	}
	
	/**
	 * Returns a hash code for this string. The hash code for a
     * {@code String} object is computed as
     * <blockquote><pre>
     * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
	 */
	@Test
	public void testStringRef()
	{
		log.info("123456's hashcode:{}","123456".hashCode());

		log.info("123+456's hashcode:{}",("123"+"456").hashCode());
		/**
		 * 执行结果,地址都是一样的:<br>
		2016-12-01 19:26:33,802 INFO  main com.person.reflection.TestReflect 1450575459
2016-12-01 19:26:33,803 INFO  main com.person.reflection.TestReflect 1450575459
2016-12-01 19:26:33,803 INFO  main com.person.reflection.TestReflect 1450575459
		 */
	}
	
	/**
	 * 参考
	 * http://stackoverflow.com/questions/15078935/what-does-class-mean-in-java<br>
	 * When you write .class after a class name, it references the Class object that represents the given class.<br>
	 */
	@Test
	public void testClassAddress()
	{
		log.info("1.TestReflect.class=" + TestReflect.class.hashCode());
		log.info("2.TestReflect.class=" + TestReflect.class.hashCode());
		log.info("3.Handler.class=" + Handler.class.hashCode());
		
		log.info("4.TestReflect.class.getName=" + TestReflect.class.getName());
		
		log.info("5.(new TestReflect()).getClass().getName()=" + (new TestReflect()).getClass().getName());
		/**
		 * 2017-01-04
		 * 2017-01-04 13:13:09,183 INFO  main com.person.reflection.TestReflect 1.TestReflect.class=1645995473
		2017-01-04 13:13:09,184 INFO  main com.person.reflection.TestReflect 2.TestReflect.class=1645995473
		2017-01-04 13:13:09,185 INFO  main com.person.reflection.TestReflect 3.Handler.class=977993101
		
		2017-01-04 14:05:46,024 INFO  main com.person.reflection.TestReflect 4.TestReflect.class.getName=com.person.reflection.TestReflect
2017-01-04 14:05:46,024 INFO  main com.person.reflection.TestReflect 5.(new TestReflect()).getClass().getName()=com.person.reflection.TestReflect
		 */
	}

}
