package com.mbpt.skillmentor.root.service.impl;

import com.mbpt.skillmentor.root.dto.MentorDTO;
import com.mbpt.skillmentor.root.entity.MentorEntity;
import com.mbpt.skillmentor.root.mapper.MentorEntityDTOMapper;
import com.mbpt.skillmentor.root.repository.MentorRepository;
import com.mbpt.skillmentor.root.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        return MentorEntityDTOMapper.map(mentorRepository.save(MentorEntityDTOMapper.map(mentorDTO)));
    }

    @Override
    public List<MentorDTO> getAllMentors() {
        return mentorRepository.findAll()
                .stream()
                .map(MentorEntityDTOMapper::map)
                .toList();
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        Optional<MentorEntity> optionalMentorEntity = mentorRepository.findById(id);
        if (optionalMentorEntity.isEmpty()) throw new RuntimeException("Mentor Not Found");
        return MentorEntityDTOMapper.map(optionalMentorEntity.get());
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        Optional<MentorEntity> optionalMentorEntity = mentorRepository.findById(mentorDTO.getMentorId());

        if (optionalMentorEntity.isEmpty()) throw new RuntimeException("Mentor Not Found");

        MentorEntity selectedMentorEntity = optionalMentorEntity.get();
        selectedMentorEntity.setFirstName(mentorDTO.getFirstName());
        selectedMentorEntity.setLastName(mentorDTO.getLastName());
        selectedMentorEntity.setEmail(mentorDTO.getEmail());
        selectedMentorEntity.setAddress(mentorDTO.getAddress());
        selectedMentorEntity.setTitle(mentorDTO.getTitle());
        selectedMentorEntity.setProfession(mentorDTO.getProfession());
        selectedMentorEntity.setSubject(mentorDTO.getSubject());
        selectedMentorEntity.setQualification(mentorDTO.getQualification());

        return MentorEntityDTOMapper.map(mentorRepository.save(selectedMentorEntity));
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        Optional<MentorEntity> optionalMentorEntity = mentorRepository.findById(id);
        if (optionalMentorEntity.isEmpty()) throw new RuntimeException("Mentor Not Found");
        mentorRepository.deleteById(id);
        return MentorEntityDTOMapper.map(optionalMentorEntity.get());
    }
}
