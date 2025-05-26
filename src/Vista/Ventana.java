package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.layer.PdfLayer;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.mysql.jdbc.PreparedStatement;
import javax.swing.text.AbstractDocument;
import java.util.regex.Matcher;

import Controlador.ControlVistaBD;
import Modelo.BD;	

public class Ventana extends JFrame{
	private String anterior = "login";
	private String actual = "login";
	private JTextField username;
	private JPasswordField password;
	public JPanel panel = null;
	private JTable table, table2;
	public JTextField txtNombre;
	public JTextField txtApellidoPaterno,txtApellidoMaterno;
	public JTextField txtCorreo;
	public JTextField txtDireccion;
	public JTextField txtTelefono;
	public JTextField txtNombreD,txtApellidoPaternoD,txtApellidoMaternoD,txtCorreoD,txtDireccionD,txtTelefonoD;
	public int grado;
	private JButton btnGuardar;
	private ControlVistaBD cvbd;
	private int idConsultar;
	private int cambio=0;
	public LocalDate fecha;
	public byte[] imagenBytes,imagenBytesD;
	public int numeroTelefono;
	public JComboBox dia_nacimiento;
	public JComboBox mes_nacimiento;
	public JComboBox ano_nacimiento;
	public int ano,mes,dia;
	public JLabel imagen;
	public JButton button, button2;
	public JComboBox comboBox;
	public JButton btnGuardarDocente;
	public JComboBox comboBoxD;
	public JComboBox ano_nacimientoD,mes_nacimientoD,dia_nacimientoD;
	public JTextField nombre_asig;
	public JTextField creditos;
	public JComboBox docente_a_cargo;
	public JComboBox semestres;
	public JButton btnGuardarAsignatura,btnGuardarGrupo;
	public JComboBox asignaturaG;
	public JComboBox docente_a_cargoG;
	public JComboBox semestreG;
	public JTextField num_alu;
	public JTextField carreraG;
	private JTable table3;
	private JButton button3;
	private JTable table4;
	private JButton button4;

	public Ventana() {
		cvbd = new ControlVistaBD(this);
		this.setTitle("Sistema Escolar");
		this.setSize(800,800);
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
		fondo.setLayout(null);
		fondo.setBackground(Color.WHITE);
		fondo.setBounds(0, 0, 800, 800);
		getContentPane().add(fondo);

		// Panel lateral decorativo
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 200, 800);
		panel_1.setLayout(null);
		fondo.add(panel_1);

		// Imagen decorativa lateral
		JLabel lblNewLabel = new JLabel();
		ImageIcon icono4 = new ImageIcon("img/paneldiseño.png");
		Image imagen4 = icono4.getImage().getScaledInstance(200, 800, Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(imagen4));
		lblNewLabel.setBounds(0, 0, 200, 800);
		panel_1.add(lblNewLabel);

		// Logo centrado superior
		JLabel lblNewLabel2 = new JLabel();
		ImageIcon icono5 = new ImageIcon("img/logo.png");
		Image imagen5 = icono5.getImage().getScaledInstance(400, 120, Image.SCALE_SMOOTH);
		lblNewLabel2.setIcon(new ImageIcon(imagen5));
		lblNewLabel2.setBounds(300, 30, 400, 120);
		fondo.add(lblNewLabel2);

