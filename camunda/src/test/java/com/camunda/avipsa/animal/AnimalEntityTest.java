package com.camunda.avipsa.animal;

import com.camunda.avipsa.exception.CamundaInterviewException;
import com.camunda.avipsa.response.ImageResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnimalEntityTest {

    @Test
    void testGetAnimal_validAnimal() throws CamundaInterviewException {
        // Given
        String animalName = "CAT";

        // When
        AnimalEntity animalEntity = AnimalEntity.getAnimal(animalName);

        // Then
        assertEquals(AnimalEntity.CAT, animalEntity);
    }

    @Test
    void testGetAnimal_invalidAnimal() {
        // Given
        String animalName = "UNKNOWN";

        // When, Then
        assertThrows(CamundaInterviewException.class, () -> AnimalEntity.getAnimal(animalName));
    }

    @Test
    void testGetImageTransformerCallback_success() throws IOException, InterruptedException, ExecutionException {
        // Given
        CompletableFuture<ImageResponse> mockFuture = new CompletableFuture<>();
        Callback callback = AnimalEntity.getImageTransformerCallback(mockFuture);
        Call mockCall = mock(Call.class);
        Response mockResponse = mock(Response.class);
        byte[] imageData = {0x00, 0x01, 0x02};
        when(mockCall.request().url().toString()).thenReturn("https://example.com/image.jpg");
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body().bytes()).thenReturn(imageData);

        // When
        callback.onResponse(mockCall, mockResponse);

        // Then
        ImageResponse imageResponse = mockFuture.get();
        assertNotNull(imageResponse);
        assertEquals("https://example.com/image.jpg", imageResponse.getImageUrl());
        assertArrayEquals(imageData, imageResponse.getImage());
    }

    @Test
    void testGetImageTransformerCallback_failure() throws InterruptedException {
        // Given
        CompletableFuture<ImageResponse> mockFuture = new CompletableFuture<>();
        Callback callback = AnimalEntity.getImageTransformerCallback(mockFuture);
        Call mockCall = mock(Call.class);
        IOException mockException = mock(IOException.class);

        // When
        callback.onFailure(mockCall, mockException);

        // Then
        assertThrows(ExecutionException.class, () -> mockFuture.get());
        assertTrue(mockFuture.isCompletedExceptionally());
    }
}
