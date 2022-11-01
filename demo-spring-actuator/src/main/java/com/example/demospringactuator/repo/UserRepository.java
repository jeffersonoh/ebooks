package com.example.demospringactuator.repo;

import com.example.demospringactuator.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserName(String userName);
}
