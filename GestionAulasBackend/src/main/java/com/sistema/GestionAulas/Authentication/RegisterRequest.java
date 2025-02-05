package com.sistema.GestionAulas.Authentication;

import com.sistema.GestionAulas.User.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RegisterRequest {
    String nombre;
    String apellido;
    String tipoDocumento;
    long dni;
    String email;
    String username;
    String password;
    Role role;
}
