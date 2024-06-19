package com.camunda.avipsa.job_worker;

import com.camunda.avipsa.clients.AnimalImageFetcherClient;
import com.camunda.avipsa.database.AnimalImageDao;
import com.camunda.avipsa.database.Animal;
import com.camunda.avipsa.response.ImageResponse;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.Variable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagePersistenceHandler {

    @Autowired private AnimalImageFetcherClient imageFetcherClient;
    @Autowired private AnimalImageDao animalImageDao;

    @JobWorker(type = "fetch-animal")
    public void processAnimal(ActivatedJob job, @Variable String animalSelected) throws Exception {
        fetchAndPersistImageForAnimal(animalSelected);
    }

    public void fetchAndPersistImageForAnimal(String animal) throws Exception {
        imageFetcherClient.getImageDetails(animal)
                .thenAccept(imageResponse -> {
                    storeToDatabase(animal, imageResponse);
                }).get();
    }

    public void storeToDatabase(String animal, ImageResponse imageResponse) {
        Animal animalEntity = Animal.builder()
                .animal(animal)
                .imageUrl(imageResponse.getImageUrl())
                .image(imageResponse.getImage())
                .build();
        animalImageDao.save(animalEntity);
    }
}
