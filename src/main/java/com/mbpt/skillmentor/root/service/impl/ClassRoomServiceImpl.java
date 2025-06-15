package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dao.ClassRoomDAO;
import com.mbpt.skillmentor.root.dto.ClassRoomDTO;
import com.mbpt.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomDAO classRoomDAO;

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        return classRoomDAO.createClassRoom(classRoomDTO);
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomDAO.getAllClassRooms();
    }

    @Override
    public ClassRoomDTO getClassRoomById(Integer id) {
        return classRoomDAO.getClassRoomById(id);
    }

    @Override
    public ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO) {
        return classRoomDAO.updateClassRoomById(classRoomDTO);
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        return classRoomDAO.deleteClassRoomById(id);
    }
}
