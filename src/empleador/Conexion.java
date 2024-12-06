package empleador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Campos Cuaquentzi
 */
public class Conexion {
            Connection con;

    public Connection obtenerconexion(){
      try {
        // Establecer la conexión
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busqueda_empleados", "root", "");
        
        if (con != null) {
            System.out.println("Conexión establecida correctamente.");
        } else {
            System.out.println("La conexión es nula.");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
    }
    return con;
    }
}
