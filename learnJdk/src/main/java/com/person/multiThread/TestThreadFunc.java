package com.person.multiThread;

import org.junit.Test;

public class TestThreadFunc {

	/**
	 * 运行结果：<br>
	 * begin create thread.
	 * t1 executing..
	 * t2 executing...
	 * end thread start...
	 * t3 executing...
	 */
	@Test
	public void testWithNoJoin()
	{
		System.out.println("begin create thread.");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t1 executing...");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t2 executing...");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t3 executing...");
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		System.out.println("end thread start...");
	}
	
	/**
	 * start()和run()方法区别：
1.start()方法中会调用run方法，但是只有start()方法才是新起一个线程。直接调用run()方法只是普通的方法调用而已。
	 */
	@Test
	public void testWithStartRunMethod()
	{
		System.out.println("begin create thread.");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t1 executing...");
			}
		});
		t1.start();
		System.out.println("t1.isAlive=" + t1.isAlive());
		
		Thread t2 = new Thread();
		t2.run();
		System.out.println("t2.isAlive=" + t2.isAlive());
		/**
		 * begin create thread.
t1.isAlive=true
 t1 executing...
t2.isAlive=false
		 */
	}


	/**
	 * 2016年11月26日 执行结果：
	 * begin create thread.
	 * t1 executing...
	 * t2 executing...
	 * t3 executing...
	 * end thread start...<br>
	 */
	@Test
	public void testWithJoin()
	{
		System.out.println("begin create thread.");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t1 executing...");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t2 executing...");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t3 executing...");
			}
		});
		t1.start();
		t2.start();
		t3.start();
		try {
			//Waits for this thread to die.
			t2.join();

			t3.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end thread start...");
	}
	

	
	@Test
	public void testWithJoinWithYield()
	{
		System.out.println("begin create thread.");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t1 executing...");
				System.out.println(" t1 executing 2...");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t2 executing...");
				System.out.println(" t2 executing 2...");
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(" t3 executing...");
				Thread.yield();
				System.out.println(" t3 executing 2...");
			}
		});
		t1.start();
		t2.start();
		t3.start();
		
		try {
			//Waits for this thread to die.
			t2.join();
			t3.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end thread start...");
	}

}
