package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.attribute.AttributeSet;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter.FilterBypass;

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
		if(ev.getSource().equals(vpbd.getBtnGuardar())) {
			int errores=0;
			 
			
			 String correo = vpbd.txtCorreo.getText();
			 String patronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			 Pattern patron = Pattern.compile(patronCorreo);
			 Matcher matcher = patron.matcher(correo);
			 
			 int grado = (int) vpbd.comboBox.getSelectedItem();
			 
			 
			 vpbd.txtTelefono.setBackground(new Color(0, 128, 192));
			 vpbd.txtApellidoMaterno.setBackground(new Color(0, 128, 192));
			 vpbd.txtApellidoPaterno.setBackground(new Color(0, 128, 192));
			 vpbd.txtCorreo.setBackground(new Color(0, 128, 192));
			 vpbd.txtNombre.setBackground(new Color(0, 128, 192));
			 	
			if (vpbd.txtTelefono.getText().length() != 10 || vpbd.txtTelefono.getText() == "") {
				 vpbd.txtTelefono.setBackground(new Color(255, 0, 0));
                 errores++;
             }
			 
             if (matcher.matches()!=true) {
            	 vpbd.txtCorreo.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.txtNombre.getText().length()<2) {
            	 vpbd.txtNombre.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.txtApellidoPaterno.getText().length()<2) {
            	 vpbd.txtApellidoPaterno.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.txtApellidoMaterno.getText().length()<2) {
            	 vpbd.txtApellidoMaterno.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
            
             
			int ano = ((Integer) vpbd.ano_nacimiento.getSelectedItem()). intValue();
			int mes = ((Integer) vpbd.mes_nacimiento.getSelectedItem()). intValue();
			int dia = ((Integer) vpbd.dia_nacimiento.getSelectedItem()). intValue();
			
			
			LocalDate fecha = LocalDate.of(ano, mes, dia);
			
			if(errores>0) {
				JOptionPane.showInternalMessageDialog(null, "Fallo al crear alumno. Favor de revisar que la informacion cumpla con las caracteristicas "
						+ "adecuadas.");
			}
			
			if(errores==0) {
			int a = r.guardarAlumno(vpbd.txtNombre.getText(), vpbd.txtApellidoPaterno.getText(), vpbd.txtApellidoMaterno.getText(),
					fecha, vpbd.txtCorreo.getText(), vpbd.txtTelefono.getText(), vpbd.txtDireccion.getText(), grado,vpbd.imagenBytes);
			
			if(a>0) {
				JOptionPane.showMessageDialog(null, "¡Registro de alumno terminado!");
			}
		}
		errores=0;	
		
		}
	
		if(ev.getSource().equals(vpbd.getBtnGuardarDocente())) {
			int errores=0;			 
			 String correo = vpbd.txtCorreoD.getText();
			 String patronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
			 Pattern patron = Pattern.compile(patronCorreo);
			 Matcher matcher = patron.matcher(correo); 
			 
			 vpbd.txtTelefonoD.setBackground(new Color(0, 128, 192));
			 vpbd.txtApellidoMaternoD.setBackground(new Color(0, 128, 192));
			 vpbd.txtApellidoPaternoD.setBackground(new Color(0, 128, 192));
			 vpbd.txtCorreoD.setBackground(new Color(0, 128, 192));
			 vpbd.txtNombreD.setBackground(new Color(0, 128, 192));
			 	
			if (vpbd.txtTelefonoD.getText().length() != 10 || vpbd.txtTelefonoD.getText() == "") {
				 vpbd.txtTelefonoD.setBackground(new Color(255, 0, 0));
                 errores++;
             }
			 
             if (matcher.matches()!=true) {
            	 vpbd.txtCorreoD.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.txtNombreD.getText().length()<2) {
            	 vpbd.txtNombreD.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.txtApellidoPaternoD.getText().length()<2) {
            	 vpbd.txtApellidoPaternoD.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.txtApellidoMaternoD.getText().length()<2) {
            	 vpbd.txtApellidoMaternoD.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(vpbd.comboBoxD==null) {
            	 vpbd.txtApellidoMaternoD.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
            
             
			int ano = ((Integer) vpbd.ano_nacimientoD.getSelectedItem()). intValue();
			int mes = ((Integer) vpbd.mes_nacimientoD.getSelectedItem()). intValue();
			int dia = ((Integer) vpbd.dia_nacimientoD.getSelectedItem()). intValue();
			
			
			LocalDate fecha = LocalDate.of(ano, mes, dia);
			
			if(errores>0) {
				JOptionPane.showInternalMessageDialog(null, "Fallo al crear Docente. Favor de revisar que la informacion cumpla con las caracteristicas "
						+ "adecuadas.");
			}
			
			if(errores==0) {
			int a = r.guardarDocente(vpbd.txtNombreD.getText(), vpbd.txtApellidoPaternoD.getText(), vpbd.txtApellidoMaternoD.getText(),
					fecha, vpbd.txtCorreoD.getText(), vpbd.txtTelefonoD.getText(), vpbd.txtDireccionD.getText(), 
					vpbd.comboBoxD.getSelectedItem().toString(),vpbd.imagenBytesD);
			
			if(a>0) {
				JOptionPane.showMessageDialog(null, "¡Registro de docente terminado!");
			}
		}
		errores=0;	
		
		}
		
		if(ev.getSource().equals(vpbd.getBtnGuardarGrupo())) {
			int errores=0;			 
			 
			 vpbd.carreraG.setBackground(new Color(0, 128, 192));
			 vpbd.num_alu.setBackground(new Color(0, 128, 192));
			 
			 int num_alu = Integer.parseInt(vpbd.num_alu.getText()) ;
			
			 	
			if (num_alu < 1 || num_alu > 50) {
				 vpbd.num_alu.setBackground(new Color(255, 0, 0));
                 errores++;
             }
			 
             if(vpbd.carreraG.getText().length()<2) {
            	 vpbd.carreraG.setBackground(new Color(255, 0, 0));
            	 errores++;
             }                    
             
             String asignatura = (String) vpbd.asignaturaG.getSelectedItem();
             String docente = (String) vpbd.docente_a_cargoG.getSelectedItem();
             int semestre = (int) vpbd.semestreG.getSelectedItem();
             
                        
			if(errores>0) {
				JOptionPane.showInternalMessageDialog(null, "Fallo al crear Grupo. Favor de revisar que la informacion cumpla con las caracteristicas "
						+ "adecuadas.");
			}
			
			if(errores==0) {
			int a = r.guardarGrupo(vpbd.carreraG.getText(), asignatura, docente, semestre, vpbd.num_alu.getText());
			
			if(a>0) {
				JOptionPane.showMessageDialog(null, "¡Registro de grupo terminado!");
			}
		}
		errores=0;	
		
		}

		if(ev.getSource().equals(vpbd.getBtnGuardarAsignatura())) {
			int errores=0;		
			int semestre = (int) vpbd.semestres.getSelectedItem();
			String maestro = (String) vpbd.docente_a_cargo.getSelectedItem();

			vpbd.nombre_asig.setBackground(new Color(0, 128, 192));
			vpbd.creditos.setBackground(new Color(0, 128, 192));
			int creditos = Integer.parseInt(vpbd.creditos.getText());

             if(vpbd.nombre_asig.getText().length()<2) {
            	 vpbd.nombre_asig.setBackground(new Color(255, 0, 0));
            	 errores++;
             }
             
             if(creditos<1 || creditos>20) {
            	 vpbd.creditos.setBackground(new Color(255, 0, 0));
            	 errores++;
             }

			if(errores>0) {
				JOptionPane.showInternalMessageDialog(null, "Fallo al crear Asginatura. Favor de revisar que la informacion cumpla con las "
						+ "caracteristicas adecuadas.");
			}
			
			if(errores==0) {
			int a = r.guardarAsignatura(vpbd.nombre_asig.getText(), vpbd.creditos.getText(), maestro, semestre);
			
			if(a>0) {
				JOptionPane.showMessageDialog(null, "¡Registro de asignatura terminado!");
			}
		}
		errores=0;	
		
		}
	}
   
}
