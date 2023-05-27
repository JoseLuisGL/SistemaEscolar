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
