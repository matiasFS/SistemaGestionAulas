package com.sistema.GestionAulas.User.service;

import java.util.List;

import com.sistema.GestionAulas.User.Controller.PasswordChangeRequest;
import com.sistema.GestionAulas.User.Controller.UpdateUserRequest;
import com.sistema.GestionAulas.User.Entity.Role;
import com.sistema.GestionAulas.User.Entity.User;

public interface IUserService {
    public List<User> findAll();
    public User findById(int id);
    public User updateUser(String username, UpdateUserRequest userUpdateRequest);
    public User save(User user);
    public void delete(int id);
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User changePassword(String username, PasswordChangeRequest passwordChangeRequest);
    public User updateUserRole(int id, Role role);
}
