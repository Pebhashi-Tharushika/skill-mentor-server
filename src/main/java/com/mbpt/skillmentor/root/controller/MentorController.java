package com.mbpt.skillmentor.root.controller;

import com.mbpt.skillmentor.root.dto.MentorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mentors")
public class MentorController {

    @PostMapping
    public ResponseEntity<MentorDTO> createMentor(@RequestBody MentorDTO mentorDTO){
    return ResponseEntity.ok().body(new MentorDTO());
    }
}
