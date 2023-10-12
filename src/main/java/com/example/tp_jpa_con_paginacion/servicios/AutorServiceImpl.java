package com.example.tp_jpa_con_paginacion.servicios;

import com.example.tp_jpa_con_paginacion.entidades.Autor;
import com.example.tp_jpa_con_paginacion.repositorios.AutorRepository;
import com.example.tp_jpa_con_paginacion.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl <Autor,Long> implements AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}