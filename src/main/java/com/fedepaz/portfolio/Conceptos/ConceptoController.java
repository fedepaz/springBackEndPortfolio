package com.fedepaz.portfolio.Conceptos;

import com.fedepaz.portfolio.Secciones.Secciones;
import com.fedepaz.portfolio.Secciones.SeccionesService;
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
@RequestMapping("/portfolio/conceptos")
@CrossOrigin(origins = "https://portfolio-1967f.firebaseapp.com/")
public class ConceptoController {
	

	@Autowired
	private SeccionesService seccionesService;

	@Autowired
	private ConceptoService conceptoService;

	@GetMapping
	public ResponseEntity<List<Concepto>> listarConcepto() {

		return ResponseEntity.ok(conceptoService.mostrar());
	}

	@PostMapping
	public ResponseEntity<Concepto> guardarConcepto(@Valid @RequestBody Concepto concept) {
		Secciones seccionesOptional = seccionesService.mostrarPorId(concept.getSecciones().getId());

		if (seccionesOptional==null) {
			return ResponseEntity.unprocessableEntity().build();
		}

		concept.setSecciones(seccionesOptional);
		Concepto conceptoGuardada = conceptoService.agregar(concept);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(conceptoGuardada.getId()).toUri();
		return ResponseEntity.created(ubicacion).body(conceptoGuardada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Concepto> editarConcepto(@PathVariable int id, @RequestBody Concepto concept) {
		
		
		Concepto conceptoOptional = conceptoService.mostrarPorId(id);

		if (conceptoOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		concept.setId(conceptoOptional.getId());
		conceptoService.agregar(concept);

		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Concepto> eliminarConcepto(@PathVariable int id) {
		Concepto conceptoOptional = conceptoService.mostrarPorId(id);

		if (conceptoOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		conceptoService.eliminar(conceptoOptional.getId());

		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Concepto> obtenerConceptoPorId(@PathVariable int id) {
		Concepto conceptoOptional = conceptoService.mostrarPorId(id);

		if (conceptoOptional == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(conceptoOptional);
	}
	
}
