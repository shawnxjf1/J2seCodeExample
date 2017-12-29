package com.person.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class TestJson {

    @Test
    public void testJson() {

        Map<String, String> jsonMap = JsonUtil.json2Obj("{buyAmt:125000,transTime:20170122182841}", Map.class);
        System.out.println("jsonMap=" + jsonMap);
        /**
         * 报错字段一定要加""
         */
        Map<String, String> jsonMap1 = JsonUtil.json2Obj("{\"buyAmt\":\"125000\",\"transTime\":\"20170122182841\"}", Map.class);
        System.out.println("jsonMap=" + jsonMap1);

        //2017-01-22 测试Ok-> jsonMap={buyAmt=125000, transTime=20170122182841}
    }

    /**
    * 这里测试= 在json中是不合适的<br>
    */
    @Test
    public void testJson2() {

        Map<String, String> jsonMap = JsonUtil.json2Obj("{\"buyAmt\"=\"125000\",\"transTime\"=\"20170122182841\"}", Map.class);
        System.out.println("jsonMap=" + jsonMap);
        /**
         * org.codehaus.jackson.JsonParseException: Unexpected character ('=' (code 61)): was expecting a colon to separate field name and value
        at [Source: java.io.StringReader@6adede5; line: 1, column: 11]
        at org.codehaus.jackson.JsonParser._constructError(JsonParser.java:1433)
         */
    }

    @Test
    public void testJson3() {
        /**
        * 如下场景解析都报错：
        * 1.response 加了引号\"
        * response:{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":null}}
        * 2.null 加了引号\"
        * 3.都加了引号
        * 猜测的原因是有层级 {{}}
        */
        String jsonStr1 = "\"response\":{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":\"null\"}}";
        Map<String, String> jsonMap1 = JsonUtil.json2Obj(jsonStr1, Map.class);
        System.out.println("jsonMap1=" + jsonMap1);
    }

    @Test
    public void testJson4() {
        String jsonStr1 = "{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":\"null\"}}";
        Map<String, String> jsonMap1 = JsonUtil.json2Obj(jsonStr1, Map.class);
        System.out.println("jsonMap1=" + jsonMap1);
        /**
        * 2017-03-07执行结果如下：多层级也是可以的，只是一定要{包围对}
        * jsonMap1={data={systti=15:10:40, blncdn=C, brchqy=, success=null}}
        */

        String jsonStr2 = "{\"data\":{\"systti\":\"15:10:40\",\"blncdn\":\"C\",\"brchqy\":\"\",\"success\":null}}";
        Map<String, String> jsonMap2 = JsonUtil.json2Obj(jsonStr1, Map.class);
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

    /**
    * 只输出重要的列，便于进行 结果和数据分析<br>
    */
    @Test
    public void printResponseImportantColumn() {
        //{"data":{"systti":"14:54:55","pckgsq":"","erortx":"","accstp":"9","acctbr":"02001","acctid":"1000000870","acctna":"其他清算款项-T+0应付清算中心款","acctno":"02001018304150105001","acctst":"1","acshtg":"3","blncdn":"C","brchqy":"","closdt":"","cltrsq":"","crcycd":"01","dtitcd":"30415010","itemcd":"30415010","itemna":"其他清算款项-T+0应付清算中心款","lastdt":"20161128","lsdtbl":"-100837.08","lstrdt":"","lstrsq":"","onlnbl":"-52163.3","onlnbl_qr":"-52163.3","opendt":"20160925","optrsq":"","pmodtg":"1","prodcd":"320240","sleptg":"0","subsac":"00001","prcscd":"qracol","prcsna":"查询账户信息(不需要输入子户号)","mutrcd":"","sid":"c4364281-a29b-4490-ba7b-8214221222a8"},"code":"1111","acctSid":"20170308145455372-000001e8fFlSbc","msg":"无返回信息","success":null}
        // response 从把上述字符串copy到notepad++ 里 进行替换 " 替换成 \"即可 赋值给response变量。
        String response = "{\"data\":{\"systti\":\"14:54:55\",\"pckgsq\":\"\",\"erortx\":\"\",\"accstp\":\"9\",\"acctbr\":\"02001\",\"acctid\":\"1000000870\",\"acctna\":\"其他清算款项-T+0应付清算中心款\",\"acctno\":\"02001018304150105001\",\"acctst\":\"1\",\"acshtg\":\"3\",\"blncdn\":\"C\",\"brchqy\":\"\",\"closdt\":\"\",\"cltrsq\":\"\",\"crcycd\":\"01\",\"dtitcd\":\"30415010\",\"itemcd\":\"30415010\",\"itemna\":\"其他清算款项-T+0应付清算中心款\",\"lastdt\":\"20161128\",\"lsdtbl\":\"-100837.08\",\"lstrdt\":\"\",\"lstrsq\":\"\",\"onlnbl\":\"-52163.3\",\"onlnbl_qr\":\"-52163.3\",\"opendt\":\"20160925\",\"optrsq\":\"\",\"pmodtg\":\"1\",\"prodcd\":\"320240\",\"sleptg\":\"0\",\"subsac\":\"00001\",\"prcscd\":\"qracol\",\"prcsna\":\"查询账户信息(不需要输入子户号)\",\"mutrcd\":\"\",\"sid\":\"c4364281-a29b-4490-ba7b-8214221222a8\"},\"code\":\"1111\",\"acctSid\":\"20170308145455372-000001e8fFlSbc\",\"msg\":\"无返回信息\",\"success\":null}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> resMap; //这里存放的值可能是 String也可能是LinkedHashMap所以这里必须使用Object
        try {
            resMap = mapper.readValue(response, Map.class);
            //			String innerMapStr = resMap.get("data"); //由于这个返回的是 LinkedHashMap,所以前面的resMap类型应该为Map<String,LinkedHashMap>
            //			Map <String,String> innerResMap = mapper.readValue(innerMapStr, Map.class);
            Map<String, String> innerResMap = (Map) resMap.get("data");
            System.out.print("acctna账务名称：" + innerResMap.get("acctna") + " ");
            System.out.print("acctno账号：" + innerResMap.get("acctno") + " ");
            System.out.print("lsdtbl上次值：" + innerResMap.get("lsdtbl") + " ");
            System.out.print("onlnbl在线值：" + innerResMap.get("onlnbl") + " ");
            System.out.print("onlnbl_qr在线值_qr" + innerResMap.get("onlnbl_qr") + " ");
            System.out.println("\n");

            /**
             * 2017-03-08 输出结果为：（清结算返回的记账数据处理）
             * acctna账务名称：其他清算款项-T+0应付清算中心款 acctno账号：02001018304150105001 lsdtbl上次值：-100837.08 onlnbl在线值：-52163.3 onlnbl_qr在线值_qr-52163.3 
             */
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testNowTime() {
        System.out.println("nowTime=" + System.currentTimeMillis());
    }

}
