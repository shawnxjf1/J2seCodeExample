package com.person.arithmetic;

import org.junit.Test;

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
}
