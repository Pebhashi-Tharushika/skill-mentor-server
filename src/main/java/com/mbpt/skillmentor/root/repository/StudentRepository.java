package com.mbpt.skillmentor.root.repository;

import com.mbpt.skillmentor.root.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
