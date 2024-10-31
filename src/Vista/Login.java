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
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

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
		getContentPane().setBackground(new Color(162, 206, 216));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(null);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);

        
        
		
		
		//Colores A2CED8
		Color azulBarra = new Color (0x0F296B);
		Color azulFondo = new Color (0xA2CED8);
		
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1200, 100);
		getContentPane().add(panel);
		
		panel.setBackground(azulBarra);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DERRAP");
		lblNewLabel_1.setForeground(new Color(162, 206, 216));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 23));
		lblNewLabel_1.setBounds(147, 34, 164, 55);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\emili\\OneDrive\\Escritorio\\logodep.jpg"));
		lblNewLabel_2.setBounds(36, 21, 149, 68);
		panel.add(lblNewLabel_2);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 618, 1200, 100);
		getContentPane().add(panel_1);
		panel_1.setBackground(azulBarra);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(436, 277, 229, 26);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(436, 252, 64, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Verdana", Font.BOLD, 12));
		lblContrasea.setBounds(436, 330, 89, 14);
		getContentPane().add(lblContrasea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion.comprobarUsuario(txtUsuario.getText(),txtContrasena.getText());
			}
		});
		btnAceptar.setBounds(436, 431, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(576, 431, 89, 23);
		getContentPane().add(btnSalir);
		
		txtContrasena = new JTextField();
		txtContrasena.setBounds(436, 370, 229, 26);
		getContentPane().add(txtContrasena);
		txtContrasena.setColumns(10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
	}
}
