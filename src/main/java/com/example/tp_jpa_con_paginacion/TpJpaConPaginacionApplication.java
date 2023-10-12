package com.example.tp_jpa_con_paginacion;

import com.example.tp_jpa_con_paginacion.entidades.*;
import com.example.tp_jpa_con_paginacion.repositorios.AutorRepository;
import com.example.tp_jpa_con_paginacion.repositorios.LocalidadRepository;
import com.example.tp_jpa_con_paginacion.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpJpaConPaginacionApplication {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	LocalidadRepository localidadRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpJpaConPaginacionApplication.class, args);
		System.out.println("Estoy en el main");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo,AutorRepository autorRepo ,LocalidadRepository localidadRepo){
		return args -> {
			System.out.println("Estoy funcionando");

			Autor autor1=Autor.builder()
					.nombre("Oscar")
					.apellido("Wilde")
					.biografia("texto")
					.build();
			Autor autor2=Autor.builder()
					.nombre("James")
					.apellido("Joyce")
					.biografia("texto")
					.build();


			Libro libro1=Libro.builder()
					.titulo("La importancia de llamarse Ernesto")
					.fecha(2000)
					.genero("Policial")
					.paginas(365)
					.build();
			Libro libro2=Libro.builder()
					.titulo("El retrato de Dorian Gray")
					.fecha(2008)
					.genero("Romance")
					.paginas(425)
					.build();
			Libro libro3=Libro.builder()
					.titulo("El fantasma de Canterville")
					.fecha(2013)
					.genero("Policial")
					.paginas(240)
					.build();
			Libro libro4=Libro.builder()
					.titulo("De profundis")
					.fecha(1996)
					.genero("Policial")
					.paginas(630)
					.build();

			libro1.agregarAutor(autor1);
			libro1.agregarAutor(autor2);
			libro2.agregarAutor(autor1);
			libro3.agregarAutor(autor1);
			libro4.agregarAutor(autor2);
			libro4.agregarAutor(autor1);

			autorRepository.save(autor1);
			autorRepository.save(autor2);

			Localidad localidad1=Localidad.builder()
					.denominacion("Guaymallen")
					.build();
			Localidad localidad2=Localidad.builder()
					.denominacion("Capital")
					.build();

			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);

			Domicilio domicilio1=Domicilio.builder()
					.calle("Murialdo")
					.numero(1569)
					.localidad(localidad1)
					.build();
			Domicilio domicilio2=Domicilio.builder()
					.calle("Libertad")
					.numero(4236)
					.localidad(localidad1)
					.build();

			Persona persona1=Persona.builder()
					.nombre("Joaquin")
					.apellido("Prato")
					.dni(42750526)
					.domicilio(domicilio1)
					.build();
			Persona persona2=Persona.builder()
					.nombre("Juan")
					.apellido("Perez")
					.dni(25689354)
					.domicilio(domicilio2)
					.build();

			persona1.agregarLibror(libro1);
			persona1.agregarLibror(libro2);
			persona1.agregarLibror(libro4);
			persona2.agregarLibror(libro3);

			personaRepository.save(persona1);
			personaRepository.save(persona2);





		};
	}

}
