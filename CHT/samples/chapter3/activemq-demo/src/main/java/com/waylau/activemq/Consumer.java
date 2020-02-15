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
 * MQ 消費者
 * 
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2016年8月7日
 */
public class Consumer implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "waylau-queue";

    public static void main(String[] args) throws JMSException {
    	
        //起始化 ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        //建立 MQ 連線
        Connection conn = connectionFactory.createConnection();
        //啟動連線
        conn.start();

        //建立階段
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //透過階段建立目的
        Destination dest = session.createQueue(SUBJECT);
        
        //建立 MQ 訊息的消費者
        MessageConsumer consumer = session.createConsumer(dest);

        //起始化 MessageListener
        Consumer me = new Consumer();

        //給消費者設定監聽物件
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
