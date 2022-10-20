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
    private static Conexion intance = null;
    private String url = "jdbc:postgresql://localhost:5432/bd_cadena_cabrera";
    private String user = "postgres";
    private String pss = "123456";

    private Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pss);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar la base de datos: " + ex.getMessage());;
        }
    }

    public static Conexion getIntance() {
        if (intance == null) {
            intance = new Conexion();
        }
        return intance;
    }

    public Connection getCnn() {
        return con;
    }

    public void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion " + ex.getMessage());
            }
        }
        //intance=null;
    }
}


/*
create database bd_cadena_cabrera;

create table usuario
(
    id serial not null,
    nombre varchar(30),
    telefono varchar(10),
    correo varchar(40) not null,
    contrasena varchar(30) not null,
    primary key(id)
);

insert into usuario(nombre,telefono,correo,contrasena) values ('andres','1254785625','andres@gmail','123');

*/