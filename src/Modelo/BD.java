package Modelo;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class BD {

	private Connection conexion = null;
	private java.sql.Statement consulta = null;
	private ResultSet rs = null;
	
	
	public Connection Conectar () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd-ejemplo?useSSL=false","root","proyectofinal123");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la base de datos");
			e.printStackTrace();
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar driver");
		}
		return conexion;
	}
	
	public int setInformacion (String instruccion) {
		Conectar();
		int validar=0;
		
		try {
			if(conexion == null){
				JOptionPane.showMessageDialog(null, "Conexion nula");
			}
			consulta = conexion.createStatement();
			validar = consulta.executeUpdate(instruccion);
			
			return validar;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al realizar consultar");
			e.printStackTrace();
			
			return validar;
		}	
	}
	
	
	
}
