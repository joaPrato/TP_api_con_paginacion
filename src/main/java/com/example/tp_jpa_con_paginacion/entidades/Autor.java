package com.example.tp_jpa_con_paginacion.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Autor extends BaseEntidad{
    private String nombre;
    private String apellido;
    private String biografia;

}