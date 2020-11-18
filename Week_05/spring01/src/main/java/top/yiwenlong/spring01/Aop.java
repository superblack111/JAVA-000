package top.yiwenlong.spring01;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class Aop {

    public void startTransaction() {
        log.info("Call start transaction method.");
    }

    public void commitTransaction() {
        log.info("Call commit transaction method.");
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Before call JoinPoint's proceed method.");
        joinPoint.proceed();
        log.info("After call JoinPoint's proceed method.");

    }
}
