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

public class NuevoVehiculo extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtMatricula, txtModelo, txtMarca, txtClienteNif;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            NuevoVehiculo dialog = new NuevoVehiculo();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public NuevoVehiculo() {
        setTitle("Nuevo Vehículo");
        setBounds(100, 100, 450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and Text Fields
        JLabel lblMatricula = new JLabel("Matrícula:");
        txtMatricula = new JTextField();
        contentPanel.add(lblMatricula);
        contentPanel.add(txtMatricula);

        JLabel lblModelo = new JLabel("Modelo:");
        txtModelo = new JTextField();
        contentPanel.add(lblModelo);
        contentPanel.add(txtModelo);

        JLabel lblMarca = new JLabel("Marca:");
        txtMarca = new JTextField();
        contentPanel.add(lblMarca);
        contentPanel.add(txtMarca);

        JLabel lblClienteNif = new JLabel("Cliente NIF:");
        txtClienteNif = new JTextField();
        contentPanel.add(lblClienteNif);
        contentPanel.add(txtClienteNif);

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
                conector.anadirVehiculo(
                    txtMatricula.getText(),
                    txtModelo.getText(),
                    txtMarca.getText(),
                    txtClienteNif.getText()
                );
                dispose();
                VentanaAdmin.loadVehiculosData();
            }
        });
        buttonPane.add(btnGuardar);
        getRootPane().setDefaultButton(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(btnCancelar);
    }


    /**
     * Logic to save vehicle data.
     */
   
}
