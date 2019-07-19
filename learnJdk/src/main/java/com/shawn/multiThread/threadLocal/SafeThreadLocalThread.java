package com.person.multiThread.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 由于是thread中有一个threadLocal.threadlocalMap引用，所以
 * @author shawn
 *
 */
public class SafeThreadLocalThread  implements Runnable{
	
	private ThreadLocal myThreadLocal = new ThreadLocal<Number>();
	
    public static  int i = 0;
	
	@Override
	public void run() {
		Number number = new Number();
		number.setNo(i++);
		
		//将值存储到threadLocal中
		myThreadLocal.set(number);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("number.getNo()" + number.getNo());
	}
	
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            newCachedThreadPool.execute(new SafeThreadLocalThread());
        }
	}
	
	/**
	 * 每个number 各不影响因为他是在各个线程里单独new的。
	 * number.getNo()2
number.getNo()3
number.getNo()1
number.getNo()4
number.getNo()0
	 */
	
	/**
	 * 这里有一个知识点就是多个线程对class  static  int i = 0;引用的是同一个。
	 */
}
