package com.camunda.avipsa.clients;

import com.camunda.avipsa.exception.CamundaInterviewException;
import com.camunda.avipsa.response.ImageResponse;
import com.camunda.avipsa.network.HttpClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AnimalImageFetcherClientTest {

    @Mock
    private HttpClient httpClient;

    @InjectMocks
    private AnimalImageFetcherClient imageFetcherClient;

    @Captor
    private ArgumentCaptor<Callback> callbackCaptor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetImageDetails() throws IOException, ExecutionException, InterruptedException, CamundaInterviewException {
        // Given
        String animalType = "cat";
        String imageUrl = "https://api.thecatapi.com/v1/images/0XYvRd7oD";
        CompletableFuture<ImageResponse> mockFuture = new CompletableFuture<>();

        // Mock behavior of httpClient.getData to capture the Callback and simulate onResponse
        doAnswer(invocation -> {
            Callback callback = invocation.getArgument(1);
            Response mockResponse = mock(Response.class);
            when(mockResponse.isSuccessful()).thenReturn(true);
            when(mockResponse.body().bytes()).thenReturn(new byte[]{0x00, 0x01, 0x02});
            callback.onResponse(mock(Call.class), mockResponse);
            return null; // Since getData is void, return null explicitly
        }).when(httpClient).getData(eq(imageUrl), callbackCaptor.capture());

        // When
        CompletableFuture<ImageResponse> result = imageFetcherClient.getImageDetails(animalType);

        // Then
        assertEquals(mockFuture.get().getImageUrl(), result.get().getImageUrl()); // Example assertion
        // Add assertions based on your actual implementation and expected behavior
    }
}
