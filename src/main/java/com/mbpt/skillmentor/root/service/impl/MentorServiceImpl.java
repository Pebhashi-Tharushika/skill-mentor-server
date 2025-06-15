package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dao.MentorDAO;
import com.mbpt.skillmentor.root.dto.MentorDTO;
import com.mbpt.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorDAO mentorDAO;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        return mentorDAO.createMentor(mentorDTO);
    }

    @Override
    public List<MentorDTO> getAllMentors() {
        return mentorDAO.getAllMentors();
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        return mentorDAO.getMentorById(id);
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        return mentorDAO.updateMentorById(mentorDTO);
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        return mentorDAO.deleteMentorById(id);
    }
}
