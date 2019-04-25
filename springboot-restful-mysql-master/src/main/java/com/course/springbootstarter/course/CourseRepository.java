package com.course.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
    
	List<Course> findAllCoursesByTopicId(String topicId);
	List<Course> findAllCoursesByTopicName(String topicId);
}
