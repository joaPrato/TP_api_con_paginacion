package com.example.tp_jpa_con_paginacion.repositorios;


import com.example.tp_jpa_con_paginacion.entidades.Libro;
import com.example.tp_jpa_con_paginacion.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {

     List<Persona> findByDomicilio_Localidad_DenominacionEquals(@Param("localidad") String localidad);


    @Query(
            value = "select * from persona where persona.nombre like %:filtro% or persona.apellido like %:filtro%",
            nativeQuery = true
    )
     List<Persona> buscarPorNombreNativo(@Param("filtro") String filtro);

    @Query(value = "select p.libros from Persona p where p.dni= :id_persona")
     List<Libro> buscarLibrosDe(@Param("id_persona")int id_persona);


    @Query(value = "select p.libros from Persona p where p.dni= :id_persona")
    Page<Libro> buscarLibrosDe(@Param("id_persona")int id_persona, Pageable pageable);





}


