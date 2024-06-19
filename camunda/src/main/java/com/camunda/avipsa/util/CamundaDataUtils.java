package com.camunda.avipsa.util;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class CamundaDataUtils {

    public String getInputData(ActivatedJob job, String parameterName) {
        Map<String, Object> variables = job.getVariablesAsMap();
        return (String) variables.get(parameterName);
    }
}
