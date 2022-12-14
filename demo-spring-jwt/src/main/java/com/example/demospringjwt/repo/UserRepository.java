package com.example.demospringjwt.repo;

import com.example.demospringjwt.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserName(String userName);
}
