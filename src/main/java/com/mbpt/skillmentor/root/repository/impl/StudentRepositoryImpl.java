package com.mbpt.skillmentor.root.repository.impl;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final List<StudentDTO> studentList = new ArrayList<>();

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        var id = studentList.size() + 1;
        studentDTO.setStudentId(id);
        studentList.add(studentDTO);
        return studentList.get(id - 1);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentList;
    }

    @Override
    public StudentDTO getStudentById(int id) {
        return studentList.stream().filter(student -> student.getStudentId() == id).findFirst().orElse(null);
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        Optional<StudentDTO> selectedStudent = studentList.stream().filter(student -> Objects.equals(student.getStudentId(), studentDTO.getStudentId())).findFirst();
        if (selectedStudent.isPresent()) {
            StudentDTO selectedStudentDTO = selectedStudent.get();
            selectedStudentDTO.setFirstName(studentDTO.getFirstName());
            selectedStudentDTO.setLastName(studentDTO.getLastName());
            selectedStudentDTO.setEmail(studentDTO.getEmail());
            selectedStudentDTO.setAddress(studentDTO.getAddress());
            selectedStudentDTO.setPhoneNumber(studentDTO.getPhoneNumber());
            selectedStudentDTO.setAge(studentDTO.getAge());
            return selectedStudentDTO;
        }
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        Optional<StudentDTO> selectedStudent = studentList.stream().filter(student -> Objects.equals(student.getStudentId(), id)).findFirst();
        selectedStudent.ifPresent(studentList::remove);
    }
}
