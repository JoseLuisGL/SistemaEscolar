package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTable table;
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
	public JButton button;
	public JComboBox comboBox;
	public JButton btnGuardarDocente;
	public JComboBox comboBoxD;
	public JComboBox ano_nacimientoD,mes_nacimientoD,dia_nacimientoD;

	public Ventana() {
		cvbd = new ControlVistaBD(this);
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
				String usuario = username.getText();
				
				char[] passwordChars = password.getPassword();
				String password = new String(passwordChars);
				System.out.println(password);

			
				Arrays.fill(passwordChars, ' ');
				
				  BD bd = new BD();
			        try {
			            Connection cn = bd.Conectar();
			            Statement stm = cn.createStatement();
			            ResultSet rs = stm.executeQuery("SELECT * FROM admin");
            
			            while (rs.next()) {		            
			                String nombre = rs.getString("Nombre");
			                String pass = rs.getString("Contrasena");
			                
			                if(usuario.equals(nombre) && pass.equals(pass)) {
			                	JOptionPane.showMessageDialog(null, "¡Datos correctos. Bienveneido "+nombre+"!");
			                	remove(fondo);
			    				anterior = actual;
			    				actual = "menu";
			    				add(menu());
			    				repaint();

			            
			                }else {
			                	JOptionPane.showMessageDialog(null, "Datos Erroneos. Intentar denuevo.");
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
		btnEliminarAlu.setBounds(51, 345, 90, 40);
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
		btnEliminarDoce.setBounds(176, 345, 90, 40);
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
		btnEliminarGrup.setBounds(308, 266, 90, 40);
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
		btnEliminarAsig.setBounds(445, 266, 90, 40);
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
		cvbd = new ControlVistaBD(this);
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
		
		JLabel tag2 = new JLabel("Apellido Paterno:");
		tag2.setBounds(25, 62, 150, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tagam = new JLabel("Apellido Materno:");
		tagam.setBounds(250, 62, 150, 25);
		fondo2.add(tagam);
		tagam.setHorizontalAlignment(SwingConstants.LEFT);
		tagam.setForeground(new Color(255, 255, 255));
		tagam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tagam.setBackground(Color.WHITE);
		
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
		
		JLabel tag6 = new JLabel("Foto (Opcional):");
		tag6.setBounds(25, 277, 130, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JLabel direccion = new JLabel("Direccion (Opcional):");
		direccion.setBounds(250, 277, 160, 25);
		fondo2.add(direccion);
		direccion.setHorizontalAlignment(SwingConstants.LEFT);
		direccion.setForeground(new Color(255, 255, 255));
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		direccion.setBackground(Color.WHITE);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(0, 128, 192));
		txtNombre.setBounds(25, 36, 420, 25);
		fondo2.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidoPaterno = new JTextField();
		txtApellidoPaterno.setColumns(10);
		txtApellidoPaterno.setBackground(new Color(0, 128, 192));
		txtApellidoPaterno.setBounds(25, 86, 150, 25);
		fondo2.add(txtApellidoPaterno);
		
		txtApellidoMaterno = new JTextField();
		txtApellidoMaterno.setColumns(10);
		txtApellidoMaterno.setBackground(new Color(0, 128, 192));
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
		txtCorreo.setBackground(new Color(0, 128, 192));
		txtCorreo.setBounds(25, 195, 420, 25);
		fondo2.add(txtCorreo);
		
		txtTelefono = new JTextField(10);
		txtTelefono.setColumns(10);
		txtTelefono.setBackground(new Color(0, 128, 192));
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
		txtDireccion.setBackground(new Color(0, 128, 192));
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
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				remove(comboBox);
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
		panelSuperior.setBackground(new Color(101, 103, 3));
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
		
		JLabel tag2 = new JLabel("Apellido Paterno:");
		tag2.setBounds(25, 62, 150, 25);
		fondo2.add(tag2);
		tag2.setHorizontalAlignment(SwingConstants.LEFT);
		tag2.setForeground(new Color(255, 255, 255));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBackground(Color.WHITE);
		
		JLabel tagam = new JLabel("Apellido Materno:");
		tagam.setBounds(250, 62, 150, 25);
		fondo2.add(tagam);
		tagam.setHorizontalAlignment(SwingConstants.LEFT);
		tagam.setForeground(new Color(255, 255, 255));
		tagam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tagam.setBackground(Color.WHITE);
		
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
		
		JLabel tag7 = new JLabel("Grado Academico:");
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
		
		JLabel tag6 = new JLabel("Foto (Opcional):");
		tag6.setBounds(25, 277, 130, 25);
		fondo2.add(tag6);
		tag6.setHorizontalAlignment(SwingConstants.LEFT);
		tag6.setForeground(new Color(255, 255, 255));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag6.setBackground(Color.WHITE);
		
		JLabel direccion = new JLabel("Direccion (Opcional):");
		direccion.setBounds(250, 277, 160, 25);
		fondo2.add(direccion);
		direccion.setHorizontalAlignment(SwingConstants.LEFT);
		direccion.setForeground(new Color(255, 255, 255));
		direccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		direccion.setBackground(Color.WHITE);
		
		txtNombreD = new JTextField();
		txtNombreD.setBackground(new Color(0, 128, 192));
		txtNombreD.setBounds(25, 36, 420, 25);
		fondo2.add(txtNombreD);
		txtNombreD.setColumns(10);
		
		txtApellidoPaternoD = new JTextField();
		txtApellidoPaternoD.setColumns(10);
		txtApellidoPaternoD.setBackground(new Color(0, 128, 192));
		txtApellidoPaternoD.setBounds(25, 86, 150, 25);
		fondo2.add(txtApellidoPaternoD);
		
		txtApellidoMaternoD = new JTextField();
		txtApellidoMaternoD.setColumns(10);
		txtApellidoMaternoD.setBackground(new Color(0, 128, 192));
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
		txtCorreoD.setBackground(new Color(0, 128, 192));
		txtCorreoD.setBounds(25, 195, 420, 25);
		fondo2.add(txtCorreoD);
		
		txtTelefonoD = new JTextField(10);
		txtTelefonoD.setColumns(10);
		txtTelefonoD.setBackground(new Color(0, 128, 192));
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
		txtDireccionD.setBackground(new Color(0, 128, 192));
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
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(fondo);
				remove(comboBoxD);
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
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
		this.add(fondo);
		return fondo;
	}
				
	public JPanel eliminarAlumno() {
        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(49, 64, 81));
        fondo.setBounds(0, 0, 584, 561);
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
        
        JButton Volver = new JButton("Volver");
        Volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(fondo);
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

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(101, 103, 3));
        panelSuperior.setBounds(0, 0, 600, 13);
        fondo.add(panelSuperior);
        
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 13);
		fondo.add(panelSuperior);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 13);
		fondo.add(panelSuperior);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 13);
		fondo.add(panelSuperior);
		
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
		
		JLabel tag1 = new JLabel("Ingrese el ID del alumno");
		tag1.setForeground(new Color(0, 0, 0));
		tag1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag1.setBounds(10, 24, 210, 14);
		fondo2.add(tag1);
		
		JLabel tagnombre = new JLabel("Nombre");
		tagnombre.setForeground(new Color(0, 0, 0));
		tagnombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tagnombre.setBounds(10, 70, 210, 20);
		fondo2.add(tagnombre);
		
		JLabel tag2 = new JLabel("Apellido Paterno");
		tag2.setForeground(new Color(0, 0, 0));
		tag2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2.setBounds(10, 114, 210, 20);
		fondo2.add(tag2);
		
		JLabel tag2_1 = new JLabel("Apellido Materno");
		tag2_1.setForeground(new Color(0, 0, 0));
		tag2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag2_1.setBounds(160, 114, 210, 20);
		fondo2.add(tag2_1);
		
		JLabel tag3 = new JLabel("Correo electrónico");
		tag3.setForeground(new Color(0, 0, 0));
		tag3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag3.setBounds(10, 158, 210, 14);
		fondo2.add(tag3);
		
		JLabel tag4 = new JLabel("Fecha de nacimiento");
		tag4.setForeground(new Color(0, 0, 0));
		tag4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag4.setBounds(10, 201, 210, 14);
		fondo2.add(tag4);
		
		JLabel tag5 = new JLabel("Teléfono");
		tag5.setForeground(new Color(0, 0, 0));
		tag5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tag5.setBounds(10, 242, 210, 14);
		fondo2.add(tag5);
		
		JLabel tag6 = new JLabel("Direccion");
		tag6.setForeground(new Color(0, 0, 0));
		tag6.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		Consultar.setBackground(new Color(255, 0, 0));
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
		panelSuperior.setBackground(new Color(101, 103, 3));
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
		
		JLabel tag1 = new JLabel("Seleccione un Docente");
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
		
		JComboBox seleccionDocente = new JComboBox();
		seleccionDocente.setBounds(10, 45, 273, 22);
		fondo2.add(seleccionDocente);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
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
		
		JLabel tag1 = new JLabel("Seleccione un Grupo:");
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
		
		JComboBox seleccionGrupo = new JComboBox();
		seleccionGrupo.setBounds(10, 45, 273, 22);
		fondo2.add(seleccionGrupo);
		
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
		
		JLabel tag1 = new JLabel("Seleccione una Asignatura:");
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
		
		JComboBox seleccionAsignatura = new JComboBox();
		seleccionAsignatura.setBounds(10, 45, 273, 22);
		fondo2.add(seleccionAsignatura);
		
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
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
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
		panelSuperior.setBackground(new Color(101, 103, 3));
		panelSuperior.setBounds(0, 0, 600, 15);
		fondo.add(panelSuperior);
		
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
		panelSuperior.setBackground(new Color(101, 103, 3));
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
}

