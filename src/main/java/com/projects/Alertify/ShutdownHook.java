package com.projects.Alertify;

import com.projects.Alertify.Respository.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private MetricsRepository metricsRepository;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("closing application");
        metricsRepository.deleteAll();
    }
}
