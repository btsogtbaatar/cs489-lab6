package com.seedapproach.tinker.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category parentCategory;
    @OneToOne
    private Image image;
    @OneToMany(mappedBy = "subCategory")
    private List<Task> tasks;

    public SubCategory(String name) {
        this.name = name;
    }

    public SubCategory(String name, Category parentCategory) {
        this.name = name;
        this.parentCategory = parentCategory;
    }
}