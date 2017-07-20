package com.person.string;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;
import org.jboss.netty.util.internal.StringUtil;
import org.junit.Test;

public class TestStringFunc {



	@Test
	public void testSplit() {
		// 注意由于 | 为正则表达式 特殊字符 所以需要转义
		// & : 不需要转义（测试过）
		String[] strArrays = "TXNTIM:1".split("\\|");
		System.out.println(strArrays.toString());
	}


	/**
	 * subString()中无需考虑正则
	 */
	@Test
	public void testSubString() {
		String a = "[abc]"; // subString 这里[] 在正则中的特殊字符不考虑
		System.out.println(a.substring(1, a.length() - 1)); // 输出结果为abc
		// extends
		// to the character
		// at
		// index endIndex - 1.

		// Returns a string that is a substring of this string. The substring
		// begins at the specified beginIndex and extends to the character at
		// index endIndex - 1.
		// Thus the length of the substring is endIndex-beginIndex.
	}

	/**
	 * Concatenates the specified string to the end of this string.
	 * <p>
	 * If the length of the argument string is {@code 0}, then this
	 * {@code String} object is returned. Otherwise, a {@code String} object is
	 * returned that represents a character sequence that is the concatenation
	 * of the character sequence represented by this {@code String} object and
	 * the character sequence represented by the argument string.
	 * <p>
	 * Examples: <blockquote>
	 * 
	 * <pre>
	 * "cares".concat("s") returns "caress"
	 * "to".concat("get").concat("her") returns "together"
	 * </pre>
	 * 
	 * </blockquote>
	 *
	 * @param str
	 *            the {@code String} that is concatenated to the end of this
	 *            {@code String}.
	 * @return a string that represents the concatenation of this object's
	 *         characters followed by the string argument's characters.
	 */
	
	/**
	 * 2016年11月20日：
	 * true:("123456".startsWith("123")
	 * 
	 */
	@Test
	public void testStartWith()
	{
		System.out.println("123456".startsWith("123"));
	}

	/**
	 * public String concat(String str) { }
	 */

	@Test
	public void testReplace() {
		String name = "a.b.c";
		String path = name.replace('.', '/').concat("/");
		System.out.println("path=" + path); //path=a/b/c/
	}

	@Test
	public void testRunWithRepaceUrll()
	{
		//注意 public String replaceAll(String regex, String replacement)替换的是
		String upstreamUrl = "================\"$ORDERID$\"=========".replaceAll("\\$ORDERID\\$", "123");
		System.out.println("replaceAll-result=" + upstreamUrl);

		String abcUrl="==========\"$ORDERID$\"=========".replace("$ORDERID$", "1234");
		System.out.println("replace-result=" + abcUrl);

		/**
		 * 结果：
		 * replaceAll-result================="123"=========
		 replace-result==========="1234"=========
		 */
	}


	
	/**
	 * empty的含义就是什么字符都没有。
	 */
	@Test
	public void testStringEmpty()
	{
		System.out.println("' ' isBlank=" + StringUtils.isBlank(" "));
		System.out.println("' ' isEmpty=" +  StringUtils.isEmpty(" "));
		System.out.println("'' isBlank=" + StringUtils.isBlank(""));
		System.out.println("'' isEmpty=" +  StringUtils.isEmpty(""));
		/**
		 * 2016-12-20
		 *' ' isBlank=true 
		 *' ' isEmpty=false 
*'' isBlank=true
*'' isEmpty=true
		 */
		
		System.out.println("for null,'' isBlank=" + StringUtils.isBlank(null));
		System.out.println("for null,'' isEmpty=" +  StringUtils.isEmpty(null));
		/**
		 * 2017-02-10
		 * for null,'' isBlank=true
		 * for null,'' isEmpty=true
		 */

	}
	
	/**
	 * 注意占位符是 %s 不是{0}
	 */
	@Test
	public void testFormat()
	{
		String url = "http:localhost:8080?fq=%s";
		System.out.println("urlFormat=" + String.format(url, "TXNTIM:20160809"));
		//urlFormat=http:localhost:8080?fq=TXNTIM:20160809
	}
	
	@Test
	public void testEqual()
	{
		Student stu = new Student("01Name","01");
		Student stuBak = new Student("01Name","01");
		if (stu == stuBak)
		{
			System.out.println(String.format("new Stu%s == new Stu%s", "Student(\"01Name\",\"01\")","Student(\"01Name\",\"01\")"));
		}
		
		if (stu.equals(stuBak))
		{
			// return (this == obj)
			System.out.println(String.format("new Stu%s == new Stu%s", "Student(\"01Name\",\"01\")","Student(\"01Name\",\"01\")"));
		}
		
		if (stu.toString().equals(stuBak.toString()))
		{
			System.out.println("toString equal.");
		}
		System.out.println("输出地址1：stu.toString=" + stu.toString());
		System.out.println("输出地址2：stuBak.toString=" + stuBak.toString());
		//输出结果为：
//		stu.toString=com.person.string.TestStringFunc$Student@2fbac9d0
//		stuBak.toString=com.person.string.TestStringFunc$Student@10178f2b
	
		System.out.println("-----end--------");

	}
	
	/**
	 * 该函数可以用来判断 当前系统默认采用什么编码<br>
	 */
	@Test
	public void printSystemEncoding()
	{
		String str1 = "拉卡拉";
		byte [] byte1 = str1.getBytes();
		System.out.println("new String in default encoding=" + new String(byte1));
		try {
			System.out.println("new String in UTF-8 encoding=" + new String(byte1,"UTF-8"));
			System.out.println("new String in GBK encoding=" + new String(byte1,"GBK"));

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		/**
		 * 2017-02-24
		 *new String in default encoding=拉卡拉
new String in UTF-8 encoding=拉卡拉
new String in GBK encoding=鎷夊崱鎷�

		 */
		
	}
	
	/**
	 * String类的hashCode:<br>
	 *  public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
       }
	 * @author shawn
	 *
	 */
	
	class Student{
		String name;
		String id;
		Student(String name,String id)
		{
			this.name = name;
			this.id = id;
		}
		
		@Override
		public boolean equals(Object obj) {
			return super.equals(obj);
		}
	}

}
