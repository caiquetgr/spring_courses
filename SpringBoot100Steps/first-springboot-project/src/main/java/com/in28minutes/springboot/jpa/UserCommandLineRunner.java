package com.in28minutes.springboot.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Caique", "Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));
        userRepository.save(new User("Mireli", "Backoffice Admin"));

        for (User u : userRepository.findAll()) {
            log.info("{}", u);
        }

        List<User> adminList = userRepository.findByRole("Admin");

        for (User u : adminList) {
            log.info("{}", u);
        }

    }
}
