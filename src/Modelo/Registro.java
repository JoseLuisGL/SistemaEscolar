package Modelo;

import java.io.File;
import java.sql.Connection;
import java.time.LocalDate;

import javax.swing.JTextField;

public class Registro extends BD {

	public int guardarAlumno (String nombre, String apellido_paterno, String apellido_materno, LocalDate fecha_nacimiento, String correo, String telefono,
			String direccion, int grado, byte[] imagenBytes ) {
	
		return setInformacion("INSERT INTO `bd-ejemplo`.`alumnosbd`"
				+"(`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Fecha Nacimiento`, `Correo`, `Telefono`, "
				+ "`Direccion`, `Grado`, `Foto`) VALUES "
				+"('"+nombre+"', '"+apellido_paterno+"', '"+apellido_materno+"', '"+fecha_nacimiento+"', '"+correo+"', '"+telefono+"',"
						+ " '"+direccion+"'" + ", '"+grado+"', '"+imagenBytes+"');");
	}

	public int guardarDocente(String nombre, String apellido_paterno, String apellido_materno, LocalDate fecha_nacimiento, String correo, String telefono,
			String direccion, String grado, byte[] imagenBytes) {
		
		
		return setInformacion("INSERT INTO `bd-ejemplo`.`docentesbd`"
				+"(`Nombre`, `Apellido Paterno`, `Apellido Materno`, `Fecha nacimiento`, `Correo`, `Telefono`, "
				+ "`Direccion`, `Grado`, `Foto`) VALUES "
				+"('"+nombre+"', '"+apellido_paterno+"', '"+apellido_materno+"', '"+fecha_nacimiento+"', '"+correo+"', '"+telefono+"',"
						+ " '"+direccion+"'" + ", '"+grado+"', '"+imagenBytes+"');");
	}

	public int guardarAsignatura(String nombre, String creditos, String docente, int semestres) {
		
		
		return setInformacion("INSERT INTO `bd-ejemplo`.`asignaturasbd`"
				+"(`Nombre`, `Creditos`, `Docente`, `Semestre`) VALUES "
				+"('"+nombre+"', '"+creditos+"', '"+docente+"', '"+semestres+"');");
	}
	
	public int guardarGrupo(String carrera, String asignatura, String docente, String semestre, String numAlumnos) {
		
		
		return setInformacion("INSERT INTO `bd-ejemplo`.`gruposbd`"
				+"(`Carrera`, `Asignatura`, `Docente`, `Semestre`, `numAlumnos`) VALUES "
				+"('"+carrera+"', '"+asignatura+"', '"+docente+"', '"+semestre+"', '"+numAlumnos+"');");
	}
	
	
}
