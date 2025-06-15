package com.mbpt.skillmentor.root.dao.impl;

import com.mbpt.skillmentor.root.dao.ClassRoomDAO;
import com.mbpt.skillmentor.root.dto.ClassRoomDTO;
import com.mbpt.skillmentor.root.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRoomDAOImpl implements ClassRoomDAO {

    @Autowired
    private DatabaseConnection databaseConnection;

    @Override
    public ClassRoomDTO createClassRoom(ClassRoomDTO classRoomDTO) {

        final String query = "INSERT INTO classrooms (title, session_fee, enrolled_student_count, mentor_id) VALUES (?,?,?,?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, classRoomDTO.getTitle());
            stm.setDouble(2, classRoomDTO.getSessionFee());
            stm.setInt(3, classRoomDTO.getEnrolledStudentCount());
            stm.setInt(4, classRoomDTO.getMentorId());

            stm.executeUpdate();

            ResultSet keys = stm.getGeneratedKeys();
            if (keys.next()) classRoomDTO.setClassRoomId(keys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classRoomDTO;
    }

    @Override
    public List<ClassRoomDTO> getAllClassRooms() {
        final String query = "SELECT * FROM classrooms";
        final List<ClassRoomDTO> classroomList = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                classroomList.add(
                        new ClassRoomDTO(
                                resultSet.getInt("class_room_id"),
                                resultSet.getString("title"),
                                resultSet.getDouble("session_fee"),
                                resultSet.getInt("enrolled_student_count"),
                                resultSet.getInt("mentor_id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return classroomList;
    }

    @Override
    public ClassRoomDTO getClassRoomById(Integer id) {
        final String query = "SELECT * FROM classrooms WHERE class_room_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new ClassRoomDTO(
                            resultSet.getInt("class_room_id"),
                            resultSet.getString("title"),
                            resultSet.getDouble("session_fee"),
                            resultSet.getInt("enrolled_student_count"),
                            resultSet.getInt("mentor_id"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClassRoomDTO updateClassRoomById(ClassRoomDTO classRoomDTO) {
        final String query = "UPDATE classrooms SET title=?,session_fee=?,enrolled_student_count=?,mentor_id=? WHERE class_room_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, classRoomDTO.getTitle());
            preparedStatement.setDouble(2, classRoomDTO.getSessionFee());
            preparedStatement.setInt(3, classRoomDTO.getEnrolledStudentCount());
            preparedStatement.setInt(4, classRoomDTO.getMentorId());
            preparedStatement.setInt(5, classRoomDTO.getClassRoomId());

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1) {
                return classRoomDTO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClassRoomDTO deleteClassRoomById(Integer id) {
        ClassRoomDTO selectedClassroom = getClassRoomById(id);
        if (selectedClassroom == null) return null;

        final String query = "DELETE FROM classrooms WHERE class_room_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 1) return selectedClassroom;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
