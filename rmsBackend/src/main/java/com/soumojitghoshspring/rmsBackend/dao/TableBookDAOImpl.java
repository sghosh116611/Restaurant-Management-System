package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.TableBookDAO;
import com.soumojitghoshspring.rmsBackend.entity.TableBook;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class TableBookDAOImpl implements TableBookDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TableBook> getAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<TableBook> query = currentSession.createQuery("from TableBook", TableBook.class);

		List<TableBook> tableBooks = query.getResultList();

		return tableBooks;
	}

	@Override
	public TableBook get(int tableBookId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableBook tableBook = currentSession.get(TableBook.class, tableBookId);
		
		if(tableBook == null) {
			throw new GenericCustomException("No Table Booked with id:"+ tableBookId);
		}
		
		return tableBook;
	}

	@Override
	public void save(TableBook tableBook) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(tableBook);

	}

	@Override
	public void delete(int tableBookId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		TableBook tableBook = this.get(tableBookId);
		
		Query<TableBook> query = currentSession.createQuery("delete from TableBook where id=:tableBookId");
		query.setParameter("tableBookId", tableBookId);
		
		query.executeUpdate();
	}

}
