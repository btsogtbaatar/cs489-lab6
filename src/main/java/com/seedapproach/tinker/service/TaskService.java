package com.seedapproach.tinker.service;

import org.springframework.stereotype.Service;

import com.seedapproach.tinker.model.Task;
import com.seedapproach.tinker.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository repository;

    public Task create(Task task) {
        return repository.save(task);
    }

    public void deleteById(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }

    public Task update(Task task) {
        var updatingTask = this.getById(task.getId());

        updatingTask.setContractor(task.getContractor());
        updatingTask.setCustomer(task.getCustomer());
        updatingTask.setSubCategory(task.getSubCategory());
        updatingTask.setDescription(task.getDescription());

        return repository.save(updatingTask);
    }

    public Task getById(Integer id) {
        var optionalTask = repository.findById(id);

        if (optionalTask.isPresent()) {
            return optionalTask.get();
        } else {
            // TODO: Throw an exception here
            return null;
        }
    }
}
