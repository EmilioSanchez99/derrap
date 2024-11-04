package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import Vista.VentanaAdmin;
import Vista.VentanaMeca;




public class ConectorBD {
	
	private static final String CONTROLADOR="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/derrap?useSSL=false";
	private static final String USUARIO="root";
	private static final String CLAVE="1234";
	
//	private static final String URL="jdbc:mysql://bt6vnfhsbznrtte5otzn-mysql.services.clever-cloud.com:3306/bt6vnfhsbznrtte5otzn?useSSL=false";
//	private static final String USUARIO="uybh0n0nbxfzycii";
//	private static final String CLAVE="PUHGl9rXIG9aJy7pBjiu";
	Connection cn=null;
	Statement stm=null;
	ResultSet resultado=null;
	
	
	
	public Connection conexionCorrecta() {
		try {
			
			cn=DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("conexion correcta");
			stm=cn.createStatement();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cn;
	}



	public void comprobarUsuario(String usuario, String contrasena) {
		
		try {
			this.conexionCorrecta();
			resultado=stm.executeQuery("SELECT contrasena,tipo FROM usuario WHERE usuario= '"+usuario+"'");
			while(resultado.next()) {
			if (resultado.getString("contrasena").equals(contrasena)) {
				if (resultado.getString("tipo").equalsIgnoreCase("admin")) {
					VentanaAdmin paginaAdmin=new VentanaAdmin();
					paginaAdmin.setVisible(true);
				}
				else {
					VentanaMeca paginaMecanico=new VentanaMeca();
					paginaMecanico.setVisible(true);
				}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public ArrayList buscarActor(String nombreActor) {
//		ArrayList dato=new ArrayList();
//		this.conexionCorrecta();
//		try {
//			resultado=stm.executeQuery("SELECT * FROM actor WHERE first_name = '"+nombreActor+"'");
//			while(resultado.next()) {
//			String nombreObtenido=resultado.getString("first_name");
//			String apellidoObtenido=resultado.getString("last_name");
//			
//			dato.add(nombreObtenido+","+apellidoObtenido);
//			System.out.println(nombreObtenido+","+apellidoObtenido);
//			}
////			stm.close();
////			cn.close();
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return dato;
//		
//	}
//
//
//
//	public DefaultTableModel cargarTabla(String nombreActor) {
//		String[]titulos= {"nombre","apellidos"};
//		String []registros =new String[2];
//		DefaultTableModel modelo=new DefaultTableModel(null,titulos);
//		
//		
//		try {
//			resultado=stm.executeQuery("SELECT * FROM actor WHERE first_name = '"+nombreActor+"'");
//			
//
//			while(resultado.next()) {
//				registros[0]=resultado.getString("first_name");
//				registros[1]=resultado.getString("last_name");
//				modelo.addRow(registros);
//				
//				
//			}
//			stm.close();
//			cn.close();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return modelo;
//	}
//
//
//
//	public void insertarNuevo(JTextField txtNombre, JTextField txtApellido) {
//		String nombreNuevo=txtNombre.getText();
//		String apellidoNuevo=txtApellido.getText();
//		this.conexionCorrecta();
//		
//		if(!nombreNuevo.isEmpty()&&!apellidoNuevo.isEmpty()) {
//		
//			try {
//				stm.executeUpdate("INSERT INTO actor (first_name,Last_name) VALUES ('"+nombreNuevo+"','"+apellidoNuevo+"')");
//				stm.close();
//				cn.close();
//				JOptionPane.showMessageDialog(null, "usuario insertado");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			}
//		}
//		else {
//			JOptionPane.showMessageDialog(null, "usuario no insertado");
//		}
//		
//	}
	


