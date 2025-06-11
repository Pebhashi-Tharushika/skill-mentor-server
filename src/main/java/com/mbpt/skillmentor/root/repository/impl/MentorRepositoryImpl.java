package com.mbpt.skillmentor.root.repository.impl;

import com.mbpt.skillmentor.root.dto.MentorDTO;
import com.mbpt.skillmentor.root.repository.MentorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
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
            mentorDTO.setAddress(selectedMentorDTO.getAddress());
            mentorDTO.setTitle(selectedMentorDTO.getTitle());
            mentorDTO.setProfession(selectedMentorDTO.getProfession());
            mentorDTO.setSubject(selectedMentorDTO.getSubject());
            mentorDTO.setQualification(selectedMentorDTO.getQualification());
            return selectedMentorDTO;
        }
        return null;
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        Optional<MentorDTO> selectedMentor = mentorList.stream().filter(mentor -> mentor.getMentorId().equals(id)).findFirst();
        selectedMentor.ifPresent(mentorList::remove);
        return selectedMentor.orElse(null);
    }
}
