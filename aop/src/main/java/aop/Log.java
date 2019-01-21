package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {

    @AfterReturning("execution(* aop.Service*.*(..)) && args(str,..)")
    public void logAfterReturning(JoinPoint jp, String str) {
        System.out.println("JoinPointSignature: " + jp.getSignature());
        System.out.println("JoinPointArgs: " + str);
    }

    @AfterThrowing(pointcut = "execution(* aop.Service*.*(..)) && args(str,..)", throwing = "ex")
    public void logAfterThrowing(JoinPoint jp, String str, Exception ex) {
        System.out.println("JoinPointSignature: " + jp.getSignature());
        System.out.println("JoinPointArgs: " + str);
        System.out.println("ex: " + ex.getMessage());
    }
}