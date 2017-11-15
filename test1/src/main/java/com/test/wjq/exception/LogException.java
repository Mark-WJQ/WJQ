package com.test.wjq.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by wangjianqiang on 2017/11/11.
 */
public class LogException extends Exception {

static Logger logger = Logger.getLogger(LogException.class.getSimpleName());
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public LogException() {

        StringWriter trace = new StringWriter();

        printStackTrace(new PrintWriter(trace));

           logger.severe(trace.toString());

    }


    public static void main(String[] args) {
        try {
            throw new LogException();
        }catch (LogException e){
            System.err.println(e);
            e.getStackTrace();
            e.printStackTrace();
            //e.printStackTrace();
        }
    }
}
