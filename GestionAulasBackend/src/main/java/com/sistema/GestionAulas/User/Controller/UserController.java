package com.sistema.GestionAulas.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.GestionAulas.Jwt.JwtService;
import com.sistema.GestionAulas.User.Entity.User;
import com.sistema.GestionAulas.User.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    
    @Autowired
    private final UserService userService;


    private final JwtService jwtService;

    @PreAuthorize("hasAnyAuthority('AUDITOR', 'ADMIN') ")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN', 'AUDITOR', 'PROFESSOR')")
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PutMapping("users/changePassword")
    public ResponseEntity<User> changePassword(@RequestHeader("Authorization") String token, @RequestBody PasswordChangeRequest passwordChangeRequest) {
        String username = jwtService.getUsernameFromToken(token.substring(7));
        User userToUpdate = userService.changePassword(username, passwordChangeRequest.getOldPassword(), passwordChangeRequest.getNewPassword());
        return ResponseEntity.ok(userService.update(userToUpdate.getId(), userToUpdate));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/users/{id}")
    public ResponseEntity<User> updateUserRole(@PathVariable int id, @RequestBody UpdateRoleRequest role) {
        System.out.println(role.getRole());
        return ResponseEntity.ok(userService.updateUserRole(id, role.getRole()));
    }

}
