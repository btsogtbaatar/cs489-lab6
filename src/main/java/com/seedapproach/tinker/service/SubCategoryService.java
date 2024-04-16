package com.seedapproach.tinker.service;

import org.springframework.stereotype.Service;

import com.seedapproach.tinker.model.Category;
import com.seedapproach.tinker.model.SubCategory;
import com.seedapproach.tinker.repository.SubCategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubCategoryService {
    private SubCategoryRepository repository;


    public SubCategory create(Category category, String name) {
        var subCategory = new SubCategory(name, category);
        return repository.save(subCategory);
    }


    public void deleteById(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    public SubCategory update(SubCategory subCategory) {
        var updatingSubCategory = this.getById(subCategory.getId());
        updatingSubCategory.setName(subCategory.getName());
        return repository.save(updatingSubCategory);
    }

    public SubCategory getById(Integer id) {
        var optionalSubCategory = repository.findById(id);

        if (optionalSubCategory.isPresent()) {
            return optionalSubCategory.get();
        } else {
            // TODO: Throw an exception here
            return null;
        }
    }
}
