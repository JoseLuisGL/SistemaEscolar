package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.Ventana;
import Modelo.Registro;

public class ControlVistaBD implements ActionListener {
	
	private Ventana vpbd;
	private Registro r = new Registro();
	private int telefono;
	
	
	
	public ControlVistaBD (Ventana vpbd) {
		this.vpbd = vpbd;
	}


	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource().equals(vpbd.getBtnGuardar())) {
			
			
			int a = r.guardarAlumno(vpbd.txtNombre.getText(), vpbd.txtApellidoPaterno.getText(), vpbd.txtApellidoMaterno.getText(),
					vpbd.fecha, vpbd.txtCorreo.getText(), vpbd.txtTelefono.getText(), vpbd.txtDireccion.getText(), vpbd.grado,vpbd.imagenBytes);
			
			if(a>0) {
				JOptionPane.showMessageDialog(null, "¡Registro de alumno terminado!");
			}
			
		}
	}
}
