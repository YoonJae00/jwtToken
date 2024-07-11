package com.finalproject.jwttoken.service;

import com.finalproject.jwttoken.DTO.RegistDTO;
import com.finalproject.jwttoken.entity.User;
import com.finalproject.jwttoken.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegistService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void joinProcess(RegistDTO registDTO) {

        String username = registDTO.getUsername();
        String password = registDTO.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {

            return;
        }

        User data = new User();

        data.setUsername(username);
        data.setPassword(bCryptPasswordEncoder.encode(password));
        data.setRole("ROLE_ADMIN");

        userRepository.save(data);
    }
}