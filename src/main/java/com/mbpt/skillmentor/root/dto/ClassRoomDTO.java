package com.mbpt.skillmentor.root.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoomDTO {
    private Integer classRoomId;
    private String title;
    private Double sessionFee;
    private Integer enrolledStudentCount;
}
