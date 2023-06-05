package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vista.Ventana;
import Modelo.Registro;

public class ControlVistaBD implements ActionListener {
	
	private Ventana vpbd;
	private Registro r = new Registro();
	
	
	
	public ControlVistaBD (Ventana vpbd) {
		this.vpbd = vpbd;
	}


	@Override
	public void actionPerformed(ActionEvent ev) {
		/*if(ev.getSource().equals(vpbd.getBtnGuardar())) {
			int a = r.guardarAlumno(vpbd.getTxtNombre().getText(), vpbd.getTxtApellidoPaterno().getText(), vpbd.getTxtApellidoMaterno().getText(),
					vpbd.getTxtCorreo().getText, vpbd.getTxtDireccion().getText, a, vpbd.getTxtApellidoMaterno().getText, 
					a, null);
			
			if(a>0) {
				JOptionPane.showMessageDialog(null, "¡Registro de alumno terminado!");
			}
			
		}*/
	}
}
