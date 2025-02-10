package Componente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import Controlador.ConectorBD;
import Vista.AnadirPieza;
import Vista.VentanaMeca;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;

public class CardView extends JPanel {
    private JLabel lblIdReparacion;
    private JLabel lblMatricula;
    private JLabel lblModelo;
    private JLabel lblEstado;
    private JLabel lblPiezas;
    private JLabel lblDescripcion;

    private JButton btnFinalizarOrden,btnDesasignarOrden,btnAnadirPieza; 
    private JPanel parentPanel; // Panel padre donde se agregan los CardViews
    private boolean isExpanded = false;
    private String idReparacion;
    private String mecanicoNIF;
    private VentanaMeca ventanaMecanico;
    private JScrollPane scrollPane;

    public CardView(String idReparacion, String matricula, String modelo, String estado, String descripcion, JPanel parentPanel, String mecanicoNIF, VentanaMeca ventanaMecanico) {
        this.idReparacion = idReparacion;
        this.parentPanel = parentPanel;
        this.mecanicoNIF = mecanicoNIF;
        this.ventanaMecanico = ventanaMecanico;

        // Configurar el panel
        setBackground(new Color(174, 232, 202));
        setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        setLayout(null);

        // Crear y configurar las etiquetas
        lblIdReparacion = new JLabel("ID Reparación: " + idReparacion);
        lblIdReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblIdReparacion.setForeground(new Color(60, 47, 128));
        lblIdReparacion.setBounds(10, 10, 200, 25);
        add(lblIdReparacion);

        lblEstado = new JLabel("Estado: " + estado);
        lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEstado.setForeground(new Color(60, 47, 128));
        lblEstado.setBounds(250, 10, 200, 25);
        add(lblEstado);

        lblMatricula = new JLabel("Matrícula: " + matricula);
        lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblMatricula.setForeground(new Color(60, 47, 128));
        lblMatricula.setBounds(10, 40, 200, 25);
        add(lblMatricula);

        lblModelo = new JLabel("Modelo: " + modelo);
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblModelo.setForeground(new Color(60, 47, 128));
        lblModelo.setBounds(250, 40, 200, 25);
        add(lblModelo);

        lblPiezas = new JLabel("Piezas: ");
        lblPiezas.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPiezas.setForeground(new Color(60, 47, 128));
        lblPiezas.setBounds(10, 123, 430, 50);
        add(lblPiezas);
        
        scrollPane=new JScrollPane(lblPiezas);

        lblDescripcion = new JLabel("<html>Descripción: " + descripcion + "</html>");
        lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDescripcion.setForeground(new Color(60, 47, 128));
        lblDescripcion.setBounds(10, 63, 440, 50);
        add(lblDescripcion);

        
        // Crear el botón de finalizar orden
        btnFinalizarOrden = new JButton("Finalizar Orden");
        btnFinalizarOrden.setBounds(450, 25, 150, 30); // Ajusta las coordenadas para que aparezca a la derecha
        btnFinalizarOrden.setBackground(new Color(255, 69, 58)); // Color rojo para el botón
        btnFinalizarOrden.setForeground(Color.WHITE); // Texto en blanco
        btnFinalizarOrden.setFocusPainted(false); // Eliminar el borde de foco
        btnFinalizarOrden.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borde negro
        btnFinalizarOrden.setVisible(false); 
        add(btnFinalizarOrden);
        
        //crear boton desasignar orden
        btnDesasignarOrden=new JButton("Desasignar Orden");
        btnDesasignarOrden.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		desasignarOrdenReparacion(idReparacion);
        	}
        });
        btnDesasignarOrden.setBounds(450,75, 150, 30); // Ajusta las coordenadas para que aparezca a la derecha
        btnDesasignarOrden.setBackground(new Color(255, 69, 58)); // Color rojo para el botón
        btnDesasignarOrden.setForeground(Color.WHITE); // Texto en blanco
        btnDesasignarOrden.setFocusPainted(false); // Eliminar el borde de foco
        btnDesasignarOrden.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borde negro
        btnDesasignarOrden.setVisible(false); 
        add(btnDesasignarOrden);
        
        //crea el boton para anadir pieza
        btnAnadirPieza=new JButton("Anadir Pieza");
        btnAnadirPieza.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AnadirPieza ventanaAnadirPieza=new AnadirPieza(idReparacion,CardView.this);
        		ventanaAnadirPieza.setVisible(true);
        		ventanaAnadirPieza.setLocationRelativeTo(null);
        	}
        });
        btnAnadirPieza.setBounds(450, 125, 150, 30); // Ajusta las coordenadas para que aparezca a la derecha
        btnAnadirPieza.setBackground(new Color(255, 69, 58)); // Color rojo para el botón
        btnAnadirPieza.setForeground(Color.WHITE); // Texto en blanco
        btnAnadirPieza.setFocusPainted(false); // Eliminar el borde de foco
        btnAnadirPieza.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Borde negro
        btnAnadirPieza.setVisible(false); 
        add(btnAnadirPieza);
        
        
        
        // Agregar un MouseListener para mostrar el botón y ajustar el tamaño del CardView al hacer clic
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isExpanded) {
                    setSize(getWidth() + 200, getHeight()); // Aumentar el tamaño del CardView
                    btnFinalizarOrden.setVisible(true); // Mostrar el botón
                    btnDesasignarOrden.setVisible(true);
                    btnAnadirPieza.setVisible(true);
                    isExpanded = true;
                } else {
                    setSize(getWidth() - 200, getHeight()); // Restaurar el tamaño original del CardView
                    btnFinalizarOrden.setVisible(false); 
                    btnDesasignarOrden.setVisible(false);// Ocultar el botón
                    btnAnadirPieza.setVisible(false);
                    isExpanded = false;
                }
                revalidate(); // Actualizar el panel
                repaint(); // Reflejar los cambios visuales
            }
        });

        // Acción del botón finalizar orden
        btnFinalizarOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarOrdenReparacion(idReparacion); // Llamar al método para actualizar el estado
            }
        });
        cargarPiezas();
    }

   

	



    private void finalizarOrdenReparacion(String idReparacion) {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            String updateQuery = "UPDATE orden_reparacion SET estado_int = 'finalizado' WHERE id_orden_reparacion = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, idReparacion);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Orden de reparación finalizada: " + idReparacion);
                lblEstado.setText("Estado: finalizado"); // Actualizar la etiqueta del estado
                parentPanel.remove(this); // Eliminar el CardView del panel padre
                parentPanel.revalidate(); // Actualizar el panel
                parentPanel.repaint(); // Reflejar los cambios visuales
                ventanaMecanico.cargarOrdenesDeReparacion(mecanicoNIF, parentPanel); // Recargar el panel

                // Insertar datos en la tabla factura
                String insertFacturaQuery = "INSERT INTO factura (precio, metodo_pago, orden_reparacion_id_orden_reparacion) VALUES (?, ?, ?)";
                PreparedStatement pstmtFactura = conn.prepareStatement(insertFacturaQuery);

                // Obtener precio, cantidad y método de pago utilizando la consulta proporcionada
                String consulta = "SELECT p.precio, r.cantidad, r.orden_reparacion_id_orden_reparacion " +
                                  "FROM recambio r " +
                                  "JOIN pieza p ON r.stock_id_pieza = p.id_pieza " +
                                  "JOIN orden_reparacion o ON r.orden_reparacion_id_orden_reparacion = o.id_orden_reparacion " +
                                  "WHERE o.id_orden_reparacion = ? AND o.estado_int = 'finalizado'";
                PreparedStatement pstmtConsulta = conn.prepareStatement(consulta);
                pstmtConsulta.setString(1, idReparacion);
                ResultSet rs = pstmtConsulta.executeQuery();

                if (rs.next()) {
                    double precio = rs.getDouble("precio") * rs.getInt("cantidad")+50; // Precio total de las piezas + mano de obra
                    String metodoPago = obtenerMetodoPagoOrdenReparacion(idReparacion); // Método de pago
                    int ordenReparacionId = rs.getInt("orden_reparacion_id_orden_reparacion");

                    pstmtFactura.setDouble(1, precio);
                    pstmtFactura.setString(2, metodoPago);
                    pstmtFactura.setInt(3, ordenReparacionId);
                    pstmtFactura.executeUpdate();
                }

                rs.close();
                pstmtConsulta.close();
                pstmtFactura.close();

            } else {
                System.out.println("No se pudo finalizar la orden de reparación: " + idReparacion);
            }
            
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String obtenerMetodoPagoOrdenReparacion(String idReparacion) {
        // Implementa este método para obtener el método de pago de la orden de reparación
        return "unico"; // Ejemplo de valor predeterminado
    }

    
    private void desasignarOrdenReparacion(String idReparacion) {
        try {
            ConectorBD conector = new ConectorBD();
            Connection conn = conector.conexionCorrecta();
            String updateQuery = "UPDATE orden_reparacion SET usuario_nif=null, estado_ext='no_asignado' WHERE id_orden_reparacion = ?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, idReparacion);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Orden de reparación finalizada: " + idReparacion);
                lblEstado.setText("Estado: finalizado"); // Actualizar la etiqueta del estado
                parentPanel.remove(this); // Eliminar el CardView del panel padre
                parentPanel.revalidate(); // Actualizar el panel
                parentPanel.repaint(); // Reflejar los cambios visuales
                ventanaMecanico.cargarOrdenesDeReparacion(mecanicoNIF, parentPanel); // Recargar el panel
            } else {
                System.out.println("No se pudo finalizar la orden de reparación: " + idReparacion);
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(0, 242, 254); // #00F2FE
        Color color2 = new Color(79, 172, 254); // #4FACFE
        GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
    
    public void cargarPiezas() {
        ConectorBD conector = new ConectorBD();
        Connection conn = conector.conexionCorrecta();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            String consulta = "SELECT r.cantidad, p.nombre_pieza FROM recambio r JOIN pieza p ON r.stock_id_pieza = p.id_pieza WHERE orden_reparacion_id_orden_reparacion = " + idReparacion;
            rs = stmt.executeQuery(consulta);

            StringBuilder piezasInfo = new StringBuilder("<html>Piezas:<br>"); // Usamos HTML para formatear el texto

            while (rs.next()) {
                String cantidad = rs.getString("cantidad");
                String nombre = rs.getString("nombre_pieza");
                piezasInfo.append(cantidad).append(" x ").append(nombre).append("<br>"); // Añadimos cada pieza en una nueva línea
            }

            piezasInfo.append("</html>"); // Cerramos el tag HTML

            lblPiezas.setText(piezasInfo.toString()); // Establecemos el texto en el JLabel

            // Establecer los colores de fondo del JLabel y JScrollPane como transparentes
            lblPiezas.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setOpaque(false);
            scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Eliminar el borde del JScrollPane
            
            // Añadir el JScrollPane con el JLabel al panel
            scrollPane.setViewportView(lblPiezas);
            scrollPane.setBounds(10, 123, 430, 50); // Ajusta las coordenadas y tamaño del JScrollPane
            add(scrollPane);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerramos los recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
