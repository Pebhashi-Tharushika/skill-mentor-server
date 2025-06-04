package com.mbpt.skillmentor.root.service;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Interface for managing students.
 * Provides operations to create, retrieve, modify student records.
 */

public interface StudentService {

    /**
     * Create a new student records.
     *
     * @param studentDTO the student dto to create
     * @return the created {@link StudentDTO } with generated student ID
     */

    StudentDTO createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();
}
