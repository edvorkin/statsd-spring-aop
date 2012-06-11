package com.statsd.aspect;





import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.statsd.client.StatsdClient;

import java.lang.reflect.Method;

/**
 * This class declares the aspects for the system.  In this example is an around advice for timing the length of methods
 * marked with the Timed annotation
 *
 *
 */
@Aspect
public class StatdPerformanceAspect {

	@Autowired 
	private StatsdClient statsdClient;
    /**
     * This around advice adds timing to any method annotated with the Timed annotation.
     * It binds the annotation to the parameter timedAnnotation so that the values are available at runtime.
     * Also note that the retention policy of the annotation needs to be RUNTIME.
     *
     * @param pjp             - the join point for this advice
     * @param timedAnnotation - the Timed annotation as declared on the method
     * @return
     * @throws Throwable
     */

    @Around("@annotation( timedAnnotation ) ")
    public Object processSystemRequest(final ProceedingJoinPoint pjp, Timed timedAnnotation) throws Throwable {
        try {
        	Log4JLogger log=new Log4JLogger("StatdPerformanceAspect.class");
            long start = System.currentTimeMillis();
            Object retVal = pjp.proceed();
            long end = System.currentTimeMillis();
            long differenceMs = end - start;

            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Method targetMethod = methodSignature.getMethod();
            //get the value of timing notes as declared in the method annotation
            String timingNotes = timedAnnotation.timingNotes();
            //String requestInfo = param.getRequestInfo();
            statsdClient.increment(targetMethod.getDeclaringClass().getName() + "." + targetMethod.getName());
            statsdClient.timing(targetMethod.getDeclaringClass().getName() + "." + targetMethod.getName(),(int) differenceMs) ;
            log.debug(targetMethod.getDeclaringClass().getName() + "." + targetMethod.getName() + " took " + differenceMs + " ms : timing notes: " + timingNotes + " request info : ");
            return retVal;
        } catch (Throwable t) {
            System.out.println("error occured");
            throw t;
        }

    }

}

