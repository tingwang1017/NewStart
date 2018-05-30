package com.testfan.timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {			// run currently
			@Override
			public void run() {
				System.out.println("This is in TimerTest, the time is : " + Calendar.getInstance().getTimeInMillis());				
			}
		}, 0);
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() { // run at 3sec later
				// TODO Auto-generated method stub
				
			}
		}, Calendar.getInstance().getTime());
		
		
		
	}
}
