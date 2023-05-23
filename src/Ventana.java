import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Ventana extends JFrame{
	
	public Ventana() {
		this.setTitle("Sistema Escolar");
		this.setSize(600,600);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
