package com.duoc.userservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rut;
    private String nombreCompleto;
    private String contacto;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        CIUDADANO,
        BRIGADISTA,
        ADMINISTRADOR
    }
}
