package com.embibe.musicPlatform.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.embibe.musicPlatform.dao.BookService;
import com.embibe.musicPlatform.dao.EmployeeRepository;
import com.embibe.musicPlatform.exception.ResourceNotFoundException;
import com.embibe.musicPlatform.model.Book;
import com.embibe.musicPlatform.model.Employee;

@RestController
@Service
public class EmployeeController {
	
	@Autowired
	private BookService bookService;

//	private final EmployeeRepository repository;
//
//	EmployeeController(EmployeeRepository repository) {
//		this.repository = repository;
//	}

	// Aggregate root

	@GetMapping("/employees")
	List<Book> all() {
		return bookService.getAllBooks();
//		List<Employee> employeeList = new ArrayList();
//		Employee sovitEmp = new Employee("sovit", "student");
//		employeeList.add(sovitEmp);
//		return employeeList;
	}

	@PostMapping("/employees")
	void newEmployee(@RequestBody Employee newEmployee) {
		//return repository.save(newEmployee);
		Book book1 = new Book(1L, "fasd", "sf");
		bookService.saveBook(book1);
	}

	// Single item

	@GetMapping("/employees/{id}")
	Optional<Employee> one(@PathVariable Long id) throws ResourceNotFoundException {

		//return repository.findById(id);
		return null;
	}

	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

//		return repository.findById(id)
//			.map(employee -> {
//				employee.setName(newEmployee.getName());
//				employee.setRole(newEmployee.getRole());
//				return repository.save(employee);
//			})
//			.orElseGet(() -> {
//				newEmployee.setId(id);
//				return repository.save(newEmployee);
//			});
		return null;
	}

	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		//repository.deleteById(id);
	}
}
