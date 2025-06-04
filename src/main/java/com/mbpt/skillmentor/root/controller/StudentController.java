package com.mbpt.skillmentor.root.controller;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        List<StudentDTO> studentsList = studentService.getAllStudents();
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }
}
