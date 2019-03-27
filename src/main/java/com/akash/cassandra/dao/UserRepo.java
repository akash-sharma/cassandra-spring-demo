package com.akash.cassandra.dao;

import com.akash.cassandra.entity.User;

import java.util.List;

public interface UserRepo {

    void insert(User user);

    List<User> findAllByFirstNameAndLastNameAndAdharNumber(String firstName, String lastName, String adharNumber);
}