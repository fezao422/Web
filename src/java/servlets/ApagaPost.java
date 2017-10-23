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
import model.Postagem;

@WebServlet(name = "ApagaPost", urlPatterns = {"/ApagaPost"})
public class ApagaPost extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean verift = false; 
        Postagem post = new Postagem();
        try {
            verift = post.apagar(Integer.parseInt(request.getParameter("id")));
            if(verift){
                response.sendRedirect("./Restrito.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApagaPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
