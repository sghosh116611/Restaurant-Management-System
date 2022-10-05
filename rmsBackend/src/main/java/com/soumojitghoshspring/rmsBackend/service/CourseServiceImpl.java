package com.soumojitghoshspring.rmsBackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soumojitghoshspring.rmsBackend.dao.intrface.CourseDAO;
import com.soumojitghoshspring.rmsBackend.entity.Course;
import com.soumojitghoshspring.rmsBackend.service.intrface.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;
	
	@Override
	@Transactional
	public List<Course> findAll() {
		return courseDAO.findAll();
	}

	@Override
	@Transactional
	public Course findCourse(int courseId) {
		return courseDAO.findCourse(courseId);
	}

	@Override
	@Transactional
	public void save(Course course) {
		courseDAO.save(course);
	}

	@Override
	@Transactional
	public void delete(int courseId) {
		courseDAO.delete(courseId);
	}

}
