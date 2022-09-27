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
import com.soumojitghoshspring.rmsBackend.entity.EmployeeType;
import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.service.intrface.EmployeeService;
import com.soumojitghoshspring.rmsBackend.service.intrface.EmployeeTypeService;
import com.soumojitghoshspring.rmsBackend.service.intrface.ItemService;

@RestController
@RequestMapping("/api")
public class EmployeeTypeRestController {

	@Autowired
	private EmployeeTypeService employeeTypeService;

	@GetMapping("/employee-types")
	public List<EmployeeType> findAll(
			@RequestParam(name="sort",required = false) Optional<List<String>> sort, 
			@RequestParam(defaultValue="asc") String order ) {
		return employeeTypeService.findAll(sort,order);
	}

	@GetMapping("/employee-types/{employeeTypeId}")
	public EmployeeType findItem(@PathVariable int employeeTypeId) {
		return employeeTypeService.findEmployeeType(employeeTypeId);
	}

	@PostMapping("/employee-types")
	public ResponseEntity<EmployeeType> save(@RequestBody EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return new ResponseEntity<>(employeeType, HttpStatus.OK);
	}

	@PutMapping("/employee-types")
	public ResponseEntity<EmployeeType> update(@RequestBody EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return new ResponseEntity<>(employeeType, HttpStatus.OK);
	}

	@DeleteMapping("/employee-types/{employeeTypeId}")
	public ResponseEntity<String> delete(@PathVariable int employeeTypeid) {
		employeeTypeService.delete(employeeTypeid);
		return new ResponseEntity<>("Deleted item with id : " + employeeTypeid, HttpStatus.OK);
	}
	
}
