package com.example.customerservice.config;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
@Getter
@Setter
@AllArgsConstructor
@NotNull
public class GlobalConfig
{
    private int p1;
    private int p2;
}
