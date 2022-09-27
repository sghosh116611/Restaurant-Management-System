package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;
import java.util.Optional;

import com.soumojitghoshspring.rmsBackend.entity.EmployeeType;

public interface EmployeeTypeDAO {
	public List<EmployeeType> findAll(Optional<List<String>> sort, String order);

	public EmployeeType findEmployeeType(int employeeId);

	public void save(EmployeeType employeeType);

	public void delete(int employeeTypeId);
}
