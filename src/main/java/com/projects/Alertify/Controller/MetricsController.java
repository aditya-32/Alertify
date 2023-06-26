package com.projects.Alertify.Controller;

import com.projects.Alertify.manager.MetricsManager;
import com.projects.Alertify.Models.MetricsResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Slf4j
@RestController
@RequestMapping(path = "/metrics/")
public class MetricsController {

    @Autowired
    private MetricsManager metricsManager;

    @GetMapping("getApiMetrics/{endPoint}")
    ResponseEntity<MetricsResponse> getApiMetrics(@PathVariable @NonNull String endPoint) {
        try {
            var apiMetrics = metricsManager.fetchApiMetrics(endPoint);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(MetricsResponse
                            .builder()
                            .message("Metrics Fetched Successfully")
                            .apiMetrics(Collections.singletonList(apiMetrics))
                            .build());
        } catch (Exception ex) {
            log.error("Error while fetching Api Metrics {} error {}", endPoint, ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MetricsResponse.builder()
                            .message("Error while Fetching Metrics: "+ex.getMessage())
                            .apiMetrics(null).build());
        }
    }

    @GetMapping("getAllMetrics")
    public ResponseEntity<MetricsResponse> getAllApiMetrics() {
        try {
            var apiMetrics = metricsManager.getAllMetrics();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(MetricsResponse
                            .builder()
                            .message("Metrics Fetched Successfully")
                            .apiMetrics(apiMetrics)
                            .build());
        } catch (Exception ex) {
            log.error("Error while fetching All Api Metrics error {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(MetricsResponse.builder()
                            .message("Error while Fetching All Metrics: "+ex.getMessage())
                            .apiMetrics(null).build());
        }
    }
}
