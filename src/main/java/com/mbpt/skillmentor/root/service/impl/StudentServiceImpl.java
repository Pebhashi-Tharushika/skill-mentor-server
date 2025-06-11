package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.repository.StudentRepository;
import com.mbpt.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return studentRepository.createStudent(studentDTO);
    }

    @Override
    public List<StudentDTO> getAllStudents(Integer age) {
        return studentRepository.getAllStudents(age);
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        return studentRepository.updateStudentById(studentDTO);
    }

    @Override
    public StudentDTO deleteStudentById(Integer id) {
        return studentRepository.deleteStudentById(id);
    }
}
