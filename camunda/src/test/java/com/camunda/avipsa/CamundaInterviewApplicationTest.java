package com.camunda.avipsa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CamundaInterviewApplication.class)
public class CamundaInterviewApplicationTest {

    @Autowired
    private CamundaInterviewApplication application;

    @Test
    public void contextLoads() {
        // Check that the application context loads successfully
        assertThat(application).isNotNull();
    }
}
