package com.statsd.aspect;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark the methods that need timing information from the around advice in SystemTiming.
 * It is critical that the retention policy be RUNTIME so that the annotation values are available at runtime to the advice
 *
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Timed {

    //sample value passed into the advice of methods marked with this annotation
    String timingNotes();
}
