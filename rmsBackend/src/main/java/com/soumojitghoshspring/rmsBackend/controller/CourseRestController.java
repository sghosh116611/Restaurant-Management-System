package com.soumojitghoshspring.rmsBackend.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumojitghoshspring.rmsBackend.entity.Course;
import com.soumojitghoshspring.rmsBackend.service.intrface.CourseService;

@RestController
@RequestMapping("/api")
public class CourseRestController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> findAll(){
		return courseService.findAll();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course find(@PathVariable int courseId) {
		return courseService.findCourse(courseId);
	}
	
	@PostMapping("/courses")
	public ResponseEntity<Course> save(@RequestBody Course course) {
		courseService.save(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@PutMapping("/courses")
	public ResponseEntity<Course> update(@RequestBody Course course) {
		courseService.save(course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<String> delete(@PathVariable int courseId) {
		courseService.delete(courseId);
		return new ResponseEntity<>("Course deleted with id:"+courseId, HttpStatus.OK);
	}
	
}
