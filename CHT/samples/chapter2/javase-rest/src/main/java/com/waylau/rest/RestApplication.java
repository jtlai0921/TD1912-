package com.waylau.rest;

 
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * REST 主套用
 * 
 * @author waylau.com
 * 2015年3月3日
 */
public class RestApplication extends ResourceConfig {

	public RestApplication() {
		// 資源類別所在的包路徑  
	    packages("com.waylau.rest.resource");
	    
	    // 登錄 MultiPart
	    register(MultiPartFeature.class);
 
	}
}
