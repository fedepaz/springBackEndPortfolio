package com.fedepaz.portfolio.Conceptos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConceptoServiceImp implements ConceptoService{
	
	@Autowired
	private ConceptoRepo repo;

	@Override
	public List<Concepto> mostrar() {
		return repo.findAll();
	}

	@Override
	public Concepto mostrarPorId(int id) {
		Optional<Concepto> conceptoOptional = repo.findById(id);
		
		if (!conceptoOptional.isPresent()) {
			return null;
		}

		return conceptoOptional.get();
	}
	
	@Override
	public Concepto agregar(Concepto concept) {
		return repo.save(concept);
	}

	@Override
	public Concepto editar(Concepto concept) {
		return repo.save(concept);
	}

	@Override
	public Concepto eliminar(int id) {
		Optional<Concepto> conceptoOptional = repo.findById(id);
		
		if (!conceptoOptional.isPresent()) {
			return null;
		} else {
			repo.delete(conceptoOptional.get());
		}

		return conceptoOptional.get();
		
	}

}
