package com.test.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadSubmitDemo
{

    class ThreadDemo implements Runnable
    {

        public void run()
        {
        	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            System.err.println("hello world");
        }

    }

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ThreadSubmitDemo threadPoolDemo = new ThreadSubmitDemo();
        for (int i = 0; i < 5; i++)
        {
            ThreadDemo threadDemo = threadPoolDemo.new ThreadDemo();
            Future<?> future = executorService.submit(threadDemo);

            // 可以取消执行
           // future.cancel(true);

            // 可以获取返回结果，如果future.get()==null 且无异常，表示执行成功
            try
            {
                if (future.get(4,TimeUnit.SECONDS) == null) System.out.println("执行完成");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
        executorService.shutdown();
    }
}
