package com.course.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCoursesByTopicId(String topicId) {
		// List<Course> courses = new ArrayList<>();
		// courseRepository.findAll().forEach(courses::add);
		return courseRepository.findAllCoursesByTopicId(topicId);
		// return courses;
	}
	
	public List<Course> getAllCoursesByTopicName(String topicName) {
		// List<Course> courses = new ArrayList<>();
		// courseRepository.findAll().forEach(courses::add);
		return courseRepository.findAllCoursesByTopicName(topicName);
		// return courses;
	}

	public Course getCourse(String id) {
		// return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	void updateAllCoursesByTopicId(Course course) {
		courseRepository.save(course);
	}

	void deleteCourse(String id) {
		courseRepository.delete(id);
	}

}
