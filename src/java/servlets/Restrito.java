package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Restrito", urlPatterns = {"/Restrito"})
public class Restrito extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean logado = (boolean) request.getSession().getAttribute("logado");
        try (PrintWriter out = response.getWriter()){
            
            if(logado){
                response.sendRedirect("./Restrito.jsp");
            }
            else{
                response.sendRedirect("");
            }
        }
    }
}