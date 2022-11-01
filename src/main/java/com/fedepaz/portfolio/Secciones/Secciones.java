package com.fedepaz.portfolio.Secciones;

import com.fedepaz.portfolio.Conceptos.Concepto;
import com.sun.istack.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "secciones")
@NoArgsConstructor

public class Secciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String titulo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


}
