/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Conexion {
    Connection con;
    private String url="jdbc:postgresql://localhost:5432/bd_taller";
    private String user="postgres";
    private String pss="123456";
    public Connection Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            con=(Connection) DriverManager.getConnection(url, user, pss);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar la base de datos: "+ex.getMessage());;
        }
        return con;
    }
}
