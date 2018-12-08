package com.person.arithmetic;

import org.junit.Test;

/**
 * 这里的规律是 a&b < a,b中的任何一个。
 * @author lakala-shawn
 *
 */
public class TestArithMetic {

	/**
	 * 想测试该测试用例是 查看hashmap源码的时候HashMap.put(),对这些 n-1 & hash 这些操作反应不灵敏<br>
	 * if ((p = tab[i = (n - 1) & hash]) == null)<br>
	 */
	@Test
	public void testAmpersand()
	{
		int n = 10;
		int hash = 8;
		int i =0;
		int j = i = (n - 1) & hash;
		System.out.println("i=" + i + ",j=" + j);
		/**
		 * i=8,j=8
		 */
	}
	
	@Test
	public void testNumberToBin()
	{
		System.out.println("Integer.toBinaryString(10)="  + Integer.toBinaryString(10));
		System.out.println("Integer.toBinaryString(8)=" + Integer.toBinaryString(8));
		/**
		 * Integer.toBinaryString(10)=1010
Integer.toBinaryString(8)=1000
		 */
	}
	
/*    作用
逻辑运算的作用相信大家都知道，下边来介绍下位运算的作用：
一、按位与 &
1、 清零特定位 (mask中特定位置0，其它位为1，s=s&mask) s=s&mask
2、取某数中指定位 (mask中特定位置1，其它位为0，s=s&mask) s=s&mask
二、按位或 ｜
常用来将源操作数某些位置1，其它位不变
三、按位异或
1、使特定位的值取反 (mask中特定位置1，其它位为0 s=s^mask)  -> 这个通过python来测试比较好
2、把一个数自清零，如 a=a xor a 不管a是多少，最后a都等于零*/
	
	@Test
	public void test1()
	{
		int a = 0xFf;
		System.out.println("a=" + a);
		//a=255
	}
	
	
}
