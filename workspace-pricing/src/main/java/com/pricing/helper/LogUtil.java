package com.pricing.helper;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class LogUtil {
	
	private final static Logger logger = Logger.getLogger(LogUtil.class);	

	public static void info(String className,String actionName,String requestMethod,String inputparm,String request,String response){
		MDC.put("class", className);
		MDC.put("action", actionName);
		MDC.put("method", requestMethod);
		MDC.put("inputparm", inputparm);
		MDC.put("request", request);
		logger.info(response);
	}

	public static void warn(String className,String actionName,int status,String requestMethod,String inputparm,String requestUrl,String exceptionType){
		MDC.put("class", className);
		MDC.put("action", actionName);
		MDC.put("method", requestMethod + " status="+ status);
		MDC.put("inputparm", inputparm);
		MDC.put("request"," url="+requestUrl);
		logger.warn("exception="+exceptionType);
	}
	
	public static void error(String className,String actionName,int status,String requestMethod,String inputparm,String requestUrl,String exceptionType){	   
		MDC.put("class", className);
		MDC.put("action", actionName);
		MDC.put("method", requestMethod + " status="+ status);
		MDC.put("inputparm", inputparm);
		MDC.put("request", " url="+requestUrl);
		logger.error("error="+exceptionType);
	}
}
