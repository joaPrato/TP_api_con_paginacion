package com.example.tp_jpa_con_paginacion.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends BaseEntidad{
    private String calle;
    private int numero;
    @ManyToOne(optional = false)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
}