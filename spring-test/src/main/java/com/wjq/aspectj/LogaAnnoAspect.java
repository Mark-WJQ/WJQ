package com.wjq.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogaAnnoAspect {


    private static Logger logger = LoggerFactory.getLogger(LogaAnnoAspect.class);

    /**
     * 按照实验结果看，within 不仅仅是对匹配到的切点做处理，而且对切点方法中的调用的方法也会进行代理
     * within 与 @within 同事出现出现会发生冲突，导致编译不通过
     */
    @Pointcut("within(com.wjq.aspectj.LogTestAspect)")
    public void expression() {

    }


  /*  @Before("expression()")
    public void beforeAnno(JoinPoint point){
        logger.info("exec beforeAnno  ===================:{}",point);
    }
*/

    @Pointcut("@within(LogAnno)")
    public void withinexpression() {

    }


    @After("withinexpression()")
    public void withinAnnoExpression(JoinPoint point) {
        logger.info("withinAnnoExpression:{}", point);
    }

    @Pointcut("target(LogTestAspect)")
    public void taegetExpression() {

    }

    @Before("taegetExpression()")
    public void testTarget(JoinPoint point) {
        logger.info("exec testTarget:{}", point.getSourceLocation());
    }

    /**
     * 对用注解{@link LogAnno}标注的目标类的每个方法进行织入
     */
    @Pointcut("@target(LogAnno)")
    public void taegetAnnoExpression() {

    }


    @Before("taegetAnnoExpression()")
    public void testTargetAnno(JoinPoint point) {
        logger.info("exec taegetAnnoExpression:{}", point.getSourceLocation());
    }

}
