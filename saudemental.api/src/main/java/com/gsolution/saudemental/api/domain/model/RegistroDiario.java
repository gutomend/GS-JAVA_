package com.gsolution.saudemental.api.domain.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDate dataRegistro;

    @Column(nullable = false)
    private Integer nivelHumor;

    @Column(nullable = false)
    private Integer nivelAnsiedade;

    @Column(nullable = false)
    private Integer horasSono;
}