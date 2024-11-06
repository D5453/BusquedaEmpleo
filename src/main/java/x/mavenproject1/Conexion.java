/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package x.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Campos Cuaquentzi
 */
public class Conexion {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    Connection con;
    public Connection obtenerconexion(){
        try{
          // jdbc:mysql://localhost:3306/farmacia
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/busqueda_empleados","root","");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos "+e.getMessage());
        }
        return con;
    }

}


