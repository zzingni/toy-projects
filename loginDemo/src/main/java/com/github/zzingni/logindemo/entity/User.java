package com.github.zzingni.logindemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String passwd;
    private String name;

    // 기본 생성자
    public User() {}

    // 생성자
    public User(String id, String passwd, String name) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
    }
}