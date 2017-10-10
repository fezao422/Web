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

    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE HTML>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta http-equiv=\"content-type\"");
            out.println("              content=\"text/html; charset=utf-8\"/>");
            out.println("        <title>Faça seu Cadastro Aqui</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Cadastro</h1>");
            out.println("        <form action=\"Cadastro\" method=\"POST\">");
            out.println("        <fieldset>");
            out.println("            <legend>Cadastro</legend>");
            out.println("            <input type=\"text\" name=\"login\" value=\"\">");
            out.println("            <input type=\"password\" name=\"senha\" value=\"\">");
            out.println("            <input type=\"submit\" value=\"Novo Cadastro\">");
            out.println("        </fieldset>");
            out.println("        </form>");
            out.println("<p>     <a href=\"/Login.jsp\">Se já tiver conta faça o login, clique aqui!</p>");
            out.println("    </body>");
            out.println("</html>");
        }
    }*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Usuario teste = null;
            Usuario user = new Usuario(0, request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"),
                    request.getParameter("email"), request.getParameter("endereco"), request.getParameter("fone"));

            if (user.getNome().equals("") && user.getLogin().equals("") && user.getSenha().equals("")
                    && user.getEmail().equals("") && user.getEndereco().equals("") && user.getTelefone().equals("")) {

                response.getWriter().println("<p>Preencha os campos!</p>");
                response.getWriter().println("<p><a href=\"Cadastro.jsp\">Tente novamente</p>");

            } else if (user.procura(user.getLogin()) != null && user.procura(user.getEmail()) != null) {

                response.getWriter().println("<p>Login/E-mail já existente!</p>");
                response.getWriter().println("<p><a href=\"Cadastro.jsp\">Tente novamente</p>");

            } else {
                if (user.gravar(user)) {
                    response.sendRedirect("VueJs/Restrito.jsp");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
