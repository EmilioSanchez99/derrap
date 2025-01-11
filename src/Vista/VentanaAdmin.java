package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.ConectorBD;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class VentanaAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel panelClientes;
    private JPanel panelVehiculos;
    private JPanel panelMecanicos;
    private JPanel panelCitas;
    private static JTable table;
    private JButton btnAnadirCliente;
    private JButton btnModificarCliente;

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

        // Colores
        Color azulBarra = new Color(0x0F296B);
        Color azulFondo = new Color(0xA2CED8);

        JPanel panel_izquierda = new JPanel();
        panel_izquierda.setBackground(new Color(15, 205, 210));
        panel_izquierda.setBounds(0, 0, 139, 700);
        getContentPane().add(panel_izquierda);
        panel_izquierda.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(10, 0, 126, 76);
        panel_izquierda.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));

        JButton btnClientes = new JButton("Clientes");
        btnClientes.setBounds(10, 152, 85, 21);
        panel_izquierda.add(btnClientes);

        JButton btnVehiculos = new JButton("Vehiculos");
        btnVehiculos.setBounds(10, 242, 85, 21);
        panel_izquierda.add(btnVehiculos);

        JButton btnMecanicos = new JButton("Mecanicos");
        btnMecanicos.setBounds(10, 352, 85, 21);
        panel_izquierda.add(btnMecanicos);

        JButton btnCitas = new JButton("Citas");
        btnCitas.setBounds(10, 448, 85, 21);
        panel_izquierda.add(btnCitas);

        JPanel panel_Principal = new JPanel();
        panel_Principal.setBounds(138, 0, 1046, 700);
        cardLayout = new CardLayout();
        panel_Principal.setLayout(cardLayout);
        getContentPane().add(panel_Principal);

        // Paneles
        panelClientes = new JPanel();
        panelClientes.setBackground(Color.CYAN);
        panelClientes.setLayout(null);

        btnAnadirCliente = new JButton("Añadir Cliente");
        btnAnadirCliente.setBounds(706, 10, 150, 25); 
        panelClientes.add(btnAnadirCliente);
        btnAnadirCliente.addActionListener(new ActionListener() {
        	

			@Override
			public void actionPerformed(ActionEvent e) {
				NuevoCliente ventanaCliente=new NuevoCliente();
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
            	ConectorBD conectorBD= new ConectorBD();
                // Obtener la fila seleccionada de la tabla
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener datos del cliente seleccionado
                    Object clienteId = table.getValueAt(selectedRow, 0); // Suponiendo que la primera columna es el ID del cliente
                    // Preguntar qué campo modificar
                    String campo = JOptionPane.showInputDialog("¿Qué campo desea modificar? (nombre, dirección, etc.)");
                    if (campo != null && !campo.isEmpty()) {
                        // Pedir el nuevo valor para el campo
                        String nuevoValor = JOptionPane.showInputDialog("Ingrese el nuevo valor para " + campo + ":");
                        if (nuevoValor != null && !nuevoValor.isEmpty()) {
                            // Lógica para actualizar el campo del cliente en la base de datos
                            conectorBD.actualizarCliente(clienteId, campo, nuevoValor);
                            loadClientesData();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla primero.");
                }
            }
        });

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 45, 1026, 645);
        panelClientes.add(scrollPane);
        loadClientesData();

	

       

        panelVehiculos = new JPanel();
        panelVehiculos.add(new JLabel("vehiculos"));
        panelVehiculos.setBackground(Color.YELLOW);

        panelMecanicos = new JPanel();
        panelMecanicos.add(new JLabel("mecanicos"));
        panelMecanicos.setBackground(Color.PINK);

        panelCitas = new JPanel();
        panelCitas.add(new JLabel("citas"));
        panelCitas.setBackground(Color.BLUE);

        panel_Principal.add(panelClientes, "clientes");
        panel_Principal.add(panelVehiculos, "vehiculos");
        panel_Principal.add(panelMecanicos, "mecanicos");
        panel_Principal.add(panelCitas, "citas");

        btnClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel_Principal, "clientes");
                loadClientesData();
            }
        });

        btnVehiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel_Principal, "vehiculos");
            }
        });

        btnMecanicos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel_Principal, "mecanicos");
            }
        });

        btnCitas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panel_Principal, "citas");
            }
        });

        JLabel lblNewLabel_1 = new JLabel("");
        panel_Principal.add(lblNewLabel_1, "name_263444679296000");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (3).png"));
    }
    
    

    static void loadClientesData() {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(query);
            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"NIF", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Email"}, 0);
            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                model.addRow(new Object[]{nif, nombre, apellido1, apellido2, telefono, email});
            }
            table.setModel(model);
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   

}
