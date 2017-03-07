package com.person.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;

import com.sun.javafx.collections.MappingChange.Map;



public class JsonUtil {
	
//	@Resource
//	private ObjectMapper objectMapper; 

	private JsonUtil() {
	}

	
	public static  <T> String object2Json(T obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
//			objectMapper.setSerializationInclusion(Inclusion.NON_NULL);
			return objectMapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) { 
			e.printStackTrace();
		} catch (JsonMappingException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return "";
	}
	
	public static  <T> T json2Obj(String jsonstr, Class<T> Type) {
		try { 
			ObjectMapper objectMapper = new ObjectMapper();

			//允许类中缺少 json字符串中的字段
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);  
//	        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);  
			return objectMapper.readValue(jsonstr, Type);
		} catch (JsonGenerationException e) { 
			e.printStackTrace();
		} catch (JsonMappingException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static JsonNode getJsonTree()
	{
		String jsonStr1 = "response:{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":null}}";
		ObjectMapper objectMapper = new ObjectMapper();

		//允许类中缺少 json字符串中的字段
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);  
//        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);  
		try {
			return objectMapper.readTree(jsonStr1);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
