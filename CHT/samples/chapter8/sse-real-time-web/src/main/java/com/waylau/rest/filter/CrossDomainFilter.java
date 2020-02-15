package com.waylau.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * �����G�䴩 Cross-domain �ШD
 *
 * @author <a href="http://www.waylau.com">waylau.com</a> 2015�~8��22�� 
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
		
		// �T���Y�[�J�F��e�\�s������A* �N��O������
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*"); 

	}

}
