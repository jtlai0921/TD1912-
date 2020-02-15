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
 * MQ �Ͳ���
 * 
 * @author <a href="https://waylau.com">Way Lau</a> 
 * @date 2016�~8��7��
 */
public class Producer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String SUBJECT = "waylau-queue";

    public static void main(String[] args) throws JMSException {
    	
        // �_�l�Ƴs�u�u�t
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        
        // ��o�s�u
        Connection conn = connectionFactory.createConnection();
        
        // �Ұʳs�u
        conn.start();

        // �إ�Session�A�Ĥ@�ӰѼƪ�ܶ��q�O�_�b���������A�ĤG�ӰѼƳ]�w���q���^���Ҧ�
        Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // �إߦ�C
        Destination dest = session.createQueue(SUBJECT);
        
        //createTopic��k�Ψӫإ�Topic
        //session.createTopic("TOPIC");

        // �z�L session �i�H�إ߰T�����Ͳ���
        MessageProducer producer = session.createProducer(dest);
        for (int i=0;i<10;i++) {
        	
            //�_�l�Ƥ@�� MQ �T��
            TextMessage message = session.createTextMessage("Welcome to waylau.com " + i);
            
            //�ǰe�T��
            producer.send(message);
            
            LOGGER.info("send message {}", i);
        }

        //���� MQ �s�u
        conn.close();
    }
}