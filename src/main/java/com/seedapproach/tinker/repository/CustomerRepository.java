package com.seedapproach.tinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seedapproach.tinker.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}