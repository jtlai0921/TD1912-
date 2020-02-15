package com.waylau.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * 說明：支援 Cross-domain 請求
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015年8月22日 
 */
public class CrossDomainFilter implements ContainerResponseFilter {

	/**
	 * 
	 */
	public CrossDomainFilter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.container.ContainerRequestContext, javax.ws.rs.container.ContainerResponseContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		
		// 響應頭加入了對容許存取的域，* 代表是全部域
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*"); 

	}

}
