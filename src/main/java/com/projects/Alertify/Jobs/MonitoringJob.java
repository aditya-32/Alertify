package com.projects.Alertify.Jobs;

import com.projects.Alertify.Annotation.QuartzKey;
import com.projects.Alertify.Annotation.Trigger;
import com.projects.Alertify.enums.TimeDelays;
import com.projects.Alertify.enums.TimeIntervals;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Trigger(interval = TimeIntervals.TIME_1_MIN, delay = TimeDelays.TIME_5_SEC)
@Component
public class MonitoringJob extends AbstractJob {

    @Override
    public void executeJobs(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello Aditya current time is :" + Instant.now());
    }
}
