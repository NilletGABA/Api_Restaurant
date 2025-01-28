package com.gamboa.api_restaurant.repository;

import com.gamboa.api_restaurant.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findOneByEmail(String email);
    boolean existsByEmail(String email);
}
