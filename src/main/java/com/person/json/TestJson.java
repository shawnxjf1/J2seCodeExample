package com.person.json;

import java.util.Map;

import org.junit.Test;

public class TestJson {
	
   @Test
   public void testJson() {
		
		Map<String,String> jsonMap = JsonUtil.json2Obj("{buyAmt:125000,transTime:20170122182841}", Map.class);
		System.out.println("jsonMap=" + jsonMap);
		/**
		 * 报错字段一定要加""
		 */
		Map<String,String> jsonMap1 = JsonUtil.json2Obj("{\"buyAmt\":\"125000\",\"transTime\":\"20170122182841\"}", Map.class);
		System.out.println("jsonMap=" + jsonMap1);
		
		//2017-01-22 测试Ok-> jsonMap={buyAmt=125000, transTime=20170122182841}
	}
   
   /**
    * 这里测试= 在json中是不合适的<br>
    */
   @Test
   public void testJson2() {
		
		Map<String,String> jsonMap = JsonUtil.json2Obj("{\"buyAmt\"=\"125000\",\"transTime\"=\"20170122182841\"}", Map.class);
		System.out.println("jsonMap=" + jsonMap);
		/**
		 * org.codehaus.jackson.JsonParseException: Unexpected character ('=' (code 61)): was expecting a colon to separate field name and value
 at [Source: java.io.StringReader@6adede5; line: 1, column: 11]
	at org.codehaus.jackson.JsonParser._constructError(JsonParser.java:1433)
		 */
	}
   
   @Test
   public void testJson3()
   {
	   /**
	    * 如下场景解析都报错：
	    * 1.response 加了引号\"
	    * response:{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":null}}
	    * 2.null 加了引号\"
	    * 3.都加了引号
	    * 猜测的原因是有层级 {{}}
	    */
	   String jsonStr1 = "\"response\":{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":\"null\"}}";
	   Map<String,String> jsonMap1 = JsonUtil.json2Obj(jsonStr1, Map.class);
	   System.out.println("jsonMap1=" + jsonMap1);
   }
   
   
   @Test
   public void testJson4()
   {
	   String jsonStr1 = "{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":\"null\"}}";
	   Map<String,String> jsonMap1 = JsonUtil.json2Obj(jsonStr1, Map.class);
	   System.out.println("jsonMap1=" + jsonMap1);
	   /**
	    * 2017-03-07执行结果如下：多层级也是可以的，只是一定要{包围对}
	    * jsonMap1={data={systti=15:10:40, blncdn=C, brchqy=, success=null}}
	    */
	   
	   String jsonStr2 = "{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":null}}";
	   Map<String,String> jsonMap2 = JsonUtil.json2Obj(jsonStr1, Map.class);
	   System.out.println("jsonMap2=" + jsonMap2); 
	   /**
	    * 2017-03-07执行成功，null 的可以不被 "" 包围。
	    */
   }
   
   @Test
   public void testJsonAnnotation() {
		
		JsonAnnotationPojo jUtil = new JsonAnnotationPojo();
		jUtil.setName("xujianfneg");
		jUtil.setValue("hahaha");
		
		System.out.println("===" + JsonUtil.object2Json(jUtil));
		//2016-11-10 19:32:32 输出结果:==={"name":"xujianfneg"}  value 没有标记 jsonProperty 所以value不输出
	}

}
