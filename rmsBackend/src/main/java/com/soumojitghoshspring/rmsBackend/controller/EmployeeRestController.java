package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soumojitghoshspring.rmsBackend.entity.Employee;
import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.service.intrface.EmployeeService;
import com.soumojitghoshspring.rmsBackend.service.intrface.ItemService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAll(
			@RequestParam(name="sort",required = false) Optional<List<String>> sort, 
			@RequestParam(defaultValue="asc") String order ) {
		return employeeService.findAll(sort,order);
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findItem(@PathVariable int employeeId) {
		return employeeService.findEmployee(employeeId);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping("/employees")
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<String> delete(@PathVariable int employeeId) {
		employeeService.delete(employeeId);
		return new ResponseEntity<>("Deleted item with id : " + employeeId, HttpStatus.OK);
	}
	
}
