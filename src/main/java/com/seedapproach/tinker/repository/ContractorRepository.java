package com.seedapproach.tinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seedapproach.tinker.model.Contractor;

public interface ContractorRepository extends JpaRepository<Contractor, Integer> {

}
