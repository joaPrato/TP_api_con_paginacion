package com.example.tp_jpa_con_paginacion.servicios;

import com.example.tp_jpa_con_paginacion.entidades.Libro;
import com.example.tp_jpa_con_paginacion.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService <Persona,Long> { //Van todos los metodos especifico del el service de persona. Es decir va a tener
    //operaciones extras a las que son comunes para todas las clases (BaseService)
    List<Persona> buscarPorNombreNativo (String filtro) throws Exception;
    List<Persona> buscarPorLocalidad (String localidad) throws Exception;
    List<Libro> buscarLibrosDe (int id_persona ) throws Exception;
    Page<Libro> buscarLibrosDe (int id_persona, Pageable pageable) throws Exception;
}
