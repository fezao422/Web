package servlets;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Postagem;

@WebServlet(name = "Postagem", urlPatterns = {"/Postagem"})
public class Post extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Postagem postagem = new Postagem();
        Part userFile = request.getPart("file");
        
        Boolean verift = true;
        
        String oldFileName = Paths.get(userFile.getSubmittedFileName()).getFileName().toString();
        if(!oldFileName.equals("")){
            String fileName = "Arquivo" + postagem.getUltimoId() + oldFileName.substring(oldFileName.lastIndexOf("."));
            InputStream fileContent = userFile.getInputStream();

            String images= request.getServletContext().getRealPath("/img/photo/");//pega a pasta raiz do projeto e navega ate a pasta atual PHOLO.
            File updates = new File(images);
            File file = new File(updates, fileName);
        
        
        
        try(InputStream input = fileContent){
            Files.copy(input, file.toPath());
            postagem.setUsuario_id(Integer.parseInt(request.getParameter("usuario_id"))); 
            postagem.setTitulo(request.getParameter("titulo"));
            postagem.setTexto(request.getParameter("texto"));
            postagem.setImagem(fileName);
            verift = postagem.gravar();
            if (verift){
                response.sendRedirect("./Restrito.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            try {
                postagem.setUsuario_id(Integer.parseInt(request.getParameter("usuario_id"))); 
                postagem.setTitulo(request.getParameter("titulo"));
                postagem.setTexto(request.getParameter("texto"));
                postagem.setImagem("");
                verift = postagem.gravar();
                if (verift)
                    response.sendRedirect("./Restrito.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}