package com.soumojitghoshspring.rmsBackend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soumojitghoshspring.rmsBackend.dao.intrface.CourseDAO;
import com.soumojitghoshspring.rmsBackend.entity.Course;
import com.soumojitghoshspring.rmsBackend.exceptions.GenericCustomException;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Course> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Course> query = currentSession.createQuery("from Course", Course.class);

		List<Course> courses = query.getResultList();

		return courses;
	}

	@Override
	public Course findCourse(int courseId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Course course = currentSession.get(Course.class, courseId);
		
		if(course == null) {
			throw new GenericCustomException("No course found with id:"+courseId);
		}

		return course;
	}

	@Override
	public void save(Course course) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(course);
	}

	@Override
	public void delete(int courseId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Course course = this.findCourse(courseId);

		Query<Course> query = currentSession.createQuery("delete from Course where id=:courseId");
		query.setParameter("courseId", courseId);

		query.executeUpdate();
	}

}
