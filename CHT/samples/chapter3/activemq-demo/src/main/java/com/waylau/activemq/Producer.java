package com.waylau.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MQ 生產者
 * 
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2016年8月7日
 */
public class Producer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "waylau-queue";

    public static void main(String[] args) throws JMSException {
    	
        // 起始化連線工廠
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        
        // 獲得連線
        Connection conn = connectionFactory.createConnection();
        
        // 啟動連線
        conn.start();

        // 建立Session，第一個參數表示階段是否在交易中執行，第二個參數設定階段的回應模式
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 建立佇列
        Destination dest = session.createQueue(SUBJECT);
        
        //createTopic方法用來建立Topic
        //session.createTopic("TOPIC");

        // 透過 session 可以建立訊息的生產者
        MessageProducer producer = session.createProducer(dest);
        for (int i=0;i<10;i++) {
        	
            //起始化一個 MQ 訊息
            TextMessage message = session.createTextMessage("Welcome to waylau.com " + i);
            
            //傳送訊息
            producer.send(message);
            
            LOGGER.info("send message {}", i);
        }

        //關閉 MQ 連線
        conn.close();
    }
}