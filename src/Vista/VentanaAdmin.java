package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Controlador.ConectorBD;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;

public class VentanaAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel panelClientes;
    private JPanel panelVehiculos;
    private JPanel panelMecanicos;
    private JPanel panelStock;
    private JPanel panelFacturas;
    private static JTable table;
    private static JTable tableMecanicos;
    private static JTable tableVehiculos;
    private static JTable tableStock;
    private JButton btnAnadirCliente,btnModificarCliente,btnAnadirMecanico,btnModificarMecanico,btnAnadirVehiculo,btnModificarVehiculo,btnAnadirStock,btnModificarStock;
    private JButton btnSeleccionado = null;
    private static JTable tableFacturas;
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
        panelIzquierda.setBackground(new Color(60,47,128));
        panelIzquierda.setBounds(0, 0, 139, 700);
        getContentPane().add(panelIzquierda);
        panelIzquierda.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(10, 10, 126, 76);
        panelIzquierda.add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\emili\\eclipse-workspace\\Derrap\\src\\imagenes\\file (2).png"));
        
//BOTON CLIENTE
        
        JButton btnClientes = new JButton("C l i e n t e");
        btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
        btnClientes.setForeground(new Color(0, 0, 0));
        btnClientes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClientes.setBounds(0, 165, 136, 57);
        
        panelIzquierda.add(btnClientes);
        
        
        MetodoBoton(btnClientes, "/imagenes/Acliente.png");

