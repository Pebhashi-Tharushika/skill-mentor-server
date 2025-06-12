package com.mbpt.skillmentor.root.dao;

import com.mbpt.skillmentor.root.dto.StudentDTO;

import java.util.List;

public interface StudentDAO {

    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    List<StudentDTO> getStudentsByAge(Integer age);

    StudentDTO getStudentById(Integer id);

    StudentDTO updateStudentById(StudentDTO studentDTO);

    StudentDTO deleteStudentById(Integer id);
}
