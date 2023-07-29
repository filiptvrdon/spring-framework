package sk.filiptvrdon.learnspringaop.example.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonPointcutConfig {
    
    @Pointcut("execution(* sk.filiptvrdon.learnspringaop.example.*.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void serviceConfig() {}
    
    @Pointcut("annotation(sk.filiptvrdon.learnspringaop.example.aspect.annotations.TrackTime)")
    public void trackTimeAnnotation() {}
    
}
