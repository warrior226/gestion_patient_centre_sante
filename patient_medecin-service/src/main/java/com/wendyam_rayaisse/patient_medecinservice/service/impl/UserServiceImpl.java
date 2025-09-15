package com.wendyam_rayaisse.patient_medecinservice.service.impl;

import com.wendyam_rayaisse.patient_medecinservice.dto.UserDto;
import com.wendyam_rayaisse.patient_medecinservice.entity.User;
import com.wendyam_rayaisse.patient_medecinservice.mapper.UserMapper;
import com.wendyam_rayaisse.patient_medecinservice.repository.UserRepository;
import com.wendyam_rayaisse.patient_medecinservice.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;
    @Override
    public void createUser(UserDto userDto) {
        boolean exist = userRepository.existsByPatientIdAndMedecinId(userDto.getPatientId(), userDto.getMedecinId());
        if(!exist){
           User user=UserMapper.mapToUser(new User(),userDto);
            userRepository.save(user);
        }else{
            throw new RuntimeException("User already exists");
        }

    }

    @Override
    public boolean deleteByPatientId(int patientId) {
        userRepository.deleteByPatientId(patientId);
        return true;
    }

    @Override
    public boolean deleteByMedecinId(int medecinId) {
        userRepository.deleteByMedecinId(medecinId);
        return true;
    }
}
