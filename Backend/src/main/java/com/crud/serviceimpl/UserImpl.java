package com.crud.serviceimpl;

import com.crud.entity.User;
import com.crud.enums.Role;
import com.crud.repository.UserRepository;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        return repository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId).get();

    }

    @Override
    public List<User> getAllUsers() {

        return repository.findAll();
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> users = repository.findById(userId);
        if (users.isPresent()) {
            User user1 = users.get();
            user1.setUserName(user.getUserName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());

            return repository.save(user1);
        } else {
            return null;
        }

    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> users = repository.findById(userId);
        if (users.isPresent()) {
            repository.deleteById(userId);
        }
    }



}
