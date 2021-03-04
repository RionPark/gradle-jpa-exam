package com.test.web.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Pson {

	public <T> String toString(T obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<T> clazz = (Class<T>) obj.getClass();
		Method[] ms = clazz.getDeclaredMethods();
		String json = "{";
		for(Method m:ms) {
			if(m.getName().indexOf("get")==0) {
				String key = m.getName().substring(3);
				key = key.substring(0,1).toLowerCase() + key.substring(1);
				Object value = m.invoke(obj);
				if(!(value instanceof Integer)) {
					value = "\"" + value + "\"";
				}
				json += "\"" + key +"\":" + value + ",";
			}
		}
		json = json.substring(0,json.length()-1) + "}";
		return json;
	}
}
