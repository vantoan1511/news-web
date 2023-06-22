package com.newsweb.utilities;

import java.io.BufferedReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtility {

	private String value;

	public HttpUtility(String value) {
		this.value = value;
		System.out.println(value);
	}

	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static HttpUtility of(BufferedReader reader) {
		StringBuilder builder = new StringBuilder();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
		} catch (Exception e) {
		}
		return new HttpUtility(builder.toString());
	}
}
