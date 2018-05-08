package data.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class MoviebankConsulta1 {
	private StringProperty peliculas;
	private StringProperty Titulo;
	private StringProperty distribuidores;
	private StringProperty Distribuidores;
	
	public MoviebankConsulta1(String peliculas, String Titulo, String distribuidores, String Distribuidores) {
		this.peliculas = new SimpleStringProperty(peliculas);
		this.Titulo = new SimpleStringProperty(Titulo);
		this.distribuidores = new SimpleStringProperty(distribuidores);
		this.Distribuidores = new SimpleStringProperty(Distribuidores);
		
	}
	public void setpeliculas(String peliculas) {
		this.peliculas.set(peliculas);
	}
	public void setTitulo(String Titulo) {
		this.Titulo.set(Titulo);
	}
	public void setdistribuidores(String distribuidores) {
		this.distribuidores.set(distribuidores);
	}
	public void setDistribuidores(String Distribuidores) {
		this.Distribuidores.set(Distribuidores);
	}
	public String getpeliculas() {
		return this.peliculas.get();
	}
	public String getTitulo() {
		return this.Titulo.get();
	}
	public String getdistribuidores() {
		return this.distribuidores.get();
	}
	public String getDistribuidores() {
		return this.Distribuidores.get();
	}
	public StringProperty getpeliculasProperty() {
		return this.peliculas;
	}
	public StringProperty getTituloProperty() {
		return this.Titulo;
	}
	public StringProperty getdistribuidoresProperty() {
		return this.distribuidores;
	}
	public StringProperty getDistribuidoresProperty() {
		return this.Distribuidores;
	}
	public ObservableList<MoviebankConsulta1> getObservableList() {
		// TODO Auto-generated method stub
		return null;
	}
}
