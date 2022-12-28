package com.tripkit.lighthouse.injector;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConstructorBinding
@ConfigurationProperties("google")
public class GoogleProperties {
    private String key;
}
