package com.person.string;

import org.junit.Test;

import com.model.JsonModel;

public class TestJson {
	
	/**
	 * MercWithdrawVO  .getReMark M是大写，json里传过来的是小写。
	 * json 对大小写也敏感,且jackson 转换是根据 getAttr()函数来决定的而不是根据attr决定的。<br>
	 * 默认情况下jackson 对attr 是大小写敏感的。<>
	 */
	@Test
	public void columConvert()
	{
		String jsonStr = "{\"id\":\"1\",\"Name\":\"2\"}";
		JsonModel req = JsonUtil.json2Obj(jsonStr, JsonModel.class);
		System.out.println("req=" + req);
		//2016-12-28 输出结果：req=JsonModel [id=1, name=null]，因为 name写成了Name<br>
	}

}
