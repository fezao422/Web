/*package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Postagem;

@WebServlet(name = "Restrito", urlPatterns = {"/Restrito"})
public class Restrito extends HttpServlet {
/*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean logado = (boolean) request.getSession().getAttribute("logado");
        try (PrintWriter out = response.getWriter()) {
            if(logado){
                out.println("<!DOCTYPE HTML>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta http-equiv=\"content-type\"");
                out.println("              content=\"text/html; charset=utf-8\"/>");
                out.println("        <title>Login</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Área Restrita</h1>");
                out.println("        ");
                out.println("        ");
                out.println("        ");
                out.println("        ");
                out.println("        ");
                out.println("        ");
                out.println("        ");
                out.println("        </form>");
                out.println("    </body>");
                out.println("<p><a href=\"\">Logout!</p>");
                out.println("</html>");
            }else{
                out.println("logado nao");
            }
        }
    }
*/
/*    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            Boolean verift = false;
            Postagem post =  new Postagem(0,Integer.parseInt(request.getParameter("usuario_id")), request.getParameter("titulo"),request.getParameter("texto"),request.getParameter("imagem"));
        try {
            verift = post.gravar();
            if(verift){
                response.sendRedirect("./Restrito.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Restrito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
*/