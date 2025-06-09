package com.mbpt.skillmentor.root.repository.impl;

import com.mbpt.skillmentor.root.dto.MentorDTO;
import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.repository.MentorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MentorRepositoryImpl implements MentorRepository {

    private final List<MentorDTO> mentorList = new ArrayList<>();

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        var id = mentorList.size() + 1;
        mentorDTO.setMentorId(id);
        mentorList.add(mentorDTO);
        return mentorList.get(id - 1);
    }

    @Override
    public List<MentorDTO> getAllMentors() {
        return mentorList;
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        return mentorList.stream().filter(mentor -> mentor.getMentorId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        Optional<MentorDTO> selectedMentor = mentorList.stream().filter(mentor -> mentor.getMentorId().equals(mentorDTO.getMentorId())).findFirst();
        if (selectedMentor.isPresent()) {
            MentorDTO selectedMentorDTO = selectedMentor.get();
            mentorDTO.setMentorId(selectedMentorDTO.getMentorId());
            mentorDTO.setFirstName(selectedMentorDTO.getFirstName());
            mentorDTO.setLastName(selectedMentorDTO.getLastName());
            mentorDTO.setEmail(selectedMentorDTO.getEmail());
            mentorDTO.setPhoneNumber(selectedMentorDTO.getPhoneNumber());
            mentorDTO.setAddress(selectedMentorDTO.getAddress());
            mentorDTO.setTitle(selectedMentorDTO.getTitle());
            mentorDTO.setSessionFee(selectedMentorDTO.getSessionFee());
            mentorDTO.setProfession(selectedMentorDTO.getProfession());
            mentorDTO.setSubject(selectedMentorDTO.getSubject());
            mentorDTO.setQualification(selectedMentorDTO.getQualification());
            mentorDTO.setClassRoomId(selectedMentorDTO.getClassRoomId());
            return selectedMentorDTO;
        }
        return null;
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        return null;
    }
}
