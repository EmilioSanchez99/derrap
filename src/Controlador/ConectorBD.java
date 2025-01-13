package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/derrap?useSSL=false";
	private static final String USUARIO = "root";
	private static final String CLAVE = "1234";

//	private static final String URL="jdbc:mysql://bt6vnfhsbznrtte5otzn-mysql.services.clever-cloud.com:3306/bt6vnfhsbznrtte5otzn?useSSL=false";
//	private static final String USUARIO="uybh0n0nbxfzycii";
//	private static final String CLAVE="PUHGl9rXIG9aJy7pBjiu";
	Connection cn = null;
	Statement stm = null;
	ResultSet resultado = null;
	PreparedStatement pst;

	/** 
	 * 
	 *  Establece una conexión con la base de datos utilizando los parámetros configurados. 
	 *  @return La conexión establecida, o null si ocurre un error.
	 *  
	  */
	public Connection conexionCorrecta() {
		try {

			cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("conexion correcta");
			stm = cn.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cn;
	}

	/** 
	 *  Comprueba las credenciales del usuario y abre la ventana correspondiente según el tipo de usuario. 
	 * @param usuario El nombre de usuario a comprobar. 
	 * @param contrasena La contraseña del usuario a comprobar.
	 * @return 
	 */
	public void comprobarUsuario(String usuario, String contrasena) {

		try {
			this.conexionCorrecta();
			resultado = stm.executeQuery("SELECT contrasena,tipo FROM usuario WHERE usuario= '" + usuario + "'");
			
			if (resultado.next()) {

				if (resultado.getString("contrasena").equals(contrasena)) {

					if (resultado.getString("tipo").equalsIgnoreCase("admin")) {
						VentanaAdmin paginaAdmin = new VentanaAdmin();
						paginaAdmin.setVisible(true);
						
					} else {
						VentanaMeca paginaMecanico = new VentanaMeca();
						paginaMecanico.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Usuario incorrecto");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void anadirCliente(String nif,String nombre,String apellido1,String apellido2,String telefono, String email) {
        String query = "INSERT INTO cliente (nif, nombre, apellido1, apellido2, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = conexionCorrecta();
        		PreparedStatement preparedStatement = connection.prepareStatement(query)){
        	preparedStatement.setString(1, nif);
        	preparedStatement.setString(2, nombre);
        	preparedStatement.setString(3, apellido1);
        	preparedStatement.setString(4, apellido2);
        	preparedStatement.setString(5, telefono);
        	preparedStatement.setString(6, email);
        	preparedStatement.executeUpdate();
        	
        }catch ( SQLException e) {
        	e.printStackTrace();
        }
	}
	public void actualizarCliente(String nif, String nombre, String apellido1, String apellido2, String telefono, String email) {
	    String query = "UPDATE cliente SET nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, email = ? WHERE nif = ?";
	    try (Connection connection = conexionCorrecta();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, nombre);
	        preparedStatement.setString(2, apellido1);
	        preparedStatement.setString(3, apellido2);
	        preparedStatement.setString(4, telefono);
	        preparedStatement.setString(5, email);
	        preparedStatement.setString(6, nif);
	        preparedStatement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void actualizarUsuario(String nif, String nombre, String apellido1, String apellido2, String telefono, String email, String usuario, String contrasena) {
	    String query = "UPDATE usuario SET nombre = ?, apellido1 = ?, apellido2 = ?, telefono = ?, email = ?, usuario = ?, contrasena = ? WHERE nif = ?";
	    try (Connection connection = conexionCorrecta();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, nombre);
	        preparedStatement.setString(2, apellido1);
	        preparedStatement.setString(3, apellido2);
	        preparedStatement.setString(4, telefono);
	        preparedStatement.setString(5, email);
	        preparedStatement.setString(6, usuario);
	        preparedStatement.setString(7, contrasena);
	        preparedStatement.setString(8, nif);
	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void anadirUsuario(String nif, String nombre, String apellido1, String apellido2, String telefono, String email, String usuario, String contrasena) {
	    String query = "INSERT INTO usuario (nif, nombre, apellido1, apellido2, telefono, email, usuario, contrasena,tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection connection = conexionCorrecta();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, nif);
	        preparedStatement.setString(2, nombre);
	        preparedStatement.setString(3, apellido1);
	        preparedStatement.setString(4, apellido2);
	        preparedStatement.setString(5, telefono);
	        preparedStatement.setString(6, email);
	        preparedStatement.setString(7, usuario);
	        preparedStatement.setString(8, contrasena);
	        preparedStatement.setString(9, "mecanico");
	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void anadirVehiculo(String matricula, String modelo, String marca, String clienteNif) {
	    String query = "INSERT INTO vehiculo (matricula, modelo, marca, cliente_nif) VALUES (?, ?, ?, ?)";
	    try (Connection connection = conexionCorrecta();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, matricula);
	        preparedStatement.setString(2, modelo);
	        preparedStatement.setString(3, marca);
	        preparedStatement.setString(4, clienteNif);
	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void actualizarVehiculo(String matricula, String modelo, String marca, String clienteNif) {
	    String query = "UPDATE vehiculo SET modelo = ?, marca = ?, cliente_nif = ? WHERE matricula = ?";
	    try (Connection connection = conexionCorrecta();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setString(1, modelo);
	        preparedStatement.setString(2, marca);
	        preparedStatement.setString(3, clienteNif);
	        preparedStatement.setString(4, matricula);
	        preparedStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}




	


	
}

