package com.camunda.avipsa.exception.error;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CamundaInterviewErrorTest {

    @Test
    void testInvalidAnimalChoiceException() {
        // Given
        CamundaInterviewError error = CamundaInterviewError.INVALID_ANIMAL_CHOICE_EXCEPTION;

        // Then
        assertNotNull(error);
        assertEquals("Wrong AnimalEntity Selected", error.getErrorMessage());
        assertEquals(HttpStatus.BAD_REQUEST, error.getHttpStatus());
    }

    @Test
    void testImageFetchFailedException() {
        // Given
        CamundaInterviewError error = CamundaInterviewError.IMAGE_FETCH_FAILED_EXCEPTION;

        // Then
        assertNotNull(error);
        assertEquals("Unable to fetch image", error.getErrorMessage());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, error.getHttpStatus());
    }
}
