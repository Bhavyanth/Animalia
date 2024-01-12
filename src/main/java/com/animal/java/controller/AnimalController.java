package com.animal.java.controller;

import com.animal.java.model.Animal;
import com.animal.java.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
@AllArgsConstructor
public class AnimalController {

    private AnimalService animalService;

    @GetMapping("/getAllAnimals")
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @PostMapping("/addAnimal")
    public Animal addAnimal(@RequestBody Animal animal){
        return animalService.addAnimal(animal);
    }

    // find Animal by ID
    // Delete an Animal By ID
    // Edit an ANimal by ID
}
