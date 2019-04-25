package com.course.springbootstarter.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.course.springbootstarter.topic.TopicService;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCoursesByTopicId(topicId);
	}

	@RequestMapping("/topics/{topicId}/coursesbyTopicName")
	public List<Course> getAllCoursesByTopicName(@PathVariable String topicId) {
		return courseService.getAllCoursesByTopicName(topicService.getTopic(topicId).getName());
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(topicService.getTopic(topicId));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(topicService.getTopic(topicId));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses")
	public void updateCoursesByTopicId(@PathVariable String topicId) {
		List<Course> courses = getAllCourses(topicId);
		for(Course course : courses) {
			course.setDescription("Updated");
			courseService.updateCourse(course);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
