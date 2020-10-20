package com.egorbarinov.springleveltwo.shop.dao;

import com.egorbarinov.springleveltwo.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
    User findByName(String username);
    User findByEmail(String username);
}
