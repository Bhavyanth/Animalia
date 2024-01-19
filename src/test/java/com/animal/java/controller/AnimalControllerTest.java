package com.animal.java.controller;

import com.animal.java.dao.AnimalRepository;
import com.animal.java.model.Animal;
import com.animal.java.service.AnimalService;
import com.animal.java.utils.UUIDUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AnimalControllerTest {
    private AnimalRepository animalRepository = mock(AnimalRepository.class);

    private AnimalService animalService = new AnimalService(animalRepository);

    private String animalId = UUIDUtils.newStringId();

    @Test
    void testGetAllAnimals(){
        when(animalRepository.findAll()).thenReturn(getAllAnimalList());
        List<Animal> animalList = animalService.getAllAnimals();
        assertThat(CollectionUtils.isNotEmpty(animalList));
        assertThat(animalList.size()).isEqualTo(3);
    }

    @Test
    void testAddAnimal(){
        when(animalRepository.save(any())).thenReturn(mockAnimal());
        Animal animal = animalService.addAnimal(new Animal());
        assertThat(animal).isNotNull();
        assertThat(animal).isExactlyInstanceOf(Animal.class);

    }
    private List<Animal> getAllAnimalList() {
        return Stream.of(
                createAnimal("Siberian Tiger", "Sumatran", "STS001", 16),
                createAnimal("Lion", "African", "LA001", 10),
                createAnimal("Bear", "Grizzley", "PG002", 5)
        ).collect(Collectors.toList());
    }
    private Animal createAnimal(String name, String breed, String earTag, int age) {
        return Animal.builder()
                .id(UUID.randomUUID().toString())
                .age(age)
                .breed(breed)
                .name(name)
                .earTag(earTag)
                .build();
    }

    private Animal animalRequest(){
        return Animal.builder()
                .age(16)
                .breed("Siberian")
                .name("Tiger")
                .earTag("ST0032")
                .build();
    }

    private Animal mockAnimal(){
        return Animal.builder()
                .id(UUID.randomUUID().toString().substring(1,6))
                .age(16)
                .breed("Siberian")
                .name("Tiger")
                .earTag("ST0032")
                .build();
    }
}
