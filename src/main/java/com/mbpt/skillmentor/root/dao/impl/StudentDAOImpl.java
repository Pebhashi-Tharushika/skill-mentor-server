package com.mbpt.skillmentor.root.dao.impl;

import com.mbpt.skillmentor.root.dao.StudentDAO;
import com.mbpt.skillmentor.root.dto.StudentDTO;
import com.mbpt.skillmentor.root.util.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
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
            stm.setString(1, studentDTO.getFirstName());
            stm.setString(2, studentDTO.getLastName());
            stm.setString(3, studentDTO.getEmail());
            stm.setString(4, studentDTO.getPhoneNumber());
            stm.setString(5, studentDTO.getAddress());
            stm.setInt(6, studentDTO.getAge());
            stm.executeUpdate();

            ResultSet keys = stm.getGeneratedKeys();
            if (keys.next()) studentDTO.setStudentId(keys.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        final String query = "SELECT * FROM student";
        final List<StudentDTO> studentList = new ArrayList<>();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                studentList.add(
                        new StudentDTO(
                                resultSet.getInt("student_id"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email"),
                                resultSet.getString("phone_number"),
                                resultSet.getString("address"),
                                resultSet.getInt("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return studentList;
    }


    @Override
    public StudentDTO getStudentById(Integer id) {
        final String query = "SELECT * FROM student WHERE student_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new StudentDTO(
                            resultSet.getInt("student_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("email"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("address"),
                            resultSet.getInt("age"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StudentDTO updateStudentById(StudentDTO studentDTO) {
        final String query = "UPDATE student SET first_name=?,last_name=?,email=?,phone_number=?,address=?,age=? WHERE student_id=?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, studentDTO.getFirstName());
            preparedStatement.setString(2, studentDTO.getLastName());
            preparedStatement.setString(3, studentDTO.getEmail());
            preparedStatement.setString(4, studentDTO.getPhoneNumber());
            preparedStatement.setString(5, studentDTO.getAddress());
            preparedStatement.setInt(6, studentDTO.getAge());
            preparedStatement.setInt(7, studentDTO.getStudentId());

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow == 1) {
                return studentDTO;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StudentDTO deleteStudentById(Integer id) {
        StudentDTO selectedStudent = getStudentById(id);
        if(selectedStudent == null) return null;

        final  String query = "DELETE FROM student WHERE student_id=?";

        try(Connection connection = databaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,id);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 1) return selectedStudent;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
