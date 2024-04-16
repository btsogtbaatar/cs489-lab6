package com.seedapproach.tinker.service;

import org.springframework.stereotype.Service;

import com.seedapproach.tinker.model.Contractor;
import com.seedapproach.tinker.repository.ContractorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContractorService {
    private ContractorRepository repository;

    public Contractor create(Contractor contractor) {
        return repository.save(contractor);
    }

    public void deleteById(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    public Contractor getById(Integer id) {
        var optionalContractor = repository.findById(id);

        if (optionalContractor.isPresent()) {
            return optionalContractor.get();
        } else {
            // TODO: Throw an exception here
            return null;
        }
    }
}
