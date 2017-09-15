package com.person;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestGeneric {

	public String printIterListForString(List<String> strList)
	{
		for (String str: strList)
		{
			System.out.println(str);
		}
		return null;
	}

	public int printIterListForInt(List<Integer> intList)
	{
		for (Integer intVal: intList)
		{
			System.out.println(intVal);
		}
		return 0;
	}
	
	
//  如下代码出现问题，Erasure of method iterList1(List<String>) is the same as another method in type  Generic

//	public void iterList1(List<String> strList)
//	{
//		for (String str: strList)
//		{
//			System.out.println(str);
//		}
//	}
//	
//	public void iterList1(List<Integer> intList)
//	{
//		for (Integer intVal: intList)
//		{
//			System.out.println(intVal);
//		}
//	}
	
	
	
	@Test
	public void test1(){
		List<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		printIterListForString(strList);
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		printIterListForInt(intList);
	}
}
