package servlets;

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
import model.Usuario;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">");
            
            Usuario user = new Usuario(request.getParameter("login"),request.getParameter("senha"));
            
            if(user.getLogin().equals("") || user.getSenha().equals("")){
                
                request.setAttribute("login", true);
                request.getRequestDispatcher("./ErroLogin.jsp").forward(request, response);
                
            }else{
               if(user.autentica(user)){
                    request.getSession().setAttribute("usuario", true);
                    request.getSession().setAttribute("login", user.getLogin());
                    response.sendRedirect("./Restrito.jsp");
               }else{
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    request.setAttribute("login", false);
                    request.getRequestDispatcher("./ErroLogin.jsp").forward(request, response);
               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
