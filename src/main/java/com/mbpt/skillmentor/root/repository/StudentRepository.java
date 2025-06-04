package com.mbpt.skillmentor.root.repository;

import com.mbpt.skillmentor.root.dto.StudentDTO;

import java.util.List;

public interface StudentRepository {

    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();
}
