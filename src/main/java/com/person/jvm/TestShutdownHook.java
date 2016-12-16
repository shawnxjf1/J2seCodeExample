package com.person.jvm;

import org.junit.Test;

/**
 * 参考：http://stackoverflow.com/questions/8722826/when-do-i-need-to-call-this-method-runtime-getruntime-addshutdownhook<br>
 * addShutdownHook() will register some actions which is to be performed on a Program's termination. The program that you start ends in two ways:

the main thread (Root) ends its running context;
the program meets some unexpected situation, so it cannot proceed further.
If you add a ShutdownHook, the hook will start a thread that will start running at time of termination only. For example:

 Runtime.getRuntime().addShutdownHook(new Thread() {
      public void run() {
        System.out.println("Running Shutdown Hook");
      }
    });
will print a Running Shutdown Hook at the time of program termination at any point. You might even call a System.exit(0).

For examples, you can google, there are enough of them. And the question 'When should you use this' is like asking 'What does catch do in a try-catch statement'.

You might have many situations like:

your program had created many temporary files in filesystem you want to delete it;
you need to send a distress signal to another process/machine before terminating;
execute any clean-up actions, logging or after-error actions on unexpected behaviours.
All this will be needed for some point of time.*/

public class TestShutdownHook {
	
	
	

	@Test
	public void testShutdownHook()
	{
		
		Thread t = new Thread( new Runnable() {
			@Override
			public void run() {
				System.out.println("thread id=" + Thread.currentThread().getName() + "is executing.");
			}
		});
		t.start();
		
		 Runtime.getRuntime().addShutdownHook(new Thread() {
		      public void run() {
		        System.out.println("Running Shutdown Hook");
		      }
		    });
		 
			System.out.println("Main thread is executing...");
		/**
		 * 2016-12-16执行结果：
		 * thread id=Thread-0is executing.
Main thread is executing...
Running Shutdown Hook  --- 永远是最后执行的
		 */

	}
	

}
