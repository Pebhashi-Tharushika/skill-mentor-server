package com.mbpt.skillmentor.root.dao;

import com.mbpt.skillmentor.root.dto.ClassRoomDTO;

import java.util.List;

public interface ClassRoomDAO {

    ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO);

    List<ClassRoomDTO> getAllClassRooms();

    ClassRoomDTO getClassRoomById(Integer id);

    ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO);

    ClassRoomDTO deleteClassRoomById(Integer id);
}
