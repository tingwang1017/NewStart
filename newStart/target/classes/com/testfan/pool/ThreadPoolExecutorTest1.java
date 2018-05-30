package com.testfan.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest1 {
	
	public static void main(String[] args) {
		//线程数0~65536  ， 最大65536    适合短任务
		ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool();
		for (int i = 0; i<100; i++) {
			final int index = i;
			cachedThreadPool1.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() +" : " +index);
					
				}
			});
		}
		cachedThreadPool1.shutdown();
		
		//固定线程数
		ExecutorService cachedThreadPool2 = Executors.newFixedThreadPool(3);
		for (int i = 0; i<100; i++) {
			final int index = i;
			cachedThreadPool2.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() +" : " +index);
					
				}
			});
		}
		cachedThreadPool2.shutdown();
		
		//单个线程   先进先出
		ExecutorService cachedThreadPool3 = Executors.newSingleThreadExecutor();
		for (int i = 0; i<100; i++) {
			final int index = i;
			cachedThreadPool3.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() +" : " +index);
					
				}
			});
		}
		cachedThreadPool3.shutdown();
		
	}

}
