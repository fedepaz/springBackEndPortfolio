package com.fedepaz.portfolio.Secciones;

import java.util.List;

public interface SeccionesService {
	
	List<Secciones> mostrar();
	
	Secciones mostrarPorId(int id);
	
	Secciones agregar(Secciones seccion);
	
	Secciones editar (Secciones seccion);
	
	Secciones eliminar(int id);
	
}
