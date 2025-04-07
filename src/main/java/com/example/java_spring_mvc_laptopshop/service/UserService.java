package com.example.java_spring_mvc_laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.java_spring_mvc_laptopshop.domain.Role;
import com.example.java_spring_mvc_laptopshop.domain.User;
import com.example.java_spring_mvc_laptopshop.repository.RoleRepository;
import com.example.java_spring_mvc_laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public String handleHello() {
        return "Hello from service";
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User handleSaveUser(User user) {
        User eric = this.userRepository.save(user);
        System.out.println(eric);
        return eric;
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
