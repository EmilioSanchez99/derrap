package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Componente.CardView;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import Controlador.ConectorBD;

public class VentanaMeca extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel panelMisOrdenes;
    private JPanel panelOrdenes;
    private static JTable tableOrdenes;
    private JPanel panelStock;
    private JButton btnAsignarOrden;
    private JButton btnSeleccionado = null;

    private String mecanicoNIF;
    private static JTable tableStock;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaMeca frame = new VentanaMeca("78945612A"); // Aquí pasa el NIF del mecánico como ejemplo
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
    public VentanaMeca(String mecanicoNIF) {
    	
        this.mecanicoNIF = mecanicoNIF;
        System.out.println(mecanicoNIF);

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
        
        // BOTON MIS ORDENES
        JButton btnSusOrdenes = new JButton("Mis ordenes");
        btnSusOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
        btnSusOrdenes.setForeground(new Color(0, 0, 0));
        btnSusOrdenes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSusOrdenes.setBounds(0, 165, 136, 57);
        panelIzquierda.add(btnSusOrdenes);
        MetodoBoton(btnSusOrdenes, "/imagenes/Acliente.png");

        // BOTON VEHICULO
        JButton btnOrdenes = new JButton("O r d e n e s");
        btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
        btnOrdenes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnOrdenes.setBounds(0, 233, 136, 57);
        panelIzquierda.add(btnOrdenes);
        MetodoBoton(btnOrdenes, "/imagenes/Acoche.png");

        // BOTON MECANICO
        JButton btnStock = new JButton("S t o c k");
        btnStock.setHorizontalAlignment(SwingConstants.LEFT);
        btnStock.setBounds(0, 302, 136, 57);
        btnStock.setFont(new Font("Tahoma", Font.BOLD, 13));
        panelIzquierda.add(btnStock);
        MetodoBoton(btnStock, "/imagenes/Amecanico.png");
        
        JButton btnSalir = new JButton("Cerrar Sesion");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int seleccion = JOptionPane.showConfirmDialog(null, "Seguro que quieres salir?", "confirmar", JOptionPane.YES_NO_OPTION);
                if (seleccion == JOptionPane.YES_OPTION) {
                    dispose();
                    Login login = new Login();
                    login.setVisible(true);
                    login.setLocationRelativeTo(null);
                }
            }
        });
        btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSalir.setBounds(0, 597, 136, 57);
        panelIzquierda.add(btnSalir);

        // Panel Principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(138, 0, 1046, 700);
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        getContentPane().add(panelPrincipal);

        // Panel Mis Ordenes
        panelMisOrdenes = new JPanel();
        panelMisOrdenes.setBackground(new Color(250, 237, 218));
        panelMisOrdenes.setLayout(null);

        // Panel Ordenes
        panelOrdenes = new JPanel();
        panelOrdenes.setBackground(new Color(250, 237, 218));
        panelOrdenes.setLayout(null); // Asegúrate de usar un diseño de disposición nulo si deseas posicionar componentes manualmente

     // Botón Asignarse orden
         btnAsignarOrden = new JButton("");
         btnAsignarOrden.setBounds(893, 19, 52, 32);
         btnAsignarOrden.setBorder(BorderFactory.createEmptyBorder());
         btnAsignarOrden.setContentAreaFilled(false);

        // Cargar la imagen original desde los recursos
        ImageIcon originalIcon = new ImageIcon(VentanaMeca.class.getResource("/imagenes/iconoAsignar (2).png"));

        // Redimensionar la imagen a 32x30 píxeles
        Image ogimagen = originalIcon.getImage();
        Image escalado = ogimagen.getScaledInstance(40,40, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(escalado);

        // Asignar el icono redimensionado al botón
        btnAsignarOrden.setIcon(resizedIcon);

        btnAsignarOrden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la fila seleccionada en la tabla
                int selectedRow = tableOrdenes.getSelectedRow();

                // Verificar si se ha seleccionado una fila
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una orden de reparación.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Obtener el ID de la orden de reparación seleccionada
                String idOrden = (String) tableOrdenes.getValueAt(selectedRow, 0);

                // Verificar si el mecánico ya tiene 3 órdenes asignadas
                try {
                    ConectorBD conector = new ConectorBD();
                    Connection conn = conector.conexionCorrecta();
                    Statement stmt = conn.createStatement();

                    // Contar las órdenes asignadas al mecánico
                    String countQuery = "SELECT COUNT(*) AS total FROM orden_reparacion WHERE usuario_nif = '" + mecanicoNIF + "' AND estado_ext = 'asignado' AND estado_int != 'finalizado'";

                    ResultSet rs = stmt.executeQuery(countQuery);

                    int totalOrdenesAsignadas = 0;
                    if (rs.next()) {
                        totalOrdenesAsignadas = rs.getInt("total");
                    }

                    // Verificar si el mecánico ya tiene 3 órdenes asignadas
                    if (totalOrdenesAsignadas >= 3) {
                        JOptionPane.showMessageDialog(null, "No se puede asignar más de 3 órdenes de reparación a un mecánico.", "Error", JOptionPane.ERROR_MESSAGE);
                        rs.close();
                        stmt.close();
                        conn.close();
                        return;
                    }

                    // Asignar la orden al mecánico logueado
                    String updateQuery = "UPDATE orden_reparacion SET usuario_nif = '" + mecanicoNIF + "', estado_ext = 'asignado' WHERE id_orden_reparacion = '" + idOrden + "'";
                    int rowsAffected = stmt.executeUpdate(updateQuery);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Orden de reparación asignada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                        // Actualizar la tabla de órdenes no asignadas
                        cargarOrdenesDeReparacionNoAsignadas(panelOrdenes);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo asignar la orden de reparación.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al asignar la orden de reparación.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        panelOrdenes.add(btnAsignarOrden);
        MetodoBoton(btnSalir, "/imagenes/Aexit.png");

        // Panel Stock
        panelStock = new JPanel();
        panelStock.setLayout(null);
        panelStock.setBackground(new Color(250, 237, 218));

        // Agregar paneles al principal
        panelPrincipal.add(panelMisOrdenes, "Mis ordenes");
        panelPrincipal.add(panelOrdenes, "O r d e n e s");
        
       
        panelPrincipal.add(panelStock, "S t o c k");
        tableOrdenes = new JTable();
        tableOrdenes.setGridColor(new Color(128, 128, 128));
        tableOrdenes.setToolTipText("");
        tableOrdenes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableOrdenes.setFillsViewportHeight(true);
        tableOrdenes.setFont(new Font("Tahoma", Font.BOLD, 12));
        tableOrdenes.setBorder(new LineBorder(new Color(60, 47, 128), 2, true));
        tableOrdenes.setBackground(new Color(174, 232, 202));
        JScrollPane scrollPaneOrdenes = new JScrollPane(tableOrdenes);
        scrollPaneOrdenes.setBounds(56, 62, 932, 554);
        panelOrdenes.add(scrollPaneOrdenes);
        
        
        //panel Stock
        
        tableStock = new JTable();
        tableStock.setGridColor(new Color(128, 128, 128));
        tableStock.setToolTipText("");
        tableStock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableStock.setFillsViewportHeight(true);
        tableStock.setFont(new Font("Tahoma", Font.BOLD, 12));
        tableStock.setBorder(new LineBorder(new Color(60, 47, 128), 2, true));
        tableStock.setBackground(new Color(174, 232, 202));
        JScrollPane scrollPaneStock = new JScrollPane(tableStock);
        scrollPaneStock.setBounds(56, 62, 932, 554);
        panelStock.add(scrollPaneStock);
       
        
        
        // Cargar las órdenes de reparación del mecánico y agregar CardViews
        cargarOrdenesDeReparacion(mecanicoNIF, panelMisOrdenes);

        // Acciones de botones
        btnSusOrdenes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Mis ordenes");
                cargarOrdenesDeReparacion(mecanicoNIF, panelMisOrdenes);
            }
        });

        btnOrdenes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "O r d e n e s");
                cargarOrdenesDeReparacionNoAsignadas(panelOrdenes);
            }
        });

        btnStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "S t o c k");
                loadStockData();
            }
        });
    }

    public void cargarOrdenesDeReparacion(String mecanicoNIF, JPanel panel) {
        try {
        	panel.removeAll();
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM orden_reparacion WHERE usuario_nif = '" + mecanicoNIF + "' AND estado_int != 'finalizado'";

            ResultSet rs = stmt.executeQuery(query);

            List<CardView> cardViews = new ArrayList<>();
            while (rs.next()) {
                String idReparacion = rs.getString("id_orden_reparacion");
                String matricula = rs.getString("vehiculo_matricula");
                String modelo = "Modelo"; // Aquí puedes agregar lógica para obtener el modelo del vehículo si es necesario
                String estado = "En diagnostico";
                String descripcion = rs.getString("descripcion");

                CardView cardView = new CardView(idReparacion, matricula, modelo, estado, descripcion, panel,mecanicoNIF,this);
                cardViews.add(cardView);
            }

            int yOffset = 10;
            for (CardView cardView : cardViews) {
                cardView.setBounds(45, yOffset,450,200);
                panel.add(cardView);
                yOffset += 216; // Espaciado entre CardViews
            }

            // Asegúrate de actualizar el panel después de agregar los CardView
            panel.revalidate();
            panel.repaint();

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    private void cargarOrdenesDeReparacionNoAsignadas(JPanel panel) {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM orden_reparacion WHERE estado_ext = 'no_asignado'";
            System.out.println("Ejecutando consulta: " + query);
            ResultSet rs = stmt.executeQuery(query);

            String[] columnNames = {"ID Reparación", "Fecha Entrada", "Fecha Salida", "Descripción", "Estado Interno", "Estado Externo", "Usuario NIF", "Vehículo Matrícula"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
             

            
            while (rs.next()) {
                String idReparacion = rs.getString("id_orden_reparacion");
                Date fechaEntrada = rs.getDate("fecha_entrada");
                Date fechaSalida = rs.getDate("fecha_salida");
                String descripcion = rs.getString("descripcion");
                String estadoInt = rs.getString("estado_int");
                String estadoExt = rs.getString("estado_ext");
                String usuarioNIF = rs.getString("usuario_nif");
                String vehiculoMatricula = rs.getString("vehiculo_matricula");
                System.out.println("Orden encontrada: " + idReparacion);

                Object[] row = {idReparacion, fechaEntrada, fechaSalida, descripcion, estadoInt, estadoExt, usuarioNIF, vehiculoMatricula};
                tableModel.addRow(row);
                System.out.println("hvbjnkm");
              
            }
            tableOrdenes.setModel(tableModel);

            

            // Personalización de la cabecera de la tabla
            JTableHeader header = tableOrdenes.getTableHeader();
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
        ImageIcon icon = new ImageIcon(VentanaMeca.class.getResource(iconPath));
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

            try {
				tableStock.setModel(model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

}


