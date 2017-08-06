package com.person.arithmetic;

import org.apache.log4j.Logger;

public class Node{
	
	static Logger log = Logger.getLogger(Node.class);
	
    int value;
    Node nextNode;
    public Node(int value, Node nextNode) {
        super();
        this.value = value;
        this.nextNode = nextNode;
    }
    
    
    /**
     * 初始化单链表
     * @param num 数量
     * @return
     */
    public static Node init(int num) {
        Node node = new Node(0, null);
        Node cur = null;
        Node temp = null;
        for(int i = 1 ; i < num;i++){
            temp = new Node(i, null);
            if (i == 1) {
                node.nextNode = temp;
            }else{
                cur.nextNode = temp;
            }
            cur = temp;
        }
        return node;
    }
    
    
    /**
     * 打印节点值
     * @param head
     */
    public static void out(Node head) {
        Node tempNode = head;
        while(tempNode != null){            
            System.out.println(tempNode.value);
            tempNode = tempNode.nextNode;
        }
    }
    
    public static Node reverse(Node head)
    {
    	Node newLinkHead = new Node(0, null);
    	
    	/**
    	 * 作为新旧 链表中移动节点的指针
    	 */
    	Node oldNewLinkCurNode = head.nextNode;
    	Node oldLinkNextNode = head.nextNode.nextNode;
    	
    	Node newLinkNextNode = newLinkHead.nextNode;
    	
    	// head ->1 -> 2 -> 3 变成了head -> 3 -> 2 -> 1
    	
    	/**
    	 * 概念一定要清晰：
    	 * 2. 这样可以把移动指针 和 变更指针指向分开。<br>
    	 * 3. 由旧的链表组装成新的链表的过程中，不是新建节点而是把旧链表节点移动到新的链表上。
    	 */
    	
    	//遍历旧链表
    	while (oldNewLinkCurNode != null)
    	{
    		//在循环里一定要捕捉异常，且把该次循环的值打印出来<br>
    		try {
    			/**
        		 * 修改新链表指针,注意上下游的指针变动，上游就是newLinkHead，下游就是newLinkNextNode
        		 */
        		newLinkHead.nextNode = oldNewLinkCurNode;
        		oldNewLinkCurNode.nextNode = newLinkNextNode;
        		newLinkNextNode = oldNewLinkCurNode;
        		
        		/**
        		 * 修改旧链表指针
        		 */
        		head.nextNode = oldLinkNextNode;
        		oldNewLinkCurNode = oldLinkNextNode;
        		if (oldLinkNextNode != null)
        		{
            		oldLinkNextNode = oldLinkNextNode.nextNode;
        		}
        		
				
			} catch (Exception e) {
				//FIXME打印日志，在循环的异常里打印日志。＜br>
				//FIXME log 不生效。<br>
				log.error("当前遍历的值：" + oldNewLinkCurNode.value,e);
			}
    		
    	}
    	return newLinkHead;
    }
    
    
}
