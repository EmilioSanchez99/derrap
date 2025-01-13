package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.ConectorBD;

public class ModificarVehiculo extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField matriculaField;
    private JTextField modeloField;
    private JTextField marcaField;
    private JTextField clienteNifField;
    private Object vehiculoSeleccionado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ModificarVehiculo dialog = new ModificarVehiculo(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ModificarVehiculo(Object vehiculo) {
        this.vehiculoSeleccionado = vehiculo;
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(10, 20, 80, 14);
        contentPanel.add(lblMatricula);

        matriculaField = new JTextField();
        matriculaField.setEditable(false);
        matriculaField.setFocusable(false);
        matriculaField.setBounds(100, 17, 200, 20);
        contentPanel.add(matriculaField);
        matriculaField.setColumns(10);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(10, 50, 80, 14);
        contentPanel.add(lblModelo);

        modeloField = new JTextField();
        modeloField.setBounds(100, 47, 200, 20);
        contentPanel.add(modeloField);
        modeloField.setColumns(45);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(10, 80, 80, 14);
        contentPanel.add(lblMarca);

        marcaField = new JTextField();
        marcaField.setBounds(100, 77, 200, 20);
        contentPanel.add(marcaField);
        marcaField.setColumns(45);

        JLabel lblClienteNif = new JLabel("Cliente NIF:");
        lblClienteNif.setBounds(10, 110, 80, 14);
        contentPanel.add(lblClienteNif);

        clienteNifField = new JTextField();
        clienteNifField.setBounds(100, 107, 200, 20);
        contentPanel.add(clienteNifField);
        clienteNifField.setColumns(9);

        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM vehiculo WHERE matricula = '" + vehiculoSeleccionado + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String matricula = rs.getString("matricula");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String clienteNif = rs.getString("cliente_nif");

                matriculaField.setText(matricula);
                modeloField.setText(modelo);
                marcaField.setText(marca);
                clienteNifField.setText(clienteNif);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConectorBD conector = new ConectorBD();
                conector.actualizarVehiculo(
                    matriculaField.getText(),
                    modeloField.getText(),
                    marcaField.getText(),
                    clienteNifField.getText()
                );

                VentanaAdmin.loadVehiculosData();
                dispose();
            }
        });
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPane.add(cancelButton);
    }
}
