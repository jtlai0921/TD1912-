package com.waylau.rest.resource;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import com.waylau.rest.bean.Alarm;

/**
 * �����G�iĵ SSE 
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015�~9��8�� 
 */
@Path("alarm-events")
public class AlarmResource {

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
        	Alarm message = new Alarm(new Date(),Short.valueOf("11"), "10", "���l�{���F");
        	 
        	eventBuilder = new OutboundEvent.Builder();
        	eventBuilder.id(message.getId()+"");
            eventBuilder.name("message");;
            eventBuilder.mediaType(MediaType.APPLICATION_JSON_TYPE);
            eventBuilder.data(Alarm.class,
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
