package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.EmployeeDAO;
import com.soumojitghoshspring.rmsBackend.dao.intrface.EmployeeTypeDAO;
import com.soumojitghoshspring.rmsBackend.entity.Employee;
import com.soumojitghoshspring.rmsBackend.entity.EmployeeType;
import com.soumojitghoshspring.rmsBackend.entity.Item;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class EmployeeTypeDAOImpl implements EmployeeTypeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<EmployeeType> findAll(Optional<List<String>> sort, String order) {

		Session currentSession = entityManager.unwrap(Session.class);

		String orderByQuery = " order by id";

		String findQuery = "from EmployeeType" + orderByQuery;

		Query<EmployeeType> query = currentSession.createQuery(findQuery, EmployeeType.class);

		List<EmployeeType> employeeTypes = query.getResultList();

		return employeeTypes;
	}

	@Override
	public EmployeeType findEmployeeType(int employeeTypeId) {
		Session currentSession = entityManager.unwrap(Session.class);

		EmployeeType employeeType = currentSession.get(EmployeeType.class, employeeTypeId);

		if (employeeType == null) {
			throw new GenericCustomException("No employee type found with ID : " + employeeTypeId);
		}

		return employeeType;
	}

	@Override
	public void save(EmployeeType employeeType) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(employeeType);
	}

	@Override
	public void delete(int employeeTypeId) {
		Session currentSession = entityManager.unwrap(Session.class);

		EmployeeType employeeType = this.findEmployeeType(employeeTypeId);

		Query<Item> query = currentSession.createQuery("delete from EmployeeType where id=:employeeTypeId");
		query.setParameter("employeeTypeId", employeeTypeId);

		query.executeUpdate();
	}

}
