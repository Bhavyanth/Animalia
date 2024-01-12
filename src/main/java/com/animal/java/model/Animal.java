package com.animal.java.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Animal {

    @Id
    private String id;

    private String breed;

    private String earTag;

    private String name;

    private int age;

    private double weight;

}
