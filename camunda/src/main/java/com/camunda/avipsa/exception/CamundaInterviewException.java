package com.camunda.avipsa.exception;

import com.camunda.avipsa.exception.error.CamundaInterviewError;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CamundaInterviewException extends Exception {

    private final CamundaInterviewError error;

    public CamundaInterviewException(CamundaInterviewError error, Exception exception) {
        super(exception);
        this.error = error;
    }

    public CamundaInterviewException(CamundaInterviewError camundaInterviewError) {
        super(camundaInterviewError.name());
        this.error = camundaInterviewError;
    }
}
