package Modelo;

import java.io.File;
import java.sql.Connection;
import java.time.LocalDate;

public class Registro extends BD {

	public int guardarAlumno (String nombre, String apellido_paterno, String apellido_materno, LocalDate fecha_nacimiento, String correo, int telefono,
			String direccion, int grado, File foto ) {
	
		return setInformacion("INSERT INTO `bd-ejemplo`.`alumnosbd`"
				+"(`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Fecha nacimiento`, `Correo`, `Telefono`, "
				+ "`Direccion`, `Grado`, `Foto`) VALUES "
				+"('"+nombre+"', '"+apellido_paterno+"', '"+apellido_materno+"', '"+fecha_nacimiento+"', '"+correo+"', '"+telefono+"',"
						+ " '"+direccion+"'" + ", '"+grado+"', '"+foto+"');");
	}
}
