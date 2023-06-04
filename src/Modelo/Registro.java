package Modelo;

import java.sql.Connection;

public class Registro extends BD {

	public int guardarAlumno (String nombre, String direccion, String rut) {
	
		return setInformacion("INSERT INTO `bd-ejemplo`.`alumnos`"
				+"(`nombre`, `direccion`, `rut`) VALUES "
				+"('"+nombre+"', '"+direccion+"', '"+rut+"');");
	}
}
