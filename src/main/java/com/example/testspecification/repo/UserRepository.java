package com.example.testspecification.repo;

import com.example.testspecification.model.DocumentState;
import com.example.testspecification.model.StateCounter;
import com.example.testspecification.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(nativeQuery = true, value = "SELECT document_state AS state, count(id) AS counter FROM users " +
            "WHERE last_name LIKE %?1 GROUP BY document_state")
    List<StateCounter> findAllByState1(String name);

//    @Query(nativeQuery = true, value = "SELECT document_state AS state, count(id) AS counter FROM users " +
//            "WHERE last_name LIKE %?1")
//    List<StateCounter> findAllByState1(String name);
}

