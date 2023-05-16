package com.example.tpProject.service;

import com.example.tpProject.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> studentList();


    public Student getOne(Long id);

    public Student save(Student student);
    public Student update(Student student, Long id);
    public void  delete(Long id);
}
