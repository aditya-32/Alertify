package com.projects.Alertify.manager;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class QuartzManager {

    @Autowired
    private Scheduler scheduler;

    public void scheduleJobs(Set<Job> jobList) throws SchedulerException{
        for (Job job: jobList) {
            JobDetail jobDetail = getJobDetails(job.getClass());
            Trigger trigger = getTrigger(job.getClass());
            scheduler.scheduleJob(jobDetail, trigger);
        }
        scheduler.start();
    }

    private JobDetail getJobDetails(Class<? extends Job> job) {
        JobDataMap jobDataMap = new JobDataMap();
        return JobBuilder.newJob(job)
                .setJobData(jobDataMap)
                .build();
    }

    private Trigger getTrigger(Class<? extends Job> job) {
        com.projects.Alertify.Annotation.Trigger trigger = job.getDeclaredAnnotation(com.projects.Alertify.Annotation.Trigger.class);
        return TriggerBuilder.newTrigger()
                .withSchedule(getScheduler(trigger))
                .build();
    }

    private static SimpleScheduleBuilder getScheduler(com.projects.Alertify.Annotation.Trigger trigger) {
        return SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInMinutes(getDuration(trigger))
                .repeatForever();
    }

    private static Integer getDuration(com.projects.Alertify.Annotation.Trigger trigger) {
        switch (trigger.interval().getUnit()) {
            case HOURS -> {
                return trigger.interval().getDuration() * 60;
            }
            default -> {
                return trigger.interval().getDuration();
            }
        }
    }
}
