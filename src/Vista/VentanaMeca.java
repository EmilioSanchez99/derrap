package Vista;


import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Toolkit;

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
					VentanaMeca frame = new VentanaMeca();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
		getContentPane().setBackground(new Color(191, 255, 244));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(null);
		this.setResizable(false);

		this.setLocationRelativeTo(null);

		
        
		
		
		//Colores A2CED8
		Color azulBarra = new Color (0x0F296B);
		Color azulFondo = new Color (0xA2CED8);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(15, 205, 210));
		panel_2.setBounds(0, 0, 139, 700);
		
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar mbCliente = new JMenuBar();
		mbCliente.setBackground(new Color(255, 255, 255));
		mbCliente.setToolTipText("Cliente");
		mbCliente.setBounds(0, 173, 136, 49);
		panel_2.add(mbCliente);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setSelectedIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\logoDERRAP\\usuario.png"));
		
		mnCliente.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\usuario.png"));
		mnCliente.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnCliente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnCliente.setBorder(UIManager.getBorder("Button.border"));
		mnCliente.setMaximumSize(new Dimension(5000, 32767));
		mnCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		mnCliente.setBounds(0, 22, 136, 49);
		mbCliente.add(mnCliente);
		

		
		

		JMenuItem btnNuevoCliente = new JMenuItem("Nuevo cliente");
		btnNuevoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		mnCliente.add(btnNuevoCliente);
		
		JSeparator separator = new JSeparator();
		mnCliente.add(separator);
		
		JMenuItem btnModificarCliente = new JMenuItem("Modificar cliente");
		mnCliente.add(btnModificarCliente);
		
		JSeparator separator_1 = new JSeparator();
		mnCliente.add(separator_1);
		
		JMenuItem btnBuscarCliente = new JMenuItem("Buscar cliente");
		mnCliente.add(btnBuscarCliente);
		
		JSeparator separator_2 = new JSeparator();
		mnCliente.add(separator_2);
		
		JMenuItem btnEliminarCliente = new JMenuItem("Eliminar cliente");
		mnCliente.add(btnEliminarCliente);
		
		
		
		JMenuBar mbVehiculo = new JMenuBar();
		mbVehiculo.setToolTipText("");
		mbVehiculo.setBounds(0, 271, 136, 49);
		panel_2.add(mbVehiculo);
		
		JMenu mnVehiculo = new JMenu("Vehículo");
		mnVehiculo.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\vehiculo.png"));
		mnVehiculo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnVehiculo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnVehiculo.setBorder(UIManager.getBorder("Button.border"));
		mnVehiculo.setMaximumSize(new Dimension(5000, 32767));
		mnVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		mbVehiculo.add(mnVehiculo);
		
		JMenuItem btnNuevoVehiculo = new JMenuItem("Nuevo Vehículo");
		mnVehiculo.add(btnNuevoVehiculo);
		
		JSeparator separator_3 = new JSeparator();
		mnVehiculo.add(separator_3);
		
		JMenuItem btnModificarVehiculo = new JMenuItem("Modificar  Vehículo");
		mnVehiculo.add(btnModificarVehiculo);
		
		JSeparator separator_4 = new JSeparator();
		mnVehiculo.add(separator_4);
		
		JMenuItem btnBuscarVehiculo = new JMenuItem("Buscar Vehículo");
		mnVehiculo.add(btnBuscarVehiculo);
		
		JSeparator separator_5 = new JSeparator();
		mnVehiculo.add(separator_5);
		
		JMenuItem btnEliminarVehiculo = new JMenuItem("Eliminar Vehículo");
		mnVehiculo.add(btnEliminarVehiculo);
		
		JMenuBar mbCita = new JMenuBar();
		mbCita.setToolTipText("Cita");
		mbCita.setBounds(0, 371, 136, 49);
		panel_2.add(mbCita);
		
		JMenu mnCita = new JMenu("Cita");
		mnCita.setMaximumSize(new Dimension(5000, 32767));
		mnCita.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\citas.png"));
		mnCita.setHorizontalAlignment(SwingConstants.RIGHT);
		mnCita.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnCita.setBorder(UIManager.getBorder("Button.border"));
		mnCita.setAlignmentX(1.0f);
		mbCita.add(mnCita);
		
		JMenuItem btnNuevoCita = new JMenuItem("Nueva Cita");
		mnCita.add(btnNuevoCita);
		
		JSeparator separator_6 = new JSeparator();
		mnCita.add(separator_6);
		
		JMenuItem btnModificarCita = new JMenuItem("Modificar Cita");
		mnCita.add(btnModificarCita);
		
		JSeparator separator_7 = new JSeparator();
		mnCita.add(separator_7);
		
		JMenuItem btnBuscarCita = new JMenuItem("Buscar Cita");
		mnCita.add(btnBuscarCita);
		
		JSeparator separator_8 = new JSeparator();
		mnCita.add(separator_8);
		
		JMenuItem btnEliminarCita = new JMenuItem("Eliminar Cita");
		mnCita.add(btnEliminarCita);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(0, 10, 136, 106);
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (3).png"));
		lblNewLabel_1.setBounds(429, 253, 452, 157);
		getContentPane().add(lblNewLabel_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
	}
}
