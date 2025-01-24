package Componente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CardView extends JPanel {
    private JLabel lblIdReparacion;
    private JLabel lblMatricula;
    private JLabel lblModelo;
    private JLabel lblEstado;
    private JLabel lblEnReparacion;
    private JLabel lblDescripcion;

    public CardView(String idReparacion, String matricula, String modelo, String estado, String descripcion) {
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

        lblEnReparacion = new JLabel("En Reparación:");
        lblEnReparacion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEnReparacion.setForeground(new Color(60, 47, 128));
        lblEnReparacion.setBounds(10, 70, 200, 25);
        add(lblEnReparacion);

        lblDescripcion = new JLabel("<html>Descripción: " + descripcion + "</html>");
        lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDescripcion.setForeground(new Color(60, 47, 128));
        lblDescripcion.setBounds(10, 100, 440, 50);
        add(lblDescripcion);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(250, 237, 218);
        Color color2 = new Color(174, 232, 202);
        GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}
