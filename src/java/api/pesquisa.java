package api;

import dados.Dbase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "pesquisa", urlPatterns = {"/pesquisa"})
public class pesquisa extends HttpServlet {
    
     Connection conn = null;
     Dbase db;
     PreparedStatement ps;
     ResultSet result = null;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            
            String busca = request.getParameter("termo");
            int num = Integer.parseInt(request.getParameter("id"));
            db = new Dbase();
            conn = db.getConnection();
            String sql = ("select * from postagem where titulo like ? and usuario_id = ?;");
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+busca+"%");
            ps.setInt(2, num);
            result = ps.executeQuery();
            
            while(result.next()){
                out.println("<li>"+result.getString("titulo")+"</li>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(pesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
