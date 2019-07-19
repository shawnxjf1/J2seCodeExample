package com.person.arithmetic;

import org.junit.Test;

public class ReverseLink {
	
	@Test
	public void testReverser()
	{
		Node head = Node.init(5);
		System.out.println("----反转前的旧链表-----");
		Node.out(head);
		System.out.println("---反转后的旧链表-------");
		Node newHead = null;
		newHead = Node.reverse(head);
	    Node.out(head);
		System.out.println("---反转后的新链表-------");
		Node.out(newHead);
		
		/**
		 * 2017-3-23 执行结果为，链表反转了。
		 * ----反转前的旧链表-----
0
1
2
3
4
---反转后的旧链表-------
0
---反转后的新链表-------
0
4
3
2
1
		 */
	}

}
