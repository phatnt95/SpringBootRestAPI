package com.example.springrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @Column(name="name")
    private String name;
    @Column(name = "surName")
    private String surName;
    @Column(name="phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name="status")
    private int status;
}
