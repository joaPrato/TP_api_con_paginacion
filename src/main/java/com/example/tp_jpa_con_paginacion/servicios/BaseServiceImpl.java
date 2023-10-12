package com.example.tp_jpa_con_paginacion.servicios;

import com.example.tp_jpa_con_paginacion.entidades.BaseEntidad;
import com.example.tp_jpa_con_paginacion.repositorios.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract  class BaseServiceImpl<E extends BaseEntidad, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository <E,ID>baseRepository;

    public BaseServiceImpl(BaseRepository <E,ID> baseRepository) {
        this.baseRepository= baseRepository;
    }


    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try{
            List<E> enities=baseRepository.findAll();
            return enities;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional=baseRepository.findById(id);
            return entityOptional.get();

        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity=(E) baseRepository.save(entity);
            return entity;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E upDate(ID id, E entity) throws Exception {
        try {
            Optional<E> entityOptional=baseRepository.findById(id);
            E enitdadUp =entityOptional.get();
            enitdadUp=baseRepository.save(entity);
            return enitdadUp;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if (baseRepository.existsById(id)){
                baseRepository.delete(findById(id));
                return true;
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
