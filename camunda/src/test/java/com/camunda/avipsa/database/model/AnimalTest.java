package com.camunda.avipsa.database.model;

import com.camunda.avipsa.database.Animal;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnimalTest {

    @Test
    void testAnimalEntity() {
        // Given
        Timestamp now = new Timestamp(System.currentTimeMillis());
        byte[] imageData = {0x00, 0x01, 0x02};

        // When
        Animal animal = Animal.builder()
                .animal("CAT")
                .imageUrl("https://example.com/image.jpg")
                .image(imageData)
                .creationTimestamp(now)
                .updationTimestamp(now)
                .build();

        // Then
        assertEquals("CAT", animal.getAnimal());
        assertEquals("https://example.com/image.jpg", animal.getImageUrl());
        assertEquals(imageData, animal.getImage());
        assertNotNull(animal.getCreationTimestamp());
        assertNotNull(animal.getUpdationTimestamp());
    }
}
