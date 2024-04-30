package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;




        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public User getUserById(Long id) {
            return (User) userRepository.findById(id).orElse(null);
        }

        public User saveUser(User user) {
            return userRepository.save(user);
        }

        public void deleteUser(Long id) {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("User with id " + id + " not found");
            }
        }

        @Transactional
        public void deleteAllUsers() {
            userRepository.deleteAll();
            // resetIdSequence();
        }

        public User getUserByEmailAndPassword(String email, String password) {
            return userRepository.findByEmailAndPassword(email, password);
        }




    public boolean isUserExists(String email) {
        // Check if a user with the given email already exists in the database
        return userRepository.findByEmail(email) != null;
    }



}
