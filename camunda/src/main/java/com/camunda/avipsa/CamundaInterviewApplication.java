package com.camunda.avipsa;

import org.springframework.boot.SpringApplication;
import io.camunda.zeebe.spring.client.EnableZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableZeebeClient
@Deployment(resources = "classpath:/camundaProcess/AnimalPictureApp.bpmn")
public class CamundaInterviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(CamundaInterviewApplication.class, args);
    }
}
