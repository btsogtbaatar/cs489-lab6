package com.seedapproach.tinker.service;

import org.springframework.stereotype.Service;

import com.seedapproach.tinker.model.Customer;
import com.seedapproach.tinker.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository repository;

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public void deleteById(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    public Customer getById(Integer id) {
        var optionalCustomer = repository.findById(id);

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        } else {
            // TODO: Throw an exception here
            return null;
        }
    }
}
