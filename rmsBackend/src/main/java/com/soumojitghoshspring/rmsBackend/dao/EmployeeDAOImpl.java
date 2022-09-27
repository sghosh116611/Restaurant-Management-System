package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.EmployeeDAO;
import com.soumojitghoshspring.rmsBackend.entity.Employee;
import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll(Optional<List<String>> sort, String order) {

		Session currentSession = entityManager.unwrap(Session.class);

		String orderByQuery = " order by id";

		if (sort.isPresent()) {
			orderByQuery = " order by ";
			List<String> sortParameters = sort.get();
			for (int i = 0; i < sortParameters.size(); i++) {
				orderByQuery += sortParameters.get(i) + (i != sortParameters.size() - 1 ? "," : "");
			}
		}

		orderByQuery += " " + order;

		String findQuery = "from Employee where isActive=1" + orderByQuery;

		Query<Employee> query = currentSession.createQuery(findQuery, Employee.class);

		List<Employee> emmployees = query.getResultList();

		return emmployees;
	}

	@Override
	public Employee findEmployee(int employeeId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Employee employee = currentSession.get(Employee.class, employeeId);

		if (employee == null) {
			throw new GenericCustomException("No Item found with ID : " + employeeId);
		}

		return employee;
	}

	@Override
	public void save(Employee item) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(item);
	}

	@Override
	public void delete(int itemId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Employee item = this.findEmployee(itemId);

		Query<Item> query = currentSession.createQuery("delete from Employee where id=:itemId");
		query.setParameter("itemId", itemId);

		query.executeUpdate();
	}

}
