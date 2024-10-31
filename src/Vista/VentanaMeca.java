package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class VentanaMeca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
	public VentanaMeca() {
		getContentPane().setBackground(new Color(162, 206, 216));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(null);
		
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
		lblNewLabel_1.setBounds(123, 34, 164, 55);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\DERRAP\\imagenprueba\\coche40x40.png"));
		lblNewLabel_2.setBounds(23, 11, 128, 89);
		panel.add(lblNewLabel_2);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 618, 1200, 100);
		getContentPane().add(panel_1);
		panel_1.setBackground(azulBarra);
		
		JLabel lblNewLabel = new JLabel("VENTANA MECANICO");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 33));
		lblNewLabel.setBounds(375, 249, 368, 153);
		getContentPane().add(lblNewLabel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
	}
}