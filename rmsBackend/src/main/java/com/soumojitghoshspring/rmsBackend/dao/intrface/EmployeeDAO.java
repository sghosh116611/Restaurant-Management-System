package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;
import java.util.Optional;

import com.soumojitghoshspring.rmsBackend.entity.Employee;
import com.soumojitghoshspring.rmsBackend.entity.Item;

public interface EmployeeDAO {
	public List<Employee> findAll(Optional<List<String>> sort, String order);

	public Employee findEmployee(int employeeId);

	public void save(Employee employee);

	public void delete(int employeeId);
}
