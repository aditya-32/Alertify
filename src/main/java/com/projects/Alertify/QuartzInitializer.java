package com.projects.Alertify;

import com.projects.Alertify.Jobs.MonitoringJob;
import com.projects.Alertify.manager.QuartzManager;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class QuartzInitializer implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    QuartzManager quartzManager;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("Starting Quartz on Application StartUp");
        Set<Job> jobList = new HashSet<>();
        jobList.add(new MonitoringJob());
        quartzManager.scheduleJobs(jobList);
    }
}
