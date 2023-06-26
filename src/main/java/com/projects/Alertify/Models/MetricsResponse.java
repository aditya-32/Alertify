package com.projects.Alertify.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MetricsResponse {
    private String message;
    private List<ApiMetrics> apiMetrics;
}
