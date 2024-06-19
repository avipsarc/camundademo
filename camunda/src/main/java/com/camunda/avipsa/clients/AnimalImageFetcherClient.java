package com.camunda.avipsa.clients;

import com.camunda.avipsa.animal.AnimalEntity;
import com.camunda.avipsa.exception.CamundaInterviewException;
import com.camunda.avipsa.network.HttpClient;
import com.camunda.avipsa.response.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AnimalImageFetcherClient {

    @Autowired private HttpClient httpClient;

    public CompletableFuture<ImageResponse> getImageDetails(String animalType) throws CamundaInterviewException {
        AnimalEntity animalEntity = AnimalEntity.getAnimal(animalType);
        CompletableFuture<ImageResponse> imageResponseFuture = new CompletableFuture<>();
        httpClient.getData(animalEntity.getImageUrl(), AnimalEntity.getImageTransformerCallback(imageResponseFuture));
        return imageResponseFuture;
    }
}
