package com.example.tp_jpa_con_paginacion.servicios;

import com.example.tp_jpa_con_paginacion.entidades.Localidad;
import com.example.tp_jpa_con_paginacion.repositorios.BaseRepository;
import com.example.tp_jpa_con_paginacion.repositorios.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService {
    @Autowired
    private LocalidadRepository localidadRepository;
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}