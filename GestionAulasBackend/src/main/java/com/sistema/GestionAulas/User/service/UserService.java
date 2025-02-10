package com.sistema.GestionAulas.User.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.User.Controller.PasswordChangeRequest;
import com.sistema.GestionAulas.User.Controller.UpdateUserRequest;
import com.sistema.GestionAulas.User.Entity.Role;
import com.sistema.GestionAulas.User.Entity.User;
import com.sistema.GestionAulas.User.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {


    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("passwordEncoder")
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(String username, UpdateUserRequest userUpdateRequest){
        User userToUpdate = findByUsername(username);
        userToUpdate.setApellido(userUpdateRequest.getApellido());
        userToUpdate.setNombre(userUpdateRequest.getNombre());
        userToUpdate.setEmail(userUpdateRequest.getEmail());
        return userRepository.save(userToUpdate);
        
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        User userToFind = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        return userToFind;
    }

    @Override
    public User findByEmail(String email) {
        User userToFind = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        return userToFind;
    }

    @Override
    public User changePassword(String username, PasswordChangeRequest passwordChangeRequest) {
        
        User userToUpdate = findByUsername(username);
        String oldPassword = passwordChangeRequest.getOldPassword();
        String newPassword = passwordChangeRequest.getNewPassword();

        if (passwordEncoder.matches(oldPassword, userToUpdate.getPassword())) {
            userToUpdate.setPassword(passwordEncoder.encode(newPassword));
            return userRepository.save(userToUpdate);
        } else {
            throw new RuntimeException("Old password is incorrect");
        }
    }

    @Override
    public User updateUserRole(int id, Role role){
        User userToUpdateRole = findById(id);
        userToUpdateRole.setRole(role);
        return userRepository.save(userToUpdateRole);
    }
}
