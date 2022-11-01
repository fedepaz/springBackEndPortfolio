package com.fedepaz.portfolio.Secciones;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/portfolio/secciones")
@CrossOrigin(origins = "http://localhost:4200")
public class SeccionesController {

	@Autowired
	private SeccionesService seccionesService;

	@GetMapping
	public ResponseEntity<List<Secciones>> listarSeccion() {
		return new ResponseEntity<>(seccionesService.mostrar(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Secciones> guardarSeccion(@Valid @RequestBody Secciones seccion) {
		Secciones seccionGuardada = seccionesService.agregar(seccion);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(seccionGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(seccionGuardada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Secciones> editarSeccion(@PathVariable int id, @Valid @RequestBody Secciones seccion) {
		Secciones seccionesOptional = seccionesService.mostrarPorId(id);

		if (seccionesOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		seccion.setId(seccionesOptional.getId());
		seccionesService.agregar(seccion);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Secciones> elminarSeccion(@PathVariable int id) {
		Secciones seccionesOptional = seccionesService.mostrarPorId(id);

		if (seccionesOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		seccionesService.eliminar(seccionesOptional.getId());

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Secciones> obtenerSeccionPorId(@PathVariable int id) {
		Secciones seccionesOptional = seccionesService.mostrarPorId(id);

		if (seccionesOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(seccionesOptional);
	}
}
