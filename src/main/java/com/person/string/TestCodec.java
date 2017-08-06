package com.person.string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.junit.Test;

public class TestCodec {
	
	@Test
	public void test1()
	{
		String s = "你好";
		// 编码
		byte[] utf;
		try {
			utf = s.getBytes("utf-8");
			byte[] gbk = s.getBytes("gbk");
			
			System.out.println("utf-8编码：" + Arrays.toString(utf));//[-28,-67,-96,-27,-91,-67]  6个字节
			System.out.println("gbk编码：" + Arrays.toString(gbk));//[-60,-29,-70,-61] 4个字节
			// 解码
			String s1 = new String(utf, "utf-8"); // utf8/utf8你好
			String s2 = new String(utf, "gbk"); // utf8/gbk 解码：浣犲ソ gbk用2个字节解码，所以会多一个字符
			String s3 = new String(gbk, "utf-8"); // gbk/utf8 用utf-8解码：??? utf-8解码需要6个字节
			String s4 = new String(gbk, "gbk"); // gbk/gbk 用utf-8解码：??? utf-8解码需要6个字节
			
			byte [] unicode = s.getBytes("unicode");
			String s5 = new String(unicode,"unicode");
			System.out.println("S5=" + s5);

			System.out.println("--------------------");
			System.out.println("utf-8/utf8 解码：" + s1);
			System.out.println("utf8/gbk解码：" + s2);
			System.out.println("gbk用utf-8解码：" + s3);
			System.out.println("gbk用gbk解码：" + s4);
			System.out.println("---------------------");
			s3 = new String(s3.getBytes("utf-8"), "gbk"); // 锟斤拷锟?   gbk用utf-8解码后无法编回去
			System.out.println("s3为gbk用utf-8编码：s3.getBytes(\"utf-8\"), \"gbk\"" + s3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}

}
