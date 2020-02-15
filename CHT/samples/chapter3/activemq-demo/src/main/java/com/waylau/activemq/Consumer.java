package com.waylau.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MQ ���O��
 * 
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2016�~8��7��
 */
public class Consumer implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "waylau-queue";

    public static void main(String[] args) throws JMSException {
    	
        //�_�l�� ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        //�إ� MQ �s�u
        Connection conn = connectionFactory.createConnection();
        //�Ұʳs�u
        conn.start();

        //�إ߶��q
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //�z�L���q�إߥت�
        Destination dest = session.createQueue(SUBJECT);
        
        //�إ� MQ �T�������O��
        MessageConsumer consumer = session.createConsumer(dest);

        //�_�l�� MessageListener
        Consumer me = new Consumer();

        //�����O�̳]�w��ť����
        consumer.setMessageListener(me);
    }

    @Override
    public void onMessage(Message message) {
        TextMessage txtMessage = (TextMessage)message;
        try {
            LOGGER.info ("get message " + txtMessage.getText());
        } catch (JMSException e) {
            LOGGER.error("error {}", e);
        }
    }
}
