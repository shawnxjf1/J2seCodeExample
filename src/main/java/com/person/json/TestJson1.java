package com.person.json;

import java.util.Map;

import org.junit.Test;

public class TestJson1 {
	
   @Test
   public void testJson() {
		
		Map<String,String> jsonMap = JsonUtil.json2Obj("{buyAmt:125000,transTime:20170122182841}", Map.class);
		System.out.println("jsonMap=" + jsonMap);
	}
   
   
   @Test
   public void testJson1() {
		
		Map<String,String> jsonMap = JsonUtil.json2Obj("{\"buyAmt\":\"125000\",\"transTime\":\"20170122182841\"}", Map.class);
		System.out.println("jsonMap=" + jsonMap);
		
		//2017-01-22 测试Ok-> jsonMap={buyAmt=125000, transTime=20170122182841}
	}
   
   
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

}
