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
import java.awt.Toolkit;

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
		panel_2.setBounds(0, 0, 139, 763);
		
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar mbCliente = new JMenuBar();
		mbCliente.setForeground(new Color(162, 206, 216));
		mbCliente.setBackground(new Color(255, 255, 255));
		mbCliente.setToolTipText("Cliente");
		mbCliente.setBounds(0, 76, 136, 49);
		panel_2.add(mbCliente);
		
		JMenu mnCliente = new JMenu("Cliente");
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
		mbMecanico.setBounds(0, 174, 136, 49);
		panel_2.add(mbMecanico);
		
		JMenu mnMecanico = new JMenu("Mecánico");
		mnMecanico.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\mecanico.png"));
		mnMecanico.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnMecanico.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnMecanico.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnMecanico.setBorder(UIManager.getBorder("Button.border"));
		mnMecanico.setMaximumSize(new Dimension(5000, 32767));
		mnMecanico.setHorizontalAlignment(SwingConstants.RIGHT);
		mbMecanico.add(mnMecanico);
		
		JMenuItem btnNuevoMecanico = new JMenuItem("Nuevo Mecánico");
		mnMecanico.add(btnNuevoMecanico);
		
		JSeparator separator_3 = new JSeparator();
		mnMecanico.add(separator_3);
		
		JMenuItem btnModificarMecanico = new JMenuItem("Modificar Mecánico");
		mnMecanico.add(btnModificarMecanico);
		
		JSeparator separator_4 = new JSeparator();
		mnMecanico.add(separator_4);
		
		JMenuItem btnBuscarMecanico = new JMenuItem("Buscar Mecánico");
		mnMecanico.add(btnBuscarMecanico);
		
		JSeparator separator_5 = new JSeparator();
		mnMecanico.add(separator_5);
		
		JMenuItem btnEliminarMecanico = new JMenuItem("Eliminar Mecánico");
		mnMecanico.add(btnEliminarMecanico);
		
		JMenuBar mbVehiculo = new JMenuBar();
		mbVehiculo.setToolTipText("");
		mbVehiculo.setBounds(0, 272, 136, 49);
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
		
		JSeparator separator_6 = new JSeparator();
		mnVehiculo.add(separator_6);
		
		JMenuItem btnModificarVehiculo = new JMenuItem("Modificar  Vehículo");
		mnVehiculo.add(btnModificarVehiculo);
		
		JSeparator separator_7 = new JSeparator();
		mnVehiculo.add(separator_7);
		
		JMenuItem btnBuscarVehiculo = new JMenuItem("Buscar Vehículo");
		mnVehiculo.add(btnBuscarVehiculo);
		
		JSeparator separator_8 = new JSeparator();
		mnVehiculo.add(separator_8);
		
		JMenuItem btnEliminarVehiculo = new JMenuItem("Eliminar Vehículo");
		mnVehiculo.add(btnEliminarVehiculo);
		
		JMenuBar mbProveedor = new JMenuBar();
		mbProveedor.setToolTipText("Proveedor");
		mbProveedor.setBounds(0, 368, 136, 49);
		panel_2.add(mbProveedor);
		
		JMenu mnProveedor = new JMenu("Proveedor");
		mnProveedor.setMaximumSize(new Dimension(5000, 32767));
		mnProveedor.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\proveedor.png"));
		mnProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
		mnProveedor.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnProveedor.setBorder(UIManager.getBorder("Button.border"));
		mnProveedor.setAlignmentX(1.0f);
		mbProveedor.add(mnProveedor);
		
		JMenuItem btnNuevoProveedor = new JMenuItem("Nuevo Proveedor"); 
		mnProveedor.add(btnNuevoProveedor);
		
		JSeparator separator_9 = new JSeparator();
		mnProveedor.add(separator_9);
		
		JMenuItem btnModificarProveedor = new JMenuItem("Modificar Proveedor");
		mnProveedor.add(btnModificarProveedor);
		
		JSeparator separator_10 = new JSeparator();
		mnProveedor.add(separator_10);
		
		JMenuItem btnBuscarProveedor = new JMenuItem("Buscar Proveedor");
		mnProveedor.add(btnBuscarProveedor);
		
		JSeparator separator_11 = new JSeparator();
		mnProveedor.add(separator_11);
		
		JMenuItem btnEliminarProveedor = new JMenuItem("Eliminar Proveedor");
		mnProveedor.add(btnEliminarProveedor);
		
		JMenuBar mbCita = new JMenuBar();
		mbCita.setToolTipText("Cita");
		mbCita.setBounds(0, 458, 136, 49);
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
		
		JSeparator separator_12 = new JSeparator();
		mnCita.add(separator_12);
		
		JMenuItem btnModificarCita = new JMenuItem("Modificar Cita");
		mnCita.add(btnModificarCita);
		
		JSeparator separator_13 = new JSeparator();
		mnCita.add(separator_13);
		
		JMenuItem btnBuscarCita = new JMenuItem("Buscar Cita");
		mnCita.add(btnBuscarCita);
		
		JSeparator separator_14 = new JSeparator();
		mnCita.add(separator_14);
		
		JMenuItem btnEliminarCita = new JMenuItem("Eliminar Cita");
		mnCita.add(btnEliminarCita);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(10, 0, 126, 76);
		panel_2.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (3).png"));
		lblNewLabel_1.setBounds(402, 229, 529, 157);
		getContentPane().add(lblNewLabel_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	

		
		
	}
}
