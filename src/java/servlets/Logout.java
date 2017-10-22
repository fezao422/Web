package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.getSession().setAttribute("usuario", new Boolean(false));
        request.getSession().setAttribute("login", null);
        response.sendRedirect("./index.html");
    }
}
