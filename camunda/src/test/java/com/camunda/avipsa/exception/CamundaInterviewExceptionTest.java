package com.camunda.avipsa.exception;

import com.camunda.avipsa.exception.error.CamundaInterviewError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CamundaInterviewExceptionTest {

    @Test
    void testCamundaInterviewException_withException() {
        // Given
        Exception nestedException = new Exception("Nested exception message");
        CamundaInterviewError error = CamundaInterviewError.IMAGE_FETCH_FAILED_EXCEPTION;

        // When
        CamundaInterviewException exception = new CamundaInterviewException(error, nestedException);

        // Then
        assertNotNull(exception);
        assertEquals(error, exception.getError());
        assertEquals("Nested exception message", exception.getCause().getMessage());
    }

    @Test
    void testCamundaInterviewException_withoutException() {
        // Given
        CamundaInterviewError error = CamundaInterviewError.INVALID_ANIMAL_CHOICE_EXCEPTION;

        // When
        CamundaInterviewException exception = new CamundaInterviewException(error);

        // Then
        assertNotNull(exception);
        assertEquals(error, exception.getError());
        assertEquals(error.name(), exception.getMessage());
    }
}
