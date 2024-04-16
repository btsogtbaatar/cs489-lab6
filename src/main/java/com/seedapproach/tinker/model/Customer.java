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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @OneToMany(mappedBy = "customer")
    private List<Task> tasks;

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.user = new User(firstName, lastName, email, phoneNumber);
    }
}
