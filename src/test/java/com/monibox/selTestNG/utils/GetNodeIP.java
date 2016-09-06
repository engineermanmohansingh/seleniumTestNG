/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monibox.selTestNG.utils;

/**
 *
 * @author manmohansingh
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class GetNodeIP {

	
	public static String getNodeExecutionId(String url){
		try {
			JSONObject ob = httpGetJSONObject(url);
			System.out.println("Node is "+ob.get("proxyId"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}
	
	 public static JSONObject httpGetJSONObject(final String url) throws IOException, JSONException {
	        return new JSONObject(httpGetJSONString(url));
	    }
	 
	 private static String httpGetJSONString(final String url) {
	        HttpURLConnection httpCon;
	        StringBuffer httpResponse = null;
			try {
				httpCon = createHttpCon(url, "GET");
				 final BufferedReader br =
			                new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			 
				   httpResponse = new StringBuffer();
			        String line = "";
			        while (null != (line = br.readLine())) {
			            httpResponse.append(line);
			        }
			 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	       
	        return httpResponse.toString();
	    }
	 
	 private static HttpURLConnection createHttpCon(final String url, final String method)
	            throws IOException {
	        final HttpURLConnection httpCon;
	        httpCon = (HttpURLConnection) new URL(url).openConnection();
	        httpCon.setDoOutput(true);
	        httpCon.setRequestMethod(method);
	        httpCon.setRequestProperty("Content-type", "application/json");
	        httpCon.setRequestProperty("accept", "application/json");
	        
	 
	        return httpCon;
	    }
	
}
