package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Componente.CardView;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Controlador.ConectorBD;

public class VentanaMeca extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel panelMisOrdenes;
    private JPanel panelOrdenes;
    private JPanel panelStock;

    private JButton btnSeleccionado = null;

    private String mecanicoNIF;

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

        // Panel Stock
        panelStock = new JPanel();
        panelStock.setLayout(null);
        panelStock.setBackground(new Color(250, 237, 218));

        // Agregar paneles al principal
        panelPrincipal.add(panelMisOrdenes, "Mis ordenes");
        panelPrincipal.add(panelOrdenes, "O r d e n e s");
        panelPrincipal.add(panelStock, "S t o c k");

        // Cargar las órdenes de reparación del mecánico y agregar CardViews
        cargarOrdenesDeReparacion(mecanicoNIF, panelMisOrdenes);

        // Acciones de botones
        btnSusOrdenes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Mis ordenes");
            }
        });

        btnOrdenes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "O r d e n e s");
            }
        });

        btnStock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "S t o c k");
            }
        });
    }

    private void cargarOrdenesDeReparacion(String mecanicoNIF, JPanel panel) {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM orden_reparacion WHERE usuario_nif = '" + mecanicoNIF + "'";
            ResultSet rs = stmt.executeQuery(query);

            List<CardView> cardViews = new ArrayList<>();
            while (rs.next()) {
                String idReparacion = rs.getString("id_orden_reparacion");
                String matricula = rs.getString("vehiculo_matricula");
                String modelo = "Modelo"; // Aquí puedes agregar lógica para obtener el modelo del vehículo si es necesario
                String estado = rs.getString("estado_ext");
                String descripcion = rs.getString("descripcion");

                CardView cardView = new CardView(idReparacion, matricula, modelo, estado, descripcion);
                cardViews.add(cardView);
            }

            int yOffset = 10;
            for (CardView cardView : cardViews) {
                cardView.setBounds(45, yOffset, 377, 196);
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
}


