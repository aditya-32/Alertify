package com.projects.Alertify.Annotation;

import com.projects.Alertify.enums.TimeDelays;
import com.projects.Alertify.enums.TimeIntervals;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Trigger {
    public TimeDelays delay()  default TimeDelays.TIME_5_MIN;
    public TimeIntervals interval() default TimeIntervals.TIME_10_MIN;

}
