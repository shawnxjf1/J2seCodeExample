package com.person.multiThread;

public class ThreadTest extends Thread {
	
	public void run() {
		System.out.println("XXXXX");
		
	}
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		System.out.println("----begin start ---- executing...");
		//t1.start();
		
		System.out.println("----begin run ---- executing...");
		t1.run();
	}
	
}
