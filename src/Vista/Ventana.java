package Vista;
import java.awt.BorderLayout;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import java.awt.*;
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
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.kernel.colors.DeviceRgb;
import java.awt.Dimension;

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

	    // Variables para control de intentos fallidos
	    final int[] intentosFallidos = {0};
	    final int maxIntentos = 3;
	    final int tiempoBloqueo = 30000; // 30 segundos en milisegundos

	    JPanel fondo = new JPanel();
	    fondo.setLayout(null);
	    fondo.setBackground(Color.WHITE);
	    fondo.setBounds(0, 0, 800, 800);
	    getContentPane().add(fondo);

	    // [Resto del código de inicialización de componentes igual...]
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

	    // Etiqueta para mensajes de bloqueo
	    JLabel mensajeBloqueo = new JLabel("");
	    mensajeBloqueo.setForeground(Color.RED);
	    mensajeBloqueo.setHorizontalAlignment(SwingConstants.CENTER);
	    mensajeBloqueo.setFont(new Font("SansSerif", Font.BOLD, 14));
	    mensajeBloqueo.setBounds(350, 550, 300, 30);
	    fondo.add(mensajeBloqueo);

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
	            // Si los campos están desactivados (bloqueados), no hacer nada
	            if (!username.isEnabled()) {
	                return;
	            }

	            String usuario = username.getText();
	            char[] passwordChars = password.getPassword();
	            String pass = new String(passwordChars);
	            Arrays.fill(passwordChars, ' ');

	            BD bd = new BD();
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT * FROM admin");

	                boolean credencialesCorrectas = false;
	                while (rs.next()) {
	                    String nombre = rs.getString("Nombre");
	                    String contrasena = rs.getString("Contrasena");

	                    if (usuario.equals(nombre) && pass.equals(contrasena)) {
	                        credencialesCorrectas = true;
	                        JOptionPane.showMessageDialog(null, "¡Datos correctos. Bienvenido " + nombre + "!");
	                        remove(fondo);
	                        anterior = actual;
	                        actual = "menuPrincipal";
	                        add(menuPrincipal());
	                        repaint();
	                        // Reiniciar contador de intentos al éxito
	                        intentosFallidos[0] = 0;
	                        break;
	                    }
	                }

	                if (!credencialesCorrectas) {
	                    intentosFallidos[0]++;
	                    if (intentosFallidos[0] >= maxIntentos) {
	                        // Bloquear campos
	                        username.setEnabled(false);
	                        password.setEnabled(false);
	                        btnAccess.setEnabled(false);
	                        mensajeBloqueo.setText("Demasiados intentos. Espere 30 segundos.");
	                        
	                        // Temporizador para reactivar campos
	                        Timer timer = new Timer(tiempoBloqueo, ev -> {
	                            username.setEnabled(true);
	                            password.setEnabled(true);
	                            btnAccess.setEnabled(true);
	                            mensajeBloqueo.setText("");
	                            username.setText("");
	                            password.setText("");
	                            intentosFallidos[0] = 0; // Reiniciar contador
	                        });
	                        timer.setRepeats(false);
	                        timer.start();
	                    } else {
	                        JOptionPane.showMessageDialog(null, 
	                            "Datos incorrectos. Intente de nuevo. " + 
	                            (maxIntentos - intentosFallidos[0]) + " intentos restantes.");
	                    }
	                }
	                
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

	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(166, 153, 103));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);

	    // Título centrado
	    JLabel Titulo = new JLabel("Bienvenido Admin", SwingConstants.CENTER);
	    Titulo.setFont(new Font("Times New Roman", Font.PLAIN, 40));
	    Titulo.setForeground(Color.BLACK);
	    Titulo.setBounds(200, 40, 400, 50);
	    fondo.add(Titulo);

	    // --------------------- Botón Alumnos ---------------------
	    JLabel tag1 = new JLabel(new ImageIcon(new ImageIcon("img/alumnos.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
	    tag1.setBounds(100, 130, 80, 80);
	    fondo.add(tag1);

	    RoundButton botonAlumnos = new RoundButton("Alumnos");
	    botonAlumnos.setBounds(200, 130, 500, 80);
	    botonAlumnos.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuAlumnos";
	        add(menuAlumnos());
	        repaint();
	        revalidate();
	    });
	    fondo.add(botonAlumnos);

	    // --------------------- Botón Docentes ---------------------
	    JLabel tag2 = new JLabel(new ImageIcon(new ImageIcon("img/docentes.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
	    tag2.setBounds(100, 230, 80, 80);
	    fondo.add(tag2);

	    RoundButton botonDocentes = new RoundButton("Docentes");
	    botonDocentes.setBounds(200, 230, 500, 80);
	    botonDocentes.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuDocentes";
	        add(menuDocentes());
	        repaint();
	        revalidate();
	    });
	    fondo.add(botonDocentes);

	    // --------------------- Botón Grupos ---------------------
	    JLabel tag3 = new JLabel(new ImageIcon(new ImageIcon("img/grupo.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
	    tag3.setBounds(100, 330, 80, 80);
	    fondo.add(tag3);

	    RoundButton botonGrupos = new RoundButton("Grupos");
	    botonGrupos.setBounds(200, 330, 500, 80);
	    botonGrupos.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuGrupos";
	        add(menuGrupos());
	        repaint();
	        revalidate();
	    });
	    fondo.add(botonGrupos);

	    // --------------------- Botón Asignaturas ---------------------
	    JLabel tag4 = new JLabel(new ImageIcon(new ImageIcon("img/asignatura.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
	    tag4.setBounds(100, 430, 80, 80);
	    fondo.add(tag4);

	    RoundButton botonAsignaturas = new RoundButton("Asignaturas");
	    botonAsignaturas.setBounds(200, 430, 500, 80);
	    botonAsignaturas.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuAsignaturas";
	        add(menuAsignaturas());
	        repaint();
	        revalidate();
	    });
	    fondo.add(botonAsignaturas);

	    // --------------------- Botón Cerrar Sesión ---------------------
	    RoundButtonRojo btnCerrarSesion = new RoundButtonRojo("Cerrar Sesión");
	    btnCerrarSesion.setFont(new Font("SansSerif", Font.BOLD, 12));
	    btnCerrarSesion.setForeground(Color.WHITE);
	    btnCerrarSesion.setBackground(Color.RED);
	    btnCerrarSesion.setBounds(600, 680, 130, 30);
	    btnCerrarSesion.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "login";
	        add(login());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnCerrarSesion);

	    // --------------------- Imagen de fondo decorativa con esquinas redondeadas ---------------------
	    RoundedImageLabel fondomenuPrincipal = new RoundedImageLabel(30); // 30px de radio
	    fondomenuPrincipal.setIcon(new ImageIcon(new ImageIcon("img/uacbsfondo.png").getImage().getScaledInstance(800, 550, Image.SCALE_SMOOTH)));
	    fondomenuPrincipal.setBounds(40, 100, 700, 550);
	    fondo.add(fondomenuPrincipal);

	    // Asegura que fondo sea visible al frente
	    fondo.setComponentZOrder(fondomenuPrincipal, fondo.getComponentCount() - 1);

	    this.add(fondo);
	    return fondo;
	}

	////FUNCIONES MENUS////
	public JPanel menuGrupos() {
		anterior = actual;
		actual = "menuGrupos";

		// Panel principal con dimensiones 800x800
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 800, 800);
		fondo.setLayout(null);
		getContentPane().add(fondo);

		// Título principal
		JLabel titulo = new JLabel("GRUPOS");
		titulo.setForeground(Color.BLACK);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("SansSerif", Font.PLAIN, 40));
		titulo.setBounds(200, 30, 400, 50);
		fondo.add(titulo);

		// Etiqueta 'Consultar'
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 28));
		lblConsultar.setBounds(340, 100, 120, 30);
		fondo.add(lblConsultar);

		// Botón Consultar
		RoundButton btnConsultarGrupo = new RoundButton("");
		ImageIcon icono = new ImageIcon("img/consulta.png");
		Image imagen = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnConsultarGrupo.setIcon(new ImageIcon(imagen));
		btnConsultarGrupo.setBackground(new Color(121, 255, 145));
		btnConsultarGrupo.setBounds(325, 140, 150, 150);
		btnConsultarGrupo.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnConsultarGrupo.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "consultarGrupo";
			add(consultarGrupo());
			repaint();
			revalidate();
		});
		fondo.add(btnConsultarGrupo);

		// Etiqueta 'Crear'
		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 28));
		lblCrear.setBounds(220, 340, 100, 30);
		fondo.add(lblCrear);

		// Botón Crear
		RoundButton btnCrearGrupo = new RoundButton("");
		ImageIcon icono2 = new ImageIcon("img/crearicono.png");
		Image imagen2 = icono2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnCrearGrupo.setIcon(new ImageIcon(imagen2));
		btnCrearGrupo.setBackground(new Color(121, 255, 145));
		btnCrearGrupo.setBounds(175, 380, 150, 150);
		btnCrearGrupo.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnCrearGrupo.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "crearGrupo";
			add(crearGrupo());
			repaint();
			revalidate();
		});
		fondo.add(btnCrearGrupo);

		// Etiqueta 'Eliminar'
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 28));
		lblEliminar.setBounds(520, 340, 120, 30);
		fondo.add(lblEliminar);

		// Botón Eliminar
		RoundButton btnEliminarGrupo = new RoundButton("");
		ImageIcon icono3 = new ImageIcon("img/eliminaricono.png");
		Image imagen3 = icono3.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnEliminarGrupo.setIcon(new ImageIcon(imagen3));
		btnEliminarGrupo.setBackground(new Color(121, 255, 145));
		btnEliminarGrupo.setBounds(495, 380, 150, 150);
		btnEliminarGrupo.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnEliminarGrupo.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "eliminarGrupo";
			add(eliminarGrupo());
			repaint();
			revalidate();
		});
		fondo.add(btnEliminarGrupo);

		// Botón Volver
		RoundButtonRojoBorde volver = new RoundButtonRojoBorde("Volver");
		volver.setForeground(Color.WHITE);
		volver.setBackground(Color.RED);
		volver.setFont(new Font("SansSerif", Font.BOLD, 14));
		volver.setBounds(650, 690, 100, 30);
		volver.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "menuPrincipal";
			add(menuPrincipal());
			repaint();
			revalidate();
		});
		fondo.add(volver);

		// Fondo decorativo
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(
			new ImageIcon("img/menu.png").getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT)
		);
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(-10, -25, 800, 800);
		fondo.add(fondoMenu);

		this.add(fondo);
		return fondo;
	}

	
	public JPanel menuAlumnos() {
	    anterior = actual;
	    actual = "menuAlumnos";

	    // Crear panel principal y establecer fondo
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(128, 128, 128));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);

	    // Título principal
	    JLabel Titulo = new JLabel("ALUMNOS");
	    Titulo.setForeground(Color.BLACK);
	    Titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    Titulo.setFont(new Font("SansSerif", Font.PLAIN, 40));
	    Titulo.setBounds(200, 30, 400, 50);
	    fondo.add(Titulo);

	    // Etiquetas
	    JLabel lblCredencial = new JLabel("Credencial");
	    lblCredencial.setForeground(new Color(121, 255, 145));
	    lblCredencial.setFont(new Font("Tahoma", Font.PLAIN, 24));
	    lblCredencial.setBounds(160, 120, 150, 30);
	    fondo.add(lblCredencial);

	    JLabel lblConsultar = new JLabel("Consultar");
	    lblConsultar.setForeground(new Color(121, 255, 145));
	    lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 24));
	    lblConsultar.setBounds(500, 120, 150, 30);
	    fondo.add(lblConsultar);

	    JLabel lblCrear = new JLabel("Crear");
	    lblCrear.setForeground(new Color(121, 255, 145));
	    lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 24));
	    lblCrear.setBounds(200, 440, 100, 30);
	    fondo.add(lblCrear);

	    JLabel lblEliminar = new JLabel("Eliminar");
	    lblEliminar.setForeground(new Color(121, 255, 145));
	    lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 24));
	    lblEliminar.setBounds(520, 440, 120, 30);
	    fondo.add(lblEliminar);

	    // Botón Credencial
	    RoundButton btnCredAlu = new RoundButton("");
	    ImageIcon icono = new ImageIcon("img/credencial.png");
	    btnCredAlu.setIcon(new ImageIcon(icono.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
	    btnCredAlu.setBackground(new Color(121, 255, 145));
	    btnCredAlu.setBounds(140, 160, 180, 180);
	    btnCredAlu.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "credencialAlumno";
	        add(credencialAlumno());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnCredAlu);

	    // Botón Consultar
	    RoundButton btnConsultarAlu = new RoundButton("");
	    ImageIcon icono2 = new ImageIcon("img/consulta.png");
	    btnConsultarAlu.setIcon(new ImageIcon(icono2.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
	    btnConsultarAlu.setBackground(new Color(121, 255, 145));
	    btnConsultarAlu.setBounds(480, 160, 180, 180);
	    btnConsultarAlu.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "consultarAlumno";
	        add(consultarAlumno());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnConsultarAlu);

	    // Botón Crear
	    RoundButton btnCrearAlu = new RoundButton("");
	    ImageIcon icono3 = new ImageIcon("img/crearicono.png");
	    btnCrearAlu.setIcon(new ImageIcon(icono3.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
	    btnCrearAlu.setBackground(new Color(121, 255, 145));
	    btnCrearAlu.setBounds(140, 480, 180, 180);
	    btnCrearAlu.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "crearAlumno";
	        add(crearAlumno());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnCrearAlu);

	    // Botón Eliminar
	    RoundButton btnEliminarAlu = new RoundButton("");
	    ImageIcon icono4 = new ImageIcon("img/eliminaricono.png");
	    btnEliminarAlu.setIcon(new ImageIcon(icono4.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
	    btnEliminarAlu.setBackground(new Color(121, 255, 145));
	    btnEliminarAlu.setBounds(480, 480, 180, 180);
	    btnEliminarAlu.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "eliminarAlumno";
	        add(eliminarAlumno());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnEliminarAlu);

	    // Botón Volver
	    RoundButtonRojoBorde Volver = new RoundButtonRojoBorde("Volver");
	    Volver.setForeground(Color.WHITE);
	    Volver.setBackground(Color.RED);
	    Volver.setBounds(650, 690, 100, 30);
	    Volver.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuPrincipal";
	        add(menuPrincipal());
	        repaint();
	        revalidate();
	    });
	    fondo.add(Volver);

	    // Imagen de fondo
	    JLabel fondoMenu = new JLabel();
	    ImageIcon imageFondo = new ImageIcon(new ImageIcon("img/menu.png").getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT));
	    fondoMenu.setIcon(imageFondo);
	    fondoMenu.setBounds(-10, -25, 800, 800);
	    fondo.add(fondoMenu);

	    this.add(fondo);
	    return fondo;
	}


	public JPanel menuDocentes() {
		anterior = actual;
		actual = "menuDocentes";

		// Panel principal de fondo
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 800, 800); // Ajuste al nuevo tamaño
		fondo.setLayout(null);
		getContentPane().add(fondo);

		// Título principal
		JLabel Titulo = new JLabel("DOCENTES");
		Titulo.setForeground(Color.BLACK);
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 40));
		Titulo.setBounds(200, 30, 400, 50);
		fondo.add(Titulo);

		// Etiquetas de acción
		JLabel lblCredencial = new JLabel("Credencial");
		lblCredencial.setForeground(new Color(121, 255, 145));
		lblCredencial.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCredencial.setBounds(180, 120, 130, 30);
		fondo.add(lblCredencial);

		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblConsultar.setBounds(500, 120, 130, 30);
		fondo.add(lblConsultar);

		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblCrear.setBounds(210, 390, 100, 30);
		fondo.add(lblCrear);

		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblEliminar.setBounds(510, 390, 120, 30);
		fondo.add(lblEliminar);

		// Botón Credencial
		RoundButton btnCredDoce = new RoundButton("");
		btnCredDoce.setIcon(escalarIcono("img/credencial.png"));
		btnCredDoce.setBackground(new Color(121, 255, 145));
		btnCredDoce.setBounds(160, 160, 180, 180);
		btnCredDoce.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "credencialDocente";
			add(credencialDocente());
			repaint();
			revalidate();
		});
		fondo.add(btnCredDoce);

		// Botón Consultar
		RoundButton btnConsultarDoce = new RoundButton("");
		btnConsultarDoce.setIcon(escalarIcono("img/consulta.png"));
		btnConsultarDoce.setBackground(new Color(121, 255, 145));
		btnConsultarDoce.setBounds(460, 160, 180, 180);
		btnConsultarDoce.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "consultarDocente";
			add(consultarDocente());
			repaint();
			revalidate();
		});
		fondo.add(btnConsultarDoce);

		// Botón Crear
		RoundButton btnCrearDoce = new RoundButton("");
		btnCrearDoce.setIcon(escalarIcono("img/crearicono.png"));
		btnCrearDoce.setBackground(new Color(121, 255, 145));
		btnCrearDoce.setBounds(160, 430, 180, 180);
		btnCrearDoce.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "crearDocente";
			add(crearDocente());
			repaint();
			revalidate();
		});
		fondo.add(btnCrearDoce);

		// Botón Eliminar
		RoundButton btnEliminarDoce = new RoundButton("");
		btnEliminarDoce.setIcon(escalarIcono("img/eliminaricono.png"));
		btnEliminarDoce.setBackground(new Color(121, 255, 145));
		btnEliminarDoce.setBounds(460, 430, 180, 180);
		btnEliminarDoce.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "eliminarDocente";
			add(eliminarDocente());
			repaint();
			revalidate();
		});
		fondo.add(btnEliminarDoce);

		// Botón Volver
		RoundButtonRojoBorde Volver = new RoundButtonRojoBorde("Volver");
		Volver.setForeground(Color.WHITE);
		Volver.setBackground(Color.RED);
		Volver.setBounds(650, 690, 100, 30);
		Volver.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "menuPrincipal";
			add(menuPrincipal());
			repaint();
			revalidate();
		});
		fondo.add(Volver);

		// Fondo visual decorativo
		JLabel fondoMenu = new JLabel("");
		ImageIcon imageFondo = new ImageIcon(
			new ImageIcon("img/menu.png").getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH)
		);
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(-10, -25, 800, 800);
		fondo.add(fondoMenu);

		return fondo;
	}

	private ImageIcon escalarIcono(String ruta) {
		ImageIcon icono = new ImageIcon(ruta);
		Image imagen = icono.getImage();
		Image redimensionada = imagen.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		return new ImageIcon(redimensionada);
	}

	
	public JPanel menuAsignaturas() {
		anterior = actual;
		actual = "menuAsignaturas";

		// Panel de fondo principal
		JPanel fondo = new JPanel();
		fondo.setBackground(new Color(128, 128, 128));
		fondo.setBounds(0, 0, 800, 800);
		fondo.setLayout(null);
		getContentPane().add(fondo);

		// Título principal
		JLabel Titulo = new JLabel("ASIGNATURAS");
		Titulo.setForeground(Color.BLACK);
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("SansSerif", Font.PLAIN, 40));
		Titulo.setBounds(200, 30, 400, 50);
		fondo.add(Titulo);

		// Etiquetas
		JLabel lblConsultar = new JLabel("Consultar");
		lblConsultar.setForeground(new Color(121, 255, 145));
		lblConsultar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblConsultar.setBounds(344, 100, 120, 30); // Centrado arriba
		fondo.add(lblConsultar);

		JLabel lblCrear = new JLabel("Crear");
		lblCrear.setForeground(new Color(121, 255, 145));
		lblCrear.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblCrear.setBounds(200, 400, 100, 30);
		fondo.add(lblCrear);

		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(new Color(121, 255, 145));
		lblEliminar.setFont(new Font("SansSerif", Font.PLAIN, 24));
		lblEliminar.setBounds(500, 400, 100, 30);
		fondo.add(lblEliminar);

		// Botón Consultar
		RoundButton btnConsultarAsi = new RoundButton("");
		ImageIcon icono = new ImageIcon("img/consulta.png");
		Image imagen = icono.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnConsultarAsi.setIcon(new ImageIcon(imagen));
		btnConsultarAsi.setBackground(new Color(121, 255, 145));
		btnConsultarAsi.setBounds(325, 140, 150, 150);
		btnConsultarAsi.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "consultarAsignatura";
			add(consultarAsignatura());
			repaint();
			revalidate();
		});
		fondo.add(btnConsultarAsi);

		// Botón Crear
		RoundButton btnCrearAsi = new RoundButton("");
		ImageIcon icono2 = new ImageIcon("img/crearicono.png");
		Image imagen2 = icono2.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnCrearAsi.setIcon(new ImageIcon(imagen2));
		btnCrearAsi.setBackground(new Color(121, 255, 145));
		btnCrearAsi.setBounds(175, 440, 150, 150);
		btnCrearAsi.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "crearAsignatura";
			add(crearAsignatura());
			repaint();
			revalidate();
		});
		fondo.add(btnCrearAsi);

		// Botón Eliminar
		RoundButton btnEliminarAsi = new RoundButton("");
		ImageIcon icono3 = new ImageIcon("img/eliminaricono.png");
		Image imagen3 = icono3.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		btnEliminarAsi.setIcon(new ImageIcon(imagen3));
		btnEliminarAsi.setBackground(new Color(121, 255, 145));
		btnEliminarAsi.setBounds(475, 440, 150, 150);
		btnEliminarAsi.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "eliminarAsignatura";
			add(eliminarAsignatura());
			repaint();
			revalidate();
		});
		fondo.add(btnEliminarAsi);

		// Botón Volver
		RoundButtonRojoBorde btnVolver = new RoundButtonRojoBorde("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(255, 0, 0));
		btnVolver.setBounds(650, 690, 100, 30);
		btnVolver.addActionListener(e -> {
			remove(fondo);
			anterior = actual;
			actual = "menuPrincipal";
			add(menuPrincipal());
			repaint();
			revalidate();
		});
		fondo.add(btnVolver);

		// Fondo de imagen decorativa (último para estar atrás)
		JLabel fondoMenu = new JLabel();
		ImageIcon imageFondo = new ImageIcon(
			new ImageIcon("img/menu.png").getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT)
		);
		fondoMenu.setIcon(imageFondo);
		fondoMenu.setBounds(-10, -25, 800, 800);
		fondo.add(fondoMenu);

		this.add(fondo);
		return fondo;
	}

	
	
	////FUNCIONES CREAR//////
	public JPanel crearAlumno() {
	    cvbd = new ControlVistaBD(this);
	    anterior = actual;
	    actual = "crearAlumno";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Cambiado a 800x800
	    fondo.setLayout(null);
	    getContentPane().add(fondo);
	    
	    // Título principal
	    JLabel tituloPrincipal = new JLabel("Alumno - Crear");
	    tituloPrincipal.setForeground(new Color(0, 0, 0));
	    tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
	    tituloPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 40));  // Tamaño de fuente aumentado
	    tituloPrincipal.setBounds(150, 30, 500, 50);  // Ajustado para 800px
	    fondo.add(tituloPrincipal);
	    
	    // Subtítulo (requerimientos)
	    JLabel subtitulo = new JLabel("Obligatorio: Llene todos los campos");
	    subtitulo.setForeground(new Color(255, 0, 0));
	    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    subtitulo.setBounds(150, 80, 500, 30);
	    fondo.add(subtitulo);
	    
	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 130, 600, 500);  // Ajustado para 800px
	    panelContenido.setLayout(null);
	    fondo.add(panelContenido);
	    
	    // ========== CAMPOS DEL FORMULARIO ==========
	    
	    // Nombres
	    JLabel lblNombres = new JLabel("Nombres:");
	    lblNombres.setBounds(50, 30, 150, 30);
	    lblNombres.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblNombres);
	    
	    txtNombre = new JTextField();
	    txtNombre.setBackground(new Color(225, 225, 225));
	    txtNombre.setBounds(50, 60, 500, 30);  // Campo más ancho
	    panelContenido.add(txtNombre);
	    
	    // Apellidos
	    JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
	    lblApellidoPaterno.setBounds(50, 110, 200, 30);
	    lblApellidoPaterno.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblApellidoPaterno);
	    
	    txtApellidoPaterno = new JTextField();
	    txtApellidoPaterno.setBackground(new Color(225, 225, 225));
	    txtApellidoPaterno.setBounds(50, 140, 200, 30);
	    panelContenido.add(txtApellidoPaterno);
	    
	    JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
	    lblApellidoMaterno.setBounds(350, 110, 200, 30);
	    lblApellidoMaterno.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblApellidoMaterno);
	    
	    txtApellidoMaterno = new JTextField();
	    txtApellidoMaterno.setBackground(new Color(225, 225, 225));
	    txtApellidoMaterno.setBounds(350, 140, 200, 30);
	    panelContenido.add(txtApellidoMaterno);
	    
	    // Fecha de nacimiento
	    JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
	    lblFechaNacimiento.setBounds(50, 190, 200, 30);
	    lblFechaNacimiento.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblFechaNacimiento);
	    
	    dia_nacimiento = new JComboBox<String>();
	    dia_nacimiento.setBounds(50, 220, 80, 30);  // Aumentado tamaño
	    panelContenido.add(dia_nacimiento);
	    for(int i = 1; i < 32; i++) {
	        dia_nacimiento.addItem(i);
	    }
	    
	    mes_nacimiento = new JComboBox<String>();
	    mes_nacimiento.setBounds(150, 220, 80, 30);  // Aumentado tamaño
	    panelContenido.add(mes_nacimiento);
	    for(int i = 1; i < 13; i++) {
	        mes_nacimiento.addItem(i);
	    }
	    
	    ano_nacimiento = new JComboBox<String>();
	    ano_nacimiento.setBounds(250, 220, 100, 30);  // Aumentado tamaño
	    panelContenido.add(ano_nacimiento);
	    for(int i = 2005; i > 1899; i--) {
	        ano_nacimiento.addItem(i);
	    }
	    
	    // Obtener fecha actual seleccionada
	    dia = (int) dia_nacimiento.getSelectedItem();
	    mes = (int) mes_nacimiento.getSelectedItem();
	    ano = (int) ano_nacimiento.getSelectedItem();
	    fecha = LocalDate.of(ano, mes, dia);
	    
	    // Correo electrónico
	    JLabel lblCorreo = new JLabel("Correo electrónico:");
	    lblCorreo.setBounds(50, 270, 200, 30);
	    lblCorreo.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblCorreo);
	    
	    txtCorreo = new JTextField();
	    txtCorreo.setBackground(new Color(225, 225, 225));
	    txtCorreo.setBounds(50, 300, 500, 30);
	    panelContenido.add(txtCorreo);
	    
	    // Teléfono
	    JLabel lblTelefono = new JLabel("Teléfono:");
	    lblTelefono.setBounds(50, 350, 200, 30);
	    lblTelefono.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblTelefono);
	    
	    txtTelefono = new JTextField(10);
	    txtTelefono.setBackground(new Color(225, 225, 225));
	    txtTelefono.setBounds(50, 380, 200, 30);
	    
	    // Filtro para solo números (10 dígitos)
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
	    panelContenido.add(txtTelefono);
	    
	    // Foto (opcional)
	    JLabel lblFoto = new JLabel("Foto (Opcional):");
	    lblFoto.setBounds(50, 430, 200, 30);
	    lblFoto.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblFoto);
	    
	    JButton btnSubirArchivo = new JButton("Subir archivo");
	    btnSubirArchivo.setBackground(new Color(192, 192, 192));
	    btnSubirArchivo.setBounds(50, 460, 150, 35);  // Aumentado tamaño
	    btnSubirArchivo.addActionListener(e -> {
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
	    });
	    panelContenido.add(btnSubirArchivo);
	    
	    // Dirección (opcional)
	    JLabel lblDireccion = new JLabel("Dirección (Opcional):");
	    lblDireccion.setBounds(350, 430, 200, 30);
	    lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblDireccion);
	    
	    txtDireccion = new JTextField();
	    txtDireccion.setBackground(new Color(225, 225, 225));
	    txtDireccion.setBounds(350, 460, 200, 35);  // Aumentado tamaño
	    panelContenido.add(txtDireccion);
	    
	    // Grado
	    JLabel lblGrado = new JLabel("Grado:");
	    lblGrado.setBounds(350, 350, 100, 30);
	    lblGrado.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblGrado);
	    
	    comboBox = new JComboBox();
	    comboBox.setBounds(350, 380, 100, 35);  // Aumentado tamaño
	    for(int i = 1; i < 14; i++) {
	        comboBox.addItem(i);
	    }
	    panelContenido.add(comboBox);
	    
	    // ========== BOTONES ==========
	    
	    // Botón Volver
	    RoundButtonRojo btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(Color.RED);
	    btnVolver.setBounds(250, 650, 120, 40);  // Aumentado tamaño y reposicionado
	    btnVolver.addActionListener(e -> {
	        remove(fondo);
	        remove(comboBox);
	        anterior = actual;
	        actual = "menuAlumnos";
	        add(menuAlumnos());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnVolver);
	    
	    // Botón Guardar
	    btnGuardar = new JButton("Guardar");
	    btnGuardar.setForeground(Color.WHITE);
	    btnGuardar.setBackground(new Color(0, 128, 255));
	    btnGuardar.setBounds(450, 650, 120, 40);  // Aumentado tamaño y reposicionado
	    btnGuardar.addActionListener(cvbd);
	    fondo.add(btnGuardar);
	    
	    // Icono decorativo
	    JLabel icono = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	    icono.setIcon(imageIcon);
	    icono.setBounds(650, 30, 80, 80);  // Reposicionado
	    fondo.add(icono);
	    
	    return fondo;
	}
	
	public JPanel crearDocente() {
	    cvbd = new ControlVistaBD(this);
	    anterior = actual;
	    actual = "crearDocente";
	    
	    // Panel principal (800x800)
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);
	    
	    // Título principal
	    JLabel tituloPrincipal = new JLabel("Docente - Crear");
	    tituloPrincipal.setForeground(Color.BLACK);
	    tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
	    tituloPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 40));
	    tituloPrincipal.setBounds(150, 30, 500, 50);
	    fondo.add(tituloPrincipal);
	    
	    // Subtítulo (requerimientos)
	    JLabel subtitulo = new JLabel("Obligatorio: Llene todos los campos");
	    subtitulo.setForeground(Color.RED);
	    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    subtitulo.setBounds(150, 80, 500, 30);
	    fondo.add(subtitulo);
	    
	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 130, 600, 500);
	    panelContenido.setLayout(null);
	    fondo.add(panelContenido);
	    
	    // ========== CAMPOS DEL FORMULARIO ==========
	    
	    // Nombres
	    JLabel lblNombres = new JLabel("Nombres:");
	    lblNombres.setBounds(50, 30, 150, 30);
	    lblNombres.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblNombres);
	    
	    txtNombreD = new JTextField();
	    txtNombreD.setBackground(new Color(225, 225, 225));
	    txtNombreD.setBounds(50, 60, 500, 30);
	    panelContenido.add(txtNombreD);
	    
	    // Apellidos
	    JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
	    lblApellidoPaterno.setBounds(50, 110, 200, 30);
	    lblApellidoPaterno.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblApellidoPaterno);
	    
	    txtApellidoPaternoD = new JTextField();
	    txtApellidoPaternoD.setBackground(new Color(225, 225, 225));
	    txtApellidoPaternoD.setBounds(50, 140, 200, 30);
	    panelContenido.add(txtApellidoPaternoD);
	    
	    JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
	    lblApellidoMaterno.setBounds(350, 110, 200, 30);
	    lblApellidoMaterno.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblApellidoMaterno);
	    
	    txtApellidoMaternoD = new JTextField();
	    txtApellidoMaternoD.setBackground(new Color(225, 225, 225));
	    txtApellidoMaternoD.setBounds(350, 140, 200, 30);
	    panelContenido.add(txtApellidoMaternoD);
	    
	    // Fecha de nacimiento
	    JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento:");
	    lblFechaNacimiento.setBounds(50, 190, 200, 30);
	    lblFechaNacimiento.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblFechaNacimiento);
	    
	    dia_nacimientoD = new JComboBox<String>();
	    dia_nacimientoD.setBounds(50, 220, 80, 30);
	    panelContenido.add(dia_nacimientoD);
	    for(int i = 1; i < 32; i++) {
	        dia_nacimientoD.addItem(i);
	    }
	    
	    mes_nacimientoD = new JComboBox<String>();
	    mes_nacimientoD.setBounds(150, 220, 80, 30);
	    panelContenido.add(mes_nacimientoD);
	    for(int i = 1; i < 13; i++) {
	        mes_nacimientoD.addItem(i);
	    }
	    
	    ano_nacimientoD = new JComboBox<String>();
	    ano_nacimientoD.setBounds(250, 220, 100, 30);
	    panelContenido.add(ano_nacimientoD);
	    for(int i = 2005; i > 1899; i--) {
	        ano_nacimientoD.addItem(i);
	    }
	    
	    // Correo electrónico
	    JLabel lblCorreo = new JLabel("Correo electrónico:");
	    lblCorreo.setBounds(50, 270, 200, 30);
	    lblCorreo.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblCorreo);
	    
	    txtCorreoD = new JTextField();
	    txtCorreoD.setBackground(new Color(225, 225, 225));
	    txtCorreoD.setBounds(50, 300, 500, 30);
	    panelContenido.add(txtCorreoD);
	    
	    // Teléfono
	    JLabel lblTelefono = new JLabel("Teléfono:");
	    lblTelefono.setBounds(50, 350, 200, 30);
	    lblTelefono.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblTelefono);
	    
	    txtTelefonoD = new JTextField(10);
	    txtTelefonoD.setBackground(new Color(225, 225, 225));
	    txtTelefonoD.setBounds(50, 380, 200, 30);
	    
	    // Filtro para solo números (10 dígitos)
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
	    panelContenido.add(txtTelefonoD);
	    
	    // Grado Académico
	    JLabel lblGradoAcademico = new JLabel("Grado Académico:");
	    lblGradoAcademico.setBounds(350, 350, 200, 30);
	    lblGradoAcademico.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblGradoAcademico);
	    
	    comboBoxD = new JComboBox();
	    comboBoxD.setBounds(350, 380, 200, 30);
	    comboBoxD.addItem("Bachiller");
	    comboBoxD.addItem("Licenciado");
	    comboBoxD.addItem("Magíster");
	    comboBoxD.addItem("Doctorado");
	    panelContenido.add(comboBoxD);
	    
	    // Foto (opcional)
	    JLabel lblFoto = new JLabel("Foto (Opcional):");
	    lblFoto.setBounds(50, 430, 200, 30);
	    lblFoto.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblFoto);
	    
	    JButton btnSubirArchivo = new JButton("Subir archivo");
	    btnSubirArchivo.setBackground(new Color(192, 192, 192));
	    btnSubirArchivo.setBounds(50, 460, 150, 35);
	    btnSubirArchivo.addActionListener(e -> {
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
	    });
	    panelContenido.add(btnSubirArchivo);
	    
	    // Dirección (opcional)
	    JLabel lblDireccion = new JLabel("Dirección (Opcional):");
	    lblDireccion.setBounds(350, 430, 200, 30);
	    lblDireccion.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblDireccion);
	    
	    txtDireccionD = new JTextField();
	    txtDireccionD.setBackground(new Color(225, 225, 225));
	    txtDireccionD.setBounds(350, 460, 200, 35);
	    panelContenido.add(txtDireccionD);
	    
	    // ========== BOTONES ==========
	    
	    // Botón Volver
	    RoundButtonRojo btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(Color.RED);
	    btnVolver.setBounds(250, 650, 120, 40);
	    btnVolver.addActionListener(e -> {
	        remove(fondo);
	        remove(comboBoxD);
	        anterior = actual;
	        actual = "menuDocentes";
	        add(menuDocentes());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnVolver);
	    
	    // Botón Guardar
	    btnGuardarDocente = new JButton("Guardar");
	    btnGuardarDocente.setForeground(Color.WHITE);
	    btnGuardarDocente.setBackground(new Color(0, 128, 255));
	    btnGuardarDocente.setBounds(450, 650, 120, 40);
	    btnGuardarDocente.addActionListener(cvbd);
	    fondo.add(btnGuardarDocente);
	    
	    // Icono decorativo
	    JLabel icono = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	    icono.setIcon(imageIcon);
	    icono.setBounds(650, 30, 80, 80);
	    fondo.add(icono);
	    
	    return fondo;
	}

	public JPanel crearGrupo() {
	    cvbd = new ControlVistaBD(this);
	    anterior = actual;
	    actual = "crearGrupo";
	    
	    // Panel principal (800x800)
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);
	    
	    // Título principal
	    JLabel tituloPrincipal = new JLabel("Grupo - Crear");
	    tituloPrincipal.setForeground(Color.BLACK);
	    tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
	    tituloPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 40));
	    tituloPrincipal.setBounds(150, 30, 500, 50);
	    fondo.add(tituloPrincipal);
	    
	    // Subtítulo (requerimientos)
	    JLabel subtitulo = new JLabel("Obligatorio: Llene todos los campos");
	    subtitulo.setForeground(Color.RED);
	    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    subtitulo.setBounds(150, 80, 500, 30);
	    fondo.add(subtitulo);
	    
	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 130, 600, 500);
	    panelContenido.setLayout(null);
	    fondo.add(panelContenido);
	    
	    // ========== CAMPOS DEL FORMULARIO ==========
	    
	    // Carrera
	    JLabel lblCarrera = new JLabel("Carrera:");
	    lblCarrera.setBounds(50, 30, 200, 30);
	    lblCarrera.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblCarrera);
	    
	    carreraG = new JTextField();
	    carreraG.setBackground(new Color(225, 225, 225));
	    carreraG.setBounds(50, 60, 500, 30);
	    panelContenido.add(carreraG);
	    
	    // Asignatura
	    JLabel lblAsignatura = new JLabel("Asignatura:");
	    lblAsignatura.setBounds(50, 110, 200, 30);
	    lblAsignatura.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblAsignatura);
	    
	    asignaturaG = new JComboBox();
	    asignaturaG.setBackground(new Color(225, 225, 225));
	    asignaturaG.setBounds(50, 140, 500, 30);
	    panelContenido.add(asignaturaG);
	    
	    // Cargar asignaturas desde BD
	    BD bd = new BD();
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");
	     
	        while (rs.next()) {
	            String nombre = rs.getString("Nombre");
	            asignaturaG.addItem(nombre);
	        }

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    // Docente a cargo
	    JLabel lblDocente = new JLabel("Docente a cargo:");
	    lblDocente.setBounds(50, 190, 200, 30);
	    lblDocente.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblDocente);
	    
	    docente_a_cargoG = new JComboBox();    
	    docente_a_cargoG.setBackground(new Color(225, 225, 225));
	    docente_a_cargoG.setBounds(50, 220, 500, 30);
	    panelContenido.add(docente_a_cargoG);
	    
	    // Cargar docentes desde BD
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");
	     
	        while (rs.next()) {
	            String nombre = rs.getString("Nombre");
	            docente_a_cargoG.addItem(nombre);
	        }

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    // Semestre
	    JLabel lblSemestre = new JLabel("Semestre:");
	    lblSemestre.setBounds(50, 270, 200, 30);
	    lblSemestre.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblSemestre);
	    
	    semestreG = new JComboBox();
	    semestreG.setBackground(new Color(225, 225, 225));
	    semestreG.setBounds(50, 300, 200, 30);
	    for(int i = 1; i < 10; i++) {
	        semestreG.addItem(i);
	    }
	    panelContenido.add(semestreG);
	    
	    // Número de alumnos
	    JLabel lblNumAlumnos = new JLabel("Número de alumnos (máximo 40):");
	    lblNumAlumnos.setBounds(50, 350, 300, 30);
	    lblNumAlumnos.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblNumAlumnos);
	    
	    num_alu = new JTextField();
	    num_alu.setBackground(new Color(225, 225, 225));
	    num_alu.setBounds(50, 380, 200, 30);
	    
	    // Filtro para solo números (máximo 2 dígitos)
	    AbstractDocument doc = (AbstractDocument) num_alu.getDocument();
	    doc.setDocumentFilter(new DocumentFilter() {
	        private final Pattern pattern = Pattern.compile("\\d{0,2}");

	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	            Matcher matcher = pattern.matcher(newText);
	            if (matcher.matches()) {
	                super.replace(fb, offset, length, text, attrs);
	            }
	        }
	    });
	    panelContenido.add(num_alu);
	    
	    // ========== BOTONES ==========
	    
	    // Botón Volver
	    RoundButtonRojo btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(Color.RED);
	    btnVolver.setBounds(250, 650, 120, 40);
	    btnVolver.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuGrupos";
	        add(menuGrupos());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnVolver);
	    
	    // Botón Guardar
	    btnGuardarGrupo = new JButton("Guardar");
	    btnGuardarGrupo.setForeground(Color.WHITE);
	    btnGuardarGrupo.setBackground(new Color(0, 128, 255));
	    btnGuardarGrupo.setBounds(450, 650, 120, 40);
	    btnGuardarGrupo.addActionListener(cvbd);
	    fondo.add(btnGuardarGrupo);
	    
	    // Icono decorativo
	    JLabel icono = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	    icono.setIcon(imageIcon);
	    icono.setBounds(650, 30, 80, 80);
	    fondo.add(icono);
	    
	    return fondo;
	}
	
	public JPanel crearAsignatura() {
	    cvbd = new ControlVistaBD(this);
	    anterior = actual;
	    actual = "crearAsignatura";
	    
	    // Panel principal (800x800)
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);
	    
	    // Título principal
	    JLabel tituloPrincipal = new JLabel("Asignatura - Crear");
	    tituloPrincipal.setForeground(Color.BLACK);
	    tituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
	    tituloPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 40));
	    tituloPrincipal.setBounds(150, 30, 500, 50);
	    fondo.add(tituloPrincipal);
	    
	    // Subtítulo (requerimientos)
	    JLabel subtitulo = new JLabel("Obligatorio: Llene todos los campos");
	    subtitulo.setForeground(Color.RED);
	    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    subtitulo.setFont(new Font("SansSerif", Font.PLAIN, 20));
	    subtitulo.setBounds(150, 80, 500, 30);
	    fondo.add(subtitulo);
	    
	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 130, 600, 500);
	    panelContenido.setLayout(null);
	    fondo.add(panelContenido);
	    
	    // ========== CAMPOS DEL FORMULARIO ==========
	    
	    // Nombre de la asignatura
	    JLabel lblNombreAsignatura = new JLabel("Nombre de la Asignatura (al menos 2 caracteres):");
	    lblNombreAsignatura.setBounds(50, 30, 500, 30);
	    lblNombreAsignatura.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblNombreAsignatura);
	    
	    nombre_asig = new JTextField();
	    nombre_asig.setBackground(new Color(225, 225, 225));
	    nombre_asig.setBounds(50, 60, 500, 30);
	    panelContenido.add(nombre_asig);
	    
	    // Créditos
	    JLabel lblCreditos = new JLabel("Créditos (al menos un crédito y máximo 20):");
	    lblCreditos.setBounds(50, 110, 400, 30);
	    lblCreditos.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblCreditos);
	    
	    creditos = new JTextField();
	    creditos.setBackground(new Color(225, 225, 225));
	    creditos.setBounds(50, 140, 200, 30);
	    
	    // Filtro para solo números (máximo 2 dígitos)
	    AbstractDocument doc = (AbstractDocument) creditos.getDocument();
	    doc.setDocumentFilter(new DocumentFilter() {
	        private final Pattern pattern = Pattern.compile("\\d{0,2}");

	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
	            Matcher matcher = pattern.matcher(newText);
	            if (matcher.matches()) {
	                super.replace(fb, offset, length, text, attrs);
	            }
	        }
	    });
	    panelContenido.add(creditos);
	    
	    // Docente a cargo
	    JLabel lblDocente = new JLabel("Docente a cargo:");
	    lblDocente.setBounds(50, 190, 200, 30);
	    lblDocente.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblDocente);
	    
	    docente_a_cargo = new JComboBox();
	    docente_a_cargo.setBackground(new Color(225, 225, 225));
	    docente_a_cargo.setBounds(50, 220, 500, 30);
	    panelContenido.add(docente_a_cargo);
	    
	    // Cargar docentes desde BD
	    BD bd = new BD();
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");
	     
	        while (rs.next()) {
	            String nombre = rs.getString("Nombre");
	            docente_a_cargo.addItem(nombre);
	        }

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    // Semestres
	    JLabel lblSemestres = new JLabel("Semestres:");
	    lblSemestres.setBounds(50, 270, 200, 30);
	    lblSemestres.setFont(new Font("SansSerif", Font.PLAIN, 18));
	    panelContenido.add(lblSemestres);
	    
	    semestres = new JComboBox();
	    semestres.setBackground(new Color(225, 225, 225));
	    semestres.setBounds(50, 300, 200, 30);
	    for(int i = 1; i < 10; i++) {
	        semestres.addItem(i);
	    }
	    panelContenido.add(semestres);
	    
	    // ========== BOTONES ==========
	    
	    // Botón Volver
	    RoundButtonRojo btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(Color.RED);
	    btnVolver.setBounds(250, 650, 120, 40);
	    btnVolver.addActionListener(e -> {
	        remove(fondo);
	        anterior = actual;
	        actual = "menuAsignaturas";
	        add(menuAsignaturas());
	        repaint();
	        revalidate();
	    });
	    fondo.add(btnVolver);
	    
	    // Botón Guardar
	    btnGuardarAsignatura = new JButton("Guardar");
	    btnGuardarAsignatura.setForeground(Color.WHITE);
	    btnGuardarAsignatura.setBackground(new Color(0, 128, 255));
	    btnGuardarAsignatura.setBounds(450, 650, 120, 40);
	    btnGuardarAsignatura.addActionListener(cvbd);
	    fondo.add(btnGuardarAsignatura);
	    
	    // Icono decorativo
	    JLabel icono = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/crear.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
	    icono.setIcon(imageIcon);
	    icono.setBounds(650, 30, 80, 80);
	    fondo.add(icono);
	    
	    return fondo;
	}
				

	///ELIMINAR ALUMNOS Y DOCENTE////
	public JPanel eliminarAlumno() {
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Ajustado a 800x800
	    fondo.setLayout(null);

	    // Título de la sección
	    JLabel titulo = new JLabel("Alumno - Eliminar");
	    titulo.setForeground(new Color(0, 0, 0));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.BOLD, 40));  // Tamaño de fuente aumentado
	    titulo.setBounds(150, 30, 500, 50);  // Posición y tamaño ajustados
	    fondo.add(titulo);

	    // Panel contenedor de la tabla
	    JPanel panelTabla = new JPanel();
	    panelTabla.setBackground(new Color(0, 128, 64));
	    panelTabla.setBounds(100, 120, 600, 550);  // Tamaño y posición ajustados
	    fondo.add(panelTabla);
	    panelTabla.setLayout(null);

	    // Etiqueta de lista de alumnos
	    JLabel etiquetaLista = new JLabel("Lista de Alumnos:");
	    etiquetaLista.setBounds(20, 20, 300, 30);  // Tamaño aumentado
	    panelTabla.add(etiquetaLista);
	    etiquetaLista.setForeground(new Color(255, 255, 255));
	    etiquetaLista.setHorizontalAlignment(SwingConstants.LEFT);
	    etiquetaLista.setFont(new Font("SansSerif", Font.BOLD, 20));  // Fuente más grande

	    // ScrollPane para la tabla
	    JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	                                           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBounds(20, 60, 560, 470);  // Tamaño ajustado
	    panelTabla.add(scrollPane);

	    // Configuración de la tabla
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
	                "Id", "Nombre del Alumno", "A. Paterno", "A. Materno", 
	                "Fecha Nacimiento", "Correo", "Telefono", "Direccion", 
	                "Grado", "Eliminar"
	            }
	    ) {
	        private static final long serialVersionUID = 1L;

	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            if (columnIndex == 9) {
	                return JButton.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
	    });

	    // Conexión a la base de datos y carga de datos
	    BD bd = new BD();
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM alumnosbd");

	        DefaultTableModel model = new DefaultTableModel(
	            new String[]{
	                "Id", "Nombre", "A. Paterno", "A. Materno", 
	                "Fecha Nacimiento", "Correo", "Telefono", 
	                "Direccion", "Grado", "Eliminar"
	            }, 0);
	     
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
	            button.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Fuente del botón
	            button.setPreferredSize(new Dimension(100, 30));  // Tamaño del botón
	           
	            button.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Acción de eliminar (sin cambios)
	                }
	            });

	            Object[] row = {id, nombre, aPaterno, aMaterno, fNacimiento, 
	                           correo, telefono, direccion, grado, button};
	            model.addRow(row);
	        }
	        
	        table.setModel(model);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	        
	        // Ajuste de anchos de columnas
	        table.getColumnModel().getColumn(0).setPreferredWidth(80);
	        table.getColumnModel().getColumn(1).setPreferredWidth(150);
	        table.getColumnModel().getColumn(2).setPreferredWidth(120);
	        table.getColumnModel().getColumn(3).setPreferredWidth(120);
	        table.getColumnModel().getColumn(4).setPreferredWidth(120);
	        table.getColumnModel().getColumn(5).setPreferredWidth(150);
	        table.getColumnModel().getColumn(6).setPreferredWidth(100);
	        table.getColumnModel().getColumn(7).setPreferredWidth(150);
	        table.getColumnModel().getColumn(8).setPreferredWidth(80);
	        table.getColumnModel().getColumn(9).setPreferredWidth(100);
	        
	        table.setRowHeight(30);  // Altura de filas aumentada
	        table.revalidate();
	        table.repaint();

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Configuración de renderizado para botones
	    table.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer());
	    table.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor());
	    
	    // Botón Volver
	    RoundButtonRojo volverBtn = new RoundButtonRojo("Volver");
	    volverBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuAlumnos";
	            add(menuAlumnos());
	            repaint();
	            revalidate();
	        }
	    });
	    volverBtn.setForeground(new Color(255, 255, 255));
	    volverBtn.setBackground(new Color(255, 0, 0));
	    volverBtn.setFont(new Font("SansSerif", Font.BOLD, 16));  // Fuente aumentada
	    volverBtn.setBounds(350, 700, 120, 40);  // Tamaño y posición ajustados
	    fondo.add(volverBtn);

	    // Icono de eliminar
	    JLabel imagen = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage()
	                                      .getScaledInstance(80, 80, Image.SCALE_SMOOTH));  // Tamaño aumentado
	    imagen.setIcon(imageIcon);
	    imagen.setBounds(650, 20, 100, 100);  // Posición ajustada
	    fondo.add(imagen);

	    return fondo;
	}
	
	
	public JPanel eliminarDocente() {
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Ajustado a 800x800
	    fondo.setLayout(null);

	    // Título de la sección
	    JLabel titulo = new JLabel("Docente - Eliminar");
	    titulo.setForeground(new Color(0, 0, 0));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.BOLD, 40));  // Fuente más grande y en negrita
	    titulo.setBounds(150, 30, 500, 50);  // Posición y tamaño ajustados
	    fondo.add(titulo);

	    // Panel contenedor de la tabla
	    JPanel panelTabla = new JPanel();
	    panelTabla.setBackground(new Color(0, 128, 64));  // Verde oscuro
	    panelTabla.setBounds(100, 120, 600, 550);  // Tamaño aumentado
	    fondo.add(panelTabla);
	    panelTabla.setLayout(null);

	    // Etiqueta de lista de docentes
	    JLabel etiquetaLista = new JLabel("Lista de Docentes:");
	    etiquetaLista.setBounds(20, 20, 300, 30);  // Tamaño aumentado
	    panelTabla.add(etiquetaLista);
	    etiquetaLista.setForeground(new Color(255, 255, 255));
	    etiquetaLista.setHorizontalAlignment(SwingConstants.LEFT);
	    etiquetaLista.setFont(new Font("SansSerif", Font.BOLD, 20));  // Fuente más grande

	    // ScrollPane para la tabla
	    JScrollPane scrollPane = new JScrollPane(table2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	                                           JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBounds(20, 60, 560, 470);  // Tamaño ajustado
	    panelTabla.add(scrollPane);

	    // Configuración de la tabla
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
	                "Id", "Nombre del Docente", "A. Paterno", "A. Materno", 
	                "Fecha Nacimiento", "Correo", "Telefono", "Direccion", 
	                "Grado de estudios", "Eliminar"
	            }
	    ) {
	        private static final long serialVersionUID = 1L;

	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            if (columnIndex == 9) {
	                return JButton.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
	    });

	    // Conexión a la base de datos y carga de datos
	    BD bd = new BD();
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd");

	        DefaultTableModel model = new DefaultTableModel(
	            new String[]{
	                "Id", "Nombre", "A. Paterno", "A. Materno", 
	                "Fecha Nacimiento", "Correo", "Telefono", 
	                "Direccion", "Grado", "Eliminar"
	            }, 0);
	     
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
	            button2.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Fuente del botón
	            button2.setPreferredSize(new Dimension(100, 30));  // Tamaño del botón
	           
	            button2.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Acción de eliminar
	                }
	            });

	            Object[] row = {id, nombre, aPaterno, aMaterno, fNacimiento, 
	                          correo, telefono, direccion, grado, button2};
	            model.addRow(row);
	        }
	        
	        table2.setModel(model);
	        table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	        
	        // Ajuste de anchos de columnas
	        table2.getColumnModel().getColumn(0).setPreferredWidth(80);
	        table2.getColumnModel().getColumn(1).setPreferredWidth(150);
	        table2.getColumnModel().getColumn(2).setPreferredWidth(120);
	        table2.getColumnModel().getColumn(3).setPreferredWidth(120);
	        table2.getColumnModel().getColumn(4).setPreferredWidth(120);
	        table2.getColumnModel().getColumn(5).setPreferredWidth(150);
	        table2.getColumnModel().getColumn(6).setPreferredWidth(100);
	        table2.getColumnModel().getColumn(7).setPreferredWidth(150);
	        table2.getColumnModel().getColumn(8).setPreferredWidth(120);
	        table2.getColumnModel().getColumn(9).setPreferredWidth(100);
	        
	        table2.setRowHeight(30);  // Altura de filas aumentada
	        table2.revalidate();
	        table2.repaint();

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Configuración de renderizado para botones
	    table2.getColumnModel().getColumn(9).setCellRenderer(new ButtonRenderer2());
	    table2.getColumnModel().getColumn(9).setCellEditor(new ButtonEditor2());
	    
	    // Botón Volver
	    RoundButtonRojo volverBtn = new RoundButtonRojo("Volver");
	    volverBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuDocentes";
	            add(menuDocentes());
	            repaint();
	            revalidate();
	        }
	    });
	    volverBtn.setForeground(new Color(255, 255, 255));
	    volverBtn.setBackground(new Color(255, 0, 0));
	    volverBtn.setFont(new Font("SansSerif", Font.BOLD, 16));  // Fuente aumentada
	    volverBtn.setBounds(350, 700, 120, 40);  // Tamaño y posición ajustados
	    fondo.add(volverBtn);

	    // Icono de eliminar
	    JLabel imagen = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage()
	                                     .getScaledInstance(80, 80, Image.SCALE_SMOOTH));  // Tamaño aumentado
	    imagen.setIcon(imageIcon);
	    imagen.setBounds(650, 20, 100, 100);  // Posición ajustada
	    fondo.add(imagen);

	    return fondo;
	}
	
	public JPanel eliminarGrupo() {
	    anterior = actual;
	    actual = "eliminarGrupo";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Ajustado a 800x800
	    fondo.setLayout(null);

	    // Título de la sección
	    JLabel titulo = new JLabel("Grupo - Eliminar");
	    titulo.setForeground(new Color(0, 0, 0));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.BOLD, 40));  // Fuente más grande y en negrita
	    titulo.setBounds(150, 30, 500, 50);  // Posición y tamaño ajustados
	    fondo.add(titulo);

	    // Panel contenedor de la tabla
	    JPanel panelTabla = new JPanel();
	    panelTabla.setBackground(new Color(0, 128, 64));  // Verde oscuro
	    panelTabla.setBounds(100, 120, 600, 550);  // Tamaño aumentado
	    fondo.add(panelTabla);
	    panelTabla.setLayout(null);

	    // Etiqueta de lista de grupos
	    JLabel etiquetaLista = new JLabel("Lista de Grupos:");
	    etiquetaLista.setBounds(20, 20, 300, 30);  // Tamaño aumentado
	    panelTabla.add(etiquetaLista);
	    etiquetaLista.setForeground(new Color(255, 255, 255));
	    etiquetaLista.setHorizontalAlignment(SwingConstants.LEFT);
	    etiquetaLista.setFont(new Font("SansSerif", Font.BOLD, 20));  // Fuente más grande

	    // ScrollPane para la tabla
	    JScrollPane scrollPane = new JScrollPane(table3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	                                          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBounds(20, 60, 560, 470);  // Tamaño ajustado
	    panelTabla.add(scrollPane);

	    // Configuración de la tabla
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
	                "Id", "Carrera", "Asignatura", "Docente", "Semestre", 
	                "Número de Alumnos", "Eliminar"
	            }
	    ) {
	        private static final long serialVersionUID = 1L;

	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            if (columnIndex == 6) {  // Corregido para la columna "Eliminar"
	                return JButton.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
	    });

	    // Conexión a la base de datos y carga de datos
	    BD bd = new BD();
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM gruposbd");

	        DefaultTableModel model = new DefaultTableModel(
	            new String[]{
	                "Id", "Carrera", "Asignatura", "Docente", 
	                "Semestre", "Número de Alumnos", "Eliminar"
	            }, 0);
	     
	        while (rs.next()) {
	            int id = rs.getInt("idGrupos");
	            String carrera = rs.getString("Carrera");
	            String asignatura = rs.getString("Asignatura");
	            String docente = rs.getString("Docente");
	            String semestre = rs.getString("Semestre");
	            String numAlum = rs.getString("numAlumnos");
	            
	            button3 = new JButton("Eliminar");
	            button3.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Fuente del botón
	            button3.setPreferredSize(new Dimension(100, 30));  // Tamaño del botón
	           
	            button3.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Acción de eliminar
	                }
	            });

	            Object[] row = {id, carrera, asignatura, docente, semestre, numAlum, button3};
	            model.addRow(row);
	        }
	        
	        table3.setModel(model);
	        table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	        
	        // Ajuste de anchos de columnas
	        table3.getColumnModel().getColumn(0).setPreferredWidth(80);
	        table3.getColumnModel().getColumn(1).setPreferredWidth(150);
	        table3.getColumnModel().getColumn(2).setPreferredWidth(150);
	        table3.getColumnModel().getColumn(3).setPreferredWidth(150);
	        table3.getColumnModel().getColumn(4).setPreferredWidth(100);
	        table3.getColumnModel().getColumn(5).setPreferredWidth(150);
	        table3.getColumnModel().getColumn(6).setPreferredWidth(100);
	        
	        table3.setRowHeight(30);  // Altura de filas aumentada
	        table3.revalidate();
	        table3.repaint();

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Configuración de renderizado para botones
	    table3.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer3());
	    table3.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor3());
	    
	    // Botón Volver
	    RoundButtonRojo volverBtn = new RoundButtonRojo("Volver");
	    volverBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuGrupos";
	            add(menuGrupos());
	            repaint();
	            revalidate();
	        }
	    });
	    volverBtn.setForeground(new Color(255, 255, 255));
	    volverBtn.setBackground(new Color(255, 0, 0));
	    volverBtn.setFont(new Font("SansSerif", Font.BOLD, 16));  // Fuente aumentada
	    volverBtn.setBounds(350, 700, 120, 40);  // Tamaño y posición ajustados
	    fondo.add(volverBtn);

	    // Icono de eliminar
	    JLabel imagen = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage()
	                                    .getScaledInstance(80, 80, Image.SCALE_SMOOTH));  // Tamaño aumentado
	    imagen.setIcon(imageIcon);
	    imagen.setBounds(650, 20, 100, 100);  // Posición ajustada
	    fondo.add(imagen);

	    return fondo;
	}
	
	public JPanel eliminarAsignatura() {
	    anterior = actual;
	    actual = "eliminarAsignatura";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Ajustado a 800x800
	    fondo.setLayout(null);

	    // Título de la sección
	    JLabel titulo = new JLabel("Asignatura - Eliminar");
	    titulo.setForeground(new Color(0, 0, 0));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.BOLD, 40));  // Fuente más grande y en negrita
	    titulo.setBounds(150, 30, 500, 50);  // Posición y tamaño ajustados
	    fondo.add(titulo);

	    // Panel contenedor de la tabla
	    JPanel panelTabla = new JPanel();
	    panelTabla.setBackground(new Color(0, 128, 64));  // Verde oscuro
	    panelTabla.setBounds(100, 120, 600, 550);  // Tamaño aumentado
	    fondo.add(panelTabla);
	    panelTabla.setLayout(null);

	    // Etiqueta de lista de asignaturas
	    JLabel etiquetaLista = new JLabel("Lista de Asignaturas:");
	    etiquetaLista.setBounds(20, 20, 300, 30);  // Tamaño aumentado
	    panelTabla.add(etiquetaLista);
	    etiquetaLista.setForeground(new Color(255, 255, 255));
	    etiquetaLista.setHorizontalAlignment(SwingConstants.LEFT);
	    etiquetaLista.setFont(new Font("SansSerif", Font.BOLD, 20));  // Fuente más grande

	    // ScrollPane para la tabla
	    JScrollPane scrollPane = new JScrollPane(table4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	                                          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setBounds(20, 60, 560, 470);  // Tamaño ajustado
	    panelTabla.add(scrollPane);

	    // Configuración de la tabla
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
	                "Id", "Nombre", "Créditos", "Docente", "Semestre", "Eliminar"
	            }
	    ) {
	        private static final long serialVersionUID = 1L;

	        @Override
	        public Class<?> getColumnClass(int columnIndex) {
	            if (columnIndex == 5) {  // Corregido para la columna "Eliminar"
	                return JButton.class;
	            }
	            return super.getColumnClass(columnIndex);
	        }
	    });

	    // Conexión a la base de datos y carga de datos
	    BD bd = new BD();
	    try {
	        Connection cn = bd.Conectar();
	        Statement stm = cn.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd");

	        DefaultTableModel model = new DefaultTableModel(
	            new String[]{
	                "Id", "Nombre", "Créditos", "Docente", 
	                "Semestre", "Eliminar"
	            }, 0);
	     
	        while (rs.next()) {
	            int id = rs.getInt("idAsignatura");
	            String nombre = rs.getString("Nombre");
	            String creditos = rs.getString("Creditos");
	            String docente = rs.getString("Docente");
	            String semestre = rs.getString("Semestre");
	            
	            button4 = new JButton("Eliminar");
	            button4.setFont(new Font("SansSerif", Font.PLAIN, 14));  // Fuente del botón
	            button4.setPreferredSize(new Dimension(100, 30));  // Tamaño del botón
	           
	            button4.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Acción de eliminar
	                }
	            });

	            Object[] row = {id, nombre, creditos, docente, semestre, button4};
	            model.addRow(row);
	        }
	        
	        table4.setModel(model);
	        table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
	        
	        // Ajuste de anchos de columnas
	        table4.getColumnModel().getColumn(0).setPreferredWidth(80);
	        table4.getColumnModel().getColumn(1).setPreferredWidth(200);
	        table4.getColumnModel().getColumn(2).setPreferredWidth(100);
	        table4.getColumnModel().getColumn(3).setPreferredWidth(200);
	        table4.getColumnModel().getColumn(4).setPreferredWidth(100);
	        table4.getColumnModel().getColumn(5).setPreferredWidth(100);
	        
	        table4.setRowHeight(30);  // Altura de filas aumentada
	        table4.revalidate();
	        table4.repaint();

	        rs.close();
	        stm.close();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Configuración de renderizado para botones
	    table4.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer4());
	    table4.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor4());
	    
	    // Botón Volver
	    RoundButtonRojo volverBtn = new RoundButtonRojo("Volver");
	    volverBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuAsignaturas";
	            add(menuAsignaturas());
	            repaint();
	            revalidate();
	        }
	    });
	    volverBtn.setForeground(new Color(255, 255, 255));
	    volverBtn.setBackground(new Color(255, 0, 0));
	    volverBtn.setFont(new Font("SansSerif", Font.BOLD, 16));  // Fuente aumentada
	    volverBtn.setBounds(350, 700, 120, 40);  // Tamaño y posición ajustados
	    fondo.add(volverBtn);

	    // Icono de eliminar
	    JLabel imagen = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/eliminar.png").getImage()
	                                    .getScaledInstance(80, 80, Image.SCALE_SMOOTH));  // Tamaño aumentado
	    imagen.setIcon(imageIcon);
	    imagen.setBounds(650, 20, 100, 100);  // Posición ajustada
	    fondo.add(imagen);

	    return fondo;
	}
	
	
	////FUNCIONES CONSULTAR//////
	public JPanel consultarAlumno() {
	    // Variables para control de navegación
	    anterior = actual;
	    actual = "consultarAlumno";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800); // Ajustado a 800x800
	    fondo.setLayout(null);
	    getContentPane().add(fondo);

	    // Título principal
	    JLabel titulo = new JLabel("Mi cuenta - Alumno");
	    titulo.setForeground(new Color(0, 0, 0));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.PLAIN, 35));
	    titulo.setBounds(150, 30, 500, 50); // Ajustado para 800px
	    fondo.add(titulo);

	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 100, 600, 550); // Ajustado para 800px
	    fondo.add(panelContenido);
	    panelContenido.setLayout(null);

	    // Etiquetas y campos de texto
	    // ID Alumno
	    JLabel lblIdAlumno = new JLabel("Ingrese el ID del alumno");
	    lblIdAlumno.setForeground(Color.WHITE);
	    lblIdAlumno.setFont(new Font("SansSerif", Font.PLAIN, 16));
	    lblIdAlumno.setBounds(30, 30, 250, 20);
	    panelContenido.add(lblIdAlumno);

	    JTextField txtIdAlumno = new JTextField();
	    txtIdAlumno.setEditable(true);
	    txtIdAlumno.setColumns(10);
	    txtIdAlumno.setBounds(30, 55, 250, 30); // Aumentado tamaño
	    panelContenido.add(txtIdAlumno);

	    // Campos de información del alumno
	    String[] etiquetas = {"Nombre", "Apellido Paterno", "Apellido Materno", 
	                          "Correo electrónico", "Fecha de nacimiento", 
	                          "Teléfono", "Dirección"};
	    
	    JTextField[] campos = new JTextField[7];
	    int yPos = 110;
	    
	    for (int i = 0; i < etiquetas.length; i++) {
	        // Etiqueta
	        JLabel label = new JLabel(etiquetas[i]);
	        label.setForeground(Color.WHITE);
	        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
	        
	        // Campo de texto
	        campos[i] = new JTextField();
	        campos[i].setEditable(false);
	        campos[i].setColumns(10);
	        
	        // Ajustar posición según el campo
	        if (i == 1 || i == 2) { // Apellidos
	            label.setBounds(30 + (i-1)*150, yPos, 150, 20);
	            campos[i].setBounds(30 + (i-1)*150, yPos + 25, 100, 30);
	            if (i == 2) yPos += 70;
	        } else {
	            label.setBounds(30, yPos, 250, 20);
	            campos[i].setBounds(30, yPos + 25, 250, 30);
	            yPos += 70;
	        }
	        
	        panelContenido.add(label);
	        panelContenido.add(campos[i]);
	    }

	    // Referencias a campos específicos para uso posterior
	    JTextField txtNombre = campos[0];
	    JTextField txtApellidoP = campos[1];
	    JTextField txtApellidoM = campos[2];
	    JTextField txtCorreo = campos[3];
	    JTextField txtFechaNac = campos[4];
	    JTextField txtTelefono = campos[5];
	    JTextField txtDireccion = campos[6];

	    // Imagen de perfil
	    JLabel lblImagenPerfil = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
	    lblImagenPerfil.setIcon(imageIcon);
	    lblImagenPerfil.setBounds(350, 50, 200, 180);
	    panelContenido.add(lblImagenPerfil);

	    // Logo UABCS
	    JLabel lblLogoUABCS = new JLabel("");
	    ImageIcon logoIcon = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(300, 120, Image.SCALE_DEFAULT));
	    lblLogoUABCS.setIcon(logoIcon);
	    lblLogoUABCS.setBounds(300, 360, 300, 120);
	    panelContenido.add(lblLogoUABCS);

	    // Botones de edición
	    JButton btnEditar = new JButton("Editar");
	    btnEditar.setForeground(Color.WHITE);
	    btnEditar.setBackground(new Color(0, 128, 255));
	    btnEditar.setBounds(340, 280, 100, 35); // Aumentado tamaño
	    panelContenido.add(btnEditar);

	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setForeground(Color.WHITE);
	    btnGuardar.setBackground(new Color(0, 180, 0));
	    btnGuardar.setBounds(450, 280, 100, 35); // Aumentado tamaño
	    btnGuardar.setEnabled(false);
	    panelContenido.add(btnGuardar);

	    // Botones inferiores
	    JButton btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(new Color(255, 0, 0));
	    btnVolver.setBounds(150, 680, 120, 40); // Aumentado tamaño y reposicionado
	    fondo.add(btnVolver);

	    JButton btnConsultar = new JButton("Consultar");
	    btnConsultar.setForeground(Color.WHITE);
	    btnConsultar.setBackground(new Color(0, 128, 255));
	    btnConsultar.setBounds(300, 680, 120, 40); // Aumentado tamaño y reposicionado
	    fondo.add(btnConsultar);

	    JButton btnDescargar = new JButton("Descargar PDF");
	    btnDescargar.setForeground(Color.WHITE);
	    btnDescargar.setBackground(new Color(0, 128, 255));
	    btnDescargar.setBounds(450, 680, 150, 40); // Aumentado tamaño y reposicionado
	    fondo.add(btnDescargar);

	    // Listeners de botones
	    // Botón Consultar
	    btnConsultar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                int idConsultar = Integer.parseInt(txtIdAlumno.getText());
	                BD bd = new BD();
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT * FROM alumnosbd");

	                boolean encontrado = false;
	                
	                while (rs.next()) {
	                    int id = rs.getInt("idAlumnos");
	                    
	                    if(idConsultar == id) {
	                        // Obtener datos de la base de datos
	                        String nombre = rs.getString("Nombre");
	                        String correo = rs.getString("Correo");
	                        String apellidoP = rs.getString("Apellido Paterno");
	                        String apellidoM = rs.getString("Apellido Materno");
	                        String telefono = rs.getString("Telefono");
	                        LocalDate fechaNacimiento = rs.getDate("Fecha Nacimiento").toLocalDate(); 
	                        String fecha = fechaNacimiento.toString();
	                        String direccion = rs.getString("Direccion");
	                        
	                        // Actualizar imagen de perfil
	                        if (imagenBytes != null && imagenBytes.length > 0) {
	                            ImageIcon nuevaImagen = new ImageIcon(new ImageIcon(imagenBytes).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
	                            lblImagenPerfil.setIcon(nuevaImagen);
	                        }
	                        
	                        // Actualizar campos de texto
	                        txtNombre.setText(nombre);
	                        txtApellidoP.setText(apellidoP);
	                        txtApellidoM.setText(apellidoM);
	                        txtCorreo.setText(correo);
	                        txtTelefono.setText(telefono);
	                        txtFechaNac.setText(fecha);
	                        txtDireccion.setText(direccion);
	                        
	                        encontrado = true;
	                        break;
	                    }
	                }

	                if (!encontrado) {
	                    JOptionPane.showMessageDialog(null, "ID de alumno inválido. Favor de intentar de nuevo");
	                }

	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            } catch (NumberFormatException e2) {
	                JOptionPane.showMessageDialog(null, "Ingrese un ID válido (número)");
	            }
	        }
	    });

	    // Botón Editar
	    btnEditar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (!txtIdAlumno.getText().isEmpty() && txtIdAlumno.getText().matches("\\d+")) {
	                txtCorreo.setEditable(true);
	                txtTelefono.setEditable(true);
	                txtDireccion.setEditable(true);
	                btnGuardar.setEnabled(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "Ingrese un ID de alumno válido primero");
	            }
	        }
	    });

	    // Botón Guardar
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                BD bd = new BD();
	                Connection cn = bd.Conectar();
	                PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement(
	                    "UPDATE alumnosbd SET Correo = ?, Telefono = ?, Direccion = ? WHERE idAlumnos = ?");
	                
	                pstmt.setString(1, txtCorreo.getText());
	                pstmt.setString(2, txtTelefono.getText());
	                pstmt.setString(3, txtDireccion.getText());
	                pstmt.setInt(4, Integer.parseInt(txtIdAlumno.getText()));

	                int filasAfectadas = pstmt.executeUpdate();
	                if (filasAfectadas > 0) {
	                    JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente");
	                    txtCorreo.setEditable(false);
	                    txtTelefono.setEditable(false);
	                    txtDireccion.setEditable(false);
	                    btnGuardar.setEnabled(false);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se encontró el alumno con ese ID");
	                }

	                pstmt.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
	            }
	        }
	    });

	    // Botón Volver
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuAlumnos";
	            add(menuAlumnos());
	            repaint();
	            revalidate();
	        }
	    });

	    // Botón Descargar PDF
	    btnDescargar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                // Crear documento PDF
	                PdfWriter writer = new PdfWriter("alumno_" + txtIdAlumno.getText() + ".pdf");
	                PdfDocument pdf = new PdfDocument(writer);
	                Document document = new Document(pdf);
	                
	                // Encabezado
	                Paragraph header = new Paragraph("Universidad Autónoma de Baja California Sur")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(20)
	                    .setBold();
	                
	                Paragraph subheader = new Paragraph("Información del Alumno")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(16)
	                    .setMarginBottom(20);
	                
	                document.add(header);
	                document.add(subheader);
	                
	                // Tabla de información
	                float[] columnWidths = {150f, 350f};
	                Table table = new Table(columnWidths);
	                
	                // Agregar filas con la información
	                table.addCell(createCell("ID Alumno", true));
	                table.addCell(createCell(txtIdAlumno.getText(), false));
	                
	                table.addCell(createCell("Nombre", true));
	                table.addCell(createCell(txtNombre.getText(), false));
	                
	                table.addCell(createCell("Apellidos", true));
	                table.addCell(createCell(txtApellidoP.getText() + " " + txtApellidoM.getText(), false));
	                
	                table.addCell(createCell("Correo", true));
	                table.addCell(createCell(txtCorreo.getText(), false));
	                
	                table.addCell(createCell("Teléfono", true));
	                table.addCell(createCell(txtTelefono.getText(), false));
	                
	                table.addCell(createCell("Dirección", true));
	                table.addCell(createCell(txtDireccion.getText(), false));
	                
	                table.addCell(createCell("Fecha Nacimiento", true));
	                table.addCell(createCell(txtFechaNac.getText(), false));
	                
	                document.add(table);
	                document.close();
	                
	                JOptionPane.showMessageDialog(null, "PDF generado exitosamente");
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al generar el PDF");
	            }
	        }
	        
	        // Método auxiliar para crear celdas del PDF
	        private Cell createCell(String text, boolean isHeader) {
	            Cell cell = new Cell();
	            Paragraph p = new Paragraph(text);
	            if (isHeader) {
	                p.setBold();
	                cell.setBackgroundColor(new DeviceRgb(200, 200, 200));
	            }
	            cell.add(p);
	            return cell;
	        }
	    });

	    return fondo;
	}
	
	public JPanel consultarDocente() {
	    // Variables para control de navegación
	    anterior = actual;
	    actual = "consultarDocente";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);

	    // Título principal
	    JLabel lblTitulo = new JLabel("Mi cuenta - Docente");
	    lblTitulo.setForeground(Color.BLACK);
	    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
	    lblTitulo.setBounds(150, 30, 500, 50);
	    fondo.add(lblTitulo);

	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 100, 600, 550);
	    fondo.add(panelContenido);
	    panelContenido.setLayout(null);

	    // Campos de información del docente
	    JLabel lblIdDocente = new JLabel("Ingrese el ID del docente");
	    lblIdDocente.setForeground(Color.WHITE);
	    lblIdDocente.setFont(new Font("SansSerif", Font.BOLD, 16));
	    lblIdDocente.setBounds(30, 30, 250, 20);
	    panelContenido.add(lblIdDocente);

	    JTextField txtIdDocente = new JTextField();
	    txtIdDocente.setEditable(true);
	    txtIdDocente.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    txtIdDocente.setBounds(30, 55, 250, 30);
	    panelContenido.add(txtIdDocente);

	    // Array de campos para organización
	    String[] etiquetas = {"Nombre", "Apellido Paterno", "Apellido Materno", 
	                         "Correo electrónico", "Fecha de nacimiento", 
	                         "Teléfono", "Dirección"};
	    
	    JTextField[] campos = new JTextField[7];
	    int yPos = 110;
	    
	    for (int i = 0; i < etiquetas.length; i++) {
	        // Etiqueta
	        JLabel label = new JLabel(etiquetas[i]);
	        label.setForeground(Color.WHITE);
	        label.setFont(new Font("SansSerif", Font.BOLD, 16));
	        
	        // Campo de texto
	        campos[i] = new JTextField();
	        campos[i].setEditable(false);
	        campos[i].setFont(new Font("SansSerif", Font.PLAIN, 14));
	        
	        // Ajustar posición según el campo
	        if (i == 1 || i == 2) { // Apellidos
	            label.setBounds(30 + (i-1)*150, yPos, 150, 20);
	            campos[i].setBounds(30 + (i-1)*150, yPos + 25, 100, 30);
	            if (i == 2) yPos += 70;
	        } else {
	            label.setBounds(30, yPos, 250, 20);
	            campos[i].setBounds(30, yPos + 25, 250, 30);
	            yPos += 70;
	        }
	        
	        panelContenido.add(label);
	        panelContenido.add(campos[i]);
	    }

	    // Referencias a campos específicos
	    JTextField txtNombre = campos[0];
	    JTextField txtApellidoP = campos[1];
	    JTextField txtApellidoM = campos[2];
	    JTextField txtCorreo = campos[3];
	    JTextField txtFechaNac = campos[4];
	    JTextField txtTelefono = campos[5];
	    JTextField txtDireccion = campos[6];

	    // Imagen de perfil
	    JLabel lblImagenPerfil = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
	    lblImagenPerfil.setIcon(imageIcon);
	    lblImagenPerfil.setBounds(350, 50, 200, 180);
	    panelContenido.add(lblImagenPerfil);

	    // Logo UABCS
	    JLabel lblLogoUABCS = new JLabel("");
	    ImageIcon logoIcon = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(300, 120, Image.SCALE_DEFAULT));
	    lblLogoUABCS.setIcon(logoIcon);
	    lblLogoUABCS.setBounds(300, 360, 300, 120);
	    panelContenido.add(lblLogoUABCS);

	    // Botones de edición
	    JButton btnEditar = new JButton("Editar");
	    btnEditar.setForeground(Color.WHITE);
	    btnEditar.setBackground(new Color(0, 128, 255));
	    btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnEditar.setBounds(340, 280, 100, 35);
	    panelContenido.add(btnEditar);

	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setForeground(Color.WHITE);
	    btnGuardar.setBackground(new Color(0, 180, 0));
	    btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnGuardar.setBounds(450, 280, 100, 35);
	    btnGuardar.setEnabled(false);
	    panelContenido.add(btnGuardar);

	    // Botones inferiores
	    JButton btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(new Color(255, 0, 0));
	    btnVolver.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnVolver.setBounds(150, 680, 120, 40);
	    fondo.add(btnVolver);

	    JButton btnConsultar = new JButton("Consultar");
	    btnConsultar.setForeground(Color.WHITE);
	    btnConsultar.setBackground(new Color(0, 128, 255));
	    btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnConsultar.setBounds(300, 680, 120, 40);
	    fondo.add(btnConsultar);

	    JButton btnDescargar = new JButton("Descargar PDF");
	    btnDescargar.setForeground(Color.WHITE);
	    btnDescargar.setBackground(new Color(0, 128, 255));
	    btnDescargar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnDescargar.setBounds(450, 680, 150, 40);
	    fondo.add(btnDescargar);

	    // Listeners de botones
	    // Botón Consultar
	    btnConsultar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                int idConsultar = Integer.parseInt(txtIdDocente.getText());
	                BD bd = new BD();
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT * FROM docentesbd WHERE idDocente = " + idConsultar);

	                if (rs.next()) {
	                    // Obtener datos de la base de datos
	                    String nombre = rs.getString("Nombre");
	                    String correo = rs.getString("Correo");
	                    String apellidoP = rs.getString("Apellido Paterno");
	                    String apellidoM = rs.getString("Apellido Materno");
	                    String telefono = rs.getString("Telefono");
	                    LocalDate fechaNacimiento = rs.getDate("Fecha Nacimiento").toLocalDate(); 
	                    String fecha = fechaNacimiento.toString();
	                    String direccion = rs.getString("Direccion");
	                    
	                    // Actualizar imagen de perfil si existe
	                    if (imagenBytes != null && imagenBytes.length > 0) {
	                        ImageIcon nuevaImagen = new ImageIcon(new ImageIcon(imagenBytes).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
	                        lblImagenPerfil.setIcon(nuevaImagen);
	                    }
	                    
	                    // Actualizar campos de texto
	                    txtNombre.setText(nombre);
	                    txtApellidoP.setText(apellidoP);
	                    txtApellidoM.setText(apellidoM);
	                    txtCorreo.setText(correo);
	                    txtTelefono.setText(telefono);
	                    txtFechaNac.setText(fecha);
	                    txtDireccion.setText(direccion);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se encontró un docente con ese ID", "Error", JOptionPane.ERROR_MESSAGE);
	                }

	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al consultar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
	            } catch (NumberFormatException e2) {
	                JOptionPane.showMessageDialog(null, "Ingrese un ID válido (número)", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    // Botón Editar
	    btnEditar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (!txtIdDocente.getText().isEmpty() && txtIdDocente.getText().matches("\\d+")) {
	                txtCorreo.setEditable(true);
	                txtTelefono.setEditable(true);
	                txtDireccion.setEditable(true);
	                btnGuardar.setEnabled(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "Ingrese un ID de docente válido primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            }
	        }
	    });

	    // Botón Guardar
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                BD bd = new BD();
	                Connection cn = bd.Conectar();
	                PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement(
	                    "UPDATE docentesbd SET Correo = ?, Telefono = ?, Direccion = ? WHERE idDocente = ?");
	                
	                pstmt.setString(1, txtCorreo.getText());
	                pstmt.setString(2, txtTelefono.getText());
	                pstmt.setString(3, txtDireccion.getText());
	                pstmt.setInt(4, Integer.parseInt(txtIdDocente.getText()));

	                int filasAfectadas = pstmt.executeUpdate();
	                if (filasAfectadas > 0) {
	                    JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente");
	                    txtCorreo.setEditable(false);
	                    txtTelefono.setEditable(false);
	                    txtDireccion.setEditable(false);
	                    btnGuardar.setEnabled(false);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se encontró el docente con ese ID");
	                }

	                pstmt.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    // Botón Volver
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuDocentes";
	            add(menuDocentes());
	            repaint();
	            revalidate();
	        }
	    });

	    // Botón Descargar PDF
	    btnDescargar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                // Validar que hay datos para exportar
	                if (txtNombre.getText().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Consulte primero los datos del docente", "Advertencia", JOptionPane.WARNING_MESSAGE);
	                    return;
	                }

	                // Crear documento PDF
	                String filename = "docente_" + txtIdDocente.getText() + ".pdf";
	                PdfWriter writer = new PdfWriter(filename);
	                PdfDocument pdf = new PdfDocument(writer);
	                Document document = new Document(pdf);
	                
	                // Encabezado
	                Paragraph header = new Paragraph("Universidad Autónoma de Baja California Sur")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(20)
	                    .setBold();
	                
	                Paragraph subheader = new Paragraph("Información del Docente")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(16)
	                    .setMarginBottom(20);
	                
	                document.add(header);
	                document.add(subheader);
	                
	                // Tabla de información
	                float[] columnWidths = {150f, 350f};
	                Table table = new Table(columnWidths);
	                
	                // Agregar filas con la información
	                addTableRow(table, "ID Docente", txtIdDocente.getText());
	                addTableRow(table, "Nombre", txtNombre.getText());
	                addTableRow(table, "Apellido Paterno", txtApellidoP.getText());
	                addTableRow(table, "Apellido Materno", txtApellidoM.getText());
	                addTableRow(table, "Correo Electrónico", txtCorreo.getText());
	                addTableRow(table, "Teléfono", txtTelefono.getText());
	                addTableRow(table, "Dirección", txtDireccion.getText());
	                addTableRow(table, "Fecha de Nacimiento", txtFechaNac.getText());
	                
	                document.add(table);
	                document.close();
	                
	                JOptionPane.showMessageDialog(null, "PDF generado exitosamente como: " + filename);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        
	        private void addTableRow(Table table, String header, String value) {
	            // Header cell
	            Cell headerCell = new Cell()
	                .add(new Paragraph(header))
	                .setBold()
	                .setBackgroundColor(new DeviceRgb(240, 240, 240));
	            
	            // Value cell
	            Cell valueCell = new Cell()
	                .add(new Paragraph(value != null ? value : ""));
	            
	            table.addCell(headerCell);
	            table.addCell(valueCell);
	        }
	    });

	    return fondo;
	}
	
	public JPanel consultarGrupo() {
	    // Variables para control de navegación
	    anterior = actual;
	    actual = "consultarGrupo";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);

	    // Título principal
	    JLabel lblTitulo = new JLabel("Consultar Grupo");
	    lblTitulo.setForeground(Color.BLACK);
	    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
	    lblTitulo.setBounds(150, 30, 500, 50);
	    fondo.add(lblTitulo);

	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 100, 600, 550);
	    fondo.add(panelContenido);
	    panelContenido.setLayout(null);

	    // ComboBox para selección de grupo
	    JLabel lblSeleccionGrupo = new JLabel("Seleccione un Grupo:");
	    lblSeleccionGrupo.setForeground(Color.WHITE);
	    lblSeleccionGrupo.setFont(new Font("SansSerif", Font.BOLD, 16));
	    lblSeleccionGrupo.setBounds(30, 30, 250, 20);
	    panelContenido.add(lblSeleccionGrupo);

	    BD bd = new BD();
	    JComboBox<Integer> cbGrupos = new JComboBox<>();
	    cbGrupos.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsGrupo().toArray(new Integer[0])));
	    cbGrupos.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    cbGrupos.setBounds(30, 55, 250, 30);
	    panelContenido.add(cbGrupos);

	    // Campos de información del grupo
	    String[] etiquetas = {"Carrera:", "Asignatura:", "Docente a cargo:", 
	                         "Semestre:", "Número de alumnos:"};
	    
	    JTextField[] campos = new JTextField[3];
	    JComboBox<String> cbAsignatura = new JComboBox<>();
	    JComboBox<String> cbDocente = new JComboBox<>();
	    
	    int yPos = 110;
	    for (int i = 0; i < etiquetas.length; i++) {
	        // Etiqueta
	        JLabel label = new JLabel(etiquetas[i]);
	        label.setForeground(Color.WHITE);
	        label.setFont(new Font("SansSerif", Font.BOLD, 16));
	        label.setBounds(30, yPos, 250, 20);
	        panelContenido.add(label);

	        // Componente de entrada
	        if (i == 1) { // Asignatura (ComboBox)
	            cbAsignatura.setEnabled(false);
	            cbAsignatura.setFont(new Font("SansSerif", Font.PLAIN, 14));
	            cbAsignatura.setBounds(30, yPos + 25, 250, 30);
	            panelContenido.add(cbAsignatura);
	            
	            // Llenar combobox de asignaturas
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT Nombre FROM asignaturasbd");
	                while (rs.next()) {
	                    cbAsignatura.addItem(rs.getString("Nombre"));
	                }
	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            yPos += 70;
	        } else if (i == 2) { // Docente (ComboBox)
	            cbDocente.setEnabled(false);
	            cbDocente.setFont(new Font("SansSerif", Font.PLAIN, 14));
	            cbDocente.setBounds(30, yPos + 25, 250, 30);
	            panelContenido.add(cbDocente);
	            
	            // Llenar combobox de docentes
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT Nombre FROM docentesbd");
	                while (rs.next()) {
	                    cbDocente.addItem(rs.getString("Nombre"));
	                }
	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            yPos += 70;
	        } else { // Campos de texto
	            campos[i < 1 ? i : i-2] = new JTextField();
	            campos[i < 1 ? i : i-2].setEditable(false);
	            campos[i < 1 ? i : i-2].setFont(new Font("SansSerif", Font.PLAIN, 14));
	            campos[i < 1 ? i : i-2].setBounds(30, yPos + 25, 250, 30);
	            panelContenido.add(campos[i < 1 ? i : i-2]);
	            yPos += 70;
	        }
	    }

	    // Referencias a campos específicos
	    JTextField txtCarrera = campos[0];
	    JTextField txtSemestre = campos[1];
	    JTextField txtNumAlumnos = campos[2];

	    // Imagen de grupo
	    JLabel lblImagenGrupo = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
	    lblImagenGrupo.setIcon(imageIcon);
	    lblImagenGrupo.setBounds(350, 50, 180, 180);
	    panelContenido.add(lblImagenGrupo);

	    // Logo UABCS
	    JLabel lblLogoUABCS = new JLabel("");
	    ImageIcon logoIcon = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(300, 120, Image.SCALE_DEFAULT));
	    lblLogoUABCS.setIcon(logoIcon);
	    lblLogoUABCS.setBounds(300, 360, 300, 120);
	    panelContenido.add(lblLogoUABCS);

	    // Botones de edición
	    JButton btnEditar = new JButton("Editar");
	    btnEditar.setForeground(Color.WHITE);
	    btnEditar.setBackground(new Color(0, 128, 255));
	    btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnEditar.setBounds(340, 250, 100, 35);
	    panelContenido.add(btnEditar);

	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setForeground(Color.WHITE);
	    btnGuardar.setBackground(new Color(0, 180, 0));
	    btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnGuardar.setBounds(450, 250, 100, 35);
	    btnGuardar.setEnabled(false);
	    panelContenido.add(btnGuardar);

	    // Botones inferiores
	    JButton btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(new Color(255, 0, 0));
	    btnVolver.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnVolver.setBounds(150, 680, 120, 40);
	    fondo.add(btnVolver);

	    JButton btnConsultar = new JButton("Consultar");
	    btnConsultar.setForeground(Color.WHITE);
	    btnConsultar.setBackground(new Color(0, 128, 255));
	    btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnConsultar.setBounds(300, 680, 120, 40);
	    fondo.add(btnConsultar);

	    JButton btnDescargar = new JButton("Descargar PDF");
	    btnDescargar.setForeground(Color.WHITE);
	    btnDescargar.setBackground(new Color(0, 128, 255));
	    btnDescargar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnDescargar.setBounds(450, 680, 150, 40);
	    fondo.add(btnDescargar);

	    // Listeners de botones
	    // Botón Consultar
	    btnConsultar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int idConsultar = (int) cbGrupos.getSelectedItem();
	            BD bd = new BD();
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT * FROM gruposbd WHERE idGrupos = " + idConsultar);

	                if (rs.next()) {
	                    // Obtener datos de la base de datos
	                    txtCarrera.setText(rs.getString("Carrera"));
	                    cbAsignatura.setSelectedItem(rs.getString("Asignatura"));
	                    cbDocente.setSelectedItem(rs.getString("Docente"));
	                    txtSemestre.setText(rs.getString("Semestre"));
	                    txtNumAlumnos.setText(rs.getString("numAlumnos"));
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se encontró el grupo", "Error", JOptionPane.ERROR_MESSAGE);
	                }

	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al consultar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    // Botón Editar
	    btnEditar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            cbAsignatura.setEnabled(true);
	            cbDocente.setEnabled(true);
	            txtSemestre.setEditable(true);
	            txtNumAlumnos.setEditable(true);
	            btnGuardar.setEnabled(true);
	        }
	    });

	    // Botón Guardar
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                BD bd = new BD();
	                Connection cn = bd.Conectar();
	                PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement(
	                    "UPDATE gruposbd SET Carrera = ?, Asignatura = ?, Docente = ?, Semestre = ?, numAlumnos = ? WHERE idGrupos = ?");
	                
	                pstmt.setString(1, txtCarrera.getText());
	                pstmt.setString(2, cbAsignatura.getSelectedItem().toString());
	                pstmt.setString(3, cbDocente.getSelectedItem().toString());
	                pstmt.setString(4, txtSemestre.getText());
	                pstmt.setString(5, txtNumAlumnos.getText());
	                pstmt.setInt(6, (int) cbGrupos.getSelectedItem());

	                int filasAfectadas = pstmt.executeUpdate();
	                if (filasAfectadas > 0) {
	                    JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente");
	                    cbAsignatura.setEnabled(false);
	                    cbDocente.setEnabled(false);
	                    txtSemestre.setEditable(false);
	                    txtNumAlumnos.setEditable(false);
	                    btnGuardar.setEnabled(false);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el grupo");
	                }

	                pstmt.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    // Botón Volver
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuGrupos";
	            add(menuGrupos());
	            repaint();
	            revalidate();
	        }
	    });

	    // Botón Descargar PDF
	    btnDescargar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                // Validar que hay datos para exportar
	                if (txtCarrera.getText().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Consulte primero los datos del grupo", "Advertencia", JOptionPane.WARNING_MESSAGE);
	                    return;
	                }

	                // Crear documento PDF
	                String filename = "grupo_" + cbGrupos.getSelectedItem() + ".pdf";
	                PdfWriter writer = new PdfWriter(filename);
	                PdfDocument pdf = new PdfDocument(writer);
	                Document document = new Document(pdf);
	                
	                // Encabezado
	                Paragraph header = new Paragraph("Universidad Autónoma de Baja California Sur")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(20)
	                    .setBold();
	                
	                Paragraph subheader = new Paragraph("Información del Grupo")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(16)
	                    .setMarginBottom(20);
	                
	                document.add(header);
	                document.add(subheader);
	                
	                // Tabla de información
	                float[] columnWidths = {150f, 350f};
	                Table table = new Table(columnWidths);
	                
	                // Agregar filas con la información
	                addTableRow(table, "ID Grupo", cbGrupos.getSelectedItem().toString());
	                addTableRow(table, "Carrera", txtCarrera.getText());
	                addTableRow(table, "Asignatura", cbAsignatura.getSelectedItem().toString());
	                addTableRow(table, "Docente", cbDocente.getSelectedItem().toString());
	                addTableRow(table, "Semestre", txtSemestre.getText());
	                addTableRow(table, "Número de Alumnos", txtNumAlumnos.getText());
	                
	                document.add(table);
	                document.close();
	                
	                JOptionPane.showMessageDialog(null, "PDF generado exitosamente como: " + filename);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        
	        private void addTableRow(Table table, String header, String value) {
	            // Header cell
	            Cell headerCell = new Cell()
	                .add(new Paragraph(header))
	                .setBold()
	                .setBackgroundColor(new DeviceRgb(240, 240, 240));
	            
	            // Value cell
	            Cell valueCell = new Cell()
	                .add(new Paragraph(value != null ? value : ""));
	            
	            table.addCell(headerCell);
	            table.addCell(valueCell);
	        }
	    });

	    return fondo;
	}
	
	public JPanel consultarAsignatura() {
	    // Variables para control de navegación
	    anterior = actual;
	    actual = "consultarAsignatura";
	    
	    // Panel principal
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);
	    fondo.setLayout(null);
	    getContentPane().add(fondo);

	    // Título principal
	    JLabel lblTitulo = new JLabel("Consultar Asignatura");
	    lblTitulo.setForeground(Color.BLACK);
	    lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 36));
	    lblTitulo.setBounds(150, 30, 500, 50);
	    fondo.add(lblTitulo);

	    // Panel de contenido (verde)
	    JPanel panelContenido = new JPanel();
	    panelContenido.setBackground(new Color(0, 128, 64));
	    panelContenido.setBounds(100, 100, 600, 550);
	    fondo.add(panelContenido);
	    panelContenido.setLayout(null);

	    // ComboBox para selección de asignatura
	    JLabel lblSeleccionAsignatura = new JLabel("Seleccione una Asignatura:");
	    lblSeleccionAsignatura.setForeground(Color.WHITE);
	    lblSeleccionAsignatura.setFont(new Font("SansSerif", Font.BOLD, 16));
	    lblSeleccionAsignatura.setBounds(30, 30, 250, 20);
	    panelContenido.add(lblSeleccionAsignatura);

	    BD bd = new BD();
	    JComboBox<Integer> cbAsignaturas = new JComboBox<>();
	    cbAsignaturas.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsAsignatura().toArray(new Integer[0])));
	    cbAsignaturas.setFont(new Font("SansSerif", Font.PLAIN, 14));
	    cbAsignaturas.setBounds(30, 55, 250, 30);
	    panelContenido.add(cbAsignaturas);

	    // Campos de información de la asignatura
	    String[] etiquetas = {"Nombre:", "Créditos:", "Docente a cargo:", "Semestres:"};
	    
	    JTextField txtCreditos = new JTextField();
	    JTextField txtSemestres = new JTextField();
	    JComboBox<String> cbNombreAsignatura = new JComboBox<>();
	    JComboBox<String> cbDocente = new JComboBox<>();
	    
	    int yPos = 110;
	    for (int i = 0; i < etiquetas.length; i++) {
	        // Etiqueta
	        JLabel label = new JLabel(etiquetas[i]);
	        label.setForeground(Color.WHITE);
	        label.setFont(new Font("SansSerif", Font.BOLD, 16));
	        label.setBounds(30, yPos, 250, 20);
	        panelContenido.add(label);

	        // Componente de entrada
	        if (i == 0) { // Nombre (ComboBox)
	            cbNombreAsignatura.setEnabled(false);
	            cbNombreAsignatura.setFont(new Font("SansSerif", Font.PLAIN, 14));
	            cbNombreAsignatura.setBounds(30, yPos + 25, 250, 30);
	            panelContenido.add(cbNombreAsignatura);
	            
	            // Llenar combobox de asignaturas
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT Nombre FROM asignaturasbd");
	                while (rs.next()) {
	                    cbNombreAsignatura.addItem(rs.getString("Nombre"));
	                }
	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            yPos += 70;
	        } else if (i == 2) { // Docente (ComboBox)
	            cbDocente.setEnabled(false);
	            cbDocente.setFont(new Font("SansSerif", Font.PLAIN, 14));
	            cbDocente.setBounds(30, yPos + 25, 250, 30);
	            panelContenido.add(cbDocente);
	            
	            // Llenar combobox de docentes
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT Nombre FROM docentesbd");
	                while (rs.next()) {
	                    cbDocente.addItem(rs.getString("Nombre"));
	                }
	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            
	            yPos += 70;
	        } else { // Campos de texto
	            JTextField textField = (i == 1) ? txtCreditos : txtSemestres;
	            textField.setEditable(false);
	            textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
	            textField.setBounds(30, yPos + 25, 250, 30);
	            panelContenido.add(textField);
	            yPos += 70;
	        }
	    }

	    // Imagen representativa
	    JLabel lblImagenAsignatura = new JLabel("");
	    ImageIcon imageIcon = new ImageIcon(new ImageIcon("img/perfil.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
	    lblImagenAsignatura.setIcon(imageIcon);
	    lblImagenAsignatura.setBounds(350, 50, 180, 180);
	    panelContenido.add(lblImagenAsignatura);

	    // Logo UABCS
	    JLabel lblLogoUABCS = new JLabel("");
	    ImageIcon logoIcon = new ImageIcon(new ImageIcon("img/uabcs.png").getImage().getScaledInstance(300, 120, Image.SCALE_DEFAULT));
	    lblLogoUABCS.setIcon(logoIcon);
	    lblLogoUABCS.setBounds(300, 360, 300, 120);
	    panelContenido.add(lblLogoUABCS);

	    // Botones de edición
	    JButton btnEditar = new JButton("Editar");
	    btnEditar.setForeground(Color.WHITE);
	    btnEditar.setBackground(new Color(0, 128, 255));
	    btnEditar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnEditar.setBounds(340, 250, 100, 35);
	    panelContenido.add(btnEditar);

	    JButton btnGuardar = new JButton("Guardar");
	    btnGuardar.setForeground(Color.WHITE);
	    btnGuardar.setBackground(new Color(0, 180, 0));
	    btnGuardar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnGuardar.setBounds(450, 250, 100, 35);
	    btnGuardar.setEnabled(false);
	    panelContenido.add(btnGuardar);

	    // Botones inferiores
	    JButton btnVolver = new RoundButtonRojo("Volver");
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setBackground(new Color(255, 0, 0));
	    btnVolver.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnVolver.setBounds(150, 680, 120, 40);
	    fondo.add(btnVolver);

	    JButton btnConsultar = new JButton("Consultar");
	    btnConsultar.setForeground(Color.WHITE);
	    btnConsultar.setBackground(new Color(0, 128, 255));
	    btnConsultar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnConsultar.setBounds(300, 680, 120, 40);
	    fondo.add(btnConsultar);

	    JButton btnDescargar = new JButton("Descargar PDF");
	    btnDescargar.setForeground(Color.WHITE);
	    btnDescargar.setBackground(new Color(0, 128, 255));
	    btnDescargar.setFont(new Font("SansSerif", Font.BOLD, 14));
	    btnDescargar.setBounds(450, 680, 150, 40);
	    fondo.add(btnDescargar);

	    // Listeners de botones
	    // Botón Consultar
	    btnConsultar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            int idConsultar = (int) cbAsignaturas.getSelectedItem();
	            BD bd = new BD();
	            try {
	                Connection cn = bd.Conectar();
	                Statement stm = cn.createStatement();
	                ResultSet rs = stm.executeQuery("SELECT * FROM asignaturasbd WHERE idAsignatura = " + idConsultar);

	                if (rs.next()) {
	                    // Obtener datos de la base de datos
	                    cbNombreAsignatura.setSelectedItem(rs.getString("Nombre"));
	                    txtCreditos.setText(rs.getString("Creditos"));
	                    cbDocente.setSelectedItem(rs.getString("Docente"));
	                    txtSemestres.setText(rs.getString("Semestre"));
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se encontró la asignatura", "Error", JOptionPane.ERROR_MESSAGE);
	                }

	                rs.close();
	                stm.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al consultar la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    // Botón Editar
	    btnEditar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            cbNombreAsignatura.setEnabled(true);
	            cbDocente.setEnabled(true);
	            txtCreditos.setEditable(true);
	            txtSemestres.setEditable(true);
	            btnGuardar.setEnabled(true);
	        }
	    });

	    // Botón Guardar
	    btnGuardar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                BD bd = new BD();
	                Connection cn = bd.Conectar();
	                PreparedStatement pstmt = (PreparedStatement) cn.prepareStatement(
	                    "UPDATE asignaturasbd SET Nombre = ?, Creditos = ?, Docente = ?, Semestre = ? WHERE idAsignatura = ?");
	                
	                pstmt.setString(1, cbNombreAsignatura.getSelectedItem().toString());
	                pstmt.setString(2, txtCreditos.getText());
	                pstmt.setString(3, cbDocente.getSelectedItem().toString());
	                pstmt.setString(4, txtSemestres.getText());
	                pstmt.setInt(5, (int) cbAsignaturas.getSelectedItem());

	                int filasAfectadas = pstmt.executeUpdate();
	                if (filasAfectadas > 0) {
	                    JOptionPane.showMessageDialog(null, "Cambios guardados exitosamente");
	                    cbNombreAsignatura.setEnabled(false);
	                    cbDocente.setEnabled(false);
	                    txtCreditos.setEditable(false);
	                    txtSemestres.setEditable(false);
	                    btnGuardar.setEnabled(false);
	                } else {
	                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la asignatura");
	                }

	                pstmt.close();
	                cn.close();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar los cambios", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    // Botón Volver
	    btnVolver.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuAsignaturas";
	            add(menuAsignaturas());
	            repaint();
	            revalidate();
	        }
	    });

	    // Botón Descargar PDF
	    btnDescargar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                // Validar que hay datos para exportar
	                if (txtCreditos.getText().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Consulte primero los datos de la asignatura", "Advertencia", JOptionPane.WARNING_MESSAGE);
	                    return;
	                }

	                // Crear documento PDF
	                String filename = "asignatura_" + cbAsignaturas.getSelectedItem() + ".pdf";
	                PdfWriter writer = new PdfWriter(filename);
	                PdfDocument pdf = new PdfDocument(writer);
	                Document document = new Document(pdf);
	                
	                // Encabezado
	                Paragraph header = new Paragraph("Universidad Autónoma de Baja California Sur")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(20)
	                    .setBold();
	                
	                Paragraph subheader = new Paragraph("Información de la Asignatura")
	                    .setTextAlignment(TextAlignment.CENTER)
	                    .setFontSize(16)
	                    .setMarginBottom(20);
	                
	                document.add(header);
	                document.add(subheader);
	                
	                // Tabla de información
	                float[] columnWidths = {150f, 350f};
	                Table table = new Table(columnWidths);
	                
	                // Agregar filas con la información
	                addTableRow(table, "ID Asignatura", cbAsignaturas.getSelectedItem().toString());
	                addTableRow(table, "Nombre", cbNombreAsignatura.getSelectedItem().toString());
	                addTableRow(table, "Créditos", txtCreditos.getText());
	                addTableRow(table, "Docente", cbDocente.getSelectedItem().toString());
	                addTableRow(table, "Semestres", txtSemestres.getText());
	                
	                document.add(table);
	                document.close();
	                
	                JOptionPane.showMessageDialog(null, "PDF generado exitosamente como: " + filename);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        
	        private void addTableRow(Table table, String header, String value) {
	            // Header cell
	            Cell headerCell = new Cell()
	                .add(new Paragraph(header))
	                .setBold()
	                .setBackgroundColor(new DeviceRgb(240, 240, 240));
	            
	            // Value cell
	            Cell valueCell = new Cell()
	                .add(new Paragraph(value != null ? value : ""));
	            
	            table.addCell(headerCell);
	            table.addCell(valueCell);
	        }
	    });

	    return fondo;
	}
	
	
	////FUNCIONES CREDENCIAL//////
	public JPanel credencialAlumno() {
	    // Variables para control de navegación
	    anterior = actual;
	    actual = "credencialAlumno";
	    
	    // Panel principal con nuevo tamaño
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Nuevo tamaño 800x800
	    getContentPane().add(fondo);
	    fondo.setLayout(null);
	    
	    // Título del panel
	    JLabel titulo = new JLabel("Alumno - Generar Credencial");
	    titulo.setForeground(new Color(0, 0, 0));
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.PLAIN, 32));  // Tamaño de fuente aumentado
	    titulo.setBounds(150, 20, 500, 50);  // Ajuste de posición y tamaño
	    fondo.add(titulo);
	    
	    // Panel para el contenido principal
	    JPanel contenido = new JPanel();
	    contenido.setBackground(new Color(0, 128, 64));
	    contenido.setBounds(100, 80, 600, 600);  // Ajuste de tamaño y posición
	    fondo.add(contenido);
	    contenido.setLayout(null);
	    
	    // Conexión con la base de datos para obtener IDs de alumnos
	    BD bd = new BD();
	    JComboBox<Integer> comboBoxID = new JComboBox<>();
	    comboBoxID.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsAlumnos().toArray(new Integer[0])));
	    comboBoxID.setBounds(50, 20, 200, 30);  // Ajuste de tamaño y posición
	    comboBoxID.setFont(new Font("SansSerif", Font.PLAIN, 16));  // Fuente más grande
	    contenido.add(comboBoxID);
	    
	    // Campos de texto para los datos del alumno (ocultos, solo para PDF)
	    JTextField datos_nombre = new JTextField();
	    JTextField datos_apePaterno = new JTextField();            
	    JTextField datos_apeMaterno = new JTextField();
	    JTextField datos_correo = new JTextField();
	    JTextField datos_direccion = new JTextField();
	    
	    // Botón para volver al menú anterior
	    RoundButtonRojo volverBtn = new RoundButtonRojo("Volver");
	    volverBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuAlumnos";
	            add(menuAlumnos());
	            repaint();
	            revalidate();
	        }
	    });
	    volverBtn.setForeground(Color.WHITE);
	    volverBtn.setBackground(Color.RED);
	    volverBtn.setFont(new Font("SansSerif", Font.BOLD, 16));  // Fuente más grande
	    volverBtn.setBounds(200, 700, 150, 50);  // Ajuste de posición y tamaño
	    fondo.add(volverBtn);
	    
	    // Botón para descargar la credencial
	    JButton descargarBtn = new JButton("Descargar");
	    descargarBtn.addActionListener(new ActionListener() {
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
	            
	            if(cambio == 0) {
	                JOptionPane.showMessageDialog(null, "ID de alumno inválido. Favor de intentar de nuevo");
	            }
	            cambio = 0;
	            
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
	    descargarBtn.setForeground(Color.WHITE);
	    descargarBtn.setBackground(new Color(0, 128, 255));
	    descargarBtn.setFont(new Font("SansSerif", Font.BOLD, 16));  // Fuente más grande
	    descargarBtn.setBounds(450, 700, 150, 50);  // Ajuste de posición y tamaño
	    fondo.add(descargarBtn);
	    
	    // Imagen frontal de la credencial
	    JLabel imagenFrontal = new JLabel("");
	    ImageIcon imageIconFrontal = new ImageIcon(new ImageIcon("img/credencialF.png").getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));  // Tamaño aumentado
	    imagenFrontal.setIcon(imageIconFrontal);
	    imagenFrontal.setBounds(50, 70, 500, 250);  // Ajuste de posición
	    contenido.add(imagenFrontal);
	    
	    // Imagen trasera de la credencial
	    JLabel imagenTrasera = new JLabel("");
	    ImageIcon imageIconTrasera = new ImageIcon(new ImageIcon("img/credencialT.png").getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));  // Tamaño aumentado
	    imagenTrasera.setIcon(imageIconTrasera);
	    imagenTrasera.setBounds(50, 330, 500, 250);  // Ajuste de posición
	    contenido.add(imagenTrasera);
	    
	    // Panel decorativo superior
	    JPanel panelSuperior = new JPanel();
	    panelSuperior.setBackground(new Color(225, 225, 225));
	    panelSuperior.setBounds(0, 0, 800, 20);  // Ajuste de tamaño
	    fondo.add(panelSuperior);
	    
	    this.add(fondo);
	    return fondo;
	}
	
	public JPanel credencialDocente() {
	    // Variables para control de navegación
	    anterior = actual;
	    actual = "credencialDocente";
	    
	    // Panel principal con nuevo tamaño
	    JPanel fondo = new JPanel();
	    fondo.setBackground(new Color(225, 225, 225));
	    fondo.setBounds(0, 0, 800, 800);  // Nuevo tamaño 800x800
	    getContentPane().add(fondo);
	    fondo.setLayout(null);
	    
	    // Título del panel
	    JLabel titulo = new JLabel("Docente - Generar Credencial");
	    titulo.setForeground(Color.BLACK);
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setFont(new Font("SansSerif", Font.PLAIN, 32));  // Tamaño de fuente aumentado
	    titulo.setBounds(150, 20, 500, 50);  // Ajuste de posición y tamaño
	    fondo.add(titulo);
	    
	    // Panel para el contenido principal
	    JPanel contenido = new JPanel();
	    contenido.setBackground(new Color(0, 128, 64));  // Verde oscuro
	    contenido.setBounds(100, 80, 600, 600);  // Ajuste de tamaño y posición
	    fondo.add(contenido);
	    contenido.setLayout(null);
	    
	    // Conexión con la base de datos para obtener IDs de docentes
	    BD bd = new BD();
	    JComboBox<Integer> comboBoxID = new JComboBox<>();
	    comboBoxID.setModel(new DefaultComboBoxModel<>(bd.obtenerIDsDocente().toArray(new Integer[0])));
	    comboBoxID.setBounds(50, 20, 200, 30);  // Ajuste de tamaño y posición
	    comboBoxID.setFont(new Font("SansSerif", Font.PLAIN, 16));  // Fuente más grande
	    contenido.add(comboBoxID);
	    
	    // Campos de texto para los datos del docente (ocultos, solo para PDF)
	    JTextField datos_nombre = new JTextField();
	    JTextField datos_apePaterno = new JTextField();            
	    JTextField datos_apeMaterno = new JTextField();
	    JTextField datos_correo = new JTextField();
	    JTextField datos_direccion = new JTextField();
	    
	    // Botón para volver al menú anterior
	    RoundButtonRojo volverBtn = new RoundButtonRojo("Volver");
	    volverBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            remove(fondo);
	            anterior = actual;
	            actual = "menuDocentes";
	            add(menuDocentes());
	            repaint();
	            revalidate();
	        }
	    });
	    volverBtn.setForeground(Color.WHITE);
	    volverBtn.setBackground(Color.RED);
	    volverBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
	    volverBtn.setBounds(200, 700, 150, 50);  // Ajuste de posición y tamaño
	    fondo.add(volverBtn);
	    
	    // Botón para descargar la credencial
	    JButton descargarBtn = new JButton("Descargar");
	    descargarBtn.addActionListener(new ActionListener() {
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
	            
	            if(cambio == 0) {
	                JOptionPane.showMessageDialog(null, "ID de docente inválido. Favor de intentar de nuevo");
	            }
	            cambio = 0;
	            
	            try {
	                // Crear el archivo PDF para docente
	                PdfWriter writer = new PdfWriter(new FileOutputStream("credencialDocente.pdf"));
	                com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
	                com.itextpdf.layout.Document document = new com.itextpdf.layout.Document(pdfDoc);

	                // Agregar las imágenes específicas para docente
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

	                // Agregar el texto a la capa de texto (posiciones ajustadas)
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

	                JOptionPane.showMessageDialog(null, "Credencial de docente generada correctamente.", "Generar PDF", JOptionPane.INFORMATION_MESSAGE);
	            } catch (FileNotFoundException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al generar la credencial.", "Generar PDF", JOptionPane.ERROR_MESSAGE);
	            } catch (MalformedURLException e1) {
	                e1.printStackTrace();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    });
	    descargarBtn.setForeground(Color.WHITE);
	    descargarBtn.setBackground(new Color(0, 128, 255));
	    descargarBtn.setFont(new Font("SansSerif", Font.BOLD, 16));
	    descargarBtn.setBounds(450, 700, 150, 50);
	    fondo.add(descargarBtn);
	    
	    // Imagen frontal de la credencial docente
	    JLabel imagenFrontal = new JLabel("");
	    ImageIcon imageIconFrontal = new ImageIcon(new ImageIcon("img/credencialDF.png").getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
	    imagenFrontal.setIcon(imageIconFrontal);
	    imagenFrontal.setBounds(50, 70, 500, 250);
	    contenido.add(imagenFrontal);
	    
	    // Imagen trasera de la credencial docente
	    JLabel imagenTrasera = new JLabel("");
	    ImageIcon imageIconTrasera = new ImageIcon(new ImageIcon("img/credencialDT.png").getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH));
	    imagenTrasera.setIcon(imageIconTrasera);
	    imagenTrasera.setBounds(50, 330, 500, 250);
	    contenido.add(imagenTrasera);
	    
	    // Panel decorativo superior
	    JPanel panelSuperior = new JPanel();
	    panelSuperior.setBackground(new Color(225, 225, 225));
	    panelSuperior.setBounds(0, 0, 800, 20);
	    fondo.add(panelSuperior);
	    
	    this.add(fondo);
	    return fondo;
	}

	
	
	////////FUNCION LIMPIAR VENTANA/////
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
                        String sql = "DELETE FROM asignaturasbd WHERE idAsignatura = " + idAsignatura;
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
	
	
	public class RoundedImageLabel extends JLabel {
	    private int cornerRadius;

	    public RoundedImageLabel(int cornerRadius) {
	        this.cornerRadius = cornerRadius;
	        setOpaque(false);
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        
	        // Crear un área de recorte con esquinas redondeadas
	        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
	            0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
	        g2.setClip(roundedRectangle);
	        
	        // Dibujar la imagen
	        super.paintComponent(g2);
	        
	        // Opcional: dibujar un borde
	        g2.setClip(null);
	        g2.setColor(new Color(150, 150, 150, 100)); // Color gris semitransparente
	        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, cornerRadius, cornerRadius);
	        
	        g2.dispose();
	    }
	}
}


