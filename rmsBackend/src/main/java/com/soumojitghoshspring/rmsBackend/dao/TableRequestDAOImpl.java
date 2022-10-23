package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableRequestDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableRequest;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class TableRequestDAOImpl implements TableRequestDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TableRequest> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<TableRequest> query = currentSession.createQuery("from TableRequest",TableRequest.class);
		
		List<TableRequest> tableRequests = query.getResultList();
		
		return tableRequests;
	}

	@Override
	public TableRequest get(int tableRequestId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableRequest tableRequest = currentSession.get(TableRequest.class, tableRequestId);
		
		if(tableRequest == null) {
			throw new GenericCustomException("No table request found with id:"+tableRequestId);
		}
		
		return tableRequest;
	}

	@Override
	public void save(TableRequest tableRequest) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(tableRequest);
	}

	@Override
	public void delete(int tableRequestId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableRequest tableRequest = this.get(tableRequestId);
		
		Query<TableRequest> query = currentSession.createQuery("delete from TableRequest where id=:tableRequestId");
		query.setParameter("tableRequestId", tableRequestId);
	
		query.executeUpdate();
		
	}

}
