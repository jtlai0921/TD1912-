package com.waylau.rest;

 
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * REST �D�M��
 * 
 * @author waylau.com
 * 2015�~3��3��
 */
public class RestApplication extends ResourceConfig {

	public RestApplication() {
		// �귽���O�Ҧb���]���|  
	    packages("com.waylau.rest.resource");
	    
	    // �n�� MultiPart
	    register(MultiPartFeature.class);
 
	}
}
