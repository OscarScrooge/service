package com.marvel.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONException;

public class Request {
	
	
	public Request(){}
	
	
	/*
	 * Método que obtiene los datos solicitados en la API Marvel
	 * */
	public JSONObject request(String url) {
		
		JSONObject jsonObject = null;
		 try {
	            URL path = new URL(url);
	            HttpURLConnection conn = (HttpURLConnection) path.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	            if (conn.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP Error code : "
	                        + conn.getResponseCode());

	            }
	            InputStreamReader in = new InputStreamReader(conn.getInputStream());
	            BufferedReader br = new BufferedReader(in);


	            jsonObject = new JSONObject(br.readLine());
	            conn.disconnect();
	        } catch (MalformedURLException | ProtocolException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
		 
		    return jsonObject;
		
	}

}
