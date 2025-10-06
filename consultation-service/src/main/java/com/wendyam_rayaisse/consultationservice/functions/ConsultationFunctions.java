package com.wendyam_rayaisse.consultationservice.functions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;


@Configuration
public class ConsultationFunctions {
    private static final Logger log = LoggerFactory.getLogger(ConsultationFunctions.class);

    public Consumer<Long> updateCommunication(){

        return patientId->{
            log.info("the patientId is:{}", patientId.toString());
        };
    }
}
