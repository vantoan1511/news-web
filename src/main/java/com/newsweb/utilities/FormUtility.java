package com.newsweb.utilities;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtility {

	public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
		T object = null;
		try {
			object = tClass.getDeclaredConstructor().newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			System.out.println(e.getMessage());
		}
		return object;
	}
}
