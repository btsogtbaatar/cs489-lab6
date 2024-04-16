package com.seedapproach.tinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seedapproach.tinker.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
