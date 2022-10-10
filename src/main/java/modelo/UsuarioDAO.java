/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public UsuarioDAO() {
    }
    
    public void nuevouser(Usuario u){
        con=cn.Conexion();
        String sql="insert into usuario(nombre,telefono,correo,contrasena) values (?,?,?,?);";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getTelefono());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getContrasena());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Usuario> traerListaUsers(){
        con=cn.Conexion();
        ArrayList<Usuario> lista=new ArrayList();
        try {
            ps=con.prepareStatement("select * from usuario;");
            rs=ps.executeQuery();
            while(rs.next()){
                lista.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
