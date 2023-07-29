package sk.filiptvrdon.learnspringaop.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceTrackingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    
    //@Around("sk.filiptvrdon.learnspringaop.example.aspect.CommonPointcutConfig.businessPackageConfig()")
    @Around ("@annotation(sk.filiptvrdon.learnspringaop.example.aspect.CommonPointcutConfig.trackTimeAnnotation())")
    public Object trackExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
	long startTimeMillis = System.currentTimeMillis();
	
	Object result = pjp.proceed();
	
	long finishTimeMillis = System.currentTimeMillis();
	long durationMillis = finishTimeMillis - startTimeMillis;
	logger.info("Around Aspect - {} executed in {}", pjp ,durationMillis);
	
	return result;
    }
    

}
