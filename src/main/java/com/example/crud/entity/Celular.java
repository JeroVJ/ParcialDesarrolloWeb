package com.example.crud.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import com.example.crud.enums.SistemaOperativo;
import com.example.crud.enums.Gama;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CELULAR_TBL")
public class Celular {
    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "La marca no puede ser nula")
    private String marca;

    @NotNull(message = "El serial no puede ser nulo")
    private String serial;

    @NotNull(message = "La fecha de compra no puede ser nula")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaDeCompra;

    @Positive(message = "El año de lanzamiento debe ser un número positivo")
    private int anoDeLanzamiento;

    @Positive(message = "El precio debe ser un número positivo")
    private double precio;

    @NotNull(message = "El sistema operativo no puede ser nulo")
    @Enumerated(EnumType.STRING)
    private SistemaOperativo sistemaOperativo;

    @NotNull(message = "La gama no puede ser nula")
    @Enumerated(EnumType.STRING)
    private Gama gama;
}
