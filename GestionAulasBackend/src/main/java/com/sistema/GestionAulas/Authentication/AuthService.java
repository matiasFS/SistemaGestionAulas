package com.sistema.GestionAulas.Authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sistema.GestionAulas.Jwt.JwtService;
import com.sistema.GestionAulas.User.Entity.User;
import com.sistema.GestionAulas.User.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.getToken(user);
        String role = user.getAuthorities().toString();
        return AuthResponse.builder().token(token).role(role).build();
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        User user = new User(registerRequest.getNombre(), registerRequest.getApellido(), registerRequest.getTipoDocumento(), registerRequest.getDni(), registerRequest.getUsername(), passwordEncoder.encode(registerRequest.getPassword()),registerRequest.getEmail(),registerRequest.getRole());
        System.out.println(user.getApellido());
        userRepository.save(user);
        

        return AuthResponse.builder().token(jwtService.getToken(user)).role(user.getRole().toString()).build();

    }

}
