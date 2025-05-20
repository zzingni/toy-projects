package com.github.zzingni.logindemo.service;

import com.github.zzingni.logindemo.entity.User;
import com.github.zzingni.logindemo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean register(User user) {
        if (userRepository.existsById(user.getId())) {
            return false;
        }

        String encodedPassword = passwordEncoder.encode(user.getPasswd());
        user.setPasswd(encodedPassword);

        userRepository.save(user);
        return true;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}