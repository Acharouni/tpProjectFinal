package com.example.tpProject.service;

import com.example.tpProject.model.Student;
import com.example.tpProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class StudentServiceImp implements StudentService  {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> studentList(){
        return  studentRepository.findAll();
    }

    @Override
    public Student getOne(Long id){
        return studentRepository.findById(id).get();}

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student, Long id) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
            studentRepository.deleteById(id);
    }
    @Override
    public Object getJokes() {
// Adrresse API REST
        String rest_api_url ="https://official-joke-api.appspot.com/random_joke";
        Object listofjOKES = restTemplate.getForObject(rest_api_url,Object.class);

        return  listofjOKES;
    }

}
