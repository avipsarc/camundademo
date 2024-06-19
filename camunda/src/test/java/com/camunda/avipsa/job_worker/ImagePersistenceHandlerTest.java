package com.camunda.avipsa.job_worker;

import com.camunda.avipsa.clients.AnimalImageFetcherClient;
import com.camunda.avipsa.database.AnimalImageDao;
import com.camunda.avipsa.response.ImageResponse;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImagePersistenceHandlerTest {

    @Mock
    private AnimalImageFetcherClient imageFetcherClient;

    @Mock
    private AnimalImageDao animalImageDao;

    @InjectMocks
    private ImagePersistenceHandler imagePersistenceHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAndPersistImageForAnimal() throws Exception {
        // Given
        String animal = "cat";
        ImageResponse mockResponse = new ImageResponse();
        mockResponse.setImageUrl("http://example.com/cat.jpg");
        mockResponse.setImage(new byte[]{});

        CompletableFuture<ImageResponse> mockFuture = CompletableFuture.completedFuture(mockResponse);
        when(imageFetcherClient.getImageDetails(animal)).thenReturn(mockFuture);

        // When
        imagePersistenceHandler.fetchAndPersistImageForAnimal(animal);

        // Then
        verify(imageFetcherClient, times(1)).getImageDetails(animal);
        verify(animalImageDao, times(1)).save(any());
    }

    @Test
    public void testProcessAnimal() throws Exception {
        // Given
        String animal = "cat";
        ImageResponse mockResponse = new ImageResponse();
        mockResponse.setImageUrl("https://api.thecatapi.com/v1/images/0XYvRd7oD");
        mockResponse.setImage(new byte[]{});

        CompletableFuture<ImageResponse> mockFuture = CompletableFuture.completedFuture(mockResponse);
        when(imageFetcherClient.getImageDetails(animal)).thenReturn(mockFuture); // Ensure stubbing is complete

        // When
        imagePersistenceHandler.processAnimal(mock(ActivatedJob.class), animal);

        // Then
        verify(imageFetcherClient, times(1)).getImageDetails(animal);
        verify(animalImageDao, times(1)).save(any());
    }
}
