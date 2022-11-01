package com.fedepaz.portfolio.Conceptos;

import java.util.List;

public interface ConceptoService {

	List<Concepto> mostrar();

	Concepto mostrarPorId(int id);
		
	Concepto agregar(Concepto concept);

	Concepto editar(Concepto concept);

	Concepto eliminar(int id);

}
