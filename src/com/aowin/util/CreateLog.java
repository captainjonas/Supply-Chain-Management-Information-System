package com.aowin.util;

import org.apache.log4j.Logger;


public class CreateLog {
	public static void log(Class clazz){
		Logger log=Logger.getLogger(clazz);
		log.error("数据库异常");
	}

}