		// Títulos
		JLabel Titulo2 = new JLabel("Accede a tu cuenta");
		Titulo2.setForeground(Color.BLACK);
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("SansSerif", Font.BOLD, 24));
		Titulo2.setBounds(350, 170, 300, 30);
		fondo.add(Titulo2);

		// Imagen de perfil
		JLabel imagen = new JLabel();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 220, 100, 100);
		fondo.add(imagen);

		// Campo Usuario
		JLabel tag1 = new JLabel("Usuario:");
		tag1.setFont(new Font("SansSerif", Font.BOLD, 16));
		tag1.setBounds(370, 340, 100, 25);
		fondo.add(tag1);

		JTextField username = new JTextField();
		username.setFont(new Font("SansSerif", Font.PLAIN, 16));
		username.setForeground(Color.BLACK);
		username.setBackground(new Color(198, 209, 218));
		username.setBounds(370, 370, 260, 35);
		fondo.add(username);

		// Campo Contraseña
		JLabel tag2 = new JLabel("Contraseña:");
		tag2.setFont(new Font("SansSerif", Font.BOLD, 16));
		tag2.setBounds(370, 420, 100, 25);
		fondo.add(tag2);

		JPasswordField password = new JPasswordField();
		password.setFont(new Font("SansSerif", Font.PLAIN, 16));
		password.setForeground(Color.BLACK);
		password.setBackground(new Color(198, 209, 218));
		password.setBounds(370, 450, 260, 35);
		fondo.add(password);

		// Botones
		RoundButtonRojo Cancelar = new RoundButtonRojo("Cancelar");
		Cancelar.setFont(new Font("SansSerif", Font.BOLD, 16));
		Cancelar.setBackground(new Color(255, 0, 0));
		Cancelar.setForeground(Color.WHITE);
		Cancelar.setBounds(370, 510, 120, 35);
		Cancelar.addActionListener(e -> {
			username.setText("");
			password.setText("");
		});
		fondo.add(Cancelar);

		RoundButtonVerde btnAccess = new RoundButtonVerde("Ingresar");
		btnAccess.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAccess.setBackground(new Color(0, 153, 51));
		btnAccess.setForeground(Color.WHITE);
		btnAccess.setBounds(510, 510, 120, 35);
		btnAccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = username.getText();
				char[] passwordChars = password.getPassword();
				String password = new String(passwordChars);
				Arrays.fill(passwordChars, ' ');

				BD bd = new BD();
				try {
					Connection cn = bd.Conectar();
					Statement stm = cn.createStatement();
					ResultSet rs = stm.executeQuery("SELECT * FROM admin");

					while (rs.next()) {
						String nombre = rs.getString("Nombre");
						String pass = rs.getString("Contrasena");

						if (usuario.equals(nombre) && password.equals(pass)) {
							JOptionPane.showMessageDialog(null, "¡Datos correctos. Bienvenido " + nombre + "!");
							remove(fondo);
							anterior = actual;
							actual = "menuPrincipal";
							add(menuPrincipal());
							repaint();
							return;
						}
					}

					JOptionPane.showMessageDialog(null, "Datos incorrectos. Intente de nuevo.");
					rs.close();
					stm.close();
					cn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		fondo.add(btnAccess);

		// Imagen de fondo decorativa (opcional si no interfiere)
		JLabel imagenfondo = new JLabel();
		ImageIcon fondoIcon = new ImageIcon(new ImageIcon("img/fondo.png").getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH));
		imagenfondo.setIcon(fondoIcon);
		imagenfondo.setBounds(0, 0, 800, 800);
		fondo.add(imagenfondo);

		this.add(fondo);
		return fondo;
	}

	
	public JPanel menuPrincipal() {
		anterior = actual;
		actual = "menuPrincipal";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Bienvenido Admin");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		Titulo.setBounds(79, 30, 421, 40);
		fondo.add(Titulo);
		
		RoundButton botonAlumnos = new RoundButton("Alumnos");
		botonAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuAlumnos";
				add(menuAlumnos());
				repaint();
				revalidate();
			}
		});
		botonAlumnos.setBounds(132, 116, 421, 78);
		fondo.add(botonAlumnos);
		
		RoundButton botonDocentes = new RoundButton("Docentes");
		botonDocentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuDocentes";
				add(menuDocentes());
				repaint();
				revalidate();
			}
		});
		botonDocentes.setBounds(132, 222, 421, 78);
		fondo.add(botonDocentes);
		
		RoundButton botonGrupos = new RoundButton("Grupos");
		botonGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuGrupos";
				add(menuGrupos());
				repaint();
				revalidate();
			}
		});
		botonGrupos.setBounds(132, 326, 421, 78);
		fondo.add(botonGrupos);
		
		RoundButton botonAsignaturas = new RoundButton("Asignaturas");
		botonAsignaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuAsignaturas";
				add(menuAsignaturas());
				repaint();
				revalidate();
			}
		});
		botonAsignaturas.setBounds(132, 429, 421, 78);
		fondo.add(botonAsignaturas);
		
		JLabel tag1 = new JLabel("");
		ImageIcon imageFondo2 = new ImageIcon(new ImageIcon("img/alumnos.png").getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		tag1.setIcon(imageFondo2);
		tag1.setBounds(35, 116, 107, 78);
		fondo.add(tag1);
		
		JLabel tag2 = new JLabel("");
		ImageIcon imageFondo3 = new ImageIcon(new ImageIcon("img/docentes.png").getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		tag2.setIcon(imageFondo3);
		tag2.setBounds(35, 222, 107, 78);
		fondo.add(tag2);
		
		JLabel tag3 = new JLabel("");
		ImageIcon imageFondo4 = new ImageIcon(new ImageIcon("img/grupo.png").getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		tag3.setIcon(imageFondo4);
		tag3.setBounds(35, 326, 107, 78);
		fondo.add(tag3);
		
		JLabel tag4 = new JLabel("");
		ImageIcon imageFondo5 = new ImageIcon(new ImageIcon("img/asignatura.png").getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		tag4.setIcon(imageFondo5);
		tag4.setBounds(35, 429, 107, 78);
		fondo.add(tag4);
		
		RoundButtonRojo btnCerrarSesion = new RoundButtonRojo("Cerrar Sesión");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("SansSerif", Font.BOLD, 11));
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
		btnCerrarSesion.setBounds(410, 515, 125, 30);
		fondo.add(btnCerrarSesion);
		
		JLabel fondomenuPrincipal = new JLabel("");
		ImageIcon imageFondo1 = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		fondomenuPrincipal.setIcon(imageFondo1);
		fondomenuPrincipal.setBounds(0, 0, 584, 561);
		fondo.add(fondomenuPrincipal);
		this.add(fondo);
		return fondo;
	}

	public JPanel menuGrupos() {
		anterior = actual;
		actual = "menuGrupos";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("GRUPOS");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 30, 421, 40);
		fondo.add(Titulo);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblConsultar.setBounds(237, 86, 112, 25);
		fondo.add(lblConsultar);
		
		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblCrear.setBounds(142, 281, 71, 25);
		fondo.add(lblCrear);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblEliminar.setBounds(365, 281, 89, 25);
		fondo.add(lblEliminar);
		
		RoundButton btnConsultarGrupo = new RoundButton("");
		ImageIcon icono = new ImageIcon("img/consulta.png");
		Image imagen = icono.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnConsultarGrupo.setIcon(new ImageIcon(imagenRedimensionada));
		btnConsultarGrupo.setBackground(new Color(121, 255, 145));
		btnConsultarGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "consultarGrupo";
				add(consultarGrupo());
				repaint();
				revalidate();
			}
		});
		btnConsultarGrupo.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnConsultarGrupo.setBounds(212, 115, 150, 150);
		fondo.add(btnConsultarGrupo);
		
		RoundButton btnCrearGrupo = new RoundButton("");
		ImageIcon icono2 = new ImageIcon("img\\crearicono.png");
		Image imagen2 = icono2.getImage();
		Image imagenRedimensionada2 = imagen2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnCrearGrupo.setIcon(new ImageIcon(imagenRedimensionada2));
		btnCrearGrupo.setBackground(new Color(121, 255, 145));
		btnCrearGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "crearGrupo";
				add(crearGrupo());
				repaint();
				revalidate();
			}
		});
		btnCrearGrupo.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnCrearGrupo.setBounds(100, 310, 150, 150);
		fondo.add(btnCrearGrupo);
		
		RoundButton  btnEliminarGrupo = new RoundButton ("");
		ImageIcon icono3 = new ImageIcon("img\\eliminaricono.png");
		Image imagen3 = icono3.getImage();
		Image imagenRedimensionada3 = imagen3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnEliminarGrupo.setIcon(new ImageIcon(imagenRedimensionada3));
		btnEliminarGrupo.setBackground(new Color(121, 255, 145));
		btnEliminarGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "eliminarGrupo";
				add(eliminarGrupo());
				repaint();
				revalidate();
			}
		});
		btnEliminarGrupo.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnEliminarGrupo.setBounds(330, 310, 150, 150);
		fondo.add(btnEliminarGrupo);
		
		RoundButtonRojoBorde Volver = new RoundButtonRojoBorde("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuPrincipal";
				add(menuPrincipal());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(450, 514, 89, 23);
		fondo.add(Volver);
		
		
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(0, 0, 584, 561);
		fondo.add(fondoMenu);
		this.add(fondo);
		return fondo;
	}
	
	public JPanel menuAlumnos() {
		anterior = actual;
		actual = "menuAlumnos";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("ALUMNOS");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 30, 421, 40);
		fondo.add(Titulo);
		
		JLabel lblCredencial = new JLabel("Credencial");
		lblCredencial.setForeground(new Color(121, 255, 145));
		lblCredencial.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCredencial.setBounds(120, 86, 112, 25);
		fondo.add(lblCredencial);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblConsultar.setBounds(353, 86, 105, 25);
		fondo.add(lblConsultar);
		
		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblCrear.setBounds(142, 281, 71, 25);
		fondo.add(lblCrear);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblEliminar.setBounds(365, 281, 89, 25);
		fondo.add(lblEliminar);

		RoundButton btnCredAlu = new RoundButton("");
		ImageIcon icono = new ImageIcon("img/credencial.png");
		Image imagen = icono.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnCredAlu.setIcon(new ImageIcon(imagenRedimensionada));
		btnCredAlu.setBackground(new Color(121, 255, 145));
		btnCredAlu.setFont(new Font("SansSerif", Font.BOLD, 11));
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
		btnCredAlu.setBounds(100, 115, 150, 150);
		fondo.add(btnCredAlu);
		
		RoundButton btnConsultarAlu = new RoundButton("");
		ImageIcon icono2 = new ImageIcon("img/consulta.png");
		Image imagen2 = icono2.getImage();
		Image imagenRedimensionada2 = imagen2.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnConsultarAlu.setIcon(new ImageIcon(imagenRedimensionada2));
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
		btnConsultarAlu.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnConsultarAlu.setBounds(330, 115, 150, 150);
		fondo.add(btnConsultarAlu);
		
		RoundButton btnCrearAlu = new RoundButton("");
		ImageIcon icono3 = new ImageIcon("img/crearicono.png");
		Image imagen3 = icono3.getImage();
		Image imagenRedimensionada3 = imagen3.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnCrearAlu.setIcon(new ImageIcon(imagenRedimensionada3));
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
		btnCrearAlu.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnCrearAlu.setBounds(100, 310, 150, 150);
		fondo.add(btnCrearAlu);
		
		RoundButton btnEliminarAlu = new RoundButton("");
		ImageIcon icono4 = new ImageIcon("img/eliminaricono.png");
		Image imagen4 = icono4.getImage();
		Image imagenRedimensionada4 = imagen4.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnEliminarAlu.setIcon(new ImageIcon(imagenRedimensionada4));
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
		btnEliminarAlu.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnEliminarAlu.setBounds(330, 310, 150, 150);
		fondo.add(btnEliminarAlu);
		
		RoundButtonRojoBorde Volver = new RoundButtonRojoBorde("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuPrincipal";
				add(menuPrincipal());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(450, 514, 89, 23);
		fondo.add(Volver);
		
		
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(0, 0, 584, 561);
		fondo.add(fondoMenu);
		this.add(fondo);
		return fondo;
	}

	public JPanel menuDocentes() {
		anterior = actual;
		actual = "menuDocentes";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("DOCENTES");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 30, 421, 40);
		fondo.add(Titulo);
		
		JLabel lblCredencial = new JLabel("Credencial");
		lblCredencial.setForeground(new Color(121, 255, 145));
		lblCredencial.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblCredencial.setBounds(120, 86, 112, 25);
		fondo.add(lblCredencial);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblConsultar.setBounds(353, 86, 105, 25);
		fondo.add(lblConsultar);
		
		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblCrear.setBounds(142, 281, 71, 25);
		fondo.add(lblCrear);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblEliminar.setBounds(365, 281, 89, 25);
		fondo.add(lblEliminar);

		RoundButton btnCredDoce = new RoundButton("");
		ImageIcon icono = new ImageIcon("img/credencial.png");
		Image imagen = icono.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnCredDoce.setIcon(new ImageIcon(imagenRedimensionada));
		btnCredDoce.setBackground(new Color(121, 255, 145));
		btnCredDoce.setFont(new Font("SansSerif", Font.BOLD, 11));
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
		btnCredDoce.setBounds(100, 115, 150, 150);
		fondo.add(btnCredDoce);
		
		RoundButton btnConsultarDoce = new RoundButton("");
		ImageIcon icono2 = new ImageIcon("img/consulta.png");
		Image imagen2 = icono2.getImage();
		Image imagenRedimensionada2 = imagen2.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnConsultarDoce.setIcon(new ImageIcon(imagenRedimensionada2));
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
		btnConsultarDoce.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnConsultarDoce.setBounds(330, 115, 150, 150);
		fondo.add(btnConsultarDoce);
		
		RoundButton btnCrearDoce = new RoundButton("");
		ImageIcon icono3 = new ImageIcon("img/crearicono.png");
		Image imagen3 = icono3.getImage();
		Image imagenRedimensionada3 = imagen3.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnCrearDoce.setIcon(new ImageIcon(imagenRedimensionada3));
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
		btnCrearDoce.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnCrearDoce.setBounds(100, 310, 150, 150);
		fondo.add(btnCrearDoce);
		
		RoundButton btnEliminarDoce = new RoundButton("");
		ImageIcon icono4 = new ImageIcon("img/eliminaricono.png");
		Image imagen4 = icono4.getImage();
		Image imagenRedimensionada4 = imagen4.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
		btnEliminarDoce.setIcon(new ImageIcon(imagenRedimensionada4));
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
		btnEliminarDoce.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnEliminarDoce.setBounds(330, 310, 150, 150);
		fondo.add(btnEliminarDoce);
		
		RoundButtonRojoBorde Volver = new RoundButtonRojoBorde("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuPrincipal";
				add(menuPrincipal());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(450, 514, 89, 23);
		fondo.add(Volver);
		
		
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(0, 0, 584, 561);
		fondo.add(fondoMenu);
		this.add(fondo);
		return fondo;
	}
	
	public JPanel menuAsignaturas() {
		anterior = actual;
		actual = "menuAsignaturas";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("ASIGNATURAS");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 30, 421, 40);
		fondo.add(Titulo);
		
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblConsultar.setBounds(237, 86, 112, 25);
		fondo.add(lblConsultar);
		
		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblCrear.setBounds(142, 281, 71, 25);
		fondo.add(lblCrear);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblEliminar.setBounds(365, 281, 89, 25);
		fondo.add(lblEliminar);
		
		
		RoundButton btnConsultarAsi = new RoundButton("");
		ImageIcon icono = new ImageIcon("img/consulta.png");
		Image imagen = icono.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnConsultarAsi.setIcon(new ImageIcon(imagenRedimensionada));
		btnConsultarAsi.setBackground(new Color(121, 255, 145));
		btnConsultarAsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "consultarAsignatura";
				add(consultarAsignatura());
				repaint();
				revalidate();
			}
		});
		btnConsultarAsi.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnConsultarAsi.setBounds(212, 115, 150, 150);
		fondo.add(btnConsultarAsi);
		
		RoundButton btnCrearAsi = new RoundButton("");
		ImageIcon icono2 = new ImageIcon("img\\crearicono.png");
		Image imagen2 = icono2.getImage();
		Image imagenRedimensionada2 = imagen2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnCrearAsi.setIcon(new ImageIcon(imagenRedimensionada2));
		btnCrearAsi.setBackground(new Color(121, 255, 145));
		btnCrearAsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "crearAsignatura";
				add(crearAsignatura());
				repaint();
				revalidate();
			}
		});
		btnCrearAsi.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnCrearAsi.setBounds(100, 310, 150, 150);
		fondo.add(btnCrearAsi);
		
		RoundButton  btnEliminarAsi = new RoundButton ("");
		ImageIcon icono3 = new ImageIcon("img\\eliminaricono.png");
		Image imagen3 = icono3.getImage();
		Image imagenRedimensionada3 = imagen3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnEliminarAsi.setIcon(new ImageIcon(imagenRedimensionada3));
		btnEliminarAsi.setBackground(new Color(121, 255, 145));
		btnEliminarAsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "eliminarAsignatura";
				add(eliminarAsignatura());
				repaint();
				revalidate();
			}
		});
		btnEliminarAsi.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnEliminarAsi.setBounds(330, 310, 150, 150);
		fondo.add(btnEliminarAsi);
		
		RoundButtonRojoBorde Volver = new RoundButtonRojoBorde("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuPrincipal";
				add(menuPrincipal());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(450, 514, 89, 23);
		fondo.add(Volver);
		
		
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(0, 0, 584, 561);
		fondo.add(fondoMenu);
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearAlumno() {
		cvbd = new ControlVistaBD(this);
		anterior = actual;
		actual = "crearAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Alumno - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("SansSerif", Font.PLAIN, 18));
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
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Apellido Paterno:");
		tag2.setBounds(25, 62, 150, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tagam = new JLabel("Apellido Materno:");
		tagam.setBounds(250, 62, 150, 25);
		fondo2.add(tagam);
		tagam.setHorizontalAlignment(SwingConstants.LEFT);
		tagam.setForeground(new Color(0, 0, 0));
		tagam.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tagam.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Fecha de nacimiento:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Correo electronico:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grado:");
		tag7.setBounds(25, 333, 90, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(0, 0, 0));
		tag7.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Teléfono:");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto (Opcional):");
		tag6.setBounds(25, 277, 130, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JLabel direccion = new JLabel("Direccion (Opcional):");
		direccion.setBounds(250, 277, 160, 25);
		fondo2.add(direccion);
		direccion.setHorizontalAlignment(SwingConstants.LEFT);
		direccion.setForeground(new Color(0, 0, 0));
		direccion.setFont(new Font("SansSerif", Font.PLAIN, 16));
		direccion.setBackground(Color.WHITE);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(225,225,225));
		txtNombre.setBounds(25, 36, 420, 25);
		fondo2.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setColumns(10);
		txtApellidoPaterno.setBackground(new Color(225,225,225));
		txtApellidoPaterno.setBounds(25, 86, 150, 25);
		fondo2.add(txtApellidoPaterno);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBackground(new Color(225,225,225));
		txtApellidoMaterno.setBounds(250, 86, 150, 25);
		fondo2.add(txtApellidoMaterno);
		
		
		dia_nacimiento =new JComboBox<String>();
		dia_nacimiento.setBounds(25,140,80,20);
        fondo2.add(dia_nacimiento);
        for(int i=1;i<32;i++) {
        	dia_nacimiento.addItem(i);
        	dia_nacimiento.addItemListener(null);
        }
        
        mes_nacimiento =new JComboBox<String>();
        mes_nacimiento.setBounds(125,140,80,20);
        fondo2.add(mes_nacimiento);
        for(int i=1;i<13;i++) {
        	mes_nacimiento.addItem(i);
        	mes_nacimiento.addItemListener(null);
        }
        
        ano_nacimiento =new JComboBox<String>();
        ano_nacimiento.setBounds(225,140,80,20);
        fondo2.add(ano_nacimiento);
        for(int i=2005;i>1899;i--) {
        	ano_nacimiento.addItem(i);
        	ano_nacimiento.addItemListener(null);
        }
        
        dia = (int) dia_nacimiento.getSelectedItem();
        mes = (int) mes_nacimiento.getSelectedItem();
        ano = (int) ano_nacimiento.getSelectedItem();
        
      
        fecha = LocalDate.of(ano, mes, dia);
	
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBackground(new Color(225,225,225));
		txtCorreo.setBounds(25, 195, 420, 25);
		fondo2.add(txtCorreo);
		
		txtTelefono = new JTextField(10);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(new Color(225,225,225));
		txtTelefono.setBounds(25, 246, 420, 25);
		
		
		AbstractDocument doc = (AbstractDocument) txtTelefono.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    private final Pattern pattern = Pattern.compile("\\d{0,10}");

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        Matcher matcher = pattern.matcher(newText);
		        if (matcher.matches()) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		fondo2.add(txtTelefono);
   
		
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBackground(new Color(225,225,225));
		txtDireccion.setBounds(250, 303, 160, 23);
		fondo2.add(txtDireccion);
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(85, 450, 90, 25);
		fondo2.getRootPane().add(comboBox);
		add(comboBox);
		
		
		for(int i=1;i<14;i++) {
        	comboBox.addItem(i);
        	comboBox.addItemListener(null);
        }
		
		
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png");
			        fileChooser.setFileFilter(filter);

			        int resultado = fileChooser.showOpenDialog(null);
			        if (resultado == JFileChooser.APPROVE_OPTION) {
			            File archivoImagen = fileChooser.getSelectedFile();
			            try {
			               imagenBytes = Files.readAllBytes(archivoImagen.toPath());
			                
			                System.out.println("La imagen se ha guardado en MySQL correctamente.");
			            } catch (IOException e1) {
			                e1.printStackTrace();
			            }
			        }
			    
		            
		        
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				remove(comboBox);
				anterior = actual;
				actual = "menuAlumnos";
				add(menuAlumnos());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(255, 255, 255));
        btnGuardar.setBackground(new Color(0, 128, 255));
        btnGuardar.setBounds(342, 514, 89, 23);
		btnGuardar.addActionListener(cvbd);
		fondo.getRootPane().add(btnGuardar);
		fondo.add(btnGuardar);

		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearDocente() {
		cvbd = new ControlVistaBD(this);
		anterior = actual;
		actual = "crearDocente";
		
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Docente - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("SansSerif", Font.PLAIN, 18));
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
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Apellido Paterno:");
		tag2.setBounds(25, 62, 150, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tagam = new JLabel("Apellido Materno:");
		tagam.setBounds(250, 62, 150, 25);
		fondo2.add(tagam);
		tagam.setHorizontalAlignment(SwingConstants.LEFT);
		tagam.setForeground(new Color(0, 0, 0));
		tagam.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tagam.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Fecha de nacimiento:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Correo electronico:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Grado Academico:");
		tag7.setBounds(25, 333, 90, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(0, 0, 0));
		tag7.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Teléfono:");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		JLabel tag6 = new JLabel("Foto (Opcional):");
		tag6.setBounds(25, 277, 130, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JLabel direccion = new JLabel("Direccion (Opcional):");
		direccion.setBounds(250, 277, 160, 25);
		fondo2.add(direccion);
		direccion.setHorizontalAlignment(SwingConstants.LEFT);
		direccion.setForeground(new Color(0, 0, 0));
		direccion.setFont(new Font("SansSerif", Font.PLAIN, 16));
		direccion.setBackground(Color.WHITE);
		
		txtNombreD = new JTextField();
		txtNombreD.setBackground(new Color(225,225,225));
		txtNombreD.setBounds(25, 36, 420, 25);
		fondo2.add(txtNombreD);
		txtNombreD.setColumns(10);
		
		txtApellidoPaternoD = new JTextField();
		txtApellidoPaternoD.setColumns(10);
		txtApellidoPaternoD.setBackground(new Color(225,225,225));
		txtApellidoPaternoD.setBounds(25, 86, 150, 25);
		fondo2.add(txtApellidoPaternoD);
		
		txtApellidoMaternoD = new JTextField();
		txtApellidoMaternoD.setColumns(10);
		txtApellidoMaternoD.setBackground(new Color(225,225,225));
		txtApellidoMaternoD.setBounds(250, 86, 150, 25);
		fondo2.add(txtApellidoMaternoD);
		
		
		dia_nacimientoD =new JComboBox<String>();
		dia_nacimientoD.setBounds(25,140,80,20);
        fondo2.add(dia_nacimientoD);
        for(int i=1;i<32;i++) {
        	dia_nacimientoD.addItem(i);
        	dia_nacimientoD.addItemListener(null);
        }
        
        mes_nacimientoD =new JComboBox<String>();
        mes_nacimientoD.setBounds(125,140,80,20);
        fondo2.add(mes_nacimientoD);
        for(int i=1;i<13;i++) {
        	mes_nacimientoD.addItem(i);
        	mes_nacimientoD.addItemListener(null);
        }
        
        ano_nacimientoD =new JComboBox<String>();
        ano_nacimientoD.setBounds(225,140,80,20);
        fondo2.add(ano_nacimientoD);
        for(int i=2005;i>1899;i--) {
        	ano_nacimientoD.addItem(i);
        	ano_nacimientoD.addItemListener(null);
        }
        
   
          
	
		txtCorreoD = new JTextField();
		txtCorreoD.setColumns(10);
		txtCorreoD.setBackground(new Color(225,225,225));
		txtCorreoD.setBounds(25, 195, 420, 25);
		fondo2.add(txtCorreoD);
		
		txtTelefonoD = new JTextField(10);
		txtTelefonoD.setColumns(10);
		txtTelefonoD.setBackground(new Color(225,225,225));
		txtTelefonoD.setBounds(25, 246, 420, 25);
		
		
		AbstractDocument doc = (AbstractDocument) txtTelefonoD.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    private final Pattern pattern = Pattern.compile("\\d{0,10}");

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        Matcher matcher = pattern.matcher(newText);
		        if (matcher.matches()) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		fondo2.add(txtTelefonoD);
   
		
		
		txtDireccionD = new JTextField();
		txtDireccionD.setColumns(10);
		txtDireccionD.setBackground(new Color(225,225,225));
		txtDireccionD.setBounds(250, 303, 160, 23);
		fondo2.add(txtDireccionD);
		
		
		comboBoxD = new JComboBox();
		comboBoxD.setBounds(85, 450, 90, 25);
		fondo2.getRootPane().add(comboBoxD);
		add(comboBoxD);

        	comboBoxD.addItem("Bachiller");
        	comboBoxD.addItem("Licenciado");
        	comboBoxD.addItem("Magíster ");
        	comboBoxD.addItem("Doctorado ");
        	
        	comboBoxD.addItemListener(null);
	
		JButton archivo = new JButton("Subir archivo");
		archivo.setBackground(new Color(192, 192, 192));
		archivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png");
			        fileChooser.setFileFilter(filter);

			        int resultado = fileChooser.showOpenDialog(null);
			        if (resultado == JFileChooser.APPROVE_OPTION) {
			            File archivoImagen = fileChooser.getSelectedFile();
			            try {
			               imagenBytesD = Files.readAllBytes(archivoImagen.toPath());
			                
			                System.out.println("La imagen se ha guardado en MySQL correctamente.");
			            } catch (IOException e1) {
			                e1.printStackTrace();
			            }
			        }
			    
		            
		        
			}
		});
		archivo.setBounds(26, 303, 116, 23);
		fondo2.add(archivo);
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				remove(comboBoxD);
				anterior = actual;
				actual = "menuDocentes";
				add(menuDocentes());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		btnGuardarDocente = new JButton("Guardar");
		btnGuardarDocente.setForeground(new Color(255, 255, 255));
		btnGuardarDocente.setBackground(new Color(0, 128, 255));
		btnGuardarDocente.setBounds(342, 514, 89, 23);
		btnGuardarDocente.addActionListener(cvbd);
		fondo.getRootPane().add(btnGuardarDocente);
		fondo.add(btnGuardarDocente);

		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}

	public JPanel crearGrupo() {
		cvbd = new ControlVistaBD(this);
		anterior = actual;
		actual = "crearGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag2 = new JLabel("Carrera:");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag3 = new JLabel("Asignatura:");
		tag3.setBounds(25, 112, 169, 25);
		fondo2.add(tag3);
		tag3.setHorizontalAlignment(SwingConstants.LEFT);
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		JLabel tag7 = new JLabel("Numero de alumnos (maximo 40):");
		tag7.setBounds(25, 333, 270, 25);
		fondo2.add(tag7);
		tag7.setHorizontalAlignment(SwingConstants.LEFT);
		tag7.setForeground(new Color(0, 0, 0));
		tag7.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag7.setBackground(Color.WHITE);
		
		JLabel tag5 = new JLabel("Semestre:\r\n");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(255, 255, 255));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		carreraG = new JTextField();
		carreraG.setColumns(10);
		carreraG.setBackground(new Color(225,225,225));
		carreraG.setBounds(25, 86, 420, 25);
		fondo2.add(carreraG);
		
		asignaturaG = new JComboBox();
		asignaturaG.setBackground(new Color(225,225,225));
		asignaturaG.setBounds(25, 140, 420, 25);
		fondo2.add(asignaturaG);
	
		 BD bd = new BD();
	        try {
	            Connection cn = bd.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idAsignatura");
	                String nombre = rs.getString("Nombre");
	                asignaturaG.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		docente_a_cargoG = new JComboBox();	
		docente_a_cargoG.setBackground(new Color(225,225,225));
		docente_a_cargoG.setBounds(25, 195, 420, 25);
		fondo2.add(docente_a_cargoG);
		
		 BD bd1 = new BD();
	        try {
	            Connection cn = bd1.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idDocente");
	                String nombre = rs.getString("Nombre");
	                docente_a_cargoG.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		semestreG = new JComboBox();
		semestreG.setBackground(new Color(225,225,225));
		semestreG.setBounds(25, 246, 420, 25);
		fondo2.add(semestreG);
		
		for(int i=1;i<10;i++) {
			semestreG.addItem(i);
		}
		
		//Cantidad maxima 50
		num_alu = new JTextField();
		num_alu.setColumns(10);
		num_alu.setBackground(new Color(225,225,225));
		num_alu.setBounds(25, 356, 420, 25);
		
		AbstractDocument doc = (AbstractDocument) num_alu.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    private final Pattern pattern = Pattern.compile("\\d{0,10}");

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        Matcher matcher = pattern.matcher(newText);
		        if (matcher.matches()) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		fondo2.add(num_alu);
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuGrupos";
				add(menuGrupos());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		btnGuardarGrupo = new JButton("Guardar");
		btnGuardarGrupo.setForeground(new Color(255, 255, 255));
		btnGuardarGrupo.setBackground(new Color(0, 128, 255));
		btnGuardarGrupo.setBounds(342, 514, 89, 23);
		btnGuardarGrupo.addActionListener(cvbd);
		fondo.getRootPane().add(btnGuardarGrupo);
		fondo.add(btnGuardarGrupo);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel crearAsignatura() {
		cvbd = new ControlVistaBD(this);
		anterior = actual;
		actual = "crearAsignatura";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Crear");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JLabel Titulo2 = new JLabel("Obligatorio: Llene todos los campos");
		Titulo2.setForeground(new Color(255, 0, 0));
		Titulo2.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		Titulo2.setBounds(79, 50, 421, 25);
		fondo.add(Titulo2);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 86, 480, 405);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Nombre de la Asignatura (al menos 2 caracteres):");
		tag1.setBounds(25, 11, 211, 25);
		fondo2.add(tag1);
		tag1.setBackground(new Color(255, 255, 255));
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setHorizontalAlignment(SwingConstants.LEFT);
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel tag2 = new JLabel("Créditos (al menos un credito y maximo 20):");
		tag2.setBounds(25, 62, 90, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setBounds(25, 170, 169, 25);
		fondo2.add(tag4);
		tag4.setHorizontalAlignment(SwingConstants.LEFT);
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBackground(Color.WHITE);
		
		
		JLabel tag5 = new JLabel("Semestres:\r\n");
		tag5.setBounds(25, 221, 90, 25);
		fondo2.add(tag5);
		tag5.setHorizontalAlignment(SwingConstants.LEFT);
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBackground(Color.WHITE);
		
		nombre_asig = new JTextField();
		nombre_asig.setBackground(new Color(225,225,225));
		nombre_asig.setBounds(25, 36, 420, 25);
		fondo2.add(nombre_asig);
		nombre_asig.setColumns(10);
		
		creditos = new JTextField();
		creditos.setColumns(10);
		creditos.setBackground(new Color(225,225,225));
		creditos.setBounds(25, 86, 420, 25);
		
		AbstractDocument doc = (AbstractDocument) creditos.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
		    private final Pattern pattern = Pattern.compile("\\d{0,10}");

		    @Override
		    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		        String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
		        Matcher matcher = pattern.matcher(newText);
		        if (matcher.matches()) {
		            super.replace(fb, offset, length, text, attrs);
		        }
		    }
		});
		fondo2.add(creditos);
		
		docente_a_cargo = new JComboBox();
		docente_a_cargo.setBackground(new Color(225,225,225));
		docente_a_cargo.setBounds(25, 195, 420, 25);
		fondo2.add(docente_a_cargo);
		
		 BD bd = new BD();
	        try {
	            Connection cn = bd.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idDocente");
	                String nombre = rs.getString("Nombre");
	                docente_a_cargo.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
		semestres = new JComboBox();
		semestres.setBackground(new Color(225,225,225));
		semestres.setBounds(25, 246, 420, 25);
		fondo2.add(semestres);
		for(int i=1;i<10;i++) {
			semestres.addItem(i);
		}
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
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
				actual = "menuAsignaturas";
				add(menuAsignaturas());
				repaint();
				revalidate();
			}
		});
		Volver.setBounds(173, 514, 89, 23);
		fondo.add(Volver);
		
		btnGuardarAsignatura = new JButton("Guardar");
		btnGuardarAsignatura.setForeground(new Color(255, 255, 255));
		btnGuardarAsignatura.setBackground(new Color(0, 128, 255));
		btnGuardarAsignatura.setBounds(342, 514, 89, 23);
		btnGuardarAsignatura.addActionListener(cvbd);
		fondo.getRootPane().add(btnGuardarAsignatura);
		fondo.add(btnGuardarAsignatura);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(450, 5, 80, 80);
		fondo.add(imagen);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
				

	public JPanel eliminarAlumno() {
        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(225,225,225));
        fondo.setBounds(0, 0, 584, 561);
        fondo.setLayout(null);

        JLabel Titulo = new JLabel("Alumno - Eliminar");
        Titulo.setForeground(new Color(0, 0, 0));
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
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
        tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 30, 460, 364);
        fondo2.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
                new Object[][]{
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                },
                new String[]{
                        "Id", "Nombre del Alumno", "A. Paterno", "A. Materno", "Fecha Nacimiento","Correo","Telefono","Direccion","Grado",
                        "Eliminar"
                }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 9) {
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        });

      

        BD bd = new BD();
        try {
            Connection cn = bd.Conectar();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM alumnosbd");

            DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nombre", "A. Paterno", "A. Materno", "Fecha Nacimiento",
            		"Correo","Telefono","Direccion","Grado", "Eliminar"}, 0);
         
            while (rs.next()) {
                int id = rs.getInt("idAlumnos");
                String nombre = rs.getString("Nombre");
                String aPaterno = rs.getString("Apellido Paterno");
                String aMaterno = rs.getString("Apellido Materno");
                String fNacimiento = rs.getString("Fecha Nacimiento");
                String correo = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                int grado = rs.getInt("Grado");
                button = new JButton("Eliminar");
               
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //System.out.println("hola");
                        /*int filaEliminada = table.getSelectedRow();
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(filaEliminada);*/
                    }
                });

                Object[] row = {id, nombre, aPaterno, aMaterno,fNacimiento,correo,telefono,direccion,grado, button};
                model.addRow(row);
            }
            

            table.setModel(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
            
            table.getColumnModel().getColumn(0).setPreferredWidth(130);
            table.getColumnModel().getColumn(1).setPreferredWidth(130);
            table.getColumnModel().getColumn(2).setPreferredWidth(130);
            table.getColumnModel().getColumn(3).setPreferredWidth(130);
            table.getColumnModel().getColumn(4).setPreferredWidth(130);
            table.getColumnModel().getColumn(5).setPreferredWidth(130);
            table.getColumnModel().getColumn(6).setPreferredWidth(130);
            table.getColumnModel().getColumn(7).setPreferredWidth(130);
            table.getColumnModel().getColumn(8).setPreferredWidth(130);
            table.getColumnModel().getColumn(9).setPreferredWidth(130);
            table.revalidate();
            table.repaint();

            rs.close();
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
       
        table.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor());
        
        RoundButtonRojo Volver = new RoundButtonRojo("Volver");
        Volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(fondo);
                anterior = actual;
				actual = "menuAlumnos";
                add(menuAlumnos());
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

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(225, 225, 225));
        panelSuperior.setBounds(0, 0, 600, 13);
        fondo.add(panelSuperior);
        
        return fondo;
    }
	
	
	public JPanel eliminarDocente() {
        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(225,225,225));
        fondo.setBounds(0, 0, 584, 561);
        fondo.setLayout(null);

        JLabel Titulo = new JLabel("Docente - Eliminar");
        Titulo.setForeground(new Color(0, 0, 0));
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
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
        tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(table2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 30, 460, 364);
        fondo2.add(scrollPane);

        table2 = new JTable();
        scrollPane.setViewportView(table2);
        table2.setModel(new DefaultTableModel(
                new Object[][]{
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null, null, null, null},  
                },
                new String[]{
                        "Id", "Nombre del Docente", "A. Paterno", "A. Materno", "Fecha Nacimiento","Correo","Telefono","Direccion","Grado de estudios",
                        "Eliminar"
                }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 9) {
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        });

      

        BD bd = new BD();
        try {
            Connection cn = bd.Conectar();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");

            DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nombre", "A. Paterno", "A. Materno", "Fecha Nacimiento",
            		"Correo","Telefono","Direccion","Grado", "Eliminar"}, 0);
         
            while (rs.next()) {
                int id = rs.getInt("idDocente");
                String nombre = rs.getString("Nombre");
                String aPaterno = rs.getString("Apellido Paterno");
                String aMaterno = rs.getString("Apellido Materno");
                String fNacimiento = rs.getString("Fecha Nacimiento");
                String correo = rs.getString("Correo");
                String telefono = rs.getString("Telefono");
                String direccion = rs.getString("Direccion");
                String grado = rs.getString("Grado");
                button2 = new JButton("Eliminar");
               
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                    }
                });

                Object[] row = {id, nombre, aPaterno, aMaterno,fNacimiento,correo,telefono,direccion,grado, button2};
                model.addRow(row);
            }
            

            table2.setModel(model);
            table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
            
            table2.getColumnModel().getColumn(0).setPreferredWidth(130);
            table2.getColumnModel().getColumn(1).setPreferredWidth(130);
            table2.getColumnModel().getColumn(2).setPreferredWidth(130);
            table2.getColumnModel().getColumn(3).setPreferredWidth(130);
            table2.getColumnModel().getColumn(4).setPreferredWidth(130);
            table2.getColumnModel().getColumn(5).setPreferredWidth(130);
            table2.getColumnModel().getColumn(6).setPreferredWidth(130);
            table2.getColumnModel().getColumn(7).setPreferredWidth(130);
            table2.getColumnModel().getColumn(8).setPreferredWidth(130);
            table2.getColumnModel().getColumn(9).setPreferredWidth(130);
            table2.revalidate();
            table2.repaint();

            rs.close();
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
       
        table2.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer2());
        table2.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor2());
        
        RoundButtonRojo Volver = new RoundButtonRojo("Volver");
        Volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(fondo);
                anterior = actual;
				actual = "menuDocentes";
				add(menuDocentes());
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

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(225, 225, 225));
        panelSuperior.setBounds(0, 0, 600, 13);
        fondo.add(panelSuperior);
        
        return fondo;
    }
	
	public JPanel eliminarGrupo() {
		anterior = actual;
		actual = "eliminarGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Eliminar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
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
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane(table3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 30, 460, 364);
        fondo2.add(scrollPane);

        table3 = new JTable();
        scrollPane.setViewportView(table3);
        table3.setModel(new DefaultTableModel(
                new Object[][]{
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                	{null, null, null, null, null, null, null},  
                },
                new String[]{
                        "Id", "Carrera", "Asignatura", "Docente","Semestre","Numero de Alumnos","Eliminar"}
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 9) {
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        });

      

        BD bd = new BD();
        try {
            Connection cn = bd.Conectar();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM gruposbd");

            DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Carrera", "Asignatura", "Docente", "Semestre",
            "Numero de Alumnos"}, 0);
         
            while (rs.next()) {
                int id = rs.getInt("idGrupos");
                String carrera = rs.getString("Carrera");
                String asignatura = rs.getString("Asignatura");
                String docente = rs.getString("Docente");
                String semestre = rs.getString("Semestre");
                String numAlum = rs.getString("numAlumnos");
                button3 = new JButton("Eliminar");
               
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                    }
                });

                Object[] row = {id, carrera, asignatura, docente,semestre,numAlum, button3};
                model.addRow(row);
            }
            

            table3.setModel(model);
            table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
            
            table3.getColumnModel().getColumn(0).setPreferredWidth(130);
            table3.getColumnModel().getColumn(1).setPreferredWidth(130);
            table3.getColumnModel().getColumn(2).setPreferredWidth(130);
            table3.getColumnModel().getColumn(3).setPreferredWidth(130);
            table3.getColumnModel().getColumn(4).setPreferredWidth(130);
            table3.getColumnModel().getColumn(5).setPreferredWidth(130);
            table3.revalidate();
            table3.repaint();

            rs.close();
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
       
        table3.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer3());
        table3.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor3());
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuGrupos";
				add(menuGrupos());
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 13);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel eliminarAsignatura() {
		anterior = actual;
		actual = "eliminarAsignatura";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Eliminar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
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
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane(table4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 30, 460, 364);
        fondo2.add(scrollPane);

        table4 = new JTable();
        scrollPane.setViewportView(table4);
        table4.setModel(new DefaultTableModel(
                new Object[][]{
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                	{null, null, null, null, null, null},  
                },
                new String[]{
                        "Id", "Nombre", "Creditos", "Docente","Semestre","Eliminar"}
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 9) {
                    return JButton.class;
                }
                return super.getColumnClass(columnIndex);
            }
        });

      

        BD bd = new BD();
        try {
            Connection cn = bd.Conectar();
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");

            DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Nombre", "Creditos", "Docente", "Semestre"}, 0);
         
            while (rs.next()) {
                int id = rs.getInt("idAsignatura");
                String nombre = rs.getString("Nombre");
                String creditos = rs.getString("Creditos");
                String docente = rs.getString("Docente");
                String semestre = rs.getString("Semestre");
                button4 = new JButton("Eliminar");
               
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                    }
                });

                Object[] row = {id, nombre, creditos, docente,semestre, button4};
                model.addRow(row);
            }
            

            table4.setModel(model);
            table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
            
            table4.getColumnModel().getColumn(0).setPreferredWidth(130);
            table4.getColumnModel().getColumn(1).setPreferredWidth(130);
            table4.getColumnModel().getColumn(2).setPreferredWidth(130);
            table4.getColumnModel().getColumn(3).setPreferredWidth(130);
            table4.getColumnModel().getColumn(4).setPreferredWidth(130);      
            table4.revalidate();
            table4.repaint();

            rs.close();
            stm.close();
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
       
        table4.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer4());
        table4.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor4());
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuAsignaturas";
				add(menuAsignaturas());
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 13);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarAlumno() {
		anterior = actual;
		actual = "consultarAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Mi cuenta - Alumno");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Ingrese el ID del alumno");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tagnombre = new JLabel("Nombre");
		tagnombre.setForeground(new Color(0, 0, 0));
		tagnombre.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tagnombre.setBounds(10, 70, 210, 20);
		fondo2.add(tagnombre);
		
		JLabel tag2 = new JLabel("Apellido Paterno");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBounds(10, 114, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag2_1 = new JLabel("Apellido Materno");
		tag2_1.setForeground(new Color(0, 0, 0));
		tag2_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2_1.setBounds(160, 114, 210, 20);
		fondo2.add(tag2_1);
		
		JLabel tag3 = new JLabel("Correo electrónico");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBounds(10, 158, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Fecha de nacimiento");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBounds(10, 201, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Teléfono");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBounds(10, 242, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Direccion");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag6.setBounds(10, 283, 210, 14);
		fondo2.add(tag6);
		
		JTextField idAlumno = new JTextField();
		idAlumno.setEditable(true);
		idAlumno.setColumns(10);
		idAlumno.setBounds(10, 45, 273, 22);
		fondo2.add(idAlumno);
		
		
		System.out.println();
		
		JTextField datos_nombre = new JTextField();
		datos_nombre.setEditable(false);
		datos_nombre.setColumns(10);
		datos_nombre.setBounds(10, 90, 273, 20);
		fondo2.add(datos_nombre);
		
		JTextField datos_apePaterno = new JTextField();
		datos_apePaterno.setEditable(false);
		datos_apePaterno.setColumns(10);
		datos_apePaterno.setBounds(10, 132, 120, 20);
		fondo2.add(datos_apePaterno);
		
		JTextField datos_apeMaterno = new JTextField();
		datos_apeMaterno.setEditable(false);
		datos_apeMaterno.setColumns(10);
		datos_apeMaterno.setBounds(160, 132, 120, 20);
		fondo2.add(datos_apeMaterno);
		
		JTextField datos_correo = new JTextField();
		datos_correo.setEditable(false);
		datos_correo.setColumns(10);
		datos_correo.setBounds(10, 174, 273, 20);
		fondo2.add(datos_correo);
		
		JTextField datos_fecha = new JTextField();
		datos_fecha.setEditable(false);
		datos_fecha.setColumns(10);
		datos_fecha.setBounds(10, 216, 273, 20);
		fondo2.add(datos_fecha);
		
		JTextField datos_tel = new JTextField();
		datos_tel.setEditable(false);
		datos_tel.setColumns(10);
		datos_tel.setBounds(10, 260, 273, 20);
		fondo2.add(datos_tel);
		
		JTextField datos_direccion = new JTextField();
		datos_direccion.setEditable(false);
		datos_direccion.setColumns(10);
		datos_direccion.setBounds(10, 299, 273, 20);
		fondo2.add(datos_direccion);
		
		
		JButton Consultar = new JButton("Consultar");
		Consultar.setForeground(new Color(255, 255, 255));
		Consultar.setBackground(new Color(0, 128, 255));
		Consultar.setBounds(250, 514, 89, 36);
		fondo.add(Consultar);
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idConsultar = Integer.parseInt(idAlumno.getText());
				BD bd = new BD();
			    try {
			        Connection cn = bd.Conectar();
			        Statement stm = cn.createStatement();
			        ResultSet rs = stm.executeQuery("SELECT * FROM alumnosbd");

			        
			        
			        while (rs.next()) {
			        	
			        	int id = rs.getInt("idAlumnos");
			           
			        	if(idConsultar == id) {
			        		String nombre = rs.getString("Nombre");
			        		String correo = rs.getString("Correo");
				            String apellidoP = rs.getString("Apellido Paterno");
				            String apellidoM = rs.getString("Apellido Materno");
				            String telefono = rs.getString("Telefono");
				            LocalDate fechaNacimiento = rs.getDate("Fecha Nacimiento").toLocalDate(); 
				            String fecha = fechaNacimiento.toString();
				            String direccion = rs.getString("Direccion");
				            byte[] imagenBytes = rs.getBytes("Foto");
				            System.out.println("Longitud de imagenBytes: " + imagenBytes.length);
				            
				            ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagenBytes).getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
				            
				            JLabel nuevaimagen = new JLabel();
				            nuevaimagen.setIcon(imageIcon);
				    		nuevaimagen.setBounds(300, 50, 160, 160);
				    		//fondo2.remove(imagen);
				    		fondo2.add(nuevaimagen);
				            
				            
				            
				            datos_nombre.setText(nombre);
				            datos_apePaterno.setText(apellidoP);
				            datos_apeMaterno.setText(apellidoM);
				            datos_correo.setText(correo);
				            datos_tel.setText(telefono);
				            datos_fecha.setText(fecha);
				            datos_direccion.setText(direccion);			  
				            cambio++;
				            fondo2.repaint();
				            fondo2.revalidate();
			        	}
			        }

			        rs.close();
			        stm.close();
			        cn.close();
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			    
			    if(cambio==0) {
			    	JOptionPane.showMessageDialog(null, "ID de alumno invalido. Favor de intentar denuevo");
			    }
			    cambio=0;
				
			
				repaint();
				revalidate();
			}
		});
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuAlumnos";
				add(menuAlumnos());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(120, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Crear el archivo PDF
		            PdfWriter writer = new PdfWriter(new FileOutputStream("archivo.pdf"));
		            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
		            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);
		            
		            //Crear txt
		            float col = 280f;
		            float anchoColumna[] = {col,col};
		            Table table = new Table(anchoColumna);
		            
		            
		            table.setBackgroundColor(new DeviceRgb(63, 169, 219))
		            	.setFontColor(new DeviceRgb(255, 255, 255));
		            Cell cell = new Cell();
		            Paragraph paragraph = new Paragraph("Universidad Autónoma de Baja California Sur").setTextAlignment(TextAlignment.CENTER)
		            		.setVerticalAlignment(VerticalAlignment.MIDDLE)
		            		.setMarginTop(30f)
		            		.setMarginBottom(30f)
		            		.setFontSize(24f)
		            		.setFontColor(new DeviceRgb(0, 0, 0))
		            		.setBorder(Border.NO_BORDER)
		            		;
		            cell.add(paragraph);
		            table.addCell(cell);

		            cell = new Cell();
		            paragraph = new Paragraph("Sabiduría como meta,\n patria como destino").setTextAlignment(TextAlignment.RIGHT)
		                .setVerticalAlignment(VerticalAlignment.MIDDLE)
		                .setMarginTop(50f)
		                .setMarginBottom(30f)
		                .setFontSize(12f)
		                .setBorder(Border.NO_BORDER)
		                .setMarginRight(10f);
		            cell.add(paragraph);
		            table.addCell(cell);

		            float columnaAncho[] = {80,300,100,80};
		            Table tablaInformacion = new Table(columnaAncho);
		            
		            tablaInformacion.addCell(new Cell(0, 8)
		                    .add(new Paragraph("Informacion del alumno:")
		                    .setBold()));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Nombres")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Apellido paterno")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Apellido materno")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Fecha de nacimiento")).setBackgroundColor(new DeviceRgb(255, 255, 0)));   
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_nombre.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_apePaterno.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_apeMaterno.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_fecha.getText())));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Correo")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Teléfono")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Dirección")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("ID del Alumno")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_correo.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_tel.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_tel.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(idAlumno.getText())));
		            
		            // Cerrar el documento
		            document.add(table);
		            document.add(tablaInformacion);
		            document.close();
		            
		            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
		        } /*catch (MalformedURLException e1) {
					e1.printStackTrace();
				}*/
		    }
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(380, 514, 89, 36);
		fondo.add(Descargar);
		
		imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(300, 50, 160, 160);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 320, 400, 100);
		fondo2.add(imagen2);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		JButton GuardarCambios = new JButton("<html>Guardar Cambios<html>");
		GuardarCambios.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nombre = datos_nombre.getText();
		        String apellidoPaterno = datos_apePaterno.getText();
		        String correo = datos_correo.getText();
		        String fechaNacimiento = datos_fecha.getText();
		        String telefono = datos_tel.getText();
		        String direccion = datos_direccion.getText();
		        int id = Integer.parseInt(idAlumno.getText());

		        BD bd = new BD();
		        try {
		            Connection cn = bd.Conectar();
		            Statement stm = cn.createStatement();
		            PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement("UPDATE alumnosbd SET Correo = ?, Telefono = ?, Direccion = ? WHERE idAlumnos = ?");
		           
		            pstmt.setString(1, correo);		            
		            pstmt.setString(2, telefono);
		            pstmt.setString(3, direccion);
		            pstmt.setInt(4, id);

		            int columnasAfectadas = pstmt.executeUpdate();
		            if (columnasAfectadas > 0) {
		                JOptionPane.showMessageDialog(null, "Los cambios se guardaron correctamente.");
		            } else {
		                JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios.");
		            }

		            pstmt.close();
		            cn.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }

		        repaint();
		        revalidate();
		    }
		});
		GuardarCambios.setForeground(new Color(255, 255, 255));
		GuardarCambios.setBackground(new Color(0, 128, 255));
		GuardarCambios.setBounds(380, 250, 70, 30);
		GuardarCambios.setEnabled(false);
		fondo2.add(GuardarCambios);
		
		JButton Editar = new JButton("<html>Editar<html>");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = idAlumno.getText();
				if(idText.matches(".*\\d.*")) {
					datos_correo.setEditable(true);
					datos_tel.setEditable(true);
					datos_direccion.setEditable(true);
					GuardarCambios.setEnabled(true);
					
					repaint();
					revalidate();
				}else {
					JOptionPane.showMessageDialog(null, "Ingresa el id del alumno");
				}
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(290, 250, 70, 30);
		fondo2.add(Editar);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarDocente() {
		anterior = actual;
		actual = "consultarDocente";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Mi cuenta - Docente");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Ingrese el ID del docente");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tagnombre = new JLabel("Nombre");
		tagnombre.setForeground(new Color(0, 0, 0));
		tagnombre.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tagnombre.setBounds(10, 70, 210, 20);
		fondo2.add(tagnombre);
		
		JLabel tag2 = new JLabel("Apellido Paterno");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBounds(10, 114, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag2_1 = new JLabel("Apellido Materno");
		tag2_1.setForeground(new Color(0, 0, 0));
		tag2_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2_1.setBounds(160, 114, 210, 20);
		fondo2.add(tag2_1);
		
		JLabel tag3 = new JLabel("Correo electrónico");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBounds(10, 158, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Fecha de nacimiento");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBounds(10, 201, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Teléfono");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBounds(10, 242, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Direccion");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag6.setBounds(10, 283, 210, 14);
		fondo2.add(tag6);
		
		JTextField idDocente = new JTextField();
		idDocente.setEditable(true);
		idDocente.setColumns(10);
		idDocente.setBounds(10, 45, 273, 22);
		fondo2.add(idDocente);
		
		
		JTextField datos_nombre = new JTextField();
		datos_nombre.setEditable(false);
		datos_nombre.setColumns(10);
		datos_nombre.setBounds(10, 90, 273, 20);
		fondo2.add(datos_nombre);
		
		JTextField datos_apePaterno = new JTextField();
		datos_apePaterno.setEditable(false);
		datos_apePaterno.setColumns(10);
		datos_apePaterno.setBounds(10, 132, 120, 20);
		fondo2.add(datos_apePaterno);
		
		JTextField datos_apeMaterno = new JTextField();
		datos_apeMaterno.setEditable(false);
		datos_apeMaterno.setColumns(10);
		datos_apeMaterno.setBounds(160, 132, 120, 20);
		fondo2.add(datos_apeMaterno);
		
		JTextField datos_correo = new JTextField();
		datos_correo.setEditable(false);
		datos_correo.setColumns(10);
		datos_correo.setBounds(10, 174, 273, 20);
		fondo2.add(datos_correo);
		
		JTextField datos_fecha = new JTextField();
		datos_fecha.setEditable(false);
		datos_fecha.setColumns(10);
		datos_fecha.setBounds(10, 216, 273, 20);
		fondo2.add(datos_fecha);
		
		JTextField datos_tel = new JTextField();
		datos_tel.setEditable(false);
		datos_tel.setColumns(10);
		datos_tel.setBounds(10, 260, 273, 20);
		fondo2.add(datos_tel);
		
		JTextField datos_direccion = new JTextField();
		datos_direccion.setEditable(false);
		datos_direccion.setColumns(10);
		datos_direccion.setBounds(10, 299, 273, 20);
		fondo2.add(datos_direccion);
		
		
		JButton Consultar = new JButton("Consultar");
		Consultar.setForeground(new Color(255, 255, 255));
		Consultar.setBackground(new Color(0, 128, 255));
		Consultar.setBounds(250, 514, 89, 36);
		fondo.add(Consultar);
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idConsultar = Integer.parseInt(idDocente.getText());
				BD bd = new BD();
			    try {
			        Connection cn = bd.Conectar();
			        Statement stm = cn.createStatement();
			        ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");

			        
			        
			        while (rs.next()) {
			        	
			        	int id = rs.getInt("idDocente");
			           
			        	if(idConsultar == id) {
			        		String nombre = rs.getString("Nombre");
			        		String correo = rs.getString("Correo");
				            String apellidoP = rs.getString("Apellido Paterno");
				            String apellidoM = rs.getString("Apellido Materno");
				            String telefono = rs.getString("Telefono");
				            LocalDate fechaNacimiento = rs.getDate("Fecha Nacimiento").toLocalDate(); 
				            String fecha = fechaNacimiento.toString();
				            String direccion = rs.getString("Direccion");
				            byte[] imagenBytes = rs.getBytes("Foto");
				            
				            
				            ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagenBytes).getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
				            
				            JLabel nuevaimagen = new JLabel();
				            nuevaimagen.setIcon(imageIcon);
				    		nuevaimagen.setBounds(300, 50, 160, 160);
				    		//fondo2.remove(imagen);
				    		fondo2.add(nuevaimagen);
				            
				            
				            
				            datos_nombre.setText(nombre);
				            datos_apePaterno.setText(apellidoP);
				            datos_apeMaterno.setText(apellidoM);
				            datos_correo.setText(correo);
				            datos_tel.setText(telefono);
				            datos_fecha.setText(fecha);
				            datos_direccion.setText(direccion);			  
				            cambio++;
				            fondo2.repaint();
				            fondo2.revalidate();
			        	}
			        }

			        rs.close();
			        stm.close();
			        cn.close();
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			    
			    if(cambio==0) {
			    	JOptionPane.showMessageDialog(null, "ID de docente invalido. Favor de intentar denuevo");
			    }
			    cambio=0;
				
			
				repaint();
				revalidate();
			}
		});
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuDocentes";
				add(menuDocentes());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(120, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Crear el archivo PDF
		            PdfWriter writer = new PdfWriter(new FileOutputStream("archivoDocente.pdf"));
		            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
		            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);
		            
		            //Crear txt
		            float col = 280f;
		            float anchoColumna[] = {col,col};
		            Table table = new Table(anchoColumna);
		            
		            
		            table.setBackgroundColor(new DeviceRgb(63, 169, 219))
		            	.setFontColor(new DeviceRgb(255, 255, 255));
		            Cell cell = new Cell();
		            Paragraph paragraph = new Paragraph("Universidad Autónoma de Baja California Sur").setTextAlignment(TextAlignment.CENTER)
		            		.setVerticalAlignment(VerticalAlignment.MIDDLE)
		            		.setMarginTop(30f)
		            		.setMarginBottom(30f)
		            		.setFontSize(24f)
		            		.setFontColor(new DeviceRgb(0, 0, 0))
		            		.setBorder(Border.NO_BORDER)
		            		;
		            cell.add(paragraph);
		            table.addCell(cell);

		            cell = new Cell();
		            paragraph = new Paragraph("Sabiduría como meta,\n patria como destino").setTextAlignment(TextAlignment.RIGHT)
		                .setVerticalAlignment(VerticalAlignment.MIDDLE)
		                .setMarginTop(50f)
		                .setMarginBottom(30f)
		                .setFontSize(12f)
		                .setBorder(Border.NO_BORDER)
		                .setMarginRight(10f);
		            cell.add(paragraph);
		            table.addCell(cell);

		            float columnaAncho[] = {80,300,100,80};
		            Table tablaInformacion = new Table(columnaAncho);
		            
		            tablaInformacion.addCell(new Cell(0, 8)
		                    .add(new Paragraph("Informacion del Docente:")
		                    .setBold()));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Nombres")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Apellido paterno")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Apellido materno")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Fecha de nacimiento")).setBackgroundColor(new DeviceRgb(255, 255, 0)));   
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_nombre.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_apePaterno.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_apeMaterno.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_fecha.getText())));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Correo")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Teléfono")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Dirección")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("ID del Docente")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_correo.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_tel.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_tel.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(idDocente.getText())));
		            
		            // Cerrar el documento
		            document.add(table);
		            document.add(tablaInformacion);
		            document.close();
		            
		            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
		        } /*catch (MalformedURLException e1) {
					e1.printStackTrace();
				}*/
		    }
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(380, 514, 89, 36);
		fondo.add(Descargar);
		
		imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(300, 50, 160, 160);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 320, 400, 100);
		fondo2.add(imagen2);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		JButton GuardarCambios = new JButton("<html>Guardar Cambios<html>");
		GuardarCambios.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nombre = datos_nombre.getText();
		        String apellidoPaterno = datos_apePaterno.getText();
		        String correo = datos_correo.getText();
		        String fechaNacimiento = datos_fecha.getText();
		        String telefono = datos_tel.getText();
		        String direccion = datos_direccion.getText();
		        int id = Integer.parseInt(idDocente.getText());

		        BD bd = new BD();
		        try {
		            Connection cn = bd.Conectar();
		            Statement stm = cn.createStatement();
		            PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement("UPDATE docentesbd SET Correo = ?, Telefono = ?, Direccion = ? WHERE idDocente = ?");
		           
		            pstmt.setString(1, correo);		            
		            pstmt.setString(2, telefono);
		            pstmt.setString(3, direccion);
		            pstmt.setInt(4, id);

		            int columnasAfectadas = pstmt.executeUpdate();
		            if (columnasAfectadas > 0) {
		                JOptionPane.showMessageDialog(null, "Los cambios se guardaron correctamente.");
		            } else {
		                JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios.");
		            }

		            pstmt.close();
		            cn.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }

		        repaint();
		        revalidate();
		    }
		});
		GuardarCambios.setForeground(new Color(255, 255, 255));
		GuardarCambios.setBackground(new Color(0, 128, 255));
		GuardarCambios.setBounds(380, 250, 70, 30);
		GuardarCambios.setEnabled(false);
		fondo2.add(GuardarCambios);
		
		JButton Editar = new JButton("<html>Editar<html>");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = idDocente.getText();
				if(idText.matches(".*\\d.*")) {
					datos_correo.setEditable(true);
					datos_tel.setEditable(true);
					datos_direccion.setEditable(true);
					GuardarCambios.setEnabled(true);
					
					repaint();
					revalidate();
				}else {
					JOptionPane.showMessageDialog(null, "Ingresa el id del Docente");
				}
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(290, 250, 70, 30);
		fondo2.add(Editar);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel consultarGrupo() {
		anterior = actual;
		actual = "consultarGrupo";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Grupo - Consultar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Seleccione un Grupo:");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tag2 = new JLabel("Carrera:");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBounds(10, 70, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag3 = new JLabel("Asignatura:");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBounds(10, 114, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBounds(10, 157, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Semestre:");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBounds(10, 198, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Numero de alumnos:");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag6.setBounds(10, 239, 210, 14);
		fondo2.add(tag6);
		
		BD bd = new BD();
		JComboBox<Integer> seleccionGrupo = new JComboBox<>();
		seleccionGrupo.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsGrupo().toArray(new Integer[0])));
		seleccionGrupo.setBounds(10, 45, 273, 22);
	    fondo2.add(seleccionGrupo);
		
		JTextField datos_carrera = new JTextField();
		datos_carrera.setEditable(false);
		datos_carrera.setColumns(10);
		datos_carrera.setBounds(10, 90, 273, 20);
		fondo2.add(datos_carrera);
		
		
		
		asignaturaG = new JComboBox();
		asignaturaG.setEnabled(false);
		asignaturaG.setBackground(new Color(255, 255, 255));
		asignaturaG.setBounds(10, 132, 273, 20);
		fondo2.add(asignaturaG);
	
		 BD bd1 = new BD();
	        try {
	            Connection cn = bd.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idAsignatura");
	                String nombre = rs.getString("Nombre");
	                asignaturaG.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		docente_a_cargoG = new JComboBox();
		docente_a_cargoG.setEnabled(false);
		docente_a_cargoG.setBackground(new Color(255, 255, 255));
		docente_a_cargoG.setBounds(10, 174, 273, 20);
		fondo2.add(docente_a_cargoG);
		
		 BD bd2 = new BD();
	        try {
	            Connection cn = bd1.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idDocente");
	                String nombre = rs.getString("Nombre");
	                docente_a_cargoG.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
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
		
		JButton Consultar = new JButton("Consultar");
		Consultar.setForeground(new Color(255, 255, 255));
		Consultar.setBackground(new Color(0, 128, 255));
		Consultar.setBounds(250, 514, 89, 36); 
		fondo.add(Consultar);
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConsultar = (int) seleccionGrupo.getSelectedItem();
				BD bd = new BD();
			    try {
			        Connection cn = bd.Conectar();
			        Statement stm = cn.createStatement();
			        ResultSet rs = stm.executeQuery("SELECT * FROM gruposbd");

			        
			        
			        while (rs.next()) {
			        	
			        	int id = rs.getInt("idGrupos");
			           
			        	if(idConsultar == id) {
			        		String carrera = rs.getString("Carrera");
			        		String asignatura = rs.getString("Asignatura");
				            String docente = rs.getString("Docente");
				            String semestre = rs.getString("Semestre");
				            String alumnos = rs.getString("numAlumnos");
	
				            
				            
				            datos_carrera.setText(carrera);
				            asignaturaG.setSelectedItem(asignatura);
				            asignaturaG.setEnabled(true);
				            docente_a_cargoG.setSelectedItem(docente);
				            docente_a_cargoG.setEnabled(true);
				            datos_semestre.setText(semestre);
				            datos_num_alumnos.setText(alumnos);
	  
				            cambio++;
				            fondo2.repaint();
				            fondo2.revalidate();
			        	}
			        }

			        rs.close();
			        stm.close();
			        cn.close();
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			    
			    if(cambio==0) {
			    	JOptionPane.showMessageDialog(null, "ID de docente invalido. Favor de intentar denuevo");
			    }
			    cambio=0;
				
			
				repaint();
				revalidate();
			}
		});
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuGrupos";
				add(menuGrupos());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(120, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Crear el archivo PDF
		            PdfWriter writer = new PdfWriter(new FileOutputStream("archivoGrupo.pdf"));
		            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
		            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);
		            
		            //Crear txt
		            float col = 280f;
		            float anchoColumna[] = {col,col};
		            Table table = new Table(anchoColumna);
		            
		            
		            table.setBackgroundColor(new DeviceRgb(63, 169, 219))
		            	.setFontColor(new DeviceRgb(255, 255, 255));
		            Cell cell = new Cell();
		            Paragraph paragraph = new Paragraph("Universidad Autónoma de Baja California Sur").setTextAlignment(TextAlignment.CENTER)
		            		.setVerticalAlignment(VerticalAlignment.MIDDLE)
		            		.setMarginTop(30f)
		            		.setMarginBottom(30f)
		            		.setFontSize(24f)
		            		.setFontColor(new DeviceRgb(0, 0, 0))
		            		.setBorder(Border.NO_BORDER)
		            		;
		            cell.add(paragraph);
		            table.addCell(cell);

		            cell = new Cell();
		            paragraph = new Paragraph("Sabiduría como meta,\n patria como destino").setTextAlignment(TextAlignment.RIGHT)
		                .setVerticalAlignment(VerticalAlignment.MIDDLE)
		                .setMarginTop(50f)
		                .setMarginBottom(30f)
		                .setFontSize(12f)
		                .setBorder(Border.NO_BORDER)
		                .setMarginRight(10f);
		            cell.add(paragraph);
		            table.addCell(cell);

		            float columnaAncho[] = {80,300,100,80};
		            Table tablaInformacion = new Table(columnaAncho);
		            
		            tablaInformacion.addCell(new Cell(0, 2)
		                    .add(new Paragraph("Informacion del Grupo:")
		                    .setBold()));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Carrera")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Asignatura")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Docente")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Semestre")).setBackgroundColor(new DeviceRgb(255, 255, 0)));   
		            
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_carrera.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(asignaturaG.getSelectedItem().toString())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(docente_a_cargoG.getSelectedItem().toString())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_semestre.getText())));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Numero de Alumnos")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_num_alumnos.getText())));

		            
		            // Cerrar el documento
		            document.add(table);
		            document.add(tablaInformacion);
		            document.close();
		            
		            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
		        } /*catch (MalformedURLException e1) {
					e1.printStackTrace();
				}*/
		    }
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(380, 514, 89, 36);
		fondo.add(Descargar);
		
		JButton GuardarCambios = new JButton("<html>Guardar Cambios<html>");
		GuardarCambios.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String carrera = datos_carrera.getText();
		        String asginatura = asignaturaG.getSelectedItem().toString();
		        String docente = docente_a_cargoG.getSelectedItem().toString();
		        String semestre = datos_semestre.getText();
		        String alumnos = datos_num_alumnos.getText();
		        int id = Integer.parseInt(String.valueOf(seleccionGrupo.getSelectedItem()));

		        BD bd = new BD();
		        try {
		            Connection cn = bd.Conectar();
		            Statement stm = cn.createStatement();
		            PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement("UPDATE gruposbd SET Carrera = ?, Asignatura = ?, Docente = ?, Semestre = ?, numAlumnos = ? WHERE idGrupos = ?");
		           
		            pstmt.setString(1, carrera);		            
		            pstmt.setString(2, asginatura);
		            pstmt.setString(3, docente);
		            pstmt.setString(4, semestre);
		            pstmt.setString(5, alumnos);
		            pstmt.setInt(6, id);

		            int columnasAfectadas = pstmt.executeUpdate();
		            if (columnasAfectadas > 0) {
		                JOptionPane.showMessageDialog(null, "Los cambios se guardaron correctamente.");
		            } else {
		                JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios.");
		            }

		            pstmt.close();
		            cn.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }

		        repaint();
		        revalidate();
		    }
		});
		GuardarCambios.setForeground(new Color(255, 255, 255));
		GuardarCambios.setBackground(new Color(0, 128, 255));
		GuardarCambios.setBounds(380, 250, 70, 30);
		GuardarCambios.setEnabled(false);
		fondo2.add(GuardarCambios);
		
		JButton Editar = new JButton("<html>Editar<html>");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = seleccionGrupo.getSelectedItem().toString();
				if(idText.matches(".*\\d.*")) {
					asignaturaG.setEnabled(true);
					docente_a_cargoG.setEnabled(true);
					datos_semestre.setEditable(true);
					datos_num_alumnos.setEditable(true);
					GuardarCambios.setEnabled(true);
					
					repaint();
					revalidate();
				}else {
					JOptionPane.showMessageDialog(null, "Ingresa el id del Docente");
				}
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(290, 250, 70, 30);
		fondo2.add(Editar);
		
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
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Asignatura - Consultar");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
		Titulo.setBounds(79, 24, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 75, 480, 429);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		JLabel tag1 = new JLabel("Seleccione una Asignatura:");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tag2 = new JLabel("Nombre:");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag2.setBounds(10, 70, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag3 = new JLabel("Créditos:");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag3.setBounds(10, 114, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Docente a cargo:");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag4.setBounds(10, 157, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Semestres:");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag5.setBounds(10, 198, 210, 14);
		fondo2.add(tag5);
		
		/*JLabel tag6 = new JLabel("Grupos que llevan esta asignatura:");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("SansSerif", Font.PLAIN, 16));
		tag6.setBounds(10, 239, 250, 14);
		fondo2.add(tag6);*/
		
		BD bd = new BD();
		JComboBox<Integer> seleccionAsignatura = new JComboBox<>();
		seleccionAsignatura.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsAsignatura().toArray(new Integer[0])));
		seleccionAsignatura.setBounds(10, 45, 273, 22);
	    fondo2.add(seleccionAsignatura);
		
		asignaturaG = new JComboBox();
		asignaturaG.setEnabled(false);
		asignaturaG.setBackground(new Color(255, 255, 255));
		asignaturaG.setBounds(10, 90, 273, 20);
		fondo2.add(asignaturaG);
	
		 BD bd1 = new BD();
	        try {
	            Connection cn = bd.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idAsignatura");
	                String nombre = rs.getString("Nombre");
	                asignaturaG.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		JTextField datos_creditos = new JTextField();
		datos_creditos.setEditable(false);
		datos_creditos.setColumns(10);
		datos_creditos.setBounds(10, 132, 273, 20);
		fondo2.add(datos_creditos);
		
		docente_a_cargoG = new JComboBox();
		docente_a_cargoG.setEnabled(false);
		docente_a_cargoG.setBackground(new Color(255, 255, 255));
		docente_a_cargoG.setBounds(10, 174, 273, 20);
		fondo2.add(docente_a_cargoG);
		
		 BD bd2 = new BD();
	        try {
	            Connection cn = bd1.Conectar();
	            Statement stm = cn.createStatement();
	            ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");
	         
	            while (rs.next()) {
	                int id = rs.getInt("idDocente");
	                String nombre = rs.getString("Nombre");
	                docente_a_cargoG.addItem(nombre);
	            }

	            rs.close();
	            stm.close();
	            cn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		JTextField datos_semestres = new JTextField();
		datos_semestres.setEditable(false);
		datos_semestres.setColumns(10);
		datos_semestres.setBounds(10, 215, 273, 20);
		fondo2.add(datos_semestres);
		
		/*JTextField datos_num_grupos = new JTextField();
		datos_num_grupos.setEditable(false);
		datos_num_grupos.setColumns(10);
		datos_num_grupos.setBounds(10, 257, 273, 20);
		fondo2.add(datos_num_grupos);*/
		
		JButton Consultar = new JButton("Consultar");
		Consultar.setForeground(new Color(255, 255, 255));
		Consultar.setBackground(new Color(0, 128, 255));
		Consultar.setBounds(250, 514, 89, 36); 
		fondo.add(Consultar);
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idConsultar = (int) seleccionAsignatura.getSelectedItem();
				BD bd = new BD();
			    try {
			        Connection cn = bd.Conectar();
			        Statement stm = cn.createStatement();
			        ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");

			        
			        
			        while (rs.next()) {
			        	
			        	int id = rs.getInt("idAsignatura");
			           
			        	if(idConsultar == id) {
			        		String nombre = rs.getString("Nombre");
			        		String creditos = rs.getString("Creditos");
				            String docente = rs.getString("Docente");
				            String semestre = rs.getString("Semestre");
				           
	
				            
				            
				            asignaturaG.setSelectedItem(nombre);
				            asignaturaG.setEnabled(true);
				            datos_creditos.setText(creditos);
				            docente_a_cargoG.setSelectedItem(docente);
				            docente_a_cargoG.setEnabled(true);
				            datos_semestres.setText(semestre);
				        
	  
				            cambio++;
				            fondo2.repaint();
				            fondo2.revalidate();
			        	}
			        }

			        rs.close();
			        stm.close();
			        cn.close();
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			    
			    if(cambio==0) {
			    	JOptionPane.showMessageDialog(null, "ID de docente invalido. Favor de intentar denuevo");
			    }
			    cambio=0;
				
			
				repaint();
				revalidate();
			}
		});
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuAsignaturas";
				add(menuAsignaturas());
				repaint();
				revalidate();
			}
		});
		Volver.setForeground(new Color(255, 255, 255));
		Volver.setBackground(new Color(255, 0, 0));
		Volver.setBounds(120, 514, 89, 36);
		fondo.add(Volver);
		
		JButton Descargar = new JButton("<html>Descargar .pdf<html>");
		Descargar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            // Crear el archivo PDF
		            PdfWriter writer = new PdfWriter(new FileOutputStream("archivoAsignatura.pdf"));
		            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
		            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);
		            
		            //Crear txt
		            float col = 280f;
		            float anchoColumna[] = {col,col};
		            Table table = new Table(anchoColumna);
		            
		            
		            table.setBackgroundColor(new DeviceRgb(63, 169, 219))
		            	.setFontColor(new DeviceRgb(255, 255, 255));
		            Cell cell = new Cell();
		            Paragraph paragraph = new Paragraph("Universidad Autónoma de Baja California Sur").setTextAlignment(TextAlignment.CENTER)
		            		.setVerticalAlignment(VerticalAlignment.MIDDLE)
		            		.setMarginTop(30f)
		            		.setMarginBottom(30f)
		            		.setFontSize(24f)
		            		.setFontColor(new DeviceRgb(0, 0, 0))
		            		.setBorder(Border.NO_BORDER)
		            		;
		            cell.add(paragraph);
		            table.addCell(cell);

		            cell = new Cell();
		            paragraph = new Paragraph("Sabiduría como meta,\n patria como destino").setTextAlignment(TextAlignment.RIGHT)
		                .setVerticalAlignment(VerticalAlignment.MIDDLE)
		                .setMarginTop(50f)
		                .setMarginBottom(30f)
		                .setFontSize(12f)
		                .setBorder(Border.NO_BORDER)
		                .setMarginRight(10f);
		            cell.add(paragraph);
		            table.addCell(cell);

		            float columnaAncho[] = {80,300,100,80};
		            Table tablaInformacion = new Table(columnaAncho);
		            
		            tablaInformacion.addCell(new Cell(0, 4)
		                    .add(new Paragraph("Informacion de la Asignatura:")
		                    .setBold()));
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Nombre")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Creditos")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Docente")).setBackgroundColor(new DeviceRgb(255, 255, 0)));
		            tablaInformacion.addCell(new Cell().add(new Paragraph("Semestres")).setBackgroundColor(new DeviceRgb(255, 255, 0)));   
		            
		            
		            tablaInformacion.addCell(new Cell().add(new Paragraph(asignaturaG.getSelectedItem().toString())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_creditos.getText())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(docente_a_cargoG.getSelectedItem().toString())));
		            tablaInformacion.addCell(new Cell().add(new Paragraph(datos_semestres.getText())));
		            
		            // Cerrar el documento
		            document.add(table);
		            document.add(tablaInformacion);
		            document.close();
		            
		            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
		        } /*catch (MalformedURLException e1) {
					e1.printStackTrace();
				}*/
		    }
		});
		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(380, 514, 89, 36);
		fondo.add(Descargar);
		
		JButton GuardarCambios = new JButton("<html>Guardar Cambios<html>");
		GuardarCambios.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String nombre = asignaturaG.getSelectedItem().toString();
		        String creditos = datos_creditos.getText();
		        String docente = docente_a_cargoG.getSelectedItem().toString();
		        String semestres = datos_semestres.getText();
		   
		        int id = Integer.parseInt(String.valueOf(seleccionAsignatura.getSelectedItem()));

		        BD bd = new BD();
		        try {
		            Connection cn = bd.Conectar();
		            Statement stm = cn.createStatement();
		            PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement("UPDATE asignaturasbd SET Nombre = ?, Creditos = ?, Docente = ?, Semestre = ? WHERE idAsignatura = ?");
		           
		            pstmt.setString(1, nombre);		            
		            pstmt.setString(2, creditos);
		            pstmt.setString(3, docente);
		            pstmt.setString(4, semestres);
		            pstmt.setInt(5, id);

		            int columnasAfectadas = pstmt.executeUpdate();
		            if (columnasAfectadas > 0) {
		                JOptionPane.showMessageDialog(null, "Los cambios se guardaron correctamente.");
		            } else {
		                JOptionPane.showMessageDialog(null, "No se pudo guardar los cambios.");
		            }

		            pstmt.close();
		            cn.close();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }

		        repaint();
		        revalidate();
		    }
		});
		GuardarCambios.setForeground(new Color(255, 255, 255));
		GuardarCambios.setBackground(new Color(0, 128, 255));
		GuardarCambios.setBounds(380, 250, 70, 30);
		GuardarCambios.setEnabled(false);
		fondo2.add(GuardarCambios);
		
		JButton Editar = new JButton("<html>Editar<html>");
		Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idText = seleccionAsignatura.getSelectedItem().toString();
				if(idText.matches(".*\\d.*")) {
					asignaturaG.setEnabled(true);
					docente_a_cargoG.setEnabled(true);
					datos_creditos.setEditable(true);
					datos_semestres.setEditable(true);
					GuardarCambios.setEnabled(true);
					
					repaint();
					revalidate();
				}else {
					JOptionPane.showMessageDialog(null, "Ingresa el id del Docente");
				}
			}
		});
		Editar.setForeground(new Color(255, 255, 255));
		Editar.setBackground(new Color(0, 128, 255));
		Editar.setBounds(290, 250, 70, 30);
		fondo2.add(Editar);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
	
	public JPanel credencialAlumno() {
		anterior = actual;
		actual = "credencialAlumno";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Alumno - Generar Credencial");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 30));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 55, 480, 449);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		BD bd = new BD();
		JComboBox<Integer> comboBoxID = new JComboBox<>();
	    comboBoxID.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsAlumnos().toArray(new Integer[0])));
	    comboBoxID.setBounds(40, 5, 200, 20);
	    fondo2.add(comboBoxID);
		
		


		JTextField datos_nombre = new JTextField();
        JTextField datos_apePaterno = new JTextField();			
        JTextField datos_apeMaterno = new JTextField();
        JTextField datos_correo = new JTextField();
        JTextField datos_direccion = new JTextField();
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuAlumnos";
				add(menuAlumnos());
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
		    	int idConsultar = (int) comboBoxID.getSelectedItem();
				BD bd = new BD();
			    try {
			        Connection cn = bd.Conectar();
			        Statement stm = cn.createStatement();
			        ResultSet rs = stm.executeQuery("SELECT * FROM alumnosbd");

			        
			        
			        while (rs.next()) {
			        	
			        	int id = rs.getInt("idAlumnos");
			           
			        	if(idConsultar == id) {
			        		String nombre = rs.getString("Nombre");
			        		String correo = rs.getString("Correo");
				            String apellidoP = rs.getString("Apellido Paterno");
				            String apellidoM = rs.getString("Apellido Materno");
				            String direccion = rs.getString("Direccion");
				            
				           
				            datos_nombre.setText(nombre);
				            datos_apePaterno.setText(apellidoP);
				            datos_apeMaterno.setText(apellidoM);
				            datos_correo.setText(correo);
				            datos_direccion.setText(direccion);		  
				            cambio++;
			        	}
			        }

			        rs.close();
			        stm.close();
			        cn.close();
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			    
			    if(cambio==0) {
			    	JOptionPane.showMessageDialog(null, "ID de alumno invalido. Favor de intentar denuevo");
			    }
			    cambio=0;
				
		        try {
		            // Crear el archivo PDF
		            PdfWriter writer = new PdfWriter(new FileOutputStream("credencialAlumno.pdf"));
		            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
		            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);

		            
		            // Agregar las imágenes al documento
		            com.itextpdf.layout.element.Image imagen1 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("img/credencialF.png"));
		            com.itextpdf.layout.element.Image imagen2 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("img/credencialT.png"));
		            document.add(imagen1);
		            document.add(imagen2);
		            
		            // Crear una capa para el texto
		            PdfPage page = pdfDoc.addNewPage();
		            com.itextpdf.kernel.pdf.layer.PdfLayer textLayer = new PdfLayer("Text Layer", pdfDoc);	  
		            PdfCanvas canvas = new PdfCanvas(page);
		            canvas.beginLayer(textLayer);
		            canvas.endLayer();

		            
		            // Agregar el texto a la capa de texto
		            PdfCanvas textCanvas = new PdfCanvas(pdfDoc.getPage(1));
		            PdfFont defaultFont = PdfFontFactory.createFont();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 750).showText(datos_nombre.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 710).showText(datos_apePaterno.getText()+" "+datos_apeMaterno.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 662).showText(datos_correo.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 621).showText(datos_direccion.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 14).moveText(345, 502).showText("2023").endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 14).moveText(345, 474).showText("2024").endText();
		            textLayer.setOn(true);

		          

		            // Cerrar el documento
		            document.close();

		            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
		        } catch (MalformedURLException e1) {
		            e1.printStackTrace();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		});





		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 95, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/credencialF.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(40, 30, 400, 200);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/credencialT.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 230, 400, 200);
		fondo2.add(imagen2);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}

	public JPanel credencialDocente() {
		anterior = actual;
		actual = "credencialDocente";
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(225,225,225));
		fondo.setBounds(0, 0, 584, 561);
		getContentPane().add(fondo);
		fondo.setLayout(null);
		
		JLabel Titulo = new JLabel("Docente - Generar Credencial");
		Titulo.setForeground(new Color(0, 0, 0));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 30));
		Titulo.setBounds(79, 11, 421, 40);
		fondo.add(Titulo);
		
		JPanel fondo2 = new JPanel();
		fondo2.setBackground(new Color(0, 128, 64));
		fondo2.setBounds(60, 55, 480, 449);
		fondo.add(fondo2);
		fondo2.setLayout(null);
		
		BD bd = new BD();
		JComboBox<Integer> comboBoxID = new JComboBox<>();
	    comboBoxID.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsDocente().toArray(new Integer[0])));
	    comboBoxID.setBounds(40, 5, 200, 20);
	    fondo2.add(comboBoxID);
		
		


		JTextField datos_nombre = new JTextField();
        JTextField datos_apePaterno = new JTextField();			
        JTextField datos_apeMaterno = new JTextField();
        JTextField datos_correo = new JTextField();
        JTextField datos_direccion = new JTextField();
		
		
		RoundButtonRojo Volver = new RoundButtonRojo("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				anterior = actual;
				actual = "menuDocentes";
				add(menuDocentes());
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
		    	int idConsultar = (int) comboBoxID.getSelectedItem();
				BD bd = new BD();
			    try {
			        Connection cn = bd.Conectar();
			        Statement stm = cn.createStatement();
			        ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");

			        
			        
			        while (rs.next()) {
			        	
			        	int id = rs.getInt("idDocente");
			           
			        	if(idConsultar == id) {
			        		String nombre = rs.getString("Nombre");
			        		String correo = rs.getString("Correo");
				            String apellidoP = rs.getString("Apellido Paterno");
				            String apellidoM = rs.getString("Apellido Materno");
				            String direccion = rs.getString("Direccion");
				            
				           
				            datos_nombre.setText(nombre);
				            datos_apePaterno.setText(apellidoP);
				            datos_apeMaterno.setText(apellidoM);
				            datos_correo.setText(correo);
				            datos_direccion.setText(direccion);		  
				            cambio++;
			        	}
			        }

			        rs.close();
			        stm.close();
			        cn.close();
			    } catch (SQLException e1) {
			        e1.printStackTrace();
			    }
			    
			    if(cambio==0) {
			    	JOptionPane.showMessageDialog(null, "ID de alumno invalido. Favor de intentar denuevo");
			    }
			    cambio=0;
				
		        try {
		            // Crear el archivo PDF
		            PdfWriter writer = new PdfWriter(new FileOutputStream("credencialDocente.pdf"));
		            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
		            com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);

		            
		            // Agregar las imágenes al documento
		            com.itextpdf.layout.element.Image imagen1 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("img/credencialDF.png"));
		            com.itextpdf.layout.element.Image imagen2 = new com.itextpdf.layout.element.Image(ImageDataFactory.create("img/credencialDT.png"));
		            document.add(imagen1);
		            document.add(imagen2);
		            
		            // Crear una capa para el texto
		            PdfPage page = pdfDoc.addNewPage();
		            com.itextpdf.kernel.pdf.layer.PdfLayer textLayer = new PdfLayer("Text Layer", pdfDoc);	  
		            PdfCanvas canvas = new PdfCanvas(page);
		            canvas.beginLayer(textLayer);
		            canvas.endLayer();

		            
		            // Agregar el texto a la capa de texto
		            PdfCanvas textCanvas = new PdfCanvas(pdfDoc.getPage(1));
		            PdfFont defaultFont = PdfFontFactory.createFont();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 750).showText(datos_nombre.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 710).showText(datos_apePaterno.getText()+" "+datos_apeMaterno.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 662).showText(datos_correo.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 12).moveText(145, 621).showText(datos_direccion.getText()).endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 14).moveText(345, 502).showText("2023").endText();
		            textCanvas.beginText().setFontAndSize(defaultFont, 14).moveText(345, 474).showText("2024").endText();
		            textLayer.setOn(true);

		          

		            // Cerrar el documento
		            document.close();

		            JOptionPane.showMessageDialog(null, "El archivo PDF se ha generado correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
		        } catch (FileNotFoundException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
		        } catch (MalformedURLException e1) {
		            e1.printStackTrace();
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		});





		Descargar.setForeground(new Color(255, 255, 255));
		Descargar.setBackground(new Color(0, 128, 255));
		Descargar.setBounds(342, 514, 95, 36);
		fondo.add(Descargar);
		
		JLabel imagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/credencialDF.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen.setIcon(imageIcon);
		imagen.setBounds(40, 30, 400, 200);
		fondo2.add(imagen);
		
		JLabel imagen2 = new JLabel("");
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("img/credencialDT.png").getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT));
		imagen2.setIcon(imageIcon2);
		imagen2.setBounds(40, 230, 400, 200);
		fondo2.add(imagen2);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(225, 225, 225));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
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
		if(actual.equals("menuPrincipal")){
			panel = menuPrincipal(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("menuAlumnos")){
			panel = menuAlumnos(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("menuDocentes")){
			panel = menuDocentes(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("menuGrupos")){
			panel = menuGrupos(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		if(actual.equals("menuAsignaturas")){
			panel = menuAsignaturas(); 
			
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

	
	///////////////////CLASES PARA EL BOTON EN TABLA////////////////////////////
	class ButtonRenderer extends JButton implements TableCellRenderer {
	    public ButtonRenderer() {
	        setOpaque(true);
	        setBorderPainted(false);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setBackground(table.getSelectionBackground());
	        } else {
	            setBackground(table.getBackground());
	        }
	        setText("Eliminar");
	        setForeground(new Color(255, 255, 255));
	        setBackground(new Color(255, 0, 0));
	        return this;
	    }
	}
	
	class ButtonRenderer2 extends JButton implements TableCellRenderer {
	    public ButtonRenderer2() {
	        setOpaque(true);
	        setBorderPainted(false);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table2, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setBackground(table2.getSelectionBackground());
	        } else {
	            setBackground(table2.getBackground());
	        }
	        setText("Eliminar");
	        setForeground(new Color(255, 255, 255));
	        setBackground(new Color(255, 0, 0));
	        return this;
	    }
	}
	
	class ButtonRenderer3 extends JButton implements TableCellRenderer {
	    public ButtonRenderer3() {
	        setOpaque(true);
	        setBorderPainted(false);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table3, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setBackground(table3.getSelectionBackground());
	        } else {
	            setBackground(table3.getBackground());
	        }
	        setText("Eliminar");
	        setForeground(new Color(255, 255, 255));
	        setBackground(new Color(255, 0, 0));
	        return this;
	    }
	}
	
	class ButtonRenderer4 extends JButton implements TableCellRenderer {
	    public ButtonRenderer4() {
	        setOpaque(true);
	        setBorderPainted(false);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table4, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setBackground(table4.getSelectionBackground());
	        } else {
	            setBackground(table4.getBackground());
	        }
	        setText("Eliminar");
	        setForeground(new Color(255, 255, 255));
	        setBackground(new Color(255, 0, 0));
	        return this;
	    }
	}
	
	

	private class ButtonEditor extends DefaultCellEditor {

        public ButtonEditor() {
            super(new JTextField());
            setClickCountToStart(1);

            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int filaEliminada = table.getSelectedRow();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int idAlumno = (int) model.getValueAt(filaEliminada, 0);
                    model.removeRow(filaEliminada);
                    table.setModel(model);

                    BD bd = new BD();
                    try {
                        Connection cn = bd.Conectar();
                        Statement stm = cn.createStatement();
                        String sql = "DELETE FROM alumnosbd WHERE idAlumnos = " + idAlumno;
                        stm.executeUpdate(sql);
                        stm.close();
                        cn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }

        public Object getCellEditorValue() {
            return "";
        }

        public boolean stopCellEditing() {
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private class ButtonEditor2 extends DefaultCellEditor {

        public ButtonEditor2() {
            super(new JTextField());
            setClickCountToStart(1);

            button2 = new JButton();
            button2.setOpaque(true);
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int filaEliminada = table2.getSelectedRow();
                    DefaultTableModel model = (DefaultTableModel) table2.getModel();
                    int idDocente = (int) model.getValueAt(filaEliminada, 0);
                    model.removeRow(filaEliminada);
                    table2.setModel(model);

                    BD bd = new BD();
                    try {
                        Connection cn = bd.Conectar();
                        Statement stm = cn.createStatement();
                        String sql = "DELETE FROM docentesbd WHERE idDocente = " + idDocente;
                        stm.executeUpdate(sql);
                        stm.close();
                        cn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button2;
        }
        
        
        public Object getCellEditorValue() {
            return "";
        }

        public boolean stopCellEditing() {
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
    
    private class ButtonEditor3 extends DefaultCellEditor {

        public ButtonEditor3() {
            super(new JTextField());
            setClickCountToStart(1);

            button3 = new JButton();
            button3.setOpaque(true);
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int filaEliminada = table3.getSelectedRow();
                    DefaultTableModel model = (DefaultTableModel) table3.getModel();
                    int idGrupo = (int) model.getValueAt(filaEliminada, 0);
                    model.removeRow(filaEliminada);
                    table3.setModel(model);

                    BD bd = new BD();
                    try {
                        Connection cn = bd.Conectar();
                        Statement stm = cn.createStatement();
                        String sql = "DELETE FROM gruposbd WHERE idGrupos = " + idGrupo;
                        stm.executeUpdate(sql);
                        stm.close();
                        cn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button3;
        }
        
        public Object getCellEditorValue() {
            return "";
        }

        public boolean stopCellEditing() {
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
    
    private class ButtonEditor4 extends DefaultCellEditor {

        public ButtonEditor4() {
            super(new JTextField());
            setClickCountToStart(1);

            button4 = new JButton();
            button4.setOpaque(true);
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int filaEliminada = table4.getSelectedRow();
                    DefaultTableModel model = (DefaultTableModel) table4.getModel();
                    int idAsignatura = (int) model.getValueAt(filaEliminada, 0);
                    model.removeRow(filaEliminada);
                    table4.setModel(model);

                    BD bd = new BD();
                    try {
                        Connection cn = bd.Conectar();
                        Statement stm = cn.createStatement();
                        String sql = "DELETE FROM gruposbd WHERE idAsignatura = " + idAsignatura;
                        stm.executeUpdate(sql);
                        stm.close();
                        cn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button4;
        }
        
        public Object getCellEditorValue() {
            return "";
        }

        public boolean stopCellEditing() {
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
    
    
    
	//////////////////////////GETTERS Y SETTERS//////////////////////////////////
	public JTextField getTxtApellidoPaterno() {
		return txtApellidoPaterno;
	}

	public void setTxtApellidoPaterno(JTextField txtApellidoPaterno) {
		this.txtApellidoPaterno = txtApellidoPaterno;
	}

	public JTextField getTxtApellidoMaterno() {
		return txtApellidoMaterno;
	}

	public void setTxtApellidoMaterno(JTextField txtApellidoMaterno) {
		this.txtApellidoMaterno = txtApellidoMaterno;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	
	public JButton getBtnGuardarDocente() {
		return btnGuardarDocente;
	}

	public void setBtnGuardarDocente(JButton btnGuardarDocente) {
		
		this.btnGuardarDocente = btnGuardarDocente;
	}

	public class RoundButton extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButton(String text) {
	        super(text);
	        this.colorFondo = new Color(64, 173, 72);
	        this.ancho = 50;
	        this.largo = 50;
	        setFont(new Font("Century", Font.PLAIN, 34));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }

	    @Override
	    protected void paintBorder(Graphics g) {
	        g.setColor(Color.BLACK);
	        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public class RoundButtonRojo extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButtonRojo(String text) {
	        super(text);
	        this.colorFondo = new Color(255,0,0);
	        this.ancho = 30;
	        this.largo = 30;
	        setFont(new Font("SansSerif", Font.PLAIN, 17));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public class RoundButtonRojoBorde extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButtonRojoBorde(String text) {
	        super(text);
	        this.colorFondo = new Color(255,0,0);
	        this.ancho = 30;
	        this.largo = 30;
	        setFont(new Font("SansSerif", Font.PLAIN, 17));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }
	    
	    @Override
	    protected void paintBorder(Graphics g) {
	        g.setColor(Color.WHITE);
	        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public class RoundButtonVerde extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButtonVerde(String text) {
	        super(text);
	        this.colorFondo = new Color(0, 255, 64);
	        this.ancho = 30;
	        this.largo = 30;
	        setFont(new Font("SansSerif", Font.PLAIN, 17));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public class RoundButtonVerdeBorde extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButtonVerdeBorde(String text) {
	        super(text);
	        this.colorFondo = new Color(255,0,0);
	        this.ancho = 30;
	        this.largo = 30;
	        setFont(new Font("SansSerif", Font.PLAIN, 17));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }
	    
	    @Override
	    protected void paintBorder(Graphics g) {
	        g.setColor(Color.WHITE);
	        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public class RoundButtonAzul extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButtonAzul(String text) {
	        super(text);
	        this.colorFondo = new Color(0, 128, 255);
	        this.ancho = 10;
	        this.largo = 10;
	        setFont(new Font("SansSerif", Font.PLAIN, 17));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public class RoundButtonAzulBorde extends JButton {
	    public Color colorFondo;
	    public int ancho;
	    public int largo;

	    public RoundButtonAzulBorde(String text) {
	        super(text);
	        this.colorFondo = new Color(255,0,0);
	        this.ancho = 30;
	        this.largo = 30;
	        setFont(new Font("SansSerif", Font.PLAIN, 17));
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        if (getModel().isArmed()) {
	            g.setColor(colorFondo.darker());
	        } else {
	            g.setColor(colorFondo);
	        }

	        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	        super.paintComponent(g);
	    }
	    
	    @Override
	    protected void paintBorder(Graphics g) {
	        g.setColor(Color.WHITE);
	        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ancho, largo);
	    }

	    @Override
	    public boolean contains(int x, int y) {
	        Shape forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ancho, largo);
	        return forma.contains(x, y);
	    }
	}
	
	public JButton getBtnGuardarAsignatura() {
		return btnGuardarAsignatura;
	}

	public void setBtnGuardarAsignatura(JButton btnGuardarAsignatura) {
		this.btnGuardarAsignatura = btnGuardarAsignatura;
	}

	public JButton getBtnGuardarGrupo() {
		return btnGuardarGrupo;
	}

	public void setBtnGuardarGrupo(JButton btnGuardarGrupo) {
		this.btnGuardarGrupo = btnGuardarGrupo;
	}
	
	
	
}


