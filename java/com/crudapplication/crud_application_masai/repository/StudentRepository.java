package com.crudapplication.crud_application_masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudapplication.crud_application_masai.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

}
