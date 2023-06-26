package com.projects.Alertify.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("healthcheck/")
public class HealthCheckController {

    @GetMapping("status")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok("Alive and Kicking");
    }
}
