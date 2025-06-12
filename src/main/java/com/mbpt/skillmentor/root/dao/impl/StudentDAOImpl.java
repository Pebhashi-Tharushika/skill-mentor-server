package com.mbpt.skillmentor.root.dao.impl;

import com.mbpt.skillmentor.root.dao.StudentDAO;
import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {

        String query = "INSERT INTO student (first_name, last_name, email, phone_number, address, age) VALUES (?,?,?,?,?,?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            if (stm != null) {
                stm.setString(1, studentDTO.getFirstName());
                stm.setString(2, studentDTO.getLastName());
                stm.setString(3, studentDTO.getEmail());
                stm.setString(4, studentDTO.getPhoneNumber());
                stm.setString(5, studentDTO.getAddress());
                stm.setInt(6, studentDTO.getAge());
                stm.executeUpdate();

                ResultSet keys = stm.getGeneratedKeys();
                if (keys.next()) studentDTO.setStudentId(keys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents(Integer age) {
        return List.of();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return null;
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        return null;
    }

    @Override
    public StudentDTO deleteStudentById(Integer id) {
        return null;
    }
}
