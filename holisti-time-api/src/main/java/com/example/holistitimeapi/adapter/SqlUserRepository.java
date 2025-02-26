package com.example.holistitimeapi.adapter;

import com.example.holistitimeapi.user.User;
import com.example.holistitimeapi.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface SqlUserRepository extends UserRepository, JpaRepository<User, Integer> {
    @Override
    Optional<User> findByEmail(String email);

    @Override
    boolean existsByEmail(String email);

    @Override
    Optional<User> findByActivationToken(String activationToken);
}
