package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;
import java.util.Optional;

import com.soumojitghoshspring.rmsBackend.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll(Optional<List<String>> sort, String order);

	public Employee findEmployee(int employeeId);

	public void save(Employee employee);

	public void delete(int employeeId);

}
