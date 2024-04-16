package com.seedapproach.tinker;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seedapproach.tinker.model.Category;
import com.seedapproach.tinker.model.Contractor;
import com.seedapproach.tinker.model.Customer;
import com.seedapproach.tinker.model.Task;
import com.seedapproach.tinker.service.ContractorService;
import com.seedapproach.tinker.service.CustomerService;
import com.seedapproach.tinker.service.SubCategoryService;
import com.seedapproach.tinker.service.TaskService;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class TinkerApplication implements CommandLineRunner {
	private ContractorService contractorService;
	private CustomerService customerService;
	private TaskService taskService;
	private SubCategoryService subCategoryService;

	public static void main(String[] args) {
		SpringApplication.run(TinkerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var contractor = new Contractor("Tushig", "Tsogtbaatar", "ts.battushig@gmail.com", "555-555-5555");
		var contractor2 = new Contractor("Enkhjin", "Tsogtbaatar", "ts.enkhjin@gmail.com", "555-666-6665");

		List.of(contractor, contractor2).stream().forEach(c -> contractorService.create(c));

		var customer = new Customer("Ganaa", "Gankhuyag", "ganaa@gmail.com", "555-555-8885");
		var customer2 = new Customer("Zulaa", "Zultsetseg", "zulaa@gmail.com", "555-555-8886");

		List.of(customer, customer2).stream().forEach(c -> customerService.create(c));

		var category = new Category("Furniture Assembly");
		var subCategory = subCategoryService.create(category, "IKEA furniture construction");

		taskService.create(new Task(subCategory, "I want someone can help me build my Norden.", contractor, customer));
		var deletingTask = taskService.create(new Task(subCategory, "I want someone can help me build my Rimforsa.", contractor2, customer2));

		subCategory.setName("IKEA furniture assembly");
		subCategoryService.update(subCategory);

		taskService.deleteById(deletingTask.getId());
	}

}
