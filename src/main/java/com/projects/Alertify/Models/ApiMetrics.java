package com.projects.Alertify.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Builder
@Table(name = "metrics")
public class ApiMetrics {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "endpoint")
    private String endpoint;
    @Column(name = "requestpermin")
    private Double requestPerMin;
    @Column(name = "errorrate")
    private Double errorRate;
    @Column(name = "successrate")
    private Double successRate;

    public ApiMetrics() {

    }
}
