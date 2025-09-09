package com.wendyam_rayaisse.patient_medecinservice.mapper;

import com.wendyam_rayaisse.patient_medecinservice.dto.UserDto;
import com.wendyam_rayaisse.patient_medecinservice.entity.User;

public class UserMapper {

    public static User mapToUser(User user , UserDto userDto){
        user.setPatientId(userDto.getPatientId());
        user.setMedecinId(userDto.getMedecinId());
        return user;
    }
}
