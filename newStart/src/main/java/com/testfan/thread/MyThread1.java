package com.testfan.thread;

public class MyThread1 extends Thread{

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("run--"+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main (String[] args) {
		MyThread1 mythread1 = new MyThread1();
		mythread1.start();
		System.out.println("main--"+Thread.currentThread().getName());
	}
	
}
