package com.cafe.util;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WebServiceAPI {

	/**
	 * Gửi yêu cầu tới API Server và nhận về dữ liệu
	 * @param url
	 * @return
	 */
	public static String sendGET(String url) {
		String json = null;
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		json = webTarget.request(MediaType.APPLICATION_JSON).get(String.class);		
		
		return json;
	}
	
	public static String sendPOST(String url, String jsonObject) {
		String json = null;
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url);
		Entity<String> entity = Entity.entity(jsonObject, MediaType.APPLICATION_JSON);
		
		json = webTarget.request(MediaType.APPLICATION_JSON).post(entity, String.class);
		
		return json;
	}
}
