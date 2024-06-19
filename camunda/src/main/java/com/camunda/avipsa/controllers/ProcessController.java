package com.camunda.avipsa.controllers;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camunda/avipsa")
public class ProcessController {

    //Move to resources
    private static final String BPMN_PROCESS_ID = "Process_AnimalPictureApp2";

    @Autowired private ZeebeClient zeebeClient;

    public ProcessController(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

    @GetMapping("/process/start")
    public void startProcess() {
        zeebeClient
                .newCreateInstanceCommand()
                .bpmnProcessId(BPMN_PROCESS_ID)
                .latestVersion()
                .send()
                .join();
    }
}
