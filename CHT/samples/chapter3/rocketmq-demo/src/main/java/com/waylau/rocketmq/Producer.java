package com.waylau.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * 生產者，用於傳送訊息
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016年8月18日
 */
public class Producer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
	private static final String GROUP_NAME = "waylau_com_producer_gorup";
	private static final String NAME_SERVER = "10.30.22.108:9876";
	
	public static void main(String[] args) throws MQClientException, InterruptedException {
		
		// producerGroup 必須唯一
		DefaultMQProducer producer = new DefaultMQProducer(GROUP_NAME);

		// 設定 name server 位址
		producer.setNamesrvAddr(NAME_SERVER);
		
		// 在傳送訊息前，必須呼叫 start 方法來啟動Producer，只需呼叫一次即可
		producer.start();

		// 類比傳送十條資料
		for (int i = 0; i < 10; i++) {
			try {
				Message msg = new Message( 
			             // Message Topic
			             "TopicTest",
			             // Message Tag,對訊息進行再歸類別,方便Consumer指定過濾條件在MQ伺服器過濾
			             "TagA",
			             // Message Body,任何二進位形式的資料,需要Producer與Consumer協商好一致的序列化和反序列化模式
			             ("Welcome to waylau.com! " + i).getBytes());
				
				// 傳送訊息
				SendResult sendResult = producer.send(msg);
 
				LOGGER.info(sendResult.toString());
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
				Thread.sleep(1000);
			}
		}

		// 在套用離開前，可以銷毀Producer物件
		producer.shutdown();
	}
}
