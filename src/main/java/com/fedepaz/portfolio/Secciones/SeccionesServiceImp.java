package com.fedepaz.portfolio.Secciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeccionesServiceImp implements SeccionesService {
	
	
	@Autowired
	private SeccionesRepo repo;

	@Override
	public List<Secciones> mostrar() {
		return repo.findAll();
	}

	@Override
	public Secciones mostrarPorId(int id) {
		Optional<Secciones> seccionesOptional = repo.findById(id);
		
		if (!seccionesOptional.isPresent()) {
			return null;
		}

		return seccionesOptional.get();
	}

	@Override
	public Secciones agregar(Secciones seccion) {
		return repo.save(seccion);
	}

	@Override
	public Secciones editar(Secciones seccion) {
		return repo.save(seccion);
	}

	@Override
	public Secciones eliminar(int id) {
		Optional<Secciones> seccionesOptional = repo.findById(id);
		
		if (!seccionesOptional.isPresent()) {
			return null;
		} else {
			repo.delete(seccionesOptional.get());
		}

		return seccionesOptional.get();
		
	}
	
}
