package com.projects.Alertify.Respository;

import com.projects.Alertify.Models.ApiMetrics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MetricsRepository extends CrudRepository<ApiMetrics,Long>{

    ApiMetrics findByEndpoint(String endPoint);

    void deleteAll();
}
