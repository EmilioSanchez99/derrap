package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ConectorBD;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	ConectorBD conexion=new ConectorBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
		getContentPane().setBackground(new Color(191, 255, 244));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(null);
		this.setUndecorated(false);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

        
        
		
		
		//Colores A2CED8
		Color azulBarra = new Color (0x0F296B);
		Color azulFondo = new Color (0xA2CED8);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(222, 209, 229, 26);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(309, 185, 64, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Verdana", Font.BOLD, 12));
		lblContrasea.setBounds(300, 262, 89, 14);
		getContentPane().add(lblContrasea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.comprobarUsuario(txtUsuario.getText(),txtContrasena.getText());
				dispose();
			}	
			
		});
		
		btnAceptar.setBounds(222, 345, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(362, 345, 89, 23);
		getContentPane().add(btnSalir);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(222, 286, 229, 26);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		txtContrasena.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            conexion.comprobarUsuario(txtUsuario.getText(), txtContrasena.getText());
		            dispose();
		        }
		    }
		});

		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(267, 31, 133, 110);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
	}
}
