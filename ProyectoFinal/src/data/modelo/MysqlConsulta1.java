package data.modelo;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MysqlConsulta1 extends MySqlAccessData {
	
	private final ObservableList<MoviebankConsulta1> DataList;
	
	
	public MysqlConsulta1(String Servidor, String BaseDeDatos, String User, String pass,
			String Query) {
		super(Servidor, BaseDeDatos, User, pass, Query);
		
		this.DataList = Mysql2FXObservableList(this.getResultado());
	}
	public MysqlConsulta1(String Query) {
		super(Query);
		this.DataList = Mysql2FXObservableList(this.getResultado());
	}
	
	private ObservableList<MoviebankConsulta1> Mysql2FXObservableList(ResultSet Data){
		ObservableList<MoviebankConsulta1> OutList = FXCollections.observableArrayList();
		String peliculasUtf8, TituloUtf8, distribuidoresUtf8, DistribuidoresUtf8;
		try {			
			while(Data.next()) {
				String peliculas = Data.getString("peliculas");
				String Titulo = Data.getString("Titulo");
				String distribuidores = Data.getString("distribuidores");
				String Distribuidores = Data.getString("Distribuidores");
				try {
					peliculasUtf8 = new String(peliculas.getBytes("latin1"), "utf-8");
					TituloUtf8 = new String(Titulo.getBytes("latin1"), "utf-8");
					distribuidoresUtf8 = new String(distribuidores.getBytes("latin1"), "utf-8");
					DistribuidoresUtf8 = new String(Distribuidores.getBytes("latin1"), "utf-8");
					MoviebankConsulta1 Dat = new MoviebankConsulta1(peliculasUtf8, TituloUtf8, distribuidoresUtf8, DistribuidoresUtf8);
					OutList.add(Dat);	
				}catch(UnsupportedEncodingException uee) {
					uee.printStackTrace();
				}
				
			}
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode() );
		}
		
		return OutList; 
	}
	public ObservableList<MoviebankConsulta1> getObservableList() {
		return DataList;
	}

}

