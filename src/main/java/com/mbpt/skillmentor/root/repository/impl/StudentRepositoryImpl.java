package com.mbpt.skillmentor.root.repository.impl;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final List<StudentDTO> studentList = new ArrayList<>();

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        var id = studentList.size() + 1;
        studentDTO.setStudentId(id);
        studentList.add(studentDTO);
        return studentList.get(id-1);
    }
}
