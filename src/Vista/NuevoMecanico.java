package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.ConectorBD;

public class NuevoMecanico extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtNIF, txtNombre, txtApellido1, txtApellido2, txtTelefono, txtEmail, txtUsuario, txtContrasena;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            NuevoMecanico dialog = new NuevoMecanico();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public NuevoMecanico() {
        setTitle("Nuevo Mecánico");
        setBounds(100, 100, 450, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(9, 2, 10, 10));

        // Labels and Text Fields
        JLabel lblNIF = new JLabel("NIF:");
        txtNIF = new JTextField();
        contentPanel.add(lblNIF);
        contentPanel.add(txtNIF);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        contentPanel.add(lblNombre);
        contentPanel.add(txtNombre);

        JLabel lblApellido1 = new JLabel("Primer Apellido:");
        txtApellido1 = new JTextField();
        contentPanel.add(lblApellido1);
        contentPanel.add(txtApellido1);

        JLabel lblApellido2 = new JLabel("Segundo Apellido:");
        txtApellido2 = new JTextField();
        contentPanel.add(lblApellido2);
        contentPanel.add(txtApellido2);

        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField();
        contentPanel.add(lblTelefono);
        contentPanel.add(txtTelefono);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        contentPanel.add(lblEmail);
        contentPanel.add(txtEmail);

        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        contentPanel.add(lblUsuario);
        contentPanel.add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JTextField();
        contentPanel.add(lblContrasena);
        contentPanel.add(txtContrasena);

        // Button Panel
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setActionCommand("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConectorBD conector = new ConectorBD();
                conector.anadirUsuario(
                    txtNIF.getText(),
                    txtNombre.getText(),
                    txtApellido1.getText(),
                    txtApellido2.getText(),
                    txtTelefono.getText(),
                    txtEmail.getText(),
                    txtUsuario.getText(),
                    txtContrasena.getText()
                );
                VentanaAdmin.loadMecanicosData();
                dispose();
            }
        });
        buttonPane.add(btnGuardar);
        getRootPane().setDefaultButton(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        buttonPane.add(btnCancelar);
    }

    /**
     * Logic to save mechanic data.
     */
    
}
