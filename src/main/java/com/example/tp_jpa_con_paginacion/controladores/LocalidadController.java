package com.example.tp_jpa_con_paginacion.controladores;

import com.example.tp_jpa_con_paginacion.entidades.Localidad;
import com.example.tp_jpa_con_paginacion.servicios.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl> {
}
