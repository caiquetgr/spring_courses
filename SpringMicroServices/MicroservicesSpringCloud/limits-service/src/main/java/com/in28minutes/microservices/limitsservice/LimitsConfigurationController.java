package com.in28minutes.microservices.limitsservice;

import com.in28minutes.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-limits")
    @HystrixCommand(fallbackMethod = "fallbackConfigurationMethod")
    public LimitConfiguration faultRetrieveLimitsFromConfiguration() {
        throw new RuntimeException("Deu ruim");
    }

    public LimitConfiguration fallbackConfigurationMethod() {
        return new LimitConfiguration(999, 9);
    }

}
