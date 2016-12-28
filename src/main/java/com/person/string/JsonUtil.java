package com.person.string;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;



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
			//注意这有配置属性，可以觉得json的特性
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
	
}
