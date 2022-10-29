package com.example.creadible.User.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String loginId;
    private String password;
    private String name;
    //LocalDate => 날짜 정보만 출력. ex) 2019-11-13
    private LocalDate birthday;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String loginId, String password, String name, LocalDate birthday, String email, Role role) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.role = role;
    }
}
