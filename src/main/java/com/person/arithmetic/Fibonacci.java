package com.person.arithmetic;

/**
 * n = 1,2 时，fib(n) = 1
 * n > 2 时，fib(n) = fib(n-2) + fib(n-1)
 * 
 * 这一看就是递归的思路，但是递归的话会有重复计算的问题。比如f(5)=f(4)+f(3),f(4)=f(3)+(2),所以f(3)被重复计算了一次。<br>
 * 本样例就是输入一个 index 求出 f(index)数列。<br>
 * @author lakala-shawn
 *
 */
public class Fibonacci {
	/**
	 * 2017-03-22 面试时候我可能想到过弄一个数组存放所有的Fibonacci数列。<br>
	 * @return 
	 */
	
	public static int fab(int index)
	{
		int a1before = 1;
		int a2before = 1;
		
		int tempValue = 0;
		for (int i = 3;i <=index; i++)
		{
			tempValue = a2before + a1before;
			
			a2before = a1before;
			
			a1before = tempValue;
		}
		
		return tempValue;
	}
	/**
	 * 2017-03-23 测试通过，这是非递归算法，通过临时保留一两个值来计算。
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fab(6));
	}
	

}
