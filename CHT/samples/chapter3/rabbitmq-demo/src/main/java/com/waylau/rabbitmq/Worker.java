package com.waylau.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �����T�����u�@��
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2016�~8��12��
 */
public class Worker {

	private static final Logger LOGGER = LoggerFactory.getLogger(Worker.class);
	private static final String TASK_QUEUE_NAME = "waylau_queue";

	public static void main(String[] argv) throws Exception {
		
		// �_�l�Ƴs�u�u�t
		ConnectionFactory factory = new ConnectionFactory();
		
		// �]�w�s�u����}
		factory.setHost("localhost");
		
		// ��o�s�u
		final Connection connection = factory.newConnection();
		
		// �إ� Channel
		final Channel channel = connection.createChannel();

		// �ŧi��C  
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		channel.basicQos(1);

		LOGGER.info(" [*] Waiting for messages. To exit press CTRL+C");
		
		// ���O��
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
					
					// �T�{�T��
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		
		// ���� autoAck  
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
