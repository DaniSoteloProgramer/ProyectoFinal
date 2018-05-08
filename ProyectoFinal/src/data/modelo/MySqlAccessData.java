package data.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlAccessData {
	private String Servidor="127.0.0.1";
	private String BaseDeDatos="moviebank";
	private String User="root";
	private String pass="Zafiro_1997d.";
	private String Query;
	private ResultSet Resultado;
	
	public  MySqlAccessData(String Servidor, String BaseDeDatos, String User, String pass, String Query) {
		this.Servidor = Servidor;
		this.BaseDeDatos= BaseDeDatos;
		this.User = User;
		this.pass = pass;
		this.Query= Query;
		
		String ConnectionString = crearCadenaConexion(this.Servidor, this.BaseDeDatos, this.User, this.pass);
		this.Resultado = sendMysqlQuery(ConnectionString, Query);	
	}
	public  MySqlAccessData(String Query) {		
		String ConnectionString = crearCadenaConexion(this.Servidor, this.BaseDeDatos, this.User, this.pass);
		this.Resultado = sendMysqlQuery(ConnectionString, Query);	
	}
	public void updateMysqlData() {
		String ConnectionString = crearCadenaConexion(this.Servidor, this.BaseDeDatos, this.User, this.pass);
		this.Resultado = sendMysqlQuery(ConnectionString, Query);	
	}
	public ResultSet getResultado() {
		return this.Resultado;
	}
 	private String crearCadenaConexion(String Servidor, String BaseDeDatos, String User, String pass) {
		String CadenaConexion ="";
		CadenaConexion ="jdbc:mysql://"+Servidor+"/"+BaseDeDatos+"?";
		CadenaConexion += "user="+User+"&password="+pass+"&useLegacyDatetimeCode=false";
		CadenaConexion += "&useUnicode=true&useJDBCCompliantTimezoneShift=true";
		CadenaConexion +="&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		return CadenaConexion;
	}
	private ResultSet sendMysqlQuery(String ConnectionString, String Query){
		Statement objConsulta = null;
		ResultSet objResultadoConsulta = null;
		try {			
			Connection objConection = DriverManager.getConnection(ConnectionString);
			objConsulta = objConection.createStatement();				
			objResultadoConsulta = objConsulta.executeQuery(Query);				
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode() );
		}
		return objResultadoConsulta;
	}
}

