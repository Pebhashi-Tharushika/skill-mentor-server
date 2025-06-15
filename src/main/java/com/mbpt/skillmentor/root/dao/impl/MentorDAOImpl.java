package com.mbpt.skillmentor.root.dao.impl;

import com.mbpt.skillmentor.root.dao.MentorDAO;
import com.mbpt.skillmentor.root.dto.MentorDTO;
import com.mbpt.skillmentor.root.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MentorDAOImpl implements MentorDAO {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Override
    public MentorDTO createMentor(MentorDTO mentorDTO) {
        final String query = "INSERT INTO mentors (first_name, last_name, email, address, title, profession, subject, qualification) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, mentorDTO.getFirstName());
            preparedStatement.setString(2, mentorDTO.getLastName());
            preparedStatement.setString(3, mentorDTO.getEmail());
            preparedStatement.setString(4, mentorDTO.getAddress());
            preparedStatement.setString(5, mentorDTO.getTitle());
            preparedStatement.setString(6, mentorDTO.getProfession());
            preparedStatement.setString(7, mentorDTO.getSubject());
            preparedStatement.setString(8, mentorDTO.getQualification());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) mentorDTO.setMentorId(generatedKeys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentorDTO;
    }

    @Override
    public List<MentorDTO> getAllMentors() {
        final String query = "SELECT * FROM mentors";
        final List<MentorDTO> mentorList = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                mentorList.add(
                        new MentorDTO(
                                resultSet.getInt("mentor_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getString("address"),
                                resultSet.getString("title"),
                                resultSet.getString("profession"),
                                resultSet.getString("subject"),
                                resultSet.getString("qualification")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return mentorList;
    }

    @Override
    public MentorDTO getMentorById(Integer id) {
        final String query = "SELECT * FROM mentors WHERE mentor_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new MentorDTO(
                            resultSet.getInt("mentor_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("address"),
                            resultSet.getString("title"),
                            resultSet.getString("profession"),
                            resultSet.getString("subject"),
                            resultSet.getString("qualification"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MentorDTO updateMentorById(MentorDTO mentorDTO) {
        final String query = "UPDATE mentors SET first_name=?,last_name=?,email=?,address=?,title=?,profession=?,subject=?,qualification=? WHERE mentor_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, mentorDTO.getFirstName());
            preparedStatement.setString(2, mentorDTO.getLastName());
            preparedStatement.setString(3, mentorDTO.getEmail());
            preparedStatement.setString(4, mentorDTO.getAddress());
            preparedStatement.setString(5, mentorDTO.getTitle());
            preparedStatement.setString(6, mentorDTO.getProfession());
            preparedStatement.setString(7, mentorDTO.getSubject());
            preparedStatement.setString(8, mentorDTO.getQualification());
            preparedStatement.setInt(9, mentorDTO.getMentorId());

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1) {
                return mentorDTO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MentorDTO deleteMentorById(Integer id) {
        MentorDTO selectedMentor = getMentorById(id);
        if (selectedMentor == null) return null;

        final String query = "DELETE FROM mentors WHERE mentor_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 1) return selectedMentor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
