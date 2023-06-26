package com.projects.Alertify.Configuration;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class SchedulerJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {

    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    @Override
    public Object createJobInstance(TriggerFiredBundle triggerFiredBundle) throws Exception {
        Object job = super.createJobInstance(triggerFiredBundle);
        autowireCapableBeanFactory.autowireBean(job);
        return job;
    }
}
