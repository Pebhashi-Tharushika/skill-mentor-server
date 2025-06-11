package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.MentorDTO;
import com.mbpt.skillmentor.root.repository.MentorRepository;
import com.mbpt.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        return mentorRepository.createMentor(mentorDTO);
    }

    @Override
    public List<MentorDTO> getAllMentors() {
        return mentorRepository.getAllMentors();
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        return mentorRepository.getMentorById(id);
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        return mentorRepository.updateMentorById(mentorDTO);
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        return mentorRepository.deleteMentorById(id);
    }
}
