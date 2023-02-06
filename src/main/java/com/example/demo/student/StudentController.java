package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        try {
            return studentService.getAllStudents();
        } catch (Exception e) {
            throw new IllegalStateException("oops error");
        }
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        if (studentService.existByEmail(student.getEmail()))
            throw new BadRequestException("Email already Exist");
        studentService.addStudent(student);
    }

    @DeleteMapping({"{id}"})
    public void deleteStudent(@PathVariable Long id) {
        if (!studentService.existById(id))
            throw new StudentNotFoundException("This student not exist");
        studentService.deleteStudent(id);
    }
}
