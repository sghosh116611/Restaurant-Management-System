package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableTypeDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableType;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class TableTypeDAOImpl implements TableTypeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TableType> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<TableType> query = currentSession.createQuery("from TableType",TableType.class);
		List<TableType> tableTypes = query.getResultList();
		
		return tableTypes;
	}

	@Override
	public TableType get(int tableTypeId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableType tableType = currentSession.get(TableType.class, tableTypeId);
		
		if(tableType == null) {
			throw new GenericCustomException("No table type found with id:"+tableTypeId);
		}
		
		return tableType;
	}

	@Override
	public void save(TableType tableType) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(tableType);
	}

	@Override
	public void delete(int tableTypeId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableType tableType = this.get(tableTypeId);
		
		Query<TableType> query = currentSession.createQuery("delete from TableType where id=:tableTypeId");
		query.setParameter("tableTypeId", tableTypeId);
		
		query.executeUpdate();
	}

}
