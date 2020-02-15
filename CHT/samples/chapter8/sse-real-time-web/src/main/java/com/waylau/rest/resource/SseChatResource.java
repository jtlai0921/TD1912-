package com.waylau.rest.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 * �����GSSE �s���Ҧ�-���
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015�~8��18�� 
 */
@Singleton
@Path("sse-chat")
public class SseChatResource {

    private SseBroadcaster broadcaster = new SseBroadcaster();
    
    private Map<String, EventOutput> eventOutputMap = new HashMap<String, EventOutput>();// �x�s�s�u��
    
    private long countId = 0;
    /**
     * ���� SSE �ƥ��X�q�D���귽��k
     * @return eventOutput
     */
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput listenToBroadcast() {
        EventOutput eventOutput = new EventOutput();
        this.eventOutputMap.put(countId+"", eventOutput);
        this.broadcaster.add(eventOutput);
        this.countId ++;
        System.out.println( "countId:"+countId + "�[�J,�@�p�G"+ eventOutputMap.size());
        return eventOutput;
    }
    
    /**
     * ���� �g�J SSE �ƥ�q�D���귽��k
     * @param message
     * @param name
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void broadcastMessage(@DefaultValue("waylau.com") @QueryParam("message")  String message,
    		@DefaultValue("waylau") @QueryParam("name")  String name) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�]�w����榡
    	String now =  df.format(new Date()); //���o�ثe�t�ήɶ�
    	message = now +":"+ name +":"+ message;  // �ǰe���T���a�W�ثe���ɶ�
    	
        OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
        OutboundEvent event = eventBuilder.name("message")
            .mediaType(MediaType.TEXT_PLAIN_TYPE)
            .data(String.class, message)
            .build();

        // �ǰe�s��
        broadcaster.broadcast(event);
     }
}
