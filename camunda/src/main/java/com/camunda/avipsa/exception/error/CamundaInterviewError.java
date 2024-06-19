package com.camunda.avipsa.exception.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CamundaInterviewError {

    INVALID_ANIMAL_CHOICE_EXCEPTION("Wrong AnimalEntity Selected", HttpStatus.BAD_REQUEST),
    IMAGE_FETCH_FAILED_EXCEPTION("Unable to fetch image", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String errorMessage;
    private final HttpStatus httpStatus;
}
