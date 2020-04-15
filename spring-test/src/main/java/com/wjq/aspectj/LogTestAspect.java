package com.wjq.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@LogAnno
public class LogTestAspect {

    private static Logger logger = LoggerFactory.getLogger(LogTestAspect.class);


    public static void log(String msg){
        logger.info("---------------------log someThing:{}",msg);
    }

    public void  instanceLog(String msg){
        logger.info("instance log:{}",msg);
    }

}
