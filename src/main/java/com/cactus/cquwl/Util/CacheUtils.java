package com.cactus.cquwl.Util;


import javax.servlet.ServletContext;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class CacheUtils {

	 private static ServletContext servletContext = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getServletContext();
	 private static WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	 private static CacheManager cacheManager = ((CacheManager)webApplicationContext.getBean("cacheManager"));


	 public static Object get(String cacheName,String key) {
		 return get0(cacheName, key);
	 }
	 
	 private static Object get0(String cacheName, String key) {
		 
		 Object obj = getCache(cacheName).get(key);
		 return obj;
	 }
	 
	 public static void put(String cacheName,String key, Object value) {
		 put0(cacheName, key, value);
	 }
	 
	 private static void put0(String cacheName, String key, Object value) {
		 
	  	 getCache(cacheName).put(key, value);
	 }
	 
	 public static void remove(String cacheName,String key) {
		 remove0(cacheName, key);
	 }

	 private static void remove0(String cacheName, String key) {
		 getCache(cacheName).remove(key);
	 }
	 
	 private static Cache getCache(String cacheName){
		 Cache cache = cacheManager.getCache(cacheName);
		 if (cache == null) 
			 return null;
		 else 
			 return cache;
	 }

	 public static CacheManager getCacheManager() {
		 return cacheManager;
	 }
}
