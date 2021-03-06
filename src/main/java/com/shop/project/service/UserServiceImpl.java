package com.shop.project.service;

import com.shop.project.domain.User;
import com.shop.project.exceptions.BadRequestException;
import com.shop.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found!");
        }
        return userOptional.get();
    }

    @Override
    public User save(User user)
    {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent())
        {
            throw new BadRequestException("This email is already registered");
        }
        user.setUsername(user.getEmail());
        User savedUser= userRepository.save(user);
        return savedUser;
    }

    @Override
    public List<User> findAll()
    {
        List<User> users = new LinkedList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (!userOptional.isPresent())
        {
            throw new RuntimeException("User not found!");
        }
        return userOptional.get();
    }

    @Override
    public void updateUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (!userOptional.isPresent()) {
            throw new BadRequestException("Nothing to update! User does not exist");
        }
        userRepository.save(user);
    }

}
