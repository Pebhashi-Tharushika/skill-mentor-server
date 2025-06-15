package com.mbpt.skillmentor.root.repository.impl;

import com.mbpt.skillmentor.root.dto.ClassRoomDTO;
import com.mbpt.skillmentor.root.repository.ClassRoomRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClassRoomRepositoryImpl implements ClassRoomRepository {
    private final List<ClassRoomDTO> classRoomList = new ArrayList<>();

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {
        var id = classRoomList.size() + 1;
        classRoomDTO.setClassRoomId(id);
        classRoomList.add(classRoomDTO);
        return classRoomList.get(id - 1);
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        return classRoomList;
    }

    @Override
    public ClassRoomDTO getClassRoomById(Integer id) {
        return classRoomList.stream().filter(classRoomDTO -> classRoomDTO.getClassRoomId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO) {
        Optional<ClassRoomDTO> selectedClassRoom = classRoomList.stream().filter(classRoom -> classRoom.getClassRoomId().equals(classRoomDTO.getClassRoomId())).findFirst();
        if (selectedClassRoom.isPresent()) {
            ClassRoomDTO selectedClassRoomDTO = selectedClassRoom.get();
            selectedClassRoomDTO.setTitle(classRoomDTO.getTitle());
            selectedClassRoomDTO.setSessionFee(classRoomDTO.getSessionFee());
            selectedClassRoomDTO.setEnrolledStudentCount(classRoomDTO.getEnrolledStudentCount());
            return selectedClassRoomDTO;
        }
        return null;
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        Optional<ClassRoomDTO> selectedClassRoom = classRoomList.stream().filter(classRoom -> classRoom.getClassRoomId().equals(id)).findFirst();
        selectedClassRoom.ifPresent(classRoomList::remove);
        return selectedClassRoom.orElse(null);
    }
}
