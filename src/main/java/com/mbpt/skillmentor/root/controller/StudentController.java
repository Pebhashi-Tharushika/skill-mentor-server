package com.mbpt.skillmentor.root.controller;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/students")
public class StudentController {

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO){
        studentDTO.setStudentId(1);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> getAllStudents(){
        return new ResponseEntity<>("All Students Successfully", HttpStatus.OK);
    }
}
