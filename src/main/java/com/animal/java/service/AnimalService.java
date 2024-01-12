package com.animal.java.service;

import com.animal.java.dao.AnimalRepository;
import com.animal.java.model.Animal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AnimalService {

    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal addAnimal(Animal animal) {
        animal.setId(UUID.randomUUID().toString().substring(1,6));
        return animalRepository.save(animal);
    }
}
