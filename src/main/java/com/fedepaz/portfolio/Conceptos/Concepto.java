package com.fedepaz.portfolio.Conceptos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedepaz.portfolio.Secciones.Secciones;
import com.sun.istack.NotNull;
import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "conceptos", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"titulo"})})
@NoArgsConstructor
public class Concepto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String titulo;
	@NotNull
	private String contenido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "secciones_id")
	private Secciones secciones;

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

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Secciones getSecciones() {
		return secciones;
	}

	public void setSecciones(Secciones secciones) {
		this.secciones = secciones;
	}
	

}
