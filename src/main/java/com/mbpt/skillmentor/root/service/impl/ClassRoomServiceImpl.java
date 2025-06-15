package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.ClassRoomDTO;
import com.mbpt.skillmentor.root.entity.ClassRoomEntity;
import com.mbpt.skillmentor.root.mapper.ClassRoomEntityDTOMapper;
import com.mbpt.skillmentor.root.repository.ClassRoomRepository;
import com.mbpt.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        return ClassRoomEntityDTOMapper.map(classRoomRepository.save(ClassRoomEntityDTOMapper.map(classRoomDTO)));
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomRepository.findAll().stream().map(ClassRoomEntityDTOMapper::map).toList();
    }

    @Override
    public ClassRoomDTO getClassRoomById(Integer id) {
        Optional<ClassRoomEntity> optionalClassRoomEntity = classRoomRepository.findById(id);
        if (optionalClassRoomEntity.isEmpty()) throw new RuntimeException("ClassRoom Not Found");
        return ClassRoomEntityDTOMapper.map(optionalClassRoomEntity.get());
    }

    @Override
    public ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO) {
        Optional<ClassRoomEntity> optionalClassRoomEntity = classRoomRepository.findById(classRoomDTO.getClassRoomId());
        if (optionalClassRoomEntity.isEmpty()) throw new RuntimeException("ClassRoom Not Found");

        ClassRoomEntity classRoomEntity = optionalClassRoomEntity.get();
        classRoomEntity.setTitle(classRoomDTO.getTitle());
        classRoomEntity.setSessionFee(classRoomDTO.getSessionFee());
        classRoomEntity.setEnrolledStudentCount(classRoomDTO.getEnrolledStudentCount());

        return ClassRoomEntityDTOMapper.map(classRoomRepository.save(classRoomEntity));
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        Optional<ClassRoomEntity> optionalClassRoomEntity = classRoomRepository.findById(id);
        if (optionalClassRoomEntity.isEmpty()) throw new RuntimeException("ClassRoom Not Found");
        classRoomRepository.deleteById(id);
        return ClassRoomEntityDTOMapper.map(optionalClassRoomEntity.get());
    }
}
