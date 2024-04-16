package com.seedapproach.tinker.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;
    @OneToOne
    private Image image;

    public Category(String name) {
        this.name = name;
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategories.add(subCategory);
    }
}
