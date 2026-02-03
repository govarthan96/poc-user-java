package com.example.user.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

@Service
public class UserService {


private final UserRepository repository;


public UserService(UserRepository repository) {
this.repository = repository;
}


public List<User> getAllUsers() {
return repository.findAll();
}


public User saveUser(User user) {
return repository.save(user);
}


public User getUserById(Long id) {
return repository.findById(id)
.orElseThrow(() -> new RuntimeException("User not found"));
}


public void deleteUser(Long id) {
repository.deleteById(id);
}

public User updateUser(Long id, User user) {
    User existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    existing.setName(user.getName());
    existing.setEmail(user.getEmail());
    existing.setAge(user.getAge());

    return repository.save(existing);
}
}
