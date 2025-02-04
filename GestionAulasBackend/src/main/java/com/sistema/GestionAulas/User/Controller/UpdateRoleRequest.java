package com.sistema.GestionAulas.User.Controller;

import com.sistema.GestionAulas.User.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleRequest {

    Role role;

}