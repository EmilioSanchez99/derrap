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

public class ModificarStock extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField idField;
    private JTextField nombreField;
    private JTextField cantidadField;
    private JTextField precioField;
    private Object stockSeleccionado;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ModificarStock dialog = new ModificarStock(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ModificarStock(Object stock) {
        this.stockSeleccionado = stock;
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 20, 80, 14);
        contentPanel.add(lblId);

        idField = new JTextField();
        idField.setEditable(false);
        idField.setFocusable(false);
        idField.setBounds(100, 17, 200, 20);
        contentPanel.add(idField);
        idField.setColumns(9);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 50, 80, 14);
        contentPanel.add(lblNombre);

        nombreField = new JTextField();
        nombreField.setBounds(100, 47, 200, 20);
        contentPanel.add(nombreField);
        nombreField.setColumns(45);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(10, 110, 80, 14);
        contentPanel.add(lblCantidad);

        cantidadField = new JTextField();
        cantidadField.setBounds(100, 107, 200, 20);
        contentPanel.add(cantidadField);
        cantidadField.setColumns(45);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(10, 80, 80, 14);
        contentPanel.add(lblPrecio);

        precioField = new JTextField();
        precioField.setBounds(100, 77, 200, 20);
        contentPanel.add(precioField);
        precioField.setColumns(45);

        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM pieza WHERE id_pieza = '" + stockSeleccionado + "'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String id = rs.getString("id_pieza");
                String nombre = rs.getString("nombre_pieza");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                
                idField.setText(id);
                nombreField.setText(nombre);
                precioField.setText(String.valueOf(precio));
                cantidadField.setText(String.valueOf(cantidad));
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
                conector.actualizarStock(
                    Integer.parseInt(idField.getText()),
                    nombreField.getText(),
                    Double.parseDouble(precioField.getText()),
                    Integer.parseInt(cantidadField.getText())
                );

                VentanaAdmin.loadStockData();
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
