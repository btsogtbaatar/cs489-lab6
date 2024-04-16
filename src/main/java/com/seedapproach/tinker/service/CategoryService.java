package com.seedapproach.tinker.service;

import org.springframework.stereotype.Service;

import com.seedapproach.tinker.model.Category;
import com.seedapproach.tinker.model.SubCategory;
import com.seedapproach.tinker.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository repository;

    public Category create(Category category) {
        return repository.save(category);
    }

    public void createSubCategory(Category category, SubCategory subCategory) {
        category.addSubCategory(subCategory);
        repository.save(category);
    }

    public void deleteById(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    public Category update(Category category) {
        var updatingCategory = this.getById(category.getId());
        updatingCategory.setName(category.getName());
        return repository.save(updatingCategory);
    }

    public Category getById(Integer id) {
        var optionalCategory = repository.findById(id);

        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            // TODO: Throw an exception here
            return null;
        }
    }
}
