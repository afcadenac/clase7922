<%-- 
    Document   : registro
    Created on : 9/10/2022, 4:00:43 p.m.
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarse</title>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <form action="Controlador" method="POST">
            <div id="login">
                <div id="ingreso">
                    
                    <label>Ingrese su nombre</label>
                    <input type="text" name="txtNombre"/>
                    <br>
                    <br>
                    
                    <label>Ingrese su telefono</label>
                    <input type="text" name="txtTelefono" />
                    <br>
                    <br>
                    
                    <label>Ingrese un correo</label>
                    <input type="email" name="txtCorreo"/>
                    <br>
                    <br>
                    
                    <label>Ingrese su contraseña</label>
                    <input type="password" name="txtContrasena1"/>
                    <br>
                    <br>
                    
                    <label>Vuelva a escribir su contraseña</label>
                    <input type="password" name="txtContrasena2"/>
                    <br>
                    <br>
                    
                    <input type="submit" name="boton"  value="registrarse"/>
                    <input type="submit" name="boton"  value="volver al inicio"/>
                </div>

            </div>
        </form>
    </body>
</html>
