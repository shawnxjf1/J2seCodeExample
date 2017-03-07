package com.person.json;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;

public class JsonAnnotationPojo{
	
	@JsonProperty
	private String name;
	
	private String value;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	Logger logger = Logger.getLogger(JsonAnnotationPojo.class);
	
	/**
	 * FIXME json对于null 的属性 怎么不让它输出<br>
	 * 2016-11-04 测试结果是，如果this 的属性有null的同样输出了
	 * @return
	 */
	public String  toJson(Object o)
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(o);
		} catch (JsonProcessingException ex) {
			logger.error("Response.toJson exception", ex);
		}
		return null;
	}
	
//	public static  <T> T json2Obj(String jsonstr, Class<T> Type) {
//		try { 
//			ObjectMapper objectMapper = new ObjectMapper();
//
//			//允许类中缺少 json字符串中的字段
//			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);  
////	        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);  
//			return objectMapper.readValue(jsonstr, Type);
//		} catch (JsonGenerationException e) { 
//			e.printStackTrace();
//		} catch (JsonMappingException e) { 
//			e.printStackTrace();
//		} catch (IOException e) { 
//			e.printStackTrace();
//		}
//		return null;
//	}
}
