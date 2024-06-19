//package com.camunda.avipsa.controllers;
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//import io.camunda.zeebe.client.ZeebeClient;
//import io.camunda.zeebe.client.api.command.CreateProcessInstanceCommandStep1;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class ProcessControllerTest {
//
//    private ProcessController processController;
//    private ZeebeClient zeebeClient;
//    private CreateProcessInstanceCommandStep1 createCommandStep1;
//    private CreateProcessInstanceCommandStep1 createCommandStep2;
//    private CreateProcessInstanceCommandStep1 createCommandStep3;
//
//    @BeforeEach
//    public void setUp() {
//        // Create mock ZeebeClient
//        zeebeClient = mock(ZeebeClient.class);
//
//        // Mock command steps
//        createCommandStep1 = mock(CreateProcessInstanceCommandStep1.class);
//        createCommandStep2 = mock(CreateProcessInstanceCommandStep1.class);
//        createCommandStep3 = mock(CreateProcessInstanceCommandStep1.class);
//
//        // Stub the behavior of the ZeebeClient methods
//        when(zeebeClient.newCreateInstanceCommand()).thenReturn(createCommandStep1);
//        //when(createCommandStep1.bpmnProcessId(anyString())).thenReturn((CreateProcessInstanceCommandStep1.CreateProcessInstanceCommandStep2) createCommandStep2);
//       // when(createCommandStep2.LATEST_VERSION).thenReturn(createCommandStep3);
//
//        // Stub the behavior of CreateProcessInstanceCommandStep3 methods
//        // You can add more stubbing as needed
//       // when(createCommandStep3.send()).thenReturn("Successfully sent");
//    }
//
//    @Test
//    public void testStartProcess() {
//        // Instantiate ProcessController with mock ZeebeClient
//        processController = new ProcessController(zeebeClient);
//
//        // Call the method under test
//        processController.startProcess();
//
//        // Verify interactions
//        verify(zeebeClient, times(1)).newCreateInstanceCommand();
//        verify(createCommandStep1, times(1)).bpmnProcessId(anyString());
//       // verify(createCommandStep2, times(1)).latestVersion();
//        //verify(createCommandStep3, times(1)).send();
//    }
//}
