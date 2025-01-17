package Vista;

import java.awt.Color;
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
import java.sql.ResultSet;
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

import Controlador.ConectorBD;

public class VentanaMeca extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel panelMisOrdenes;
    private JPanel panelOrdenes;
    private JPanel panelStock;
 

    
    private JButton btnSeleccionado = null;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaMeca frame = new VentanaMeca();
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
    public VentanaMeca() {
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
        
//BOTON MIS ORDENES
        
        JButton btnSusOrdenes = new JButton("Mis ordenes");
        btnSusOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
        btnSusOrdenes.setForeground(new Color(0, 0, 0));
        btnSusOrdenes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSusOrdenes.setBounds(0, 165, 136, 57);
        
        panelIzquierda.add(btnSusOrdenes);
        
        
        MetodoBoton(btnSusOrdenes, "/imagenes/Acliente.png");

//BOTON VEHICULO
        

        JButton btnOrdenes = new JButton("O r d e n e s");
        btnOrdenes.setHorizontalAlignment(SwingConstants.LEFT);
        btnOrdenes.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnOrdenes.setBounds(0, 233, 136, 57);

      

        panelIzquierda.add(btnOrdenes);

        MetodoBoton(btnOrdenes, "/imagenes/Acoche.png");

        
        
        
        //BOTON MECANICO
        
        JButton btnStock = new JButton("S t o c k");
        btnStock.setHorizontalAlignment(SwingConstants.LEFT);
        btnStock.setBounds(0, 302, 136, 57);
        btnStock.setFont(new Font("Tahoma", Font.BOLD, 13));
        panelIzquierda.add(btnStock);
        
        MetodoBoton(btnStock, "/imagenes/Amecanico.png");
        
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

        // Panel Principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBounds(138, 0, 1046, 700);
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);
        getContentPane().add(panelPrincipal);

        // Panel Clientes
        panelMisOrdenes = new JPanel();
        panelMisOrdenes.setBackground(new Color(250,237,218));
        panelMisOrdenes.setLayout(null);

        // Cargar la imagen original desde los recursos
        ImageIcon originalIcon = new ImageIcon(VentanaAdmin.class.getResource("/imagenes/add.png"));

        // Redimensionar la imagen a 32x30 píxeles
        Image ogimagen = originalIcon.getImage();
        Image escalado = ogimagen.getScaledInstance(32, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(escalado);

        ImageIcon originalIcon2 = new ImageIcon(VentanaAdmin.class.getResource("/imagenes/modify.png"));
        Image ogimagen2 = originalIcon2.getImage();
        Image escalado2 = ogimagen2.getScaledInstance(32, 30, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(escalado2);

        

        // Panel Mecánicos
        panelStock = new JPanel();
        panelStock.setLayout(null);
        panelStock.setBackground(new Color(250,237,218));
    
        panelOrdenes = new JPanel();
        panelOrdenes.setBackground(new Color(250,237,218));
        panelOrdenes.setLayout(null); // Asegúrate de usar un diseño de disposición nulo si deseas posicionar componentes manualmente




        // Agregar paneles al principal
        panelPrincipal.add(panelMisOrdenes, "Mis ordenes");
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 999, 182);
        panelMisOrdenes.add(panel);
        panel.setLayout(null);
        
        JLabel lblId = new JLabel("ID Reparacion");
        lblId.setBounds(10, 10, 70, 13);
        panel.add(lblId);
        
        JLabel lblIdEditable = new JLabel("1");
        lblIdEditable.setBounds(103, 10, 45, 13);
        panel.add(lblIdEditable);
        
        JLabel lblMatricula = new JLabel("Matricula: ");
        lblMatricula.setBounds(227, 10, 70, 13);
        panel.add(lblMatricula);
        
        JLabel lblIdEditable_1 = new JLabel("2544JJD");
        lblIdEditable_1.setBounds(307, 10, 45, 13);
        panel.add(lblIdEditable_1);
        
        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(441, 10, 70, 13);
        panel.add(lblModelo);
        
        JLabel lblModeloEditable = new JLabel("Renault megane");
        lblModeloEditable.setBounds(541, 10, 110, 13);
        panel.add(lblModeloEditable);
        
        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setBounds(10, 72, 70, 13);
        panel.add(lblDescripcion);
        
        JLabel lblDescripcionEditable = new JLabel("No arranca");
        lblDescripcionEditable.setBounds(103, 72, 83, 13);
        panel.add(lblDescripcionEditable);
        
        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setBounds(705, 10, 70, 13);
        panel.add(lblEstado);
        
        JLabel lblEstadoEditable = new JLabel("En reparacion");
        lblEstadoEditable.setBounds(792, 10, 110, 13);
        panel.add(lblEstadoEditable);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBounds(10, 218, 999, 182);
        panelMisOrdenes.add(panel_1);
        
        JLabel lblId_1 = new JLabel("ID Reparacion");
        lblId_1.setBounds(10, 10, 70, 13);
        panel_1.add(lblId_1);
        
        JLabel lblIdEditable_2 = new JLabel("2");
        lblIdEditable_2.setBounds(103, 10, 45, 13);
        panel_1.add(lblIdEditable_2);
        
        JLabel lblMatricula_1 = new JLabel("Matricula: ");
        lblMatricula_1.setBounds(227, 10, 70, 13);
        panel_1.add(lblMatricula_1);
        
        JLabel lblIdEditable_1_1 = new JLabel("5555AAA");
        lblIdEditable_1_1.setBounds(307, 10, 45, 13);
        panel_1.add(lblIdEditable_1_1);
        
        JLabel lblModelo_1 = new JLabel("Modelo");
        lblModelo_1.setBounds(441, 10, 70, 13);
        panel_1.add(lblModelo_1);
        
        JLabel lblModeloEditable_1 = new JLabel("Opel Corsa");
        lblModeloEditable_1.setBounds(541, 10, 110, 13);
        panel_1.add(lblModeloEditable_1);
        
        JLabel lblDescripcion_1 = new JLabel("Descripcion");
        lblDescripcion_1.setBounds(10, 72, 70, 13);
        panel_1.add(lblDescripcion_1);
        
        JLabel lblDescripcionEditable_1 = new JLabel("Limpiaparabrisas roto");
        lblDescripcionEditable_1.setBounds(103, 72, 118, 13);
        panel_1.add(lblDescripcionEditable_1);
        
        JLabel lblEstado_1 = new JLabel("Estado");
        lblEstado_1.setBounds(705, 10, 70, 13);
        panel_1.add(lblEstado_1);
        
        JLabel lblEstadoEditable_1 = new JLabel("Pendiente");
        lblEstadoEditable_1.setBounds(792, 10, 110, 13);
        panel_1.add(lblEstadoEditable_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBounds(10, 430, 999, 182);
        panelMisOrdenes.add(panel_2);
        
        JLabel lblId_2 = new JLabel("ID Reparacion");
        lblId_2.setBounds(10, 10, 70, 13);
        panel_2.add(lblId_2);
        
        JLabel lblIdEditable_3 = new JLabel("3");
        lblIdEditable_3.setBounds(103, 10, 45, 13);
        panel_2.add(lblIdEditable_3);
        
        JLabel lblMatricula_2 = new JLabel("Matricula: ");
        lblMatricula_2.setBounds(227, 10, 70, 13);
        panel_2.add(lblMatricula_2);
        
        JLabel lblIdEditable_1_2 = new JLabel("8888BBB");
        lblIdEditable_1_2.setBounds(307, 10, 45, 13);
        panel_2.add(lblIdEditable_1_2);
        
        JLabel lblModelo_2 = new JLabel("Modelo");
        lblModelo_2.setBounds(441, 10, 70, 13);
        panel_2.add(lblModelo_2);
        
        JLabel lblModeloEditable_2 = new JLabel("Toyota Auris");
        lblModeloEditable_2.setBounds(541, 10, 110, 13);
        panel_2.add(lblModeloEditable_2);
        
        JLabel lblDescripcion_2 = new JLabel("Descripcion");
        lblDescripcion_2.setBounds(10, 72, 70, 13);
        panel_2.add(lblDescripcion_2);
        
        JLabel lblDescripcionEditable_2 = new JLabel("Ruedas pinchadas");
        lblDescripcionEditable_2.setBounds(103, 72, 82, 13);
        panel_2.add(lblDescripcionEditable_2);
        
        JLabel lblEstado_2 = new JLabel("Estado");
        lblEstado_2.setBounds(705, 10, 70, 13);
        panel_2.add(lblEstado_2);
        
        JLabel lblEstadoEditable_2 = new JLabel("Pendiente");
        lblEstadoEditable_2.setBounds(792, 10, 110, 13);
        panel_2.add(lblEstadoEditable_2);
        panelPrincipal.add(panelOrdenes, "O r d e n e s");
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(214, 194, 85, 21);
        panelOrdenes.add(btnNewButton);
        panelPrincipal.add(panelStock, "S t o c k");
       

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


