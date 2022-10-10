/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;

/**
 *
 * @author user
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    UsuarioDAO ud=new UsuarioDAO();
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        String n = request.getParameter("txt_nombres");
        String a = request.getParameter("txt_apellidos");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Control</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>el domicilio llego oli: " + n + " " + a + "</h1>");
            out.println("<h1>respuesta desde el control" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String b = request.getParameter("boton");
        if (b.equals("registrar")) {
            String n = request.getParameter("txt_nombres");
            String a = request.getParameter("txt_apellidos");
            response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Control</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>el domicilio llego oli: " + n + " " + a + "</h1>");
                out.println("<h1>respuesta desde el control" + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        
        if (b.equals("crear cuenta")) {
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
        
        if (b.equals("volver al inicio")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        if(b.equals("registrarse")){
            String ps1=request.getParameter("txtContrasena1");
            String ps2=request.getParameter("txtContrasena2");
            if(ps1.equals(ps2)){
                String nom=request.getParameter("txtNombre");
                String tel=request.getParameter("txtTelefono");
                String cor=request.getParameter("txtCorreo");
                Usuario u=new Usuario(nom, tel, cor, ps1.toString());
                ud.nuevouser(u);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                System.out.println("no son iguales");
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }
        }
        
        if(b.equals("Ingresar")){
            ArrayList<Usuario> lista=ud.traerListaUsers();
            Usuario u=null;
            String correo=request.getParameter("txtEmail");
            String pas=request.getParameter("txtPass").toString();
            for(int i=0 ; i<lista.size(); i++){
                if(lista.get(i).getCorreo().equals(correo)){
                    u=new Usuario();
                    u.setId(lista.get(i).getId());
                    u.setNombre(lista.get(i).getNombre());
                    u.setTelefono(lista.get(i).getTelefono());
                    u.setCorreo(lista.get(i).getTelefono());
                    u.setContrasena(lista.get(i).getContrasena());
                    break;
                }
            }
            if(u!=null){
                if(u.getContrasena().equals(pas)){
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                }else{
                    System.out.println("Su contraseña es incorrecta");
                }
            }else{
                System.out.println("El correo ingresado no existe");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
