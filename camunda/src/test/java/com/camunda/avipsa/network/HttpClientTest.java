//package com.camunda.avipsa.network;
//
//import okhttp3.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//
//import java.io.IOException;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class HttpClientTest {
//
//    @Mock
//    OkHttpClient mockOkHttpClient;
//
//    @InjectMocks
//    HttpClient httpClient;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetData() throws IOException {
//        // Given
//        String url = "http://example.com";
//        Callback mockCallback = mock(Callback.class);
//
//        // Mock behavior of OkHttp's Call
//        Call mockCall = mock(Call.class);
//        when(mockOkHttpClient.newCall(any())).thenReturn(mockCall);
//
//        // When
//        httpClient.getData(url, mockCallback);
//
//        // Then
//        verify(mockOkHttpClient).newCall(any()); // Verify that newCall was invoked with any Request
//
//        // Simulate the callback behavior (assuming success)
//        Response mockResponse = mock(Response.class);
//        when(mockResponse.isSuccessful()).thenReturn(true); // Example success condition
//
//        // Stubbing the execute method to return the mockResponse
//        when(mockCall.execute()).thenReturn(mockResponse);
//
//        // Optionally, you can verify that enqueue was called on the mockCall
//        verify(mockCall).enqueue(any());
//
//        // Optionally, simulate the callback manually (assuming success)
//        ResponseBody mockResponseBody = mock(ResponseBody.class);
//        when(mockResponse.body()).thenReturn(mockResponseBody);
//        when(mockResponseBody.string()).thenReturn("Mocked response body");
//
//        // Manually invoke the callback to simulate success
//        mockCallback.onResponse(mockCall, mockResponse);
//
//        // You can assert further based on the callback behavior or the result returned by HttpClient.getData()
//    }
//}
