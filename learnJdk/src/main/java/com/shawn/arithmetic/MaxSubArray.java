package com.person.arithmetic;

/**
 * 待完善<br>
 * @author lakala-shawn
 *
 */
public class MaxSubArray {
	/**
	 * 事实上，当我们令currSum为当前最大子数组的和，maxSum为最后要返回的最大子数组的和，当我们往后扫描时，

对第j+1个元素有两种选择：要么放入前面找到的子数组，要么做为新子数组的第一个元素；
如果currSum加上当前元素a[j]后不小于a[j]，则令currSum加上a[j]，否则currSum重新赋值，置为下一个元素，即currSum = a[j]。
同时，当currSum > maxSum，则更新maxSum = currSum，否则保持原值，不更新。
即
	 */
	/**
	 * 关键点：如果currSum加上当前元素a[j]后不小于a[j]
	 * @param a
	 * @param n
	 * @return
	 */
	int MaxSubArray(int a[], int n)
	{
	    int currSum = 0;
	    int maxSum = a[0];       //全负情况，返回最大数

	    for (int j = 0; j < n; j++)
	    {
	        currSum = (a[j] > currSum + a[j]) ? a[j] : currSum + a[j];
	        maxSum = (maxSum > currSum) ? maxSum : currSum;

	    }
	    return maxSum;
	}
	
	public static void main(String[] args) {
		
//		举个例子，当输入数组是 1, -2, 3, 10, -4, 7, 2, -5 ，那么，currSum和maxSum相应的变化为：
//		currSum： 0 1 - 1 3 13 9 16 18 13
//		maxSum ： 0 1 1 3 13 13 16 18 18
		
		
	}

}
