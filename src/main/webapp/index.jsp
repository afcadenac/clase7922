<%-- 
    Document   : index
    Created on : 7/09/2022, 1:14:06 p. m.
    Author     : administradorPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ejemplo</title>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body id="index">



        <form action="Controlador" method="POST">
            <div id="login">
                <div id="ingreso">
                    <img src="imagenes/user.png" alt="130" width="130"/>
                    <br>
                    <br>
                    <label>Usuario</label>
                    <input type="email" name="txtEmail"/>
                    <br>
                    <br>
                    <label>Contraseña</label>
                    <input type="password" name="txtPass" />
                    <br>
                    <br>
                    <input type="submit" name="boton"  value="Ingresar"/>
                    <input type="submit" name="boton"  value="crear cuenta"/>
                </div>


                <div id="nombres">
                    <label>nombres</label>
                    <input type="text" name="txt_nombres" />

                    <br>

                    <label>apellido</label>
                    <input type="text" name="txt_apellidos" />

                    <br>

                    <input type="submit" value="registrar" name="boton"/>

                    <br>

                    <div>
                        <h5>Hola mundo web</h5>

                        <h5>Andres Felipe Cadena Cadena - 20192578035</h5>
                        <h5>Jonathan cabrera Rodriguez - 20201578117</h5>
                        <h5>ramas con git2</h5>

                        <a href="Controlador">verificar response </a>
                    </div>
                </div>


            </div>
        </form>
    </body>
</html>
