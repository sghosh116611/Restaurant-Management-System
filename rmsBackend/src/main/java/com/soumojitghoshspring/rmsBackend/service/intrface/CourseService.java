package com.soumojitghoshspring.rmsBackend.service.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.Course;

public interface CourseService {

	public List<Course> findAll();

	public Course findCourse(int courseId);

	public void save(Course course);

	public void delete(int courseId);
	
}
