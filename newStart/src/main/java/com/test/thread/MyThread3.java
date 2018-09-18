package com.test.thread;

public class MyThread3 {

public void threadCount () {
	int allcount = 10000;
	int pagesize = 1003;
	int pageCount = (allcount % pagesize) == 0 ? allcount/pagesize : allcount/pagesize + 1;
	
	for (int i = 0; i < pageCount; i++) {
		int begin = i*pagesize +1;
		int end = (i+1)*pagesize;
		if(end > allcount) {
			end = allcount;
			System.out.println( " begin "+begin + " end " +end);
			new MyThread(begin, end).start();
		}

	}
}

class MyThread extends Thread {
	public int begin;
	public int end;
	
	public MyThread(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public void run () {
		for (int i = begin; i<=end; i++) {
			System.out.println(i);
		}
	}
	
}
	public static void main(String[] args) {
		new MyThread3().threadCount();
	}
	
}
