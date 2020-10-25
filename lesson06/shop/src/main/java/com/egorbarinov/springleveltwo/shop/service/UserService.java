package com.egorbarinov.springleveltwo.shop.service;

import com.egorbarinov.springleveltwo.shop.domain.User;
import com.egorbarinov.springleveltwo.shop.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);

    List<UserDto> getAll();

    User findByName(String name);

    void updateProfile(UserDto dto);

    void save(User user);
}
