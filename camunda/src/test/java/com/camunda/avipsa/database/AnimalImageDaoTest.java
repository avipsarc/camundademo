package com.camunda.avipsa.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AnimalImageDaoTest {

    @Autowired
    private AnimalImageDao animalImageDao;

    @Test
    void testSaveAndFindAnimal() {
        // Given
        Animal animal = Animal.builder()
                .animal("CAT")
                .imageUrl("https://example.com/image.jpg")
                .image(new byte[]{0x00, 0x01, 0x02})
                .build();

        // When
        animalImageDao.save(animal);
        Optional<Animal> retrievedAnimalOptional = animalImageDao.findById("CAT");

        // Then
        assertTrue(retrievedAnimalOptional.isPresent());
        Animal retrievedAnimal = retrievedAnimalOptional.get();
        assertEquals("CAT", retrievedAnimal.getAnimal());
        assertEquals("https://example.com/image.jpg", retrievedAnimal.getImageUrl());
        assertArrayEquals(new byte[]{0x00, 0x01, 0x02}, retrievedAnimal.getImage());
    }
}
