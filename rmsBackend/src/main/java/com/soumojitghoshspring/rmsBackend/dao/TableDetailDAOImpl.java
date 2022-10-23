package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableDetailDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableDetail;
import com.soumojitghoshspring.rmsBackend.entity.TableType;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class TableDetailDAOImpl implements TableDetailDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<TableDetail> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<TableDetail> query = currentSession.createQuery("from TableDetail",TableDetail.class);
		
		List<TableDetail> tableDetails = query.getResultList();
		
		return tableDetails;
	}

	@Override
	public TableDetail get(int tableDetailId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableDetail tableDetail = currentSession.get(TableDetail.class, tableDetailId);
		
		if(tableDetail == null) {
			throw new GenericCustomException("No table detail found with id:"+tableDetailId);
		}
		
		return tableDetail;
	}

	@Override
	public void save(TableDetail tableDetail) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(tableDetail);
		
	}

	@Override
	public void delete(int tableDetailId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableDetail tableDetail = this.get(tableDetailId);
		
		Query<TableDetail> query = currentSession.createQuery("delete from TableDetail where id=:tableDetailId");
		query.setParameter("tableDetailId", tableDetailId);
		
		query.executeUpdate();
	}

}
