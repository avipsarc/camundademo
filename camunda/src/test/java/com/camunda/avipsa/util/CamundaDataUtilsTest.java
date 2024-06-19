package com.camunda.avipsa.util;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CamundaDataUtilsTest {

    @Mock
    ActivatedJob mockJob;

    @Test
    void testGetInputData() {
        // Given
        String parameterName = "imageUrl";
        String expectedValue = "https://example.com/image.jpg";

        Map<String, Object> variables = new HashMap<>();
        variables.put(parameterName, expectedValue);

        MockitoAnnotations.openMocks(this);
        when(mockJob.getVariablesAsMap()).thenReturn(variables);

        // When
        String actualValue = CamundaDataUtils.getInputData(mockJob, parameterName);

        // Then
        assertEquals(expectedValue, actualValue);
        verify(mockJob, times(1)).getVariablesAsMap();
    }

    @Test
    void testGetInputDataWithMissingParameter() {
        // Given
        String parameterName = "imageUrl"; // Assuming this parameter is missing

        Map<String, Object> variables = new HashMap<>();

        MockitoAnnotations.openMocks(this);
        when(mockJob.getVariablesAsMap()).thenReturn(variables);

        // When
        String actualValue = CamundaDataUtils.getInputData(mockJob, parameterName);

        // Then
        assertNull(actualValue);
        verify(mockJob, times(1)).getVariablesAsMap();
    }
}
