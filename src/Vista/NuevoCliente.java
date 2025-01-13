package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.ConectorBD;

public class NuevoCliente extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField nifField;
    private JTextField nombreField;
    private JTextField apellido1Field;
    private JTextField apellido2Field;
    private JTextField telefonoField;
    private JTextField emailField;

    public static void main(String[] args) {
        try {
            NuevoCliente dialog = new NuevoCliente();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NuevoCliente() {
	        setBounds(100, 100, 450, 300);
	        getContentPane().setLayout(new BorderLayout());
	        contentPanel.setLayout(null);
	        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	        getContentPane().add(contentPanel, BorderLayout.CENTER);
	        
	        JLabel lblNif = new JLabel("NIF:");
	        lblNif.setBounds(10, 20, 80, 14);
	        contentPanel.add(lblNif);
	        
	        nifField = new JTextField();
	        nifField.setBounds(100, 17, 200, 20);
	        contentPanel.add(nifField);
	        nifField.setColumns(9);
	        
	        JLabel lblNombre = new JLabel("Nombre:");
	        lblNombre.setBounds(10, 50, 80, 14);
	        contentPanel.add(lblNombre);
	        
	        nombreField = new JTextField();
	        nombreField.setBounds(100, 47, 200, 20);
	        contentPanel.add(nombreField);
	        nombreField.setColumns(45);
	        
	        JLabel lblApellido1 = new JLabel("Apellido 1:");
	        lblApellido1.setBounds(10, 80, 80, 14);
	        contentPanel.add(lblApellido1);
	        
	        apellido1Field = new JTextField();
	        apellido1Field.setBounds(100, 77, 200, 20);
	        contentPanel.add(apellido1Field);
	        apellido1Field.setColumns(45);
	        
	        JLabel lblApellido2 = new JLabel("Apellido 2:");
	        lblApellido2.setBounds(10, 110, 80, 14);
	        contentPanel.add(lblApellido2);
	        
	        apellido2Field = new JTextField();
	        apellido2Field.setBounds(100, 107, 200, 20);
	        contentPanel.add(apellido2Field);
	        apellido2Field.setColumns(45);
	        
	        JLabel lblTelefono = new JLabel("Teléfono:");
	        lblTelefono.setBounds(10, 140, 80, 14);
	        contentPanel.add(lblTelefono);
	        
	        telefonoField = new JTextField();
	        telefonoField.setBounds(100, 137, 200, 20);
	        contentPanel.add(telefonoField);
	        telefonoField.setColumns(45);
	        
	        JLabel lblEmail = new JLabel("Email:");
	        lblEmail.setBounds(10, 170, 80, 14);
	        contentPanel.add(lblEmail);
	        
	        emailField = new JTextField();
	        emailField.setBounds(100, 167, 200, 20);
	        contentPanel.add(emailField);
	        emailField.setColumns(45);
	        
	        JPanel buttonPane = new JPanel();
	        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	        getContentPane().add(buttonPane, BorderLayout.SOUTH);
	        
	        JButton okButton = new JButton("OK");
	        okButton.setActionCommand("OK");
	        okButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                ConectorBD conector = new ConectorBD();
	                conector.anadirCliente(
	                    nifField.getText(),
	                    nombreField.getText(),
	                    apellido1Field.getText(),
	                    apellido2Field.getText(),
	                    telefonoField.getText(),
	                    emailField.getText()
	                );
	                VentanaAdmin.loadClientesData();
                dispose();
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
    }
}
