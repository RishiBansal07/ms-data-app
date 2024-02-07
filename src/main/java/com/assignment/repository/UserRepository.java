package com.assignment.repository;

import com.assignment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT p from Users p where (:firstName is null or UPPER(p.firstName) like UPPER(concat('%', :firstName,'%'))) " +
            " and (:lastName is null or UPPER(p.lastName) like UPPER(concat('%', :lastName,'%'))) ")
    List<Users> searchByFirstAndOrLastName(String firstName, String lastName);
}