package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.ClassRoomDTO;
import com.mbpt.skillmentor.root.repository.ClassRoomRepository;
import com.mbpt.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        return classRoomRepository.createClassRoom(classRoomDTO);
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomRepository.getAllClassRooms();
    }

    @Override
    public ClassRoomDTO getClassRoomById(Integer id) {
        return classRoomRepository.getClassRoomById(id);
    }

    @Override
    public ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO) {
        return classRoomRepository.updateClassRoomById(classRoomDTO);
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        return classRoomRepository.deleteClassRoomById(id);
    }
}
