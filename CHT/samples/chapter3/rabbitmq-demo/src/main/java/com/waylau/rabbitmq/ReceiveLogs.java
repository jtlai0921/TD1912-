package com.waylau.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * ��ӱ����{��
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016�~8��12��
 */
public class ReceiveLogs {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiveLogs.class);
	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		
		// ���ǻ�����Ѽƨӫإߤ@�ӫD���[���B�ߤ@���B�ʲ�������C�A�Ӧ�C�W�٥Ѧ��A���H�����͡C
		String queueName = channel.queueDeclare().getQueue();
		
		// ���洫�����w��C�A�]�w binding
		channel.queueBind(queueName, EXCHANGE_NAME, "");

		LOGGER.info(" [*] Waiting for messages. To exit press CTRL+C");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				LOGGER.info(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume(queueName, true, consumer);
	}
}
