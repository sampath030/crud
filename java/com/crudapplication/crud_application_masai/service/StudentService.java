package com.crudapplication.crud_application_masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.crud_application_masai.entity.Student;
import com.crudapplication.crud_application_masai.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	public Student addStudent(Student student) {
		Student student1 = studentRepository.save(student);
		return student1;
	}

	public String updateStudent(Student student) {
		Optional<Student> student1 = studentRepository.findById(student.getStudentId());
		if (student1.isEmpty()) 
			return "Repository error";
		student1.get().setStudentName(student.getStudentName());
		student1.get().setStudentSection(student.getStudentSection());
		studentRepository.save(student1.get());
		return "Updated Successfully";
	}

	public String deleteStudent(String studentId) {
		Student student = studentRepository.findById(studentId).get();
		try {
			studentRepository.delete(student);
			return "Delete Successfully";
		}
		catch(Exception ex) {
			return "Delete Error";
		}
	}
}