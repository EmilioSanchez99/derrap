package Vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;

import java.awt.ComponentOrientation;
import javax.swing.JMenu;
import javax.swing.Popup;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Cursor;

public class VentanaAdmin extends JFrame {

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
					VentanaAdmin frame = new VentanaAdmin();
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
	public VentanaAdmin() {
		getContentPane().setBackground(new Color(162, 206, 216));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane().setLayout(null);
		this.setUndecorated(false);
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
		lblNewLabel_1.setBounds(114, 34, 164, 55);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(23, 11, 107, 78);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\coche40x40.png"));
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(0, 618, 1200, 100);
		getContentPane().add(panel_1);
		panel_1.setBackground(azulBarra);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(0, 96, 139, 526);
		
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar mbCliente = new JMenuBar();
		mbCliente.setBackground(new Color(255, 255, 255));
		mbCliente.setToolTipText("Cliente");
		mbCliente.setBounds(0, 22, 136, 49);
		panel_2.add(mbCliente);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setIcon(new ImageIcon("../imagenes/android.png"));
		mnCliente.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnCliente.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnCliente.setBorder(UIManager.getBorder("Button.border"));
		mnCliente.setMaximumSize(new Dimension(5000, 32767));
		mnCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		mnCliente.setBounds(0, 22, 136, 49);
		mbCliente.add(mnCliente);
		

		
		

		JMenuItem btnNuevoCliente = new JMenuItem("Nuevo cliente");
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
		
		JMenuBar mbMecanico = new JMenuBar();
		mbMecanico.setToolTipText("Cliente");
		mbMecanico.setBounds(0, 71, 136, 49);
		panel_2.add(mbMecanico);
		
		JMenu mnMecanico = new JMenu("Mecánico");
		mnMecanico.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\menulateral\\SlidingMenu\\Dashboard_1\\src\\img\\android.png"));
		mnMecanico.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnMecanico.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnMecanico.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnMecanico.setBorder(UIManager.getBorder("Button.border"));
		mnMecanico.setMaximumSize(new Dimension(5000, 32767));
		mnMecanico.setHorizontalAlignment(SwingConstants.RIGHT);
		mbMecanico.add(mnMecanico);
		
		JMenuItem btnNuevoMecanico = new JMenuItem("Nuevo Mecánico");
		mnMecanico.add(btnNuevoMecanico);
		
		JMenuItem btnModificarMecanico = new JMenuItem("Modificar Mecánico");
		mnMecanico.add(btnModificarMecanico);
		
		JMenuItem btnBuscarMecanico = new JMenuItem("Buscar Mecánico");
		mnMecanico.add(btnBuscarMecanico);
		
		JMenuItem btnEliminarMecanico = new JMenuItem("Eliminar Mecánico");
		mnMecanico.add(btnEliminarMecanico);
		
		JMenuBar mbVehiculo = new JMenuBar();
		mbVehiculo.setToolTipText("");
		mbVehiculo.setBounds(0, 120, 136, 49);
		panel_2.add(mbVehiculo);
		
		JMenu mnVehiculo = new JMenu("Vehículo");
		mnVehiculo.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\menulateral\\SlidingMenu\\Dashboard_1\\src\\img\\android.png"));
		mnVehiculo.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnVehiculo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnVehiculo.setBorder(UIManager.getBorder("Button.border"));
		mnVehiculo.setMaximumSize(new Dimension(5000, 32767));
		mnVehiculo.setHorizontalAlignment(SwingConstants.RIGHT);
		mbVehiculo.add(mnVehiculo);
		
		JMenuItem btnNuevoVehiculo = new JMenuItem("Nuevo Vehículo");
		mnVehiculo.add(btnNuevoVehiculo);
		
		JMenuItem btnModificarVehiculo = new JMenuItem("Modificar  Vehículo");
		mnVehiculo.add(btnModificarVehiculo);
		
		JMenuItem btnBuscarVehiculo = new JMenuItem("Buscar Vehículo");
		mnVehiculo.add(btnBuscarVehiculo);
		
		JMenuItem btnEliminarVehiculo = new JMenuItem("Eliminar Vehículo");
		mnVehiculo.add(btnEliminarVehiculo);
		
		JMenuBar mbProveedor = new JMenuBar();
		mbProveedor.setToolTipText("Proveedor");
		mbProveedor.setBounds(0, 168, 136, 49);
		panel_2.add(mbProveedor);
		
		JMenu mnProveedor = new JMenu("Proveedor");
		mnProveedor.setMaximumSize(new Dimension(5000, 32767));
		mnProveedor.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\menulateral\\SlidingMenu\\Dashboard_1\\src\\img\\android.png"));
		mnProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
		mnProveedor.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnProveedor.setBorder(UIManager.getBorder("Button.border"));
		mnProveedor.setAlignmentX(1.0f);
		mbProveedor.add(mnProveedor);
		
		JMenuItem btnNuevoProveedor = new JMenuItem("Nuevo Proveedor"); 
		mnProveedor.add(btnNuevoProveedor);
		
		JMenuItem btnModificarProveedor = new JMenuItem("Modificar Proveedor");
		mnProveedor.add(btnModificarProveedor);
		
		JMenuItem btnBuscarProveedor = new JMenuItem("Buscar Proveedor");
		mnProveedor.add(btnBuscarProveedor);
		
		JMenuItem btnEliminarProveedor = new JMenuItem("Eliminar Proveedor");
		mnProveedor.add(btnEliminarProveedor);
		
		JMenuBar mbCita = new JMenuBar();
		mbCita.setToolTipText("Cita");
		mbCita.setBounds(0, 213, 136, 49);
		panel_2.add(mbCita);
		
		JMenu mnCita = new JMenu("Cita");
		mnCita.setMaximumSize(new Dimension(5000, 32767));
		mnCita.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\menulateral\\SlidingMenu\\Dashboard_1\\src\\img\\android.png"));
		mnCita.setHorizontalAlignment(SwingConstants.RIGHT);
		mnCita.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnCita.setBorder(UIManager.getBorder("Button.border"));
		mnCita.setAlignmentX(1.0f);
		mbCita.add(mnCita);
		
		JMenuItem btnNuevoCita = new JMenuItem("Nueva Cita");
		mnCita.add(btnNuevoCita);
		
		JMenuItem btnModificarCita = new JMenuItem("Modificar Cita");
		mnCita.add(btnModificarCita);
		
		JMenuItem btnBuscarCita = new JMenuItem("Buscar Cita");
		mnCita.add(btnBuscarCita);
		
		JMenuItem btnEliminarCita = new JMenuItem("Eliminar Cita");
		mnCita.add(btnEliminarCita);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	

		
		
	}
}
