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

            out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">");

            Usuario user = new Usuario(0, request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"),
                    request.getParameter("email"), request.getParameter("endereco"), request.getParameter("fone"));

            if (user.getNome().equals("") || user.getLogin().equals("") || user.getSenha().equals("")
                    || user.getEmail().equals("") || user.getEndereco().equals("") || user.getTelefone().equals("")) {

                out.println("<div class=\"cadastro\">");
                out.println("<p>Preencha todos os campos!</p>");
                out.println("<p><a href=\"Cadastro.jsp\">Tente novamente</a></p>");
                out.println("</div>");

            } else if (user.procura(user.getLogin()) != null && user.procura(user.getEmail()) != null) {

                out.println("<div class=\"cadastro\">");
                out.println("<p>Login ou E-mail já existente!</p>");
                out.println("<p><a href=\"Cadastro.jsp\">Tente novamente</a></p>");
                out.println("</div>");

            } else {
                if (user.gravar(user)) {
                    response.sendRedirect("./Restrito.jsp");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
