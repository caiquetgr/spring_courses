package com.in28minutes.springboot.service;

import com.in28minutes.springboot.aspect.PageableCustom;
import com.in28minutes.springboot.jpa.User;
import com.in28minutes.springboot.jpa.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> findAll(Pageable pageable) {
        Page<User> all = this.userRepository.findAll(pageable);
        return all;
    }

    public Page<User> findAll(Pageable pageable, Boolean todos) {
        PageableCustom pageableCustom = new PageableCustom(pageable, todos);
        return this.userRepository.findAll(pageableCustom);
    }
}
