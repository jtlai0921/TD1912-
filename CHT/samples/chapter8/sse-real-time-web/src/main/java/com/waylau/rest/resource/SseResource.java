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
 * 說明：SSE 發布-訂閱模式
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年8月18日 
 */
@Path("see-events")
public class SseResource {

    private EventOutput eventOutput = new EventOutput();
    private OutboundEvent.Builder eventBuilder;
    private OutboundEvent event ;
    
    /**
     * 提供 SSE 事件輸出通道的資源方法
     * @return eventOutput
     */
 	@GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents() {

 		// 不斷循環執行
        while (true) {
        	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//設定日期格式
        	String now =  df.format(new Date()); //取得目前系統時間
        	String message = "Server Time:" + now;
        	System.out.println( message );
            
        	eventBuilder = new OutboundEvent.Builder();
        	eventBuilder.id(now);
            eventBuilder.name("message");
            eventBuilder.data(String.class,
            		message );  // 推送伺服器時間的訊息給用戶端
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
