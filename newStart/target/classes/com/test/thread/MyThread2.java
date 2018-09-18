package com.test.thread;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("run--" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new MyThread2());
		thread.start();
		System.out.print("main--" + Thread.currentThread().getName());
		// 上面的写法可以连起来写
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 10; j++) {
						System.out.println(Thread.currentThread().getName() + j);
					}
				}
			}).start();
		}
	}
}
