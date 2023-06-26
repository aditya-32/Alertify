package com.projects.Alertify.Jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
public abstract class AbstractJob extends QuartzJobBean {

    @Override
    public void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Instant start = Instant.now();
        executeJobs(jobExecutionContext);
        Duration duration = Duration.between(start, Instant.now());
    }

    public abstract void executeJobs(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
