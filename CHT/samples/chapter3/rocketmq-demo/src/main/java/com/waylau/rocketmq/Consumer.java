package com.waylau.rocketmq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageConst;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消費者，接收和處理訊息
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016年8月18日
 */
public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	private static final String GROUP_NAME = "waylau_com_consumer_gorup";
	private static final String NAME_SERVER = "10.30.22.108:9876";

	public static void main(String[] args) throws InterruptedException, MQClientException {

		// consumerGroup 必須唯一
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP_NAME);

		// 設定 Consumer 第一次啟動是從佇列頁首開始消費還是佇列尾部開始消費
		// 若果非第一次啟動，那麼按照上次消費的位置繼續消費
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		// 設定 name server 位址
		consumer.setNamesrvAddr(NAME_SERVER);

		// 訂閱 topic
		consumer.subscribe("TopicTest", "*");

		// 監聽訊息
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(
		            List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
			    LOGGER.info(Thread.currentThread().getName() 
			    		+ " Receive New Messages: " + new String(msgs.get(0).getBody()));
			    
			    /*
			    // 略過非重要訊息。當某個佇列的訊息數堆積到 100000 條以上，
			    // 則嘗試捨棄部分或全部訊息，這樣就可以快速追上傳送訊息的速度
			    long offset = msgs.get(0).getQueueOffset(); 
			    String maxOffset = msgs.get(0).getProperty(MessageConst.PROPERTY_MAX_OFFSET); 
			    long diff = Long.parseLong(maxOffset) - offset;
			    if (diff > 100000) { 
	
			        // TODO 訊息堆積情況的特殊處理
			        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			    }
			    */
			    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});

		consumer.start();

		LOGGER.info("Consumer Started.");
	}
}
