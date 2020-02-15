package com.waylau.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.waylau.rest.bean.MyBean;

/**
 * �ڸ귽 (�n�S�b"myresource"���|)
 * 
 * @author waylau.com 
 * 2015-3-1
 */
@Path("myresource")
public class MyResource {

    /**
     * ��k�B�z HTTP GET �ШD�C�Ǧ^������H"text/plain"�C�髬�A
	 * ���Τ��
     *
     * @return String �H text/plain �Φ��T��
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    

    /**
     * ��k�B�z HTTP GET �ШD�C�Ǧ^������H"application/xml"�C�髬�A
	 * ���Τ��
     *
     * @return MyPojo �H application/xml �Φ��T��
     */
    @GET
    @Path("pojoxml")
    @Produces(MediaType.APPLICATION_XML)
    public MyBean getPojoXml() {
    	MyBean pojo = new MyBean();
    	pojo.setName("waylau.com");
    	pojo.setAge(28);
        return pojo;
    }
    
    /**
     * ��k�B�z HTTP GET �ШD�C�Ǧ^������H"application/json"�C�髬�A
	 * ���Τ��
     *
     * @return MyPojo �H application/json �Φ��T��
     */
    @GET
    @Path("pojojson")
    @Produces(MediaType.APPLICATION_JSON)
    public MyBean getPojoJson() {
    	MyBean pojo = new MyBean();
    	pojo.setName("waylau.com");
    	pojo.setAge(28);
        return pojo;
    }
    
    @DELETE
    @Path("pojojson")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePojoJson(@QueryParam("name") String name ) {
        return  "You delete " + name;
    }
    
    @DELETE
    @Path("pojojson/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePojoJsonPath(@PathParam("name") String name ) {
        return  "You delete " + name;
    }
    
    //�U������ҬO�L�k������ body �@���Ѽƪ��ϭ����
//    @DELETE
//    @Path("pojojson")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String deletePojoJsonBody(@QueryParam("name") String name ) {
//        return  "You delete " + name;
//    }
 
}
