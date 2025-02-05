package com.sistema.GestionAulas.User.Entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sistema.GestionAulas.Universidad.Entity.Persona;
import com.sistema.GestionAulas.User.CustomAuthorityDeserializer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"})})
public class User extends Persona implements UserDetails {

    @Column(nullable = false, unique = true)
    @NotBlank
    String username;

    @Column(nullable = false)
    @NotBlank
    String password;

    @Column(nullable = false, unique = true)
    @NotBlank
    @Email
    String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Role role;

    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public User(String nombre, String apellido, String tipoDocumento, long dni, 
                String username, String password, String email, Role role) {
        super(nombre, apellido, tipoDocumento, dni);
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}