//BOTON VEHICULO
        

        JButton btnVehiculos = new JButton("V e h í c u l o");
        btnVehiculos.setHorizontalAlignment(SwingConstants.LEFT);
        btnVehiculos.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVehiculos.setBounds(0, 233, 136, 57);

      

        panelIzquierda.add(btnVehiculos);

        MetodoBoton(btnVehiculos, "/imagenes/Acoche.png");

        
        
        
        //BOTON MECANICO
        
        JButton btnMecanicos = new JButton("M e c á n i c o");
        btnMecanicos.setHorizontalAlignment(SwingConstants.LEFT);
        btnMecanicos.setBounds(0, 302, 136, 57);
        btnMecanicos.setFont(new Font("Tahoma", Font.BOLD, 13));
        panelIzquierda.add(btnMecanicos);
        
        MetodoBoton(btnMecanicos, "/imagenes/Amecanico.png");
        
        
        
        //BOTON CITAS
        
        
        
        JButton btnCitas = new JButton("S t o c k");
        btnCitas.setHorizontalAlignment(SwingConstants.LEFT);
        btnCitas.setBounds(0, 369, 136, 57);
        btnCitas.setFont(new Font("Tahoma", Font.BOLD, 13));
        panelIzquierda.add(btnCitas);
        
        MetodoBoton(btnCitas, "/imagenes/Acitas.png");
        
        JButton btnSalir = new JButton("Cerrar Sesion");
        
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	int seleccion=JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "confirmar", JOptionPane.YES_NO_OPTION);
        	if (seleccion==JOptionPane.YES_OPTION) {
        		dispose();
        		Login login=new Login();
        		login.setVisible(true);
        		login.setLocationRelativeTo(null);
        	}
        		
        	}
        });
        btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSalir.setBounds(0, 597, 136, 57);
        panelIzquierda.add(btnSalir);
        
        
        JButton btnFacturas = new JButton("F a c t u r a");
        btnFacturas.setHorizontalAlignment(SwingConstants.LEFT);
        btnFacturas.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnFacturas.setBounds(0, 446, 136, 57);
        panelIzquierda.add(btnFacturas);
        
        MetodoBoton(btnFacturas, "/imagenes/Afactura.png");
        MetodoBoton(btnSalir, "/imagenes/Aexit.png");
        // Panel Principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(138, 0, 1046, 700);
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        getContentPane().add(panelPrincipal);

        // Panel Clientes
        panelClientes = new JPanel();
        panelClientes.setBackground(new Color(250,237,218));
        panelClientes.setLayout(null);
        

     // Botón Añadir Cliente
        JButton btnAnadirCliente = new JButton("");
        btnAnadirCliente.setBounds(893, 19, 52, 32);
        btnAnadirCliente.setBorder(BorderFactory.createEmptyBorder());
        btnAnadirCliente.setContentAreaFilled(false);

        // Cargar la imagen original desde los recursos
        ImageIcon originalIcon = new ImageIcon(VentanaAdmin.class.getResource("/imagenes/add.png"));

        // Redimensionar la imagen a 32x30 píxeles
        Image ogimagen = originalIcon.getImage();
        Image escalado = ogimagen.getScaledInstance(32, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(escalado);

        // Asignar el icono redimensionado al botón
        btnAnadirCliente.setIcon(resizedIcon);

        btnAnadirCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoCliente ventanaCliente = new NuevoCliente();
                ventanaCliente.setVisible(true);
                ventanaCliente.setLocationRelativeTo(null);
            }
        });

        agregarEventoTeclado(btnAnadirCliente, "ADD_CLIENT", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);
        panelClientes.add(btnAnadirCliente);



     // Botón Modificar Cliente
        JButton btnModificarCliente = new JButton("");
        btnModificarCliente.setBounds(955, 19, 33, 33);
        btnModificarCliente.setBorder(BorderFactory.createEmptyBorder());
        btnModificarCliente.setContentAreaFilled(false);

        ImageIcon originalIcon2 = new ImageIcon(VentanaAdmin.class.getResource("/imagenes/modify.png"));
        Image ogimagen2 = originalIcon2.getImage();
        Image escalado2 = ogimagen2.getScaledInstance(32, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(escalado2);
        btnModificarCliente.setIcon(resizedIcon2);

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
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        agregarEventoTeclado(btnModificarCliente, "MODIFY_CLIENT", KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK);

        panelClientes.add(btnModificarCliente);


        table = new JTable();
        table.setGridColor(new Color(128, 128, 128));
        table.setToolTipText("");
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        table.setBorder(new LineBorder(new Color(60, 47, 128), 2, true));
        table.setBackground(new Color(174, 232, 202));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(56, 62, 932, 554);
        panelClientes.add(scrollPane);

        loadClientesData();

        // Panel Mecánicos
        panelMecanicos = new JPanel();
        panelMecanicos.setLayout(null);
        panelMecanicos.setBackground(new Color(250,237,218));
        btnAnadirMecanico = new JButton("");
        btnAnadirMecanico.setBounds(890, 19, 59, 32);
        btnAnadirMecanico.setBorder(BorderFactory.createEmptyBorder());
        btnAnadirMecanico.setContentAreaFilled(false);
        btnAnadirMecanico.setIcon(resizedIcon);
        panelMecanicos.add(btnAnadirMecanico);

        btnAnadirMecanico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoMecanico ventanaMecanico = new NuevoMecanico();
                ventanaMecanico.setVisible(true);
                ventanaMecanico.setLocationRelativeTo(null);
            }
        });
        agregarEventoTeclado(btnAnadirMecanico, "ADD_MECANIC", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);

        btnModificarMecanico = new JButton("");
        btnModificarMecanico.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnModificarMecanico.setBackground(new Color(255, 255, 255));
        btnModificarMecanico.setBounds(955, 19, 33, 33);
        btnModificarMecanico.setBorder(BorderFactory.createEmptyBorder());
        btnModificarMecanico.setContentAreaFilled(false);

     
        btnModificarMecanico.setIcon(resizedIcon2);

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
        agregarEventoTeclado(btnModificarMecanico, "MODIDFY_MECANIC", KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK);
        panelMecanicos.add(btnModificarMecanico);
        tableMecanicos = new JTable();
        tableMecanicos.setFont(new Font("Tahoma", Font.BOLD, 12));
        tableMecanicos.setFillsViewportHeight(true);
        tableMecanicos.setBackground(new Color(174, 232, 202));
        tableMecanicos.setBorder(new LineBorder(new Color(60, 47, 128), 2));
        JScrollPane scrollPane2 = new JScrollPane(tableMecanicos);
        scrollPane2.setBounds(56, 62, 932, 554);
        panelMecanicos.add(scrollPane2);
        loadMecanicosData();
        // OPanel Vehiculos
       
        panelVehiculos = new JPanel();
        panelVehiculos.setBorder(new LineBorder(new Color(60, 47, 128), 2));
        panelVehiculos.setBackground(new Color(250,237,218));
        panelVehiculos.setLayout(null); // Asegúrate de usar un diseño de disposición nulo si deseas posicionar componentes manualmente

        btnAnadirVehiculo = new JButton("");
        btnAnadirVehiculo.setBounds(893, 19, 52, 32);
        btnAnadirVehiculo.setBorder(BorderFactory.createEmptyBorder());
        btnAnadirVehiculo.setContentAreaFilled(false);
        btnAnadirVehiculo.setIcon(resizedIcon);
        agregarEventoTeclado(btnAnadirVehiculo, "ADD_VEHICLE", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);
        panelVehiculos.add(btnAnadirVehiculo);
        btnAnadirVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoVehiculo ventanaVehiculo = new NuevoVehiculo();
                ventanaVehiculo.setVisible(true);
                ventanaVehiculo.setLocationRelativeTo(null);
            }
        });

        btnModificarVehiculo = new JButton("");
        btnModificarVehiculo.setBounds(955, 19, 33, 33);
        btnModificarVehiculo.setBorder(BorderFactory.createEmptyBorder());
        btnModificarVehiculo.setContentAreaFilled(false);

     
        btnModificarVehiculo.setIcon(resizedIcon2);
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
        agregarEventoTeclado(btnModificarVehiculo, "modify_VEHICLE", KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK);


        tableVehiculos = new JTable();
        tableVehiculos.setBorder(new LineBorder(new Color(60, 47, 128)));
        tableVehiculos.setFont(new Font("Tahoma", Font.BOLD, 12));
        tableVehiculos.setFillsViewportHeight(true);
        tableVehiculos.setBackground(new Color(174, 232, 202));
        JScrollPane scrollPane3 = new JScrollPane(tableVehiculos);
        scrollPane3.setBounds(56, 62, 932, 554);
        panelVehiculos.add(scrollPane3);

        loadVehiculosData();
        
        
        panelStock = new JPanel();
        panelStock.setBorder(new LineBorder(new Color(60, 47, 128), 2));
        panelStock.setBackground(new Color(250, 237, 218));
        panelStock.setLayout(null); // Asegúrate de usar un diseño de disposición nulo si deseas posicionar componentes manualmente

        btnAnadirStock = new JButton("");
        btnAnadirStock.setBounds(893, 19, 52, 32);
        btnAnadirStock.setBorder(BorderFactory.createEmptyBorder());
        btnAnadirStock.setContentAreaFilled(false);
        btnAnadirStock.setIcon(resizedIcon);
        agregarEventoTeclado(btnAnadirStock, "ADD_STOCK", KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK);
        panelStock.add(btnAnadirStock);
        btnAnadirStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NuevoStock ventanaStock = new NuevoStock();
                ventanaStock.setVisible(true);
                ventanaStock.setLocationRelativeTo(null);
            }
        });

        btnModificarStock = new JButton("");
        btnModificarStock.setBounds(955, 19, 33, 33);
        btnModificarStock.setBorder(BorderFactory.createEmptyBorder());
        btnModificarStock.setContentAreaFilled(false);
        btnModificarStock.setIcon(resizedIcon2);
        panelStock.add(btnModificarStock);
        btnModificarStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int stockSeleccionado = tableStock.getSelectedRow();
                if (stockSeleccionado != -1) {
                    Object stockId = tableStock.getValueAt(stockSeleccionado, 0);
                    ModificarStock modificarStock = new ModificarStock(stockId);
                    modificarStock.setVisible(true);
                    modificarStock.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un ítem de stock de la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        agregarEventoTeclado(btnModificarStock, "MODIFY_STOCK", KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK);

        tableStock = new JTable();
        tableStock.setBorder(new LineBorder(new Color(60, 47, 128)));
        tableStock.setFont(new Font("Tahoma", Font.BOLD, 12));
        tableStock.setFillsViewportHeight(true);
        tableStock.setBackground(new Color(174, 232, 202));
        JScrollPane scrollPaneStock = new JScrollPane(tableStock);
        scrollPaneStock.setBounds(56, 62, 932, 554);
        panelStock.add(scrollPaneStock);

        loadStockData();
        
        //panel facturas
        setupFacturasPanel();
  
       

        // Agregar paneles al principal
        panelPrincipal.add(panelClientes, "clientes");
        panelPrincipal.add(panelVehiculos, "vehiculos");
        panelPrincipal.add(panelMecanicos, "mecanicos");
        panelPrincipal.add(panelStock, "citas");
        panelPrincipal.add(panelFacturas,"facturas");
        
        
        
        
        
   
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
        btnFacturas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "facturas");
                cargarFacturas();
                
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

            // Personalizar el renderizado del encabezado de la tabla
            JTableHeader header = table.getTableHeader();
            header.setDefaultRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setBackground(new Color(60, 47, 128));
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Tahoma", Font.BOLD, 12));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    return label;
                }
            });

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
                    new Object[]{"NIF", "Nombre", "Apellido1", "Apellido2", "Teléfono", "Email", "Usuario", "Contraseña"}, 0);

            while (rs.next()) {
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");
                model2.addRow(new Object[]{nif, nombre, apellido1, apellido2, telefono, email, usuario, contrasena});
            }

            tableMecanicos.setModel(model2);

            // Personalizar el renderizado del encabezado de la tabla
            JTableHeader header = tableMecanicos.getTableHeader();
            header.setDefaultRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setBackground(new Color(60, 47, 128));
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Tahoma", Font.BOLD, 12));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    return label;
                }
            });

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
         // Personalizar el renderizado del encabezado de la tabla
            JTableHeader header = tableVehiculos.getTableHeader();
            header.setDefaultRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setBackground(new Color(60, 47, 128));
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Tahoma", Font.BOLD, 12));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    return label;
                }
            });
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void loadStockData() {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM pieza";
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = new DefaultTableModel(
                    new Object[]{"ID", "Nombre", "Precio", "Cantidad"}, 0);

            while (rs.next()) {
                int id = rs.getInt("id_pieza");
                String nombre = rs.getString("nombre_pieza");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                
                model.addRow(new Object[]{id, nombre,precio , cantidad});
            }

            tableStock.setModel(model);

            // Personalizar el renderizado del encabezado de la tabla
            JTableHeader header = tableStock.getTableHeader();
            header.setDefaultRenderer(new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setBackground(new Color(60, 47, 128));
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Tahoma", Font.BOLD, 12));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    
                    return label;
                }
            });
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void MetodoBoton(JButton button, String iconPath) {

        // Establecer el icono
        ImageIcon icon = new ImageIcon(VentanaAdmin.class.getResource(iconPath));
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(26, 26, Image.SCALE_SMOOTH);  // Redimensionar el icono
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        button.setIcon(resizedIcon);


        // Configurar el botón para que tenga el borde negro y no tenga el fondo verde desde el inicio
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));  // Borde negro con grosor 2
        button.setFocusPainted(false);  // Eliminar el borde de foco

        // Acción del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si ya hay un botón previamente seleccionado, quitarle el fondo verde
                if (btnSeleccionado != null) {
                    btnSeleccionado.setBackground(new Color (240,240,240)); // Eliminar el fondo verde del botón previamente seleccionado
                }

                // Establecer el fondo verde para el botón actual
                button.setBackground(new Color(106,207,201)); // Fondo verde 

                // Guardar el botón actual como el seleccionado
                btnSeleccionado = button;
            }
        });
    }
    private void agregarEventoTeclado(JButton button,String actionCommand, int keyEvent, int modifiers) {
    	InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    	KeyStroke keyStroke = KeyStroke.getKeyStroke(keyEvent, modifiers);
    	inputMap.put(keyStroke, actionCommand);
    	
    	ActionMap actionMap = button.getActionMap();
    	actionMap.put(actionCommand, new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				button.doClick();
			}
    		
    	});
    }
    
 // Método para inicializar el panel de facturas
    private void setupFacturasPanel() {
        panelFacturas = new JPanel();
        panelFacturas.setBorder(new LineBorder(new Color(60, 47, 128), 2));
        panelFacturas.setBackground(new Color(250, 237, 218));
        panelFacturas.setLayout(null);

        tableFacturas = new JTable();
        tableFacturas.setFont(new Font("Tahoma", Font.BOLD, 12));
        tableFacturas.setFillsViewportHeight(true);
        tableFacturas.setBorder(new LineBorder(new Color(60, 47, 128)));
        tableFacturas.setBackground(new Color(174, 232, 202));

        JScrollPane scrollPaneFacturas = new JScrollPane(tableFacturas);
        scrollPaneFacturas.setBounds(45, 59, 932, 554);
        panelFacturas.add(scrollPaneFacturas);
    }
    

 /// Método para cargar las facturas en la tabla
    private void cargarFacturas() {
        ConectorBD conector = new ConectorBD();
        Connection conexion = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conexion = conector.conexionCorrecta();
            stmt = conexion.createStatement();

            String consulta = "SELECT id_factura, precio, metodo_pago, orden_reparacion_id_orden_reparacion FROM factura";
            rs = stmt.executeQuery(consulta);

            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID Factura", "Precio Total", "Método Pago", "Orden Reparación"}, 0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_factura"),
                    rs.getDouble("precio"),
                    rs.getString("metodo_pago"),
                    rs.getInt("orden_reparacion_id_orden_reparacion")
                });
            }

            tableFacturas.setModel(model);
            setupTableHeader(tableFacturas);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error al cargar facturas: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para configurar el encabezado de la tabla
    private void setupTableHeader(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, 
                    boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setOpaque(true);
                label.setBackground(new Color(60, 47, 128));
                label.setForeground(Color.WHITE);
                label.setFont(new Font("Tahoma", Font.BOLD, 12));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
    }
 


