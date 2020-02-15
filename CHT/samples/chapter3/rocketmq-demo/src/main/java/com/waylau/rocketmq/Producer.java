package com.waylau.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * �Ͳ��̡A�Ω�ǰe�T��
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016�~8��18��
 */
public class Producer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
	private static final String GROUP_NAME = "waylau_com_producer_gorup";
	private static final String NAME_SERVER = "10.30.22.108:9876";
	
	public static void main(String[] args) throws MQClientException, InterruptedException {
		
		// producerGroup �����ߤ@
		DefaultMQProducer producer = new DefaultMQProducer(GROUP_NAME);

		// �]�w name server ��}
		producer.setNamesrvAddr(NAME_SERVER);
		
		// �b�ǰe�T���e�A�����I�s start ��k�ӱҰ�Producer�A�u�ݩI�s�@���Y�i
		producer.start();

		// ����ǰe�Q�����
		for (int i = 0; i < 10; i++) {
			try {
				Message msg = new Message( 
			             // Message Topic
			             "TopicTest",
			             // Message Tag,��T���i��A�k���O,��KConsumer���w�L�o����bMQ���A���L�o
			             "TagA",
			             // Message Body,����G�i��Φ������,�ݭnProducer�PConsumer��Ӧn�@�P���ǦC�ƩM�ϧǦC�ƼҦ�
			             ("Welcome to waylau.com! " + i).getBytes());
				
				// �ǰe�T��
				SendResult sendResult = producer.send(msg);
 
				LOGGER.info(sendResult.toString());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Thread.sleep(1000);
			}
		}

		// �b�M�����}�e�A�i�H�P��Producer����
		producer.shutdown();
	}
}
