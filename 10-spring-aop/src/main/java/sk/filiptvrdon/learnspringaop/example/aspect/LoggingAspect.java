package sk.filiptvrdon.learnspringaop.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Before execution of * method in given package
    // logic implemented in this method will be executed
    @Before("execution(* sk.filiptvrdon.learnspringaop.example.business.*.*(..))")
    public void logMethodCallBeforeCall(JoinPoint joinPoint) {
	logger.info("Before Method {} with arguments: {}", joinPoint, joinPoint.getArgs());

    }

    @After("execution(* sk.filiptvrdon.learnspringaop.example.business.*.*(..))")
    public void logMethodCallAfterCall(JoinPoint joinPoint) {
	logger.info("After Method {} with arguments: {}", joinPoint, joinPoint.getArgs());

    }

    @AfterThrowing(
	    pointcut = "execution(* sk.filiptvrdon.learnspringaop.example.business.*.*(..))",
	    throwing = "exception")
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
	logger.info("AfterThrowing Method {} has thrown an exception {}", joinPoint, exception);

    }
    
    @AfterReturning(
	    pointcut = "execution(* sk.filiptvrdon.learnspringaop.example.business.*.*(..))",
	    returning = "result")
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object result) {
	logger.info("AfterReturning Method {} has executed and returned {}", joinPoint, result);

    }
    
    
    

}