//    private void cargarFacturas() {
//        ConectorBD conector = new ConectorBD();
//        Connection conexion = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            conexion = conector.conexionCorrecta();
//            stmt = conexion.createStatement();
//
//            // Consulta para obtener los datos de las órdenes finalizadas
//            String consulta = "SELECT p.precio, r.cantidad, r.orden_reparacion_id_orden_reparacion " +
//                              "FROM recambio r " +
//                              "JOIN pieza p ON r.stock_id_pieza = p.id_pieza " +
//                              "JOIN orden_reparacion o ON r.orden_reparacion_id_orden_reparacion = o.id_orden_reparacion " +
//                              "WHERE o.estado_int = 'finalizado'";
//            rs = stmt.executeQuery(consulta);
//
//            // Crear el modelo de la tabla
//            String[] columnNames = {"Precio", "Método de Pago", "Orden de Reparación"};
//            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
//
//            // Insertar datos en la tabla factura y en el modelo de la tabla
//            String insertQuery = "INSERT INTO factura (precio, metodo_pago, orden_reparacion_id_orden_reparacion) VALUES (?, ?, ?)";
//            try{
//            	pstmt = conexion.prepareStatement(insertQuery);
//            }catch(SQLException e) {
//            	e.printStackTrace();
//            }
//
//            while (rs.next()) {
//                double precio = rs.getDouble("precio");
//                int cantidad = rs.getInt("cantidad");
//                int ordenReparacionId = rs.getInt("orden_reparacion_id_orden_reparacion");
//
//                // Calcular el precio total
//                double precioTotal = precio * cantidad;
//
//                // Verificar si la factura ya existe para evitar duplicados
//                String verificarFactura = "SELECT * FROM factura WHERE orden_reparacion_id_orden_reparacion = ?";
//                PreparedStatement verificarStmt = conexion.prepareStatement(verificarFactura);
//                verificarStmt.setInt(1, ordenReparacionId);
//                ResultSet facturaExistente = verificarStmt.executeQuery();
//
//                if (!facturaExistente.next()) { // Si no existe, insertar
//                    pstmt.setDouble(1, precioTotal);
//                    pstmt.setString(2, "unico"); // Método de pago por defecto
//                    pstmt.setInt(3, ordenReparacionId);
//                    pstmt.executeUpdate();
//                }
//
//                // Añadir los datos a la tabla
//                Object[] rowData = {precioTotal, "unico", ordenReparacionId};
//                tableModel.addRow(rowData);
//
//                // Cerrar recursos de verificación
//                facturaExistente.close();
//                verificarStmt.close();
//            }
//
//            // Asignar el modelo a la tabla
//            tableFacturas.setModel(tableModel);
//
//            // Personalizar el renderizado del encabezado de la tabla
//            JTableHeader header = tableFacturas.getTableHeader();
//            header.setDefaultRenderer(new TableCellRenderer() {
//                @Override
//                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                    JLabel label = new JLabel(value.toString());
//                    label.setOpaque(true);
//                    label.setBackground(new Color(60, 47, 128));
//                    label.setForeground(Color.WHITE);
//                    label.setFont(new Font("Tahoma", Font.BOLD, 12));
//                    label.setHorizontalAlignment(SwingConstants.CENTER);
//                    return label;
//                }
//            });
//
//            // Añadir el JScrollPane al panel de facturas
//            JScrollPane scrollPane = new JScrollPane(tableFacturas);
//            scrollPane.setBounds(45, 59, 932, 554); // Ajustar coordenadas y tamaño
//            panelFacturas.add(scrollPane);
//
//            System.out.println("Datos cargados correctamente en la tabla de facturas.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error al cargar las facturas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            // Cerrar recursos
//            try {
//                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
//                if (pstmt != null) pstmt.close();
//                if (conexion != null) conexion.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    
    
}


