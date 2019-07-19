package com.person.multiThread.threadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 由于是thread中有一个threadLocal.threadlocalMap引用，所以
 * @author shawn
 *
 */
public class NoSafeThreadLocalThread  implements Runnable{
	
	private ThreadLocal myThreadLocal = new ThreadLocal<Number>();
	
	public static Number number = new Number();

    public static  int i = 0;
	
	@Override
	public void run() {
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
            newCachedThreadPool.execute(new NoSafeThreadLocalThread());
        }
	}
	
	/**
	 * 一个线程执行结果影响了其他线程，因为每个线程的myThreadLocal都引用同一个Number引用。
	 * number.getNo()2
	 * number.getNo()3
	 * number.getNo()2
	 * number.getNo()2
	 * number.getNo()4
	 */
	
	/**
	 * 加了Thread.sleep(500);后的执行结果为，一个一个线程改变number完全能够被另一个线程看到。
	 * 
	 * number.getNo()4
number.getNo()4
number.getNo()4
number.getNo()4
number.getNo()4
	 */
}
