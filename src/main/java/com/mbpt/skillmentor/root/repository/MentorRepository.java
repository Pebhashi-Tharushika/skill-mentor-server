package com.mbpt.skillmentor.root.repository;

import com.mbpt.skillmentor.root.dto.MentorDTO;

import java.util.List;

public interface MentorRepository {
    MentorDTO createMentor(MentorDTO mentorDTO);

    List<MentorDTO> getAllMentors();

    MentorDTO getMentorById(Integer id);

    MentorDTO updateMentorById(MentorDTO mentorDTO);

    MentorDTO deleteMentorById(Integer id);

}
