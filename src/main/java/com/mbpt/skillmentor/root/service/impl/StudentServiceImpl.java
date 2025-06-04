package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.repository.StudentRepository;
import com.mbpt.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return studentRepository.createStudent(studentDTO);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public StudentDTO getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        return studentRepository.updateStudentById(studentDTO);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteStudentById(id);
    }
}
