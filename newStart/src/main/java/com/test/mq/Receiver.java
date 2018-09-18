package com.test.mq;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
 
/**
 * 
* @ClassName: Recv
* @Description: TODO(接收消息类)
* @author czq
* @date 2017年11月29日 下午5:33:27
*
*/
public class Receiver{
 
    private final static String QUEUE_NAME = "TestMQ";
 
    public static void main(String[] args) throws Exception{
    	
        //创建一个连接
        ConnectionFactory factory = new ConnectionFactory();
        
        //连接本地，如果需要指定到服务，需在这里指定IP
        factory.setHost("192.168.1.107");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        
        //创建一个通道
        Channel channel = connection.createChannel();
        
        //申明接收消息的队列，与发送消息队列"hello"对应
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        //The extra DefaultConsumer is a class implementing the Consumer interface 
        //we'll use to buffer the messages pushed to us by the server.
        Consumer consumer = new DefaultConsumer(channel){
        	
            //重写DefaultConsumer中handleDelivery方法，在方法中获取消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, 
                    AMQP.BasicProperties properties, byte[] body) throws IOException{
                String message = new String(body, "UTF-8");
                System.out.println(" 收到了消息: '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true,consumer);
    }
}

