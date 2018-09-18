package com.test.timer;

import java.util.Calendar;
import java.util.TimerTask;
import java.util.jar.Attributes.Name;

public class MyTimerTask extends TimerTask{

	@Override
	public void run() {	
		System.out.println("This is in MyTimerTask, the time is : " + Calendar.getInstance().getTimeInMillis());		
	}

	
	
}

