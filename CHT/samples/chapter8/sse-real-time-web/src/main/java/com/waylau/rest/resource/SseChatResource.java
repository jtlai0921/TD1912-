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
 * 說明：SSE 廣播模式-聊天
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年8月18日 
 */
@Singleton
@Path("sse-chat")
public class SseChatResource {

    private SseBroadcaster broadcaster = new SseBroadcaster();
    
    private Map<String, EventOutput> eventOutputMap = new HashMap<String, EventOutput>();// 儲存連線數
    
    private long countId = 0;
    /**
     * 提供 SSE 事件輸出通道的資源方法
     * @return eventOutput
     */
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput listenToBroadcast() {
        EventOutput eventOutput = new EventOutput();
        this.eventOutputMap.put(countId+"", eventOutput);
        this.broadcaster.add(eventOutput);
        this.countId ++;
        System.out.println( "countId:"+countId + "加入,共計："+ eventOutputMap.size());
        return eventOutput;
    }
    
    /**
     * 提供 寫入 SSE 事件通道的資源方法
     * @param message
     * @param name
     */
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void broadcastMessage(@DefaultValue("waylau.com") @QueryParam("message")  String message,
    		@DefaultValue("waylau") @QueryParam("name")  String name) {
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//設定日期格式
    	String now =  df.format(new Date()); //取得目前系統時間
    	message = now +":"+ name +":"+ message;  // 傳送的訊息帶上目前的時間
    	
        OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
        OutboundEvent event = eventBuilder.name("message")
            .mediaType(MediaType.TEXT_PLAIN_TYPE)
            .data(String.class, message)
            .build();

        // 傳送廣播
        broadcaster.broadcast(event);
     }
}
