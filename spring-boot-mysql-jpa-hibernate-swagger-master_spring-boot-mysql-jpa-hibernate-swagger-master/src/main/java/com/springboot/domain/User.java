package com.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an User for this web application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String name;

    public User(long id) {
        this.id = id;
    }
    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

} // class User
