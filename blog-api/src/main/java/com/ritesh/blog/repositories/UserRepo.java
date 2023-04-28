package com.ritesh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
