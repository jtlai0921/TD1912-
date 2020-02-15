package com.waylau.rest.resource;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 * �����GSSE �o��-�q�\�Ҧ�
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015�~8��18�� 
 */
@Path("see-events")
public class SseResource {

    private EventOutput eventOutput = new EventOutput();
    private OutboundEvent.Builder eventBuilder;
    private OutboundEvent event ;
    
    /**
     * ���� SSE �ƥ��X�q�D���귽��k
     * @return eventOutput
     */
 	@GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() {

 		// ���_�`������
        while (true) {
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�]�w����榡
        	String now =  df.format(new Date()); //���o�ثe�t�ήɶ�
        	String message = "Server Time:" + now;
        	System.out.println( message );
            
        	eventBuilder = new OutboundEvent.Builder();
        	eventBuilder.id(now);
            eventBuilder.name("message");
            eventBuilder.data(String.class,
            		message );  // ���e���A���ɶ����T�����Τ��
            event = eventBuilder.build();
            try {
				eventOutput.write(event);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					eventOutput.close();
			        return eventOutput;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
        }
    }
}
