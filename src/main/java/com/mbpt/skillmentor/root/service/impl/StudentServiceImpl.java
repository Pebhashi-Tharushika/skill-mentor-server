package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dao.StudentDAO;
import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return studentDAO.createStudent(studentDTO);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        return studentDAO.updateStudentById(studentDTO);
    }

    @Override
    public StudentDTO deleteStudentById(Integer id) {
        return studentDAO.deleteStudentById(id);
    }
}
