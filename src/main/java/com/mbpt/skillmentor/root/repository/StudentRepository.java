package com.mbpt.skillmentor.root.repository;

import com.mbpt.skillmentor.root.dto.StudentDTO;

public interface StudentRepository {

    StudentDTO createStudent(StudentDTO studentDTO);
}
