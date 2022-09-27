package com.tripkit.lighthouse.module;

import com.tripkit.lighthouse.data.dto.SpotBasicDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class SenderModule {

    final RabbitTemplate rabbitTemplate;

    public void sender(SpotBasicDto spotBasicDto){
        rabbitTemplate.convertAndSend(spotBasicDto);
    }
}
