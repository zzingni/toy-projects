package com.github.zzingni.logindemo.repository;

import com.github.zzingni.logindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
}
