package com.seedapproach.tinker.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreatedDate
    private LocalDateTime created;
    private String description;
    @ManyToOne
    private SubCategory subCategory;
    @ManyToOne
    private Contractor contractor;
    @ManyToOne
    private Customer customer;

    public Task(SubCategory subCategory, String description, Contractor contractor, Customer customer) {
        this.subCategory = subCategory;
        this.description = description;
        this.contractor = contractor;
        this.customer = customer;
    }
}
