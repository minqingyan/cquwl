package com.cactus.cquwl.Util;


public class CacheUtil {
/*
	public static BasicGood getBasicGoodInCache(AdminUser adminUser){
		ServletContext servletContext =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager)webApplicationContext.getBean("cacheManagerLocation", EhCacheCacheManager.class);
		Cache dzshCache = (Cache) ehCacheCacheManager.getCache("dzshCache");
		return (BasicGood)dzshCache.get(adminUser);
	}
	
	public static Boolean addBasicGoodInCache(BasicGood basicGood,AdminUser adminUser){
		ServletContext servletContext = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager)webApplicationContext.getBean("cacheManagerLocation", EhCacheCacheManager.class);
		Cache dzshCache = (Cache)ehCacheCacheManager.getCache("dzshCache");
		dzshCache.put(adminUser, basicGood);
		return true;
	}
	*/
}
