package com.projects.Alertify.manager;

import com.projects.Alertify.Models.ApiMetrics;
import com.projects.Alertify.Respository.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MetricsManager {

    @Autowired
    private MetricsRepository metricsRepository;

    public ApiMetrics fetchApiMetrics(String endPoint) {
         return metricsRepository.findByEndpoint(endPoint);
    }

    public List<ApiMetrics> getAllMetrics() {
        Iterable<ApiMetrics> iterables = metricsRepository.findAll();
        List<ApiMetrics> apiMetrics = new ArrayList<>();
        iterables.forEach(iterable -> {
            ApiMetrics metrics = ApiMetrics.builder()
                    .endpoint(iterable.getEndpoint())
                    .id(iterable.getId())
                    .errorRate(iterable.getErrorRate())
                    .requestPerMin(iterable.getRequestPerMin())
                    .successRate(iterable.getSuccessRate())
                    .build();
            apiMetrics.add(metrics);
        });

        return apiMetrics;
    }

}
