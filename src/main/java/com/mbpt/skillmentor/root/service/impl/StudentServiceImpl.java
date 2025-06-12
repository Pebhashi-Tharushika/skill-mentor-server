package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.entity.StudentEntity;
import com.mbpt.skillmentor.root.mapper.StudentEntityDTOMapper;
import com.mbpt.skillmentor.root.repository.StudentRepository;
import com.mbpt.skillmentor.root.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        return StudentEntityDTOMapper.map(studentRepository.save(StudentEntityDTOMapper.map(studentDTO)));
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentEntityDTOMapper::map).toList();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        return optionalStudentEntity.map(StudentEntityDTOMapper::map).orElse(null);
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        StudentDTO deletedStudentDTO = getStudentById(studentDTO.getStudentId());
        if (deletedStudentDTO == null) return null;
        return StudentEntityDTOMapper.map(studentRepository.save(StudentEntityDTOMapper.map(studentDTO)));
    }

    @Override
    public StudentDTO deleteStudentById(Integer id) {
        StudentDTO deletedStudentDTO = getStudentById(id);
        studentRepository.deleteById(id);
        return deletedStudentDTO;
    }
}
