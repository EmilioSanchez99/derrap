package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import Controlador.ConectorBD;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AnadirPieza extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            AnadirPieza dialog = new AnadirPieza(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public AnadirPieza(String idReparacion) {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // Array with piece names
        String[] piezas = {"Filtro de aceite", "Bujía", "Pastillas de freno", "Correa de distribución",
                           "Amortiguador", "Filtro de aire", "Batería", "Radiador", 
                           "Alternador", "Bomba de agua", "Volante", "Bombilla"};

        // Label for piece selection
        JLabel piezaLabel = new JLabel("Elige una pieza:");
        piezaLabel.setBounds(50, 50, 150, 30);
        contentPanel.add(piezaLabel);

        // Create JComboBox and add it to the contentPanel
        JComboBox<String> comboBox = new JComboBox<>(piezas);
        comboBox.setBounds(200, 50, 150, 30);
        contentPanel.add(comboBox);

        // Label for quantity
        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setBounds(50, 100, 150, 30);
        contentPanel.add(cantidadLabel);

        // Create JSpinner for quantity
        JSpinner cantidadSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        cantidadSpinner.setBounds(200, 100, 50, 30);
        contentPanel.add(cantidadSpinner);

        // Button panel
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
            	JButton okButton = new JButton("OK");
            	okButton.addActionListener(new ActionListener() {
            	    public void actionPerformed(ActionEvent e) {
            	        // Obtener el nombre de la pieza seleccionada del JComboBox
            	        String nombrePieza = comboBox.getSelectedItem().toString();
            	        System.out.println(nombrePieza);

            	        // Obtener la cantidad seleccionada del JSpinner
            	        int cantidad = (Integer) cantidadSpinner.getValue();
            	        System.out.println(cantidad);
            	         ConectorBD conector=new ConectorBD();
            	         try {
							conector.anadirRecambioCompleto(idReparacion, nombrePieza, cantidad);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
            	        
            	    }
            	});

                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }
}
