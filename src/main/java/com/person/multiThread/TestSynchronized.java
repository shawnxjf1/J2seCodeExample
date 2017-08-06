package com.person.multiThread;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestSynchronized {
	Logger log = Logger.getLogger(TestSynchronized.class);
	
	public  synchronized void  method1()
	{
		long t2 = System.currentTimeMillis();

		System.out.println("method1 before sleep,timestamp=" + t2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("method1 after sleep");
	}
	
	public  void  method2()
	{
		long t2 = System.currentTimeMillis();

		System.out.println("method2,timestamp=" + t2);
	}

	/**
	 * synchronized 不能作用到null对象上
	 */
	private void testSynchronizeNull() {
		Object o = null;

		synchronized (o) {
			log.info("synchronized null");
		}
	}

	@Test
	public void testSynchronizedNull() {
		testSynchronizeNull();
	}

	@Test
	public void testSynchronizeMutex()
	{
		TestSynchronized test1 = new TestSynchronized();
		long t1 = System.currentTimeMillis();
		test1.method1();
		long t2 = System.currentTimeMillis();
		System.out.
		test1.method2();
		test1.method2();
		
	}
}
