package com.camunda.avipsa.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ImageResponseTest {

    @Test
    void testImageResponse() {
        // Given
        String imageUrl = "https://example.com/image.jpg";
        byte[] imageData = {0x00, 0x01, 0x02}; // Example byte array

        // When
        ImageResponse imageResponse = new ImageResponse(imageUrl, imageData);

        // Then
        assertEquals(imageUrl, imageResponse.getImageUrl());
        assertEquals(imageData, imageResponse.getImage());
    }

    @Test
    void testImageResponseWithNullValues() {
        // When
        ImageResponse imageResponse = new ImageResponse();

        // Then
        assertNull(imageResponse.getImageUrl());
        assertNull(imageResponse.getImage());
    }
}
