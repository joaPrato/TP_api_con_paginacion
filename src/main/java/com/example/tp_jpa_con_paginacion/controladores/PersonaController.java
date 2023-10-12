package com.example.tp_jpa_con_paginacion.controladores;

import com.example.tp_jpa_con_paginacion.entidades.Persona;
import com.example.tp_jpa_con_paginacion.servicios.BaseServiceImpl;
import com.example.tp_jpa_con_paginacion.servicios.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona,PersonaServiceImpl> {

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<?> buscarPorNombreNativo(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombreNativo(filtro));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/buscarPorLocalidad")
    public ResponseEntity<?> buscarPorLocalidad (@RequestParam String localidad){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorLocalidad(localidad));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/buscarLibrosDe")
    public ResponseEntity<?> buscarLibrosDe (@RequestParam int id_persona){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarLibrosDe(id_persona));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }

    @GetMapping("/buscarLibrosDePaginado")
    public ResponseEntity<?> buscarLibrosDe (@RequestParam int id_persona, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarLibrosDe(id_persona,pageable));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\""+e.getMessage()+"\"}"));
        }
    }


}