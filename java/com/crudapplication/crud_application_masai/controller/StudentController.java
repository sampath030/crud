package com.crudapplication.crud_application_masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudapplication.crud_application_masai.entity.Student;
import com.crudapplication.crud_application_masai.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student>  getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return students;
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		Student student1 = studentService.addStudent(student);
		return student1;
	}
	
	@PutMapping("/student")
	public String updateStudent(@RequestBody Student student) {
		String msg = studentService.updateStudent(student);
		return msg;
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") String studentId) {
		String msg = studentService.deleteStudent(studentId);
		return msg;
	}
}
