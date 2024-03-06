package com.example.customerservice.controller;


import com.example.customerservice.config.GlobalConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class ConfigTestController {

   @Value("${global.params.p1}")
    private int p1;
    @Value("${global.params.p2}")
    private int p2;
    @Value("${customer.params.x}")
    private double x;
    @Value("${customer.params.y}")
    private double y;

    private final GlobalConfig globalConfig;


    @GetMapping("/testConfig")
    public Map<String,Double> configTest()
    {
        return Map.of("x",x,"y",y);
    }

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig()
    {
        return globalConfig;
    }



}
