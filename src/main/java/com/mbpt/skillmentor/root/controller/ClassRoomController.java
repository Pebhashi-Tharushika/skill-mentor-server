package com.mbpt.skillmentor.root.controller;

import com.mbpt.skillmentor.root.dto.ClassRoomDTO;
import com.mbpt.skillmentor.root.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @PostMapping
    public ResponseEntity<ClassRoomDTO> createClassRoom(ClassRoomDTO classRoomDTO) {
        ClassRoomDTO createdClassRoom = classRoomService.createClassRoom(classRoomDTO);
        return new ResponseEntity<>(createdClassRoom, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClassRoomDTO>> getAllClassRooms() {
        List<ClassRoomDTO> allClassRooms = classRoomService.getAllClassRooms();
        return new ResponseEntity<>(allClassRooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> getClassRoomById(@PathVariable Integer id) {
        ClassRoomDTO classRoomDTO = classRoomService.getClassRoomById(id);
        return new ResponseEntity<>(classRoomDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ClassRoomDTO> updateClassRoom(ClassRoomDTO classRoomDTO) {
        ClassRoomDTO updatedClassRoom = classRoomService.updateClassRoomById(classRoomDTO);
        return new ResponseEntity<>(updatedClassRoom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassRoomDTO> deleteClassRoom(@PathVariable Integer id) {
        ClassRoomDTO deletedClassRoom = classRoomService.deleteClassRoomById(id);
        return new ResponseEntity<>(deletedClassRoom, HttpStatus.OK);
    }
}
