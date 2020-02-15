package com.waylau.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 接收訊息的工作者
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2016年8月12日
 */
public class Worker {

	private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);
	private static final String TASK_QUEUE_NAME = "waylau_queue";

	public static void main(String[] argv) throws Exception {
		
		// 起始化連線工廠
		ConnectionFactory factory = new ConnectionFactory();
		
		// 設定連線的位址
		factory.setHost("localhost");
		
		// 獲得連線
		final Connection connection = factory.newConnection();
		
		// 建立 Channel
		final Channel channel = connection.createChannel();

		// 宣告佇列  
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		channel.basicQos(1);

		LOGGER.info(" [*] Waiting for messages. To exit press CTRL+C");
		
		// 消費者
		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");

				LOGGER.info(" [x] Received '" + message + "'");
				try {
					doWork(message);
				} finally {
					LOGGER.info(" [x] Done");
					
					// 確認訊息
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		
		// 取消 autoAck  
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}

	private static void doWork(String task) {
		for (char ch : task.toCharArray()) {
			if (ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException _ignored) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}
}
