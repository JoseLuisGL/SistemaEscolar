import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Ventana extends JFrame{
	private String anterior = "login";
	private String actual = "login";
	private JTextField username;
	private JPasswordField password;
	public JPanel panel = null;
	private JTable table;
	
	public Ventana() {
		this.setTitle("Sistema Escolar");
		this.setSize(600,600);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		limpiarVentana();
	}
	
	public JPanel login() {
		anterior = actual;
		actual = "login";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Sistema Escolar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Accede a tu cuenta");
		Titulo2.setForeground(new Color(0, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Titulo2.setBounds(79, 62, 421, 25);
		fondo.add(Titulo2);
		
		JLabel tag1 = new JLabel("Correo eléctronico:");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(260, 155, 152, 25);
		fondo.add(tag1);
		
		JLabel tag2 = new JLabel("Contraseña:");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(260, 250, 152, 25);
		fondo.add(tag2);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 0));
		username.setBackground(new Color(51, 51, 255));
		username.setBounds(260, 191, 267, 33);
		fondo.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setForeground(new Color(0, 0, 0));
		password.setBackground(new Color(51, 51, 255));
		password.setBounds(260, 286, 267, 33);
		fondo.add(password);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.setBackground(new Color(255, 0, 0));
		Cancelar.setForeground(new Color(255, 255, 255));
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		Cancelar.setBounds(260, 364, 120, 33);
		fondo.add(Cancelar);
		
		JButton btnAccess = new JButton("Iniciar Sesión");
		btnAccess.setForeground(new Color(255, 255, 255));
		btnAccess.setBackground(new Color(0, 255, 64));
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		btnAccess.setBounds(407, 364, 120, 33);
		fondo.add(btnAccess);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(50, 155, 161, 174);
		fondo.add(imagen);
		
		JLabel imagenfondo = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/fondo.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		imagenfondo.setIcon(imageFondo);
		imagenfondo.setBounds(0, 0, 600, 600);
		fondo.add(imagenfondo);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel menu() {
		anterior = actual;
		actual = "menu";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Bienvenido Admin");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("¿Qué acción desea realizar?");
		Titulo2.setForeground(new Color(0, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 62, 421, 25);
		fondo.add(Titulo2);
		
		JLabel tag1 = new JLabel("Alumnos");
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setHorizontalAlignment(SwingConstants.CENTER);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(51, 108, 90, 25);
		fondo.add(tag1);
		
		JLabel tag2 = new JLabel("Docentes");
		tag2.setHorizontalAlignment(SwingConstants.CENTER);
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(176, 108, 90, 25);
		fondo.add(tag2);
		
		JLabel tag3 = new JLabel("Grupos");
		tag3.setHorizontalAlignment(SwingConstants.CENTER);
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBounds(308, 108, 90, 25);
		fondo.add(tag3);
		
		JLabel tag4 = new JLabel("Asignaturas");
		tag4.setHorizontalAlignment(SwingConstants.CENTER);
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBounds(445, 108, 90, 25);
		fondo.add(tag4);
		
		JButton btnCredAlu = new JButton("<html>Generar Credencial<html>");
		btnCredAlu.setBackground(new Color(121, 255, 145));
		btnCredAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCredAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "credencialAlumno";
				add(credencialAlumno());
				repaint();
				revalidate();
			}
		});
		btnCredAlu.setBounds(51, 144, 90, 59);
		fondo.add(btnCredAlu);
		
		JButton btnCredDoce = new JButton("<html>Generar Credencial<html>");
		btnCredDoce.setBackground(new Color(121, 255, 145));
		btnCredDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCredDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "credencialDocente";
				add(credencialDocente());
				repaint();
				revalidate();
			}
		});
		btnCredDoce.setBounds(176, 144, 90, 59);
		fondo.add(btnCredDoce);
		
		JButton btnConsultarAlu = new JButton("Consultar");
		btnConsultarAlu.setBackground(new Color(121, 255, 145));
		btnConsultarAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "consultarAlumno";
				add(consultarAlumno());
				repaint();
				revalidate();
			}
		});
		btnConsultarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarAlu.setBounds(51, 225, 90, 40);
		fondo.add(btnConsultarAlu);
		
		JButton btnConsultarDoce = new JButton("Consultar");
		btnConsultarDoce.setBackground(new Color(121, 255, 145));
		btnConsultarDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "consultarDocente";
				add(consultarDocente());
				repaint();
				revalidate();
			}
		});
		btnConsultarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarDoce.setBounds(176, 225, 90, 40);
		fondo.add(btnConsultarDoce);
		
		JButton btnCrearAlu = new JButton("Crear");
		btnCrearAlu.setBackground(new Color(121, 255, 145));
		btnCrearAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "crearAlumno";
				add(crearAlumno());
				repaint();
				revalidate();
			}
		});
		btnCrearAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearAlu.setBounds(51, 285, 90, 40);
		fondo.add(btnCrearAlu);
		
		JButton btnCrearDoce = new JButton("Crear");
		btnCrearDoce.setBackground(new Color(121, 255, 145));
		btnCrearDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "crearDocente";
				add(crearDocente());
				repaint();
				revalidate();
			}
		});
		btnCrearDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearDoce.setBounds(176, 285, 90, 40);
		fondo.add(btnCrearDoce);
		
		JButton btnEditarAlu = new JButton("Editar");
		btnEditarAlu.setBackground(new Color(121, 255, 145));
		btnEditarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "editarAlumno";
				add(editarAlumno());
				repaint();
				revalidate();
			}
		});
		btnEditarAlu.setBounds(51, 345, 90, 40);
		fondo.add(btnEditarAlu);
		
		JButton btnEditarDoce = new JButton("Editar");
		btnEditarDoce.setBackground(new Color(121, 255, 145));
		btnEditarDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "editarDocente";
				add(editarDocente());
				repaint();
				revalidate();
			}
		});
		btnEditarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarDoce.setBounds(176, 345, 90, 40);
		fondo.add(btnEditarDoce);
		
		JButton btnEliminarAlu = new JButton("Eliminar");
		btnEliminarAlu.setBackground(new Color(121, 255, 145));
		btnEliminarAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "eliminarAlumno";
				add(eliminarAlumno());
				repaint();
				revalidate();
			}
		});
		btnEliminarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarAlu.setBounds(51, 405, 90, 40);
		fondo.add(btnEliminarAlu);
		
		JButton btnEliminarDoce = new JButton("Eliminar");
		btnEliminarDoce.setBackground(new Color(121, 255, 145));
		btnEliminarDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "eliminarDocente";
				add(eliminarDocente());
				repaint();
				revalidate();
			}
		});
		btnEliminarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarDoce.setBounds(176, 405, 90, 40);
		fondo.add(btnEliminarDoce);
		
		JButton btnConsultarGrup = new JButton("Consultar");
		btnConsultarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarGrup.setBackground(new Color(121, 255, 145));
		btnConsultarGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "consultarGrupo";
				add(consultarGrupo());
				repaint();
				revalidate();
			}
		});
		btnConsultarGrup.setBounds(308, 144, 90, 40);
		fondo.add(btnConsultarGrup);
		
		JButton btnCrearGrup = new JButton("Crear");
		btnCrearGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearGrup.setBackground(new Color(121, 255, 145));
		btnCrearGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "crearGrupo";
				add(crearGrupo());
				repaint();
				revalidate();
			}
		});
		btnCrearGrup.setBounds(308, 205, 90, 40);
		fondo.add(btnCrearGrup);
		
		JButton btnEditarGrup = new JButton("Editar");
		btnEditarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarGrup.setBackground(new Color(121, 255, 145));
		btnEditarGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "editarGrupo";
				add(editarGrupo());
				repaint();
				revalidate();
			}
		});
		btnEditarGrup.setBounds(308, 266, 90, 40);
		fondo.add(btnEditarGrup);
		
		JButton btnEliminarGrup = new JButton("Eliminar");
		btnEliminarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarGrup.setBackground(new Color(121, 255, 145));
		btnEliminarGrup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "eliminarGrupo";
				add(eliminarGrupo());
				repaint();
				revalidate();
			}
		});
		btnEliminarGrup.setBounds(308, 335, 90, 40);
		fondo.add(btnEliminarGrup);
		
		JButton btnConsultarAsig = new JButton("Consultar");
		btnConsultarAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarAsig.setBackground(new Color(121, 255, 145));
		btnConsultarAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "consultarAsignatura";
				add(consultarAsignatura());
				repaint();
				revalidate();
			}
		});
		btnConsultarAsig.setBounds(445, 144, 90, 40);
		fondo.add(btnConsultarAsig);
		
		JButton btnCrearAsig = new JButton("Crear");
		btnCrearAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearAsig.setBackground(new Color(121, 255, 145));
		btnCrearAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "crearAsignatura";
				add(crearAsignatura());
				repaint();
				revalidate();
			}
		});
		btnCrearAsig.setBounds(445, 205, 90, 40);
		fondo.add(btnCrearAsig);
		
		JButton btnEditarAsig = new JButton("Editar");
		btnEditarAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarAsig.setBackground(new Color(121, 255, 145));
		btnEditarAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "editarAsignatura";
				add(editarAsignatura());
				repaint();
				revalidate();
			}
		});
		btnEditarAsig.setBounds(445, 266, 90, 40);
		fondo.add(btnEditarAsig);
		
		JButton btnEliminarAsig = new JButton("Eliminar");
		btnEliminarAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarAsig.setBackground(new Color(121, 255, 145));
		btnEliminarAsig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "eliminarAsignatura";
				add(eliminarAsignatura());
				repaint();
				revalidate();
			}
		});
		btnEliminarAsig.setBounds(445, 335, 90, 40);
		fondo.add(btnEliminarAsig);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrarSesion.setBackground(new Color(255, 0, 0));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "login";
				add(login());
				repaint();
				revalidate();
			}
		});
		btnCerrarSesion.setBounds(410, 496, 125, 40);
		fondo.add(btnCerrarSesion);
		
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(0, 0, 584, 561);
		fondo.add(fondoMenu);
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearAlumno() {
		anterior = actual;
		actual = "crearAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Alumno - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombres:");
		tag1.setBounds(25, 11, 90, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Apellidos:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Fecha de nacimiento:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Correo electronico:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grado:");
		tag7.setBounds(25, 333, 90, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Teléfono:");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombres = new JTextField();
		nombres.setBackground(new Color(0, 128, 192));
		nombres.setBounds(25, 36, 420, 25);
		fondo2.add(nombres);
		nombres.setColumns(10);
		
		JTextField apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBackground(new Color(0, 128, 192));
		apellidos.setBounds(25, 86, 420, 25);
		fondo2.add(apellidos);
		
		JTextField fechaNacimiento = new JTextField();
		fechaNacimiento.setColumns(10);
		fechaNacimiento.setBackground(new Color(0, 128, 192));
		fechaNacimiento.setBounds(25, 140, 420, 25);
		fondo2.add(fechaNacimiento);
		
		JTextField correo = new JTextField();
		correo.setColumns(10);
		correo.setBackground(new Color(0, 128, 192));
		correo.setBounds(25, 195, 420, 25);
		fondo2.add(correo);
		
		JTextField telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBackground(new Color(0, 128, 192));
		telefono.setBounds(25, 246, 420, 25);
		fondo2.add(telefono);
		
		JTextField grado = new JTextField();
		grado.setColumns(10);
		grado.setBackground(new Color(0, 128, 192));
		grado.setBounds(25, 356, 420, 25);
		fondo2.add(grado);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Crear.setForeground(new Color(255, 255, 255));
		Crear.setBackground(new Color(0, 128, 255));
		Crear.setBounds(342, 514, 89, 23);
		fondo.add(Crear);

		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearDocente() {
		anterior = actual;
		actual = "crearAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Docente - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombres:");
		tag1.setBounds(25, 11, 90, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Apellidos:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Fecha de nacimiento:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Correo electronico:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grado de estudios:");
		tag7.setBounds(25, 333, 150, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Teléfono:");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombres = new JTextField();
		nombres.setBackground(new Color(0, 128, 192));
		nombres.setBounds(25, 36, 420, 25);
		fondo2.add(nombres);
		nombres.setColumns(10);
		
		JTextField apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBackground(new Color(0, 128, 192));
		apellidos.setBounds(25, 86, 420, 25);
		fondo2.add(apellidos);
		
		JTextField fechaNacimiento = new JTextField();
		fechaNacimiento.setColumns(10);
		fechaNacimiento.setBackground(new Color(0, 128, 192));
		fechaNacimiento.setBounds(25, 140, 420, 25);
		fondo2.add(fechaNacimiento);
		
		JTextField correo = new JTextField();
		correo.setColumns(10);
		correo.setBackground(new Color(0, 128, 192));
		correo.setBounds(25, 195, 420, 25);
		fondo2.add(correo);
		
		JTextField telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBackground(new Color(0, 128, 192));
		telefono.setBounds(25, 246, 420, 25);
		fondo2.add(telefono);
		
		JTextField grado = new JTextField();
		grado.setColumns(10);
		grado.setBackground(new Color(0, 128, 192));
		grado.setBounds(25, 356, 420, 25);
		fondo2.add(grado);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Crear.setForeground(new Color(255, 255, 255));
		Crear.setBackground(new Color(0, 128, 255));
		Crear.setBounds(342, 514, 89, 23);
		fondo.add(Crear);

		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearGrupo() {
		anterior = actual;
		actual = "crearGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre del Grupo:");
		tag1.setBounds(25, 11, 169, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Carrera:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Turno:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Numero de alumnos:");
		tag7.setBounds(25, 333, 169, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Semestre:\r\n");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombres = new JTextField();
		nombres.setBackground(new Color(0, 128, 192));
		nombres.setBounds(25, 36, 420, 25);
		fondo2.add(nombres);
		nombres.setColumns(10);
		
		JTextField carrera = new JTextField();
		carrera.setColumns(10);
		carrera.setBackground(new Color(0, 128, 192));
		carrera.setBounds(25, 86, 420, 25);
		fondo2.add(carrera);
		
		JTextField turno = new JTextField();
		turno.setColumns(10);
		turno.setBackground(new Color(0, 128, 192));
		turno.setBounds(25, 140, 420, 25);
		fondo2.add(turno);
		
		JTextField docente_a_cargo = new JTextField();
		docente_a_cargo.setColumns(10);
		docente_a_cargo.setBackground(new Color(0, 128, 192));
		docente_a_cargo.setBounds(25, 195, 420, 25);
		fondo2.add(docente_a_cargo);
		
		JTextField semestre = new JTextField();
		semestre.setColumns(10);
		semestre.setBackground(new Color(0, 128, 192));
		semestre.setBounds(25, 246, 420, 25);
		fondo2.add(semestre);
		
		JTextField num_alu = new JTextField();
		num_alu.setColumns(10);
		num_alu.setBackground(new Color(0, 128, 192));
		num_alu.setBounds(25, 356, 420, 25);
		fondo2.add(num_alu);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Crear.setForeground(new Color(255, 255, 255));
		Crear.setBackground(new Color(0, 128, 255));
		Crear.setBounds(342, 514, 89, 23);
		fondo.add(Crear);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearAsignatura() {
		anterior = actual;
		actual = "crearAsignatura";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre de la Asignatura:");
		tag1.setBounds(25, 11, 211, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Créditos:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Turnos:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grupos que llevan esta asignatura:");
		tag7.setBounds(25, 333, 263, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Semestres:\r\n");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombre_asig = new JTextField();
		nombre_asig.setBackground(new Color(0, 128, 192));
		nombre_asig.setBounds(25, 36, 420, 25);
		fondo2.add(nombre_asig);
		nombre_asig.setColumns(10);
		
		JTextField creditos = new JTextField();
		creditos.setColumns(10);
		creditos.setBackground(new Color(0, 128, 192));
		creditos.setBounds(25, 86, 420, 25);
		fondo2.add(creditos);
		
		JTextField turnos = new JTextField();
		turnos.setColumns(10);
		turnos.setBackground(new Color(0, 128, 192));
		turnos.setBounds(25, 140, 420, 25);
		fondo2.add(turnos);
		
		JTextField docente_a_cargo = new JTextField();
		docente_a_cargo.setColumns(10);
		docente_a_cargo.setBackground(new Color(0, 128, 192));
		docente_a_cargo.setBounds(25, 195, 420, 25);
		fondo2.add(docente_a_cargo);
		
		JTextField semestres = new JTextField();
		semestres.setColumns(10);
		semestres.setBackground(new Color(0, 128, 192));
		semestres.setBounds(25, 246, 420, 25);
		fondo2.add(semestres);
		
		JTextField grupos = new JTextField();
		grupos.setColumns(10);
		grupos.setBackground(new Color(0, 128, 192));
		grupos.setBounds(25, 356, 420, 25);
		fondo2.add(grupos);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Crear = new JButton("Crear");
		Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Crear.setForeground(new Color(255, 255, 255));
		Crear.setBackground(new Color(0, 128, 255));
		Crear.setBounds(342, 514, 89, 23);
		fondo.add(Crear);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel editarGrupo() {
		anterior = actual;
		actual = "editarGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Editar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre del Grupo:");
		tag1.setBounds(25, 11, 211, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Carrera:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Turno:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Numero de alumnos:");
		tag7.setBounds(25, 333, 263, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Semestre:\r\n");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombre_grup = new JTextField();
		nombre_grup.setBackground(new Color(0, 128, 192));
		nombre_grup.setBounds(25, 36, 420, 25);
		fondo2.add(nombre_grup);
		nombre_grup.setColumns(10);
		
		JTextField carrera = new JTextField();
		carrera.setColumns(10);
		carrera.setBackground(new Color(0, 128, 192));
		carrera.setBounds(25, 86, 420, 25);
		fondo2.add(carrera);
		
		JTextField turno = new JTextField();
		turno.setColumns(10);
		turno.setBackground(new Color(0, 128, 192));
		turno.setBounds(25, 140, 420, 25);
		fondo2.add(turno);
		
		JTextField docente_a_cargo = new JTextField();
		docente_a_cargo.setColumns(10);
		docente_a_cargo.setBackground(new Color(0, 128, 192));
		docente_a_cargo.setBounds(25, 195, 420, 25);
		fondo2.add(docente_a_cargo);
		
		JTextField semestre = new JTextField();
		semestre.setColumns(10);
		semestre.setBackground(new Color(0, 128, 192));
		semestre.setBounds(25, 246, 420, 25);
		fondo2.add(semestre);
		
		JTextField num_alu = new JTextField();
		num_alu.setColumns(10);
		num_alu.setBackground(new Color(0, 128, 192));
		num_alu.setBounds(25, 356, 420, 25);
		fondo2.add(num_alu);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Editar = new JButton("Editar");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(342, 514, 89, 23);
		fondo.add(Editar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/editar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel editarAsignatura() {
		anterior = actual;
		actual = "editarAsignatura";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Editar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre de la Asignatura:");
		tag1.setBounds(25, 11, 211, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Créditos:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Turnos:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grupos que llevan esta asignatura:");
		tag7.setBounds(25, 333, 263, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Semestres:\r\n");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombre_asig = new JTextField();
		nombre_asig.setBackground(new Color(0, 128, 192));
		nombre_asig.setBounds(25, 36, 420, 25);
		fondo2.add(nombre_asig);
		nombre_asig.setColumns(10);
		
		JTextField creditos = new JTextField();
		creditos.setColumns(10);
		creditos.setBackground(new Color(0, 128, 192));
		creditos.setBounds(25, 86, 420, 25);
		fondo2.add(creditos);
		
		JTextField turnos = new JTextField();
		turnos.setColumns(10);
		turnos.setBackground(new Color(0, 128, 192));
		turnos.setBounds(25, 140, 420, 25);
		fondo2.add(turnos);
		
		JTextField docente_a_cargo = new JTextField();
		docente_a_cargo.setColumns(10);
		docente_a_cargo.setBackground(new Color(0, 128, 192));
		docente_a_cargo.setBounds(25, 195, 420, 25);
		fondo2.add(docente_a_cargo);
		
		JTextField semestres = new JTextField();
		semestres.setColumns(10);
		semestres.setBackground(new Color(0, 128, 192));
		semestres.setBounds(25, 246, 420, 25);
		fondo2.add(semestres);
		
		JTextField grupos = new JTextField();
		grupos.setColumns(10);
		grupos.setBackground(new Color(0, 128, 192));
		grupos.setBounds(25, 356, 420, 25);
		fondo2.add(grupos);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Editar = new JButton("Editar");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(342, 514, 89, 23);
		fondo.add(Editar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/editar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel editarDocente() {
		anterior = actual;
		actual = "editarDocente";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Docente - Editar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombres:");
		tag1.setBounds(25, 11, 90, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Apellidos:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Fecha de nacimiento:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Correo electronico:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grado de estudios:");
		tag7.setBounds(25, 333, 150, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Teléfono:");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombres = new JTextField();
		nombres.setBackground(new Color(0, 128, 192));
		nombres.setBounds(25, 36, 420, 25);
		fondo2.add(nombres);
		nombres.setColumns(10);
		
		JTextField apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBackground(new Color(0, 128, 192));
		apellidos.setBounds(25, 86, 420, 25);
		fondo2.add(apellidos);
		
		JTextField fechaNacimiento = new JTextField();
		fechaNacimiento.setColumns(10);
		fechaNacimiento.setBackground(new Color(0, 128, 192));
		fechaNacimiento.setBounds(25, 140, 420, 25);
		fondo2.add(fechaNacimiento);
		
		JTextField correo = new JTextField();
		correo.setColumns(10);
		correo.setBackground(new Color(0, 128, 192));
		correo.setBounds(25, 195, 420, 25);
		fondo2.add(correo);
		
		JTextField telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBackground(new Color(0, 128, 192));
		telefono.setBounds(25, 246, 420, 25);
		fondo2.add(telefono);
		
		JTextField grado = new JTextField();
		grado.setColumns(10);
		grado.setBackground(new Color(0, 128, 192));
		grado.setBounds(25, 356, 420, 25);
		fondo2.add(grado);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Editar = new JButton("Editar");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(342, 514, 89, 23);
		fondo.add(Editar);

		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/editar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel editarAlumno() {
		anterior = actual;
		actual = "editarAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Alumno - Editar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombres:");
		tag1.setBounds(25, 11, 90, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Apellidos:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Fecha de nacimiento:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(255, 255, 255));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Correo electronico:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(255, 255, 255));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grado:");
		tag7.setBounds(25, 333, 150, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(255, 255, 255));
		tag7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Teléfono:");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto:");
		tag6.setBounds(25, 277, 90, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JTextField nombres = new JTextField();
		nombres.setBackground(new Color(0, 128, 192));
		nombres.setBounds(25, 36, 420, 25);
		fondo2.add(nombres);
		nombres.setColumns(10);
		
		JTextField apellidos = new JTextField();
		apellidos.setColumns(10);
		apellidos.setBackground(new Color(0, 128, 192));
		apellidos.setBounds(25, 86, 420, 25);
		fondo2.add(apellidos);
		
		JTextField fechaNacimiento = new JTextField();
		fechaNacimiento.setColumns(10);
		fechaNacimiento.setBackground(new Color(0, 128, 192));
		fechaNacimiento.setBounds(25, 140, 420, 25);
		fondo2.add(fechaNacimiento);
		
		JTextField correo = new JTextField();
		correo.setColumns(10);
		correo.setBackground(new Color(0, 128, 192));
		correo.setBounds(25, 195, 420, 25);
		fondo2.add(correo);
		
		JTextField telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBackground(new Color(0, 128, 192));
		telefono.setBounds(25, 246, 420, 25);
		fondo2.add(telefono);
		
		JTextField grado = new JTextField();
		grado.setColumns(10);
		grado.setBackground(new Color(0, 128, 192));
		grado.setBounds(25, 356, 420, 25);
		fondo2.add(grado);
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Ruta = "";
		        JFileChooser jFileChooser = new JFileChooser();
		        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JGP, PNG & GIF", "jpg", "png", "gif");
		        jFileChooser.setFileFilter(filtrado);
		        
		        int respuesta = jFileChooser.showOpenDialog(fondo);
		        
		        if (respuesta == JFileChooser.APPROVE_OPTION) {
		            Ruta = jFileChooser.getSelectedFile().getPath();
		            
		            JLabel lblImagen = new JLabel("");
		            Image mImagen = new ImageIcon(Ruta).getImage();
		            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		            lblImagen.setIcon(mIcono);
		            lblImagen.setBounds(200, 200, 200, 200);
		    		fondo2.add(lblImagen);
		            
		        }
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		JButton Editar = new JButton("Editar");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(342, 514, 89, 23);
		fondo.add(Editar);

		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/editar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel eliminarAlumno() {
		anterior = actual;
		actual = "eliminarAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Alumno - Eliminar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Lista de Alumnos:");
		tag1.setBounds(10, 11, 211, 20);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 460, 364);
		fondo2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre del Alumno", "Apellidos", "Correo", "Eliminar"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(270, 515, 89, 23);
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		fondo.add(Volver);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel eliminarDocente() {
		anterior = actual;
		actual = "eliminarDocente";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Docente - Eliminar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Lista de Docentes:");
		tag1.setBounds(10, 11, 211, 20);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 460, 364);
		fondo2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre del Docente", "Apellidos", "Correo", "Eliminar"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(270, 515, 89, 23);
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		fondo.add(Volver);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel eliminarGrupo() {
		anterior = actual;
		actual = "eliminarGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Eliminar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Lista de Grupos:");
		tag1.setBounds(10, 11, 211, 20);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 460, 364);
		fondo2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre del Grupo", "Carrera", "Semestre", "Eliminar"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(270, 515, 89, 23);
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		fondo.add(Volver);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel eliminarAsignatura() {
		anterior = actual;
		actual = "eliminarAsignatura";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Eliminar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Lista de Asignaturas:");
		tag1.setBounds(10, 11, 211, 20);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(255, 255, 255));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 460, 364);
		fondo2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre de la Asignatura", "Créditos", "Semestres", "Eliminar"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(105);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(105);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(270, 515, 89, 23);
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		fondo.add(Volver);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarAlumno() {
		anterior = actual;
		actual = "consultarAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Mi cuenta - Alumno");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombres del Alumno");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tag2 = new JLabel("Apellidos");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(10, 70, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag3 = new JLabel("Correo electrónico");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBounds(10, 114, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Fecha de nacimiento");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBounds(10, 157, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Teléfono");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBounds(10, 198, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Grado");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBounds(10, 239, 210, 14);
		fondo2.add(tag6);
		
		JTextField datos_nom = new JTextField();
		datos_nom.setEditable(false);
		datos_nom.setBounds(10, 45, 273, 20);
		fondo2.add(datos_nom);
		datos_nom.setColumns(10);
		
		JTextField datos_ape = new JTextField();
		datos_ape.setEditable(false);
		datos_ape.setColumns(10);
		datos_ape.setBounds(10, 90, 273, 20);
		fondo2.add(datos_ape);
		
		JTextField datos_correo = new JTextField();
		datos_correo.setEditable(false);
		datos_correo.setColumns(10);
		datos_correo.setBounds(10, 132, 273, 20);
		fondo2.add(datos_correo);
		
		JTextField datos_fecha = new JTextField();
		datos_fecha.setEditable(false);
		datos_fecha.setColumns(10);
		datos_fecha.setBounds(10, 174, 273, 20);
		fondo2.add(datos_fecha);
		
		JTextField datos_tel = new JTextField();
		datos_tel.setEditable(false);
		datos_tel.setColumns(10);
		datos_tel.setBounds(10, 215, 273, 20);
		fondo2.add(datos_tel);
		
		JTextField datos_grado = new JTextField();
		datos_grado.setEditable(false);
		datos_grado.setColumns(10);
		datos_grado.setBounds(10, 257, 273, 20);
		fondo2.add(datos_grado);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 89, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(300, 80, 160, 160);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 300, 400, 100);
		fondo2.add(imagen2);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarDocente() {
		anterior = actual;
		actual = "consultarDocente";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Mi cuenta - Docente");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombres del Docente");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tag2 = new JLabel("Apellidos");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(10, 70, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag3 = new JLabel("Correo electrónico");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBounds(10, 114, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Fecha de nacimiento");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBounds(10, 157, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Teléfono");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBounds(10, 198, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Grado de estudios:");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBounds(10, 239, 210, 14);
		fondo2.add(tag6);
		
		JTextField datos_nom = new JTextField();
		datos_nom.setEditable(false);
		datos_nom.setBounds(10, 45, 273, 20);
		fondo2.add(datos_nom);
		datos_nom.setColumns(10);
		
		JTextField datos_ape = new JTextField();
		datos_ape.setEditable(false);
		datos_ape.setColumns(10);
		datos_ape.setBounds(10, 90, 273, 20);
		fondo2.add(datos_ape);
		
		JTextField datos_correo = new JTextField();
		datos_correo.setEditable(false);
		datos_correo.setColumns(10);
		datos_correo.setBounds(10, 132, 273, 20);
		fondo2.add(datos_correo);
		
		JTextField datos_fecha = new JTextField();
		datos_fecha.setEditable(false);
		datos_fecha.setColumns(10);
		datos_fecha.setBounds(10, 174, 273, 20);
		fondo2.add(datos_fecha);
		
		JTextField datos_tel = new JTextField();
		datos_tel.setEditable(false);
		datos_tel.setColumns(10);
		datos_tel.setBounds(10, 215, 273, 20);
		fondo2.add(datos_tel);
		
		JTextField datos_grado = new JTextField();
		datos_grado.setEditable(false);
		datos_grado.setColumns(10);
		datos_grado.setBounds(10, 257, 273, 20);
		fondo2.add(datos_grado);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 89, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(300, 80, 160, 160);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 300, 400, 100);
		fondo2.add(imagen2);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarGrupo() {
		anterior = actual;
		actual = "consultarGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Consultar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre del Grupo:");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tag2 = new JLabel("Carrera:");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(10, 70, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag3 = new JLabel("Turno:");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBounds(10, 114, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBounds(10, 157, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Semestre:");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBounds(10, 198, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Numero de alumnos:");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBounds(10, 239, 210, 14);
		fondo2.add(tag6);
		
		JTextField datos_nom = new JTextField();
		datos_nom.setEditable(false);
		datos_nom.setBounds(10, 45, 273, 20);
		fondo2.add(datos_nom);
		datos_nom.setColumns(10);
		
		JTextField datos_carrera = new JTextField();
		datos_carrera.setEditable(false);
		datos_carrera.setColumns(10);
		datos_carrera.setBounds(10, 90, 273, 20);
		fondo2.add(datos_carrera);
		
		JTextField datos_turno = new JTextField();
		datos_turno.setEditable(false);
		datos_turno.setColumns(10);
		datos_turno.setBounds(10, 132, 273, 20);
		fondo2.add(datos_turno);
		
		JTextField datos_docente_a_cargo = new JTextField();
		datos_docente_a_cargo.setEditable(false);
		datos_docente_a_cargo.setColumns(10);
		datos_docente_a_cargo.setBounds(10, 174, 273, 20);
		fondo2.add(datos_docente_a_cargo);
		
		JTextField datos_semestre = new JTextField();
		datos_semestre.setEditable(false);
		datos_semestre.setColumns(10);
		datos_semestre.setBounds(10, 215, 273, 20);
		fondo2.add(datos_semestre);
		
		JTextField datos_num_alumnos = new JTextField();
		datos_num_alumnos.setEditable(false);
		datos_num_alumnos.setColumns(10);
		datos_num_alumnos.setBounds(10, 257, 273, 20);
		fondo2.add(datos_num_alumnos);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 89, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(300, 80, 160, 160);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 300, 400, 100);
		fondo2.add(imagen2);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarAsignatura() {
		anterior = actual;
		actual = "consultarAsignatura";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Consultar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre de la Asignatura:");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tag2 = new JLabel("Créditos:");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(10, 70, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag3 = new JLabel("Turnos:");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBounds(10, 114, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBounds(10, 157, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Semestres:");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBounds(10, 198, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Grupos que llevan esta asignatura:");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBounds(10, 239, 250, 14);
		fondo2.add(tag6);
		
		JTextField datos_nom = new JTextField();
		datos_nom.setEditable(false);
		datos_nom.setBounds(10, 45, 273, 20);
		fondo2.add(datos_nom);
		datos_nom.setColumns(10);
		
		JTextField datos_creditos = new JTextField();
		datos_creditos.setEditable(false);
		datos_creditos.setColumns(10);
		datos_creditos.setBounds(10, 90, 273, 20);
		fondo2.add(datos_creditos);
		
		JTextField datos_turnos = new JTextField();
		datos_turnos.setEditable(false);
		datos_turnos.setColumns(10);
		datos_turnos.setBounds(10, 132, 273, 20);
		fondo2.add(datos_turnos);
		
		JTextField datos_docente_a_cargo = new JTextField();
		datos_docente_a_cargo.setEditable(false);
		datos_docente_a_cargo.setColumns(10);
		datos_docente_a_cargo.setBounds(10, 174, 273, 20);
		fondo2.add(datos_docente_a_cargo);
		
		JTextField datos_semestres = new JTextField();
		datos_semestres.setEditable(false);
		datos_semestres.setColumns(10);
		datos_semestres.setBounds(10, 215, 273, 20);
		fondo2.add(datos_semestres);
		
		JTextField datos_num_grupos = new JTextField();
		datos_num_grupos.setEditable(false);
		datos_num_grupos.setColumns(10);
		datos_num_grupos.setBounds(10, 257, 273, 20);
		fondo2.add(datos_num_grupos);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 89, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(300, 80, 160, 160);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 300, 400, 100);
		fondo2.add(imagen2);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel credencialAlumno() {
		anterior = actual;
		actual = "credencialAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Alumno - Generar Credencial");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 55, 480, 449);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("Descargar");
		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 95, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/credencialF.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(40, 10, 400, 200);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/credencialT.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 230, 400, 200);
		fondo2.add(imagen2);
		
		this.add(fondo);
		return fondo;
	}

	public JPanel credencialDocente() {
		anterior = actual;
		actual = "credencialDocente";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(49, 64, 81));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Docente - Generar Credencial");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 55, 480, 449);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menu";
				add(menu());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("Descargar");
		Descargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 95, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/credencialDF.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(40, 10, 400, 200);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/credencialDT.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 230, 400, 200);
		fondo2.add(imagen2);
		
		this.add(fondo);
		return fondo;
	}
	
	public void limpiarVentana() {
		
		if(panel!= null) {
			this.remove(panel);
		}
		
		if(actual.equals("login")){
			panel = login(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("menu")){
			panel = menu(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("crearAlumno")){
			panel = crearAlumno(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("crearDocente")){
			panel = crearDocente(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("crearGrupo")){
			panel = crearGrupo(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("crearAsignatura")){
			panel = crearAsignatura(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("editarAsignatura")){
			panel = editarAsignatura(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("editarGrupo")){
			panel = editarGrupo(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("editarDocente")){
			panel = editarDocente(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("editarAlumno")){
			panel = editarAlumno(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("eliminarAlumno")){
			panel = eliminarAlumno(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("eliminarDocente")){
			panel = eliminarDocente(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("eliminarGrupo")){
			panel = eliminarGrupo(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("eliminarAsignatura")){
			panel = eliminarAsignatura(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("consultarAlumno")){
			panel = consultarAlumno(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("consultarDocente")){
			panel = consultarDocente(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("consultarGrupo")){
			panel = consultarGrupo(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("consultarAsignatura")){
			panel = consultarAsignatura(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("credencialAlumno")){
			panel = credencialAlumno(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("credencialDocente")){
			panel = credencialDocente(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
	}
}
