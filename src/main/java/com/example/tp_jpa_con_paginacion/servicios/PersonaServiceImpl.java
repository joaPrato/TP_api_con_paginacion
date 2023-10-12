package com.example.tp_jpa_con_paginacion.servicios;

import com.example.tp_jpa_con_paginacion.entidades.Libro;
import com.example.tp_jpa_con_paginacion.entidades.Persona;
import com.example.tp_jpa_con_paginacion.repositorios.BaseRepository;
import com.example.tp_jpa_con_paginacion.repositorios.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class PersonaServiceImpl extends BaseServiceImpl <Persona,Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Persona> buscarPorNombreNativo(String filtro)throws Exception{
        try{
            return personaRepository.buscarPorNombreNativo(filtro);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Persona> buscarPorLocalidad(String localidad) throws Exception {
       try{
           return personaRepository.findByDomicilio_Localidad_DenominacionEquals(localidad);
       }
       catch (Exception e){
           throw new Exception(e.getMessage());
       }
    }

    @Override
    @Transactional
    public List<Libro> buscarLibrosDe(int id_persona) throws Exception {
        try {
            return personaRepository.buscarLibrosDe(id_persona);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Libro> buscarLibrosDe(int id_persona, Pageable pageable) throws Exception {
        try {
            return personaRepository.buscarLibrosDe(id_persona,pageable);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
