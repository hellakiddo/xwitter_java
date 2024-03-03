package com.xwitter_java.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class UserIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Имя пользователя не может быть пустым")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    @Column(unique = true)
    private String email;

    @Size(min = 6, message = "Пароль должен содержать не менее 6 символов")
    private String password;

    @NotEmpty(message = "Имя не может быть пустым")
    private String first_name;

    @NotEmpty(message = "Фамилия не может быть пустой")
    private String last_name;

    public UserIn(
            Long id, String username, String email, String password,
            String first_name, String last_name
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public UserIn() {}

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
