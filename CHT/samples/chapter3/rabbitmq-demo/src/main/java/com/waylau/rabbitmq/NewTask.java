package com.waylau.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * �ǰe�T�����u�@�ǰe�{��
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2016�~8��12��
 */
public class NewTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewTask.class);
	private static final String TASK_QUEUE_NAME = "waylau_queue";

	public static void main(String[] argv) throws Exception {

		// �_�l�Ƴs�u�u�t
		ConnectionFactory factory = new ConnectionFactory();

		// �]�w�s�u����}
		factory.setHost("localhost");

		// ��o�s�u
		Connection connection = factory.newConnection();

		// �إ� Channel
		Channel channel = connection.createChannel();

		// �ŧi��C
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

		// �q�D���x�ѼƤ��A���o�T��
		String message = getMessage(argv);

		// �ǰe�T���C�ǰe10��
		for (int i = 0; i < 10; i++) {
			String msg = message + " " + i;
			channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
					(msg).getBytes("UTF-8"));

			LOGGER.info(" [x] Sent '" + msg + "'");
		}

		channel.close();
		connection.close();
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 1)
			return "Hello World!";
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter) {
		int length = strings.length;
		if (length == 0)
			return "";
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(delimiter).append(strings[i]);
		}
		return words.toString();
	}
}
