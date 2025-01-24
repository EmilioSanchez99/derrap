package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.ConectorBD;

public class NuevoStock extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtCantidad;
    private JTextField txtPrecio;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            NuevoStock dialog = new NuevoStock();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public NuevoStock() {
        setTitle("Nuevo Stock");
        setBounds(100, 100, 450, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new GridLayout(4, 2, 10, 10)); // Ajuste a GridLayout para los campos
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        // Etiquetas y campos de texto
        contentPanel.add(new JLabel("ID:"));
        txtId = new JTextField();
        contentPanel.add(txtId);
        contentPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        contentPanel.add(txtNombre);
        contentPanel.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        contentPanel.add(txtCantidad);
        contentPanel.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        contentPanel.add(txtPrecio);
        
        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setActionCommand("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores de los campos de texto
                int id = Integer.parseInt(txtId.getText());
                String nombre = txtNombre.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());
                double precio = Double.parseDouble(txtPrecio.getText());

                // Llamar al método para añadir el nuevo stock a la base de datos
                ConectorBD conector = new ConectorBD();
                conector.anadirStock(id, nombre, cantidad, precio);

                // Mostrar mensaje de confirmación
                JOptionPane.showMessageDialog(null, "Stock añadido exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

                // Cerrar el cuadro de diálogo
                VentanaAdmin.loadStockData();
                dispose();
            }
        });
        buttonPane.add(btnGuardar);
        getRootPane().setDefaultButton(btnGuardar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand("Cancelar");
        buttonPane.add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    
}
