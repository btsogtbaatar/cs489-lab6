package com.seedapproach.tinker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seedapproach.tinker.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
