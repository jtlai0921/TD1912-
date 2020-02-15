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
 * ���O�̡A�����M�B�z�T��
 * 
 * @author <a href="https://waylau.com">waylau.com</a>
 * @date 2016�~8��18��
 */
public class Consumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
	private static final String GROUP_NAME = "waylau_com_consumer_gorup";
	private static final String NAME_SERVER = "10.30.22.108:9876";

	public static void main(String[] args) throws InterruptedException, MQClientException {

		// consumerGroup �����ߤ@
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP_NAME);

		// �]�w Consumer �Ĥ@���ҰʬO�q��C�����}�l���O�٬O��C�����}�l���O
		// �Y�G�D�Ĥ@���ҰʡA������ӤW�����O����m�~����O
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		// �]�w name server ��}
		consumer.setNamesrvAddr(NAME_SERVER);

		// �q�\ topic
		consumer.subscribe("TopicTest", "*");

		// ��ť�T��
		consumer.registerMessageListener(new MessageListenerConcurrently() {

			@Override
			public ConsumeConcurrentlyStatus consumeMessage(
		            List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
			    LOGGER.info(Thread.currentThread().getName() 
			    		+ " Receive New Messages: " + new String(msgs.get(0).getBody()));
			    
			    /*
			    // ���L�D���n�T���C��Y�Ӧ�C���T���ư�n�� 100000 ���H�W�A
			    // �h���ձ˱󳡤��Υ����T���A�o�˴N�i�H�ֳt�l�W�ǰe�T�����t��
			    long offset = msgs.get(0).getQueueOffset(); 
			    String maxOffset = msgs.get(0).getProperty(MessageConst.PROPERTY_MAX_OFFSET); 
			    long diff = Long.parseLong(maxOffset) - offset;
			    if (diff > 100000) { 
	
			        // TODO �T����n���p���S��B�z
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
