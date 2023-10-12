package com.example.tp_jpa_con_paginacion.repositorios;

import com.example.tp_jpa_con_paginacion.entidades.BaseEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <E extends BaseEntidad , ID extends Serializable> extends JpaRepository<E,ID> {

}
