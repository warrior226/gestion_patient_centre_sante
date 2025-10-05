package com.wendyam_rayaisse.message.functions;


import com.wendyam_rayaisse.message.dto.ConsultationMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {
    private static final Logger logger = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<ConsultationMsgDto,ConsultationMsgDto> email(){

        return consultationMsgDto -> {
            logger.info("Sending email to {}",consultationMsgDto.toString());
            return consultationMsgDto;
        };
    }


    @Bean
    public Function<ConsultationMsgDto,Long> sms(){

        return consultationMsgDto -> {
            logger.info("Sending sms to {}",consultationMsgDto.toString());
            return consultationMsgDto.consultationId();
        };
    }
}
