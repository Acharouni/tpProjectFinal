package com.example.tpProject.endPoint;

import com.example.tpProject.model.Student;
import com.example.tpProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path= "/Student", produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Student> studentList(){
        return studentService.studentList();
    }
    @GetMapping(path = "/{id}")
    public Student getOne(@PathVariable Long id) {
        return studentService.getOne(id);
    }
    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }
    @PutMapping(path = "/{id}")
    public Student update(@RequestBody Student student, @PathVariable Long id) {
        return studentService.update(student,id);
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
    @GetMapping("/jokes")
    public Object listOfJokes() {
        return studentService.getJokes();
    }


}
