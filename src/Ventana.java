import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;


public class Ventana extends JFrame{
	private String anterior = "login";
	private String actual = "login";
	private JTextField username;
	private JPasswordField password;
	public JPanel panel = null;
	
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
				actual = "registro";
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
		
		JButton btnDescargarAlu = new JButton("<html>Descargar información<html>");
		btnDescargarAlu.setBackground(new Color(121, 255, 145));
		btnDescargarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDescargarAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDescargarAlu.setBounds(51, 144, 90, 59);
		fondo.add(btnDescargarAlu);
		
		JButton btnDescargarDoce = new JButton("<html>Descargar información<html>");
		btnDescargarDoce.setBackground(new Color(121, 255, 145));
		btnDescargarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDescargarDoce.setBounds(176, 144, 90, 59);
		fondo.add(btnDescargarDoce);
		
		JButton btnCredAlu = new JButton("<html>Generar Credencial<html>");
		btnCredAlu.setBackground(new Color(121, 255, 145));
		btnCredAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCredAlu.setBounds(51, 224, 90, 59);
		fondo.add(btnCredAlu);
		
		JButton btnCredDoce = new JButton("<html>Generar Credencial<html>");
		btnCredDoce.setBackground(new Color(121, 255, 145));
		btnCredDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCredDoce.setBounds(176, 224, 90, 59);
		fondo.add(btnCredDoce);
		
		JButton btnConsultarAlu = new JButton("Consultar");
		btnConsultarAlu.setBackground(new Color(121, 255, 145));
		btnConsultarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarAlu.setBounds(51, 305, 90, 40);
		fondo.add(btnConsultarAlu);
		
		JButton btnConsultarDoce = new JButton("Consultar");
		btnConsultarDoce.setBackground(new Color(121, 255, 145));
		btnConsultarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarDoce.setBounds(176, 305, 90, 40);
		fondo.add(btnConsultarDoce);
		
		JButton btnCrearAlu = new JButton("Crear");
		btnCrearAlu.setBackground(new Color(121, 255, 145));
		btnCrearAlu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearAlu.setBounds(51, 366, 90, 40);
		fondo.add(btnCrearAlu);
		
		JButton btnCrearDoce = new JButton("Crear");
		btnCrearDoce.setBackground(new Color(121, 255, 145));
		btnCrearDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearDoce.setBounds(176, 366, 90, 40);
		fondo.add(btnCrearDoce);
		
		JButton btnEditarAlu = new JButton("Editar");
		btnEditarAlu.setBackground(new Color(121, 255, 145));
		btnEditarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarAlu.setBounds(51, 427, 90, 40);
		fondo.add(btnEditarAlu);
		
		JButton btnEditarDoce = new JButton("Editar");
		btnEditarDoce.setBackground(new Color(121, 255, 145));
		btnEditarDoce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarDoce.setBounds(176, 427, 90, 40);
		fondo.add(btnEditarDoce);
		
		JButton btnEliminarAlu = new JButton("Eliminar");
		btnEliminarAlu.setBackground(new Color(121, 255, 145));
		btnEliminarAlu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarAlu.setBounds(51, 496, 90, 40);
		fondo.add(btnEliminarAlu);
		
		JButton btnEliminarDoce = new JButton("Eliminar");
		btnEliminarDoce.setBackground(new Color(121, 255, 145));
		btnEliminarDoce.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarDoce.setBounds(176, 496, 90, 40);
		fondo.add(btnEliminarDoce);
		
		JButton btnDescargarGrup = new JButton("<html>Descargar información<html>");
		btnDescargarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDescargarGrup.setBackground(new Color(121, 255, 145));
		btnDescargarGrup.setBounds(308, 144, 90, 59);
		fondo.add(btnDescargarGrup);
		
		JButton btnConsultarGrup = new JButton("Consultar");
		btnConsultarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarGrup.setBackground(new Color(121, 255, 145));
		btnConsultarGrup.setBounds(308, 224, 90, 40);
		fondo.add(btnConsultarGrup);
		
		JButton btnCrearGrup = new JButton("Crear");
		btnCrearGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearGrup.setBackground(new Color(121, 255, 145));
		btnCrearGrup.setBounds(308, 285, 90, 40);
		fondo.add(btnCrearGrup);
		
		JButton btnEditarGrup = new JButton("Editar");
		btnEditarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarGrup.setBackground(new Color(121, 255, 145));
		btnEditarGrup.setBounds(308, 346, 90, 40);
		fondo.add(btnEditarGrup);
		
		JButton btnEliminarGrup = new JButton("Eliminar");
		btnEliminarGrup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarGrup.setBackground(new Color(121, 255, 145));
		btnEliminarGrup.setBounds(308, 415, 90, 40);
		fondo.add(btnEliminarGrup);
		
		JButton btnConsultarAsig = new JButton("Consultar");
		btnConsultarAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarAsig.setBackground(new Color(121, 255, 145));
		btnConsultarAsig.setBounds(445, 144, 90, 40);
		fondo.add(btnConsultarAsig);
		
		JButton btnCrearAsig = new JButton("Crear");
		btnCrearAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearAsig.setBackground(new Color(121, 255, 145));
		btnCrearAsig.setBounds(445, 205, 90, 40);
		fondo.add(btnCrearAsig);
		
		JButton btnEditarAsig = new JButton("Editar");
		btnEditarAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditarAsig.setBackground(new Color(121, 255, 145));
		btnEditarAsig.setBounds(445, 266, 90, 40);
		fondo.add(btnEditarAsig);
		
		JButton btnEliminarAsig = new JButton("Eliminar");
		btnEliminarAsig.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminarAsig.setBackground(new Color(121, 255, 145));
		btnEliminarAsig.setBounds(445, 335, 90, 40);
		fondo.add(btnEliminarAsig);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrarSesion.setBackground(new Color(255, 0, 0));
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
	}
}
