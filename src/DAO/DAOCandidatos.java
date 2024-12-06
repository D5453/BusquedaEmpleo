/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;
import Objetos.Candidatos;
import empleador.Conexion;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Campos Cuaquentzi
 */
public class DAOCandidatos {
     Connection cn;
    PreparedStatement ps;
    Conexion con;
    ResultSet rs; 
    
    
       public java.util.List<Candidatos> obtenerCandidatos(){
        java.util.List<Candidatos> lista=new ArrayList<>();
        try {
            con=new Conexion();
            cn=con.obtenerconexion();
            ps=cn.prepareStatement("select * from ussers where type = 1");
            rs=ps.executeQuery();
            
            while(rs.next()){
                Candidatos mc=new Candidatos();
                mc.setId(rs.getInt(1));
                mc.setName(rs.getString(2));
                mc.setEmail(rs.getString(3));
                mc.setPassword(rs.getString(4));
                mc.setType(rs.getInt(5));     
                mc.setStatus(rs.getBoolean(6));     

                lista.add(mc);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener carrera "+ex.getMessage());
        }
        return lista;
    }
    
       
              public java.util.List<Candidatos> obtenerEmpleadores(){
        java.util.List<Candidatos> lista=new ArrayList<>();
        try {
            con=new Conexion();
            cn=con.obtenerconexion();
            ps=cn.prepareStatement("select * from ussers where type = 2");
            rs=ps.executeQuery();
            while(rs.next()){
                Candidatos mc=new Candidatos();
                mc.setId(rs.getInt(1));
                mc.setName(rs.getString(2));
                mc.setEmail(rs.getString(3));
                mc.setPassword(rs.getString(4));
                mc.setType(rs.getInt(5));     
                mc.setStatus(rs.getBoolean(6));     

                lista.add(mc);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener carrera "+ex.getMessage());
        }
        return lista;
    }
}
