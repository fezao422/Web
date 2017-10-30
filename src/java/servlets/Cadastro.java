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

@WebServlet(name = "Cadastro", urlPatterns = {"/Cadastro"})
public class Cadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            

            Usuario user = new Usuario(0, request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"),
                    request.getParameter("email"), request.getParameter("endereco"), request.getParameter("fone"));

            if (user.getNome().equals("") || user.getLogin().equals("") || user.getSenha().equals("")
                    || user.getEmail().equals("") || user.getEndereco().equals("") || user.getTelefone().equals("")) {
                
                request.setAttribute("cadastro", true);
                request.getRequestDispatcher("./ErroCadastro.jsp").forward(request, response);
                
            } else if (user.procura(user.getLogin(),user.getEmail()) != null ) {
                
                request.setAttribute("cadastro", false);
                request.getRequestDispatcher("./ErroCadastro.jsp").forward(request, response);

            } else {
                if (user.gravar(user)) {
                    request.getSession().setAttribute("usuario", true);
                    request.getSession().setAttribute("login", user.getLogin());
                    response.sendRedirect("./Restrito.jsp");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
