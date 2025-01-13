package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controlador.ConectorBD;

public class VentanaAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel panelClientes;
    private JPanel panelVehiculos;
    private JPanel panelMecanicos;
    private JPanel panelCitas;
    private static JTable table;
    private static JTable tableMecanicos;
    private static JTable tableVehiculos;
    private JButton btnAnadirCliente,btnModificarCliente,btnAnadirMecanico,btnModificarMecanico,btnAnadirVehiculo,btnModificarVehiculo;

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
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
        getContentPane().setBackground(new Color(191, 255, 244));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 700);
        getContentPane().setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Panel Izquierda
        JPanel panelIzquierda = new JPanel();
        panelIzquierda.setBackground(new Color(15, 205, 210));
        panelIzquierda.setBounds(0, 0, 139, 700);
        getContentPane().add(panelIzquierda);
        panelIzquierda.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(10, 0, 126, 76);
        panelIzquierda.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(10, 152, 85, 21);
        panelIzquierda.add(btnClientes);

        JButton btnVehiculos = new JButton("Vehículos");
        btnVehiculos.setBounds(10, 242, 85, 21);
        panelIzquierda.add(btnVehiculos);

        JButton btnMecanicos = new JButton("Mecánicos");
        btnMecanicos.setBounds(10, 352, 85, 21);
        panelIzquierda.add(btnMecanicos);

        JButton btnCitas = new JButton("Citas");
        btnCitas.setBounds(10, 448, 85, 21);
        panelIzquierda.add(btnCitas);

        // Panel Principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(138, 0, 1046, 700);
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        getContentPane().add(panelPrincipal);

        // Panel Clientes
        panelClientes = new JPanel();
        panelClientes.setBackground(Color.CYAN);
        panelClientes.setLayout(null);

        btnAnadirCliente = new JButton("Añadir Cliente");
        btnAnadirCliente.setBounds(706, 10, 150, 25);
        panelClientes.add(btnAnadirCliente);

        btnAnadirCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoCliente ventanaCliente = new NuevoCliente();
                ventanaCliente.setVisible(true);
                ventanaCliente.setLocationRelativeTo(null);
            }
        });

        btnModificarCliente = new JButton("Modificar Cliente");
        btnModificarCliente.setBounds(886, 10, 150, 25);
        panelClientes.add(btnModificarCliente);

        btnModificarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usuarioSeleccionado = table.getSelectedRow();
                if (usuarioSeleccionado != -1) {
                    Object clienteId = table.getValueAt(usuarioSeleccionado, 0);
                    ModificarCliente modificarCliente = new ModificarCliente(clienteId);
                    modificarCliente.setVisible(true);
                    modificarCliente.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente de la tabla.", "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 45, 1026, 645);
        panelClientes.add(scrollPane);

        loadClientesData();

        // Panel Mecánicos
        panelMecanicos = new JPanel();
        panelMecanicos.setLayout(null);
        panelMecanicos.setBackground(Color.PINK);
        btnAnadirMecanico = new JButton("Añadir Mecanico");
        btnAnadirMecanico.setBounds(706, 10, 150, 25);
        panelMecanicos.add(btnAnadirMecanico);

        btnAnadirMecanico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoMecanico ventanaMecanico = new NuevoMecanico();
                ventanaMecanico.setVisible(true);
                ventanaMecanico.setLocationRelativeTo(null);
            }
        });

        btnModificarMecanico = new JButton("Modificar Mecanico");
        btnModificarMecanico.setBounds(886, 10, 150, 25);
        panelMecanicos.add(btnModificarMecanico);

        btnModificarMecanico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mecanicoSeleccionado = tableMecanicos.getSelectedRow();
                if (mecanicoSeleccionado != -1) {
                    Object mecanicoId = tableMecanicos.getValueAt(mecanicoSeleccionado, 0);
                    ModificarMecanico modificarMecanico = new ModificarMecanico(mecanicoId);
                    modificarMecanico.setVisible(true);
                    modificarMecanico.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un mecanico de la tabla.", "Advertencia",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        tableMecanicos = new JTable();
        JScrollPane scrollPane2 = new JScrollPane(tableMecanicos);
        scrollPane2.setBounds(10, 45, 1026, 645);
        panelMecanicos.add(scrollPane2);
        loadMecanicosData();
        // OPanel Vehiculos
       
        panelVehiculos = new JPanel();
        panelVehiculos.setBackground(Color.YELLOW);
        panelVehiculos.setLayout(null); // Asegúrate de usar un diseño de disposición nulo si deseas posicionar componentes manualmente

        btnAnadirVehiculo = new JButton("Añadir Vehículo");
        btnAnadirVehiculo.setBounds(706, 10, 150, 25);
        panelVehiculos.add(btnAnadirVehiculo);
        btnAnadirVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoVehiculo ventanaVehiculo = new NuevoVehiculo();
                ventanaVehiculo.setVisible(true);
                ventanaVehiculo.setLocationRelativeTo(null);
            }
        });

        btnModificarVehiculo = new JButton("Modificar Vehículo");
        btnModificarVehiculo.setBounds(886, 10, 150, 25);
        panelVehiculos.add(btnModificarVehiculo);
        btnModificarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int vehiculoSeleccionado = tableVehiculos.getSelectedRow();
                if (vehiculoSeleccionado != -1) {
                    Object vehiculoId = tableVehiculos.getValueAt(vehiculoSeleccionado, 0);
                    ModificarVehiculo modificarVehiculo = new ModificarVehiculo(vehiculoId);
                    modificarVehiculo.setVisible(true);
                    modificarVehiculo.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un vehículo de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        tableVehiculos = new JTable();
        JScrollPane scrollPane3 = new JScrollPane(tableVehiculos);
        scrollPane3.setBounds(10, 45, 1026, 645);
        panelVehiculos.add(scrollPane3);

        loadVehiculosData();

        panelCitas = new JPanel();
        panelCitas.add(new JLabel("Citas"));
        panelCitas.setBackground(Color.BLUE);


        // Agregar paneles al principal
        panelPrincipal.add(panelClientes, "clientes");
        panelPrincipal.add(panelVehiculos, "vehiculos");
        panelPrincipal.add(panelMecanicos, "mecanicos");
        panelPrincipal.add(panelCitas, "citas");

        // Acciones de botones
        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "clientes");
                loadClientesData();
            }
        });

        btnVehiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "vehiculos");
            }
        });

        btnMecanicos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "mecanicos");
                loadMecanicosData();
            }
        });

        btnCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "citas");
            }
        });
    }

    static void loadClientesData() {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[] { "NIF", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Email" }, 0);

            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                model.addRow(new Object[] { nif, nombre, apellido1, apellido2, telefono, email });
            }

            table.setModel(model);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void loadMecanicosData() {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM usuario WHERE tipo = 'mecanico'";
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model2 = new DefaultTableModel(
                    new Object[] { "NIF", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Email", "Usuario",
                            "Contraseña" },
                    0);

            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");
                model2.addRow(new Object[] { nif, nombre, apellido1, apellido2, telefono, email, usuario, contrasena });
            }

            tableMecanicos.setModel(model2);

            rs.close();
            stmt.close();
            conn.close();
             } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void loadVehiculosData() {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM vehiculo";
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"Matrícula", "Modelo", "Marca", "Cliente NIF"}, 0);

            while (rs.next()) {
                String matricula = rs.getString("matricula");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                String clienteNif = rs.getString("cliente_nif");
                model.addRow(new Object[]{matricula, modelo, marca, clienteNif});
            }

            tableVehiculos.setModel(model);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

