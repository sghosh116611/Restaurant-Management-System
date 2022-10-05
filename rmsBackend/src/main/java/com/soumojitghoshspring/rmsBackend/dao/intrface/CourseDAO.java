package com.soumojitghoshspring.rmsBackend.dao.intrface;

import java.util.List;

import com.soumojitghoshspring.rmsBackend.entity.Course;

public interface CourseDAO {
	public List<Course> findAll();

	public Course findCourse(int courseId);

	public void save(Course course);

	public void delete(int courseId);
}
