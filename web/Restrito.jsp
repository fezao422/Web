<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="model.Postagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VueJs</title>
    </head>
    <body>
        <% 
            if(session.getAttribute("login")!= null && session.getAttribute("usuario").equals(new Boolean(true))){
                String userLogin = (String) session.getAttribute("login");
                Usuario user = new Usuario();
                Postagem post = new Postagem();
                user = user.procura(userLogin,null);
                ArrayList<Postagem> postagem;
                if(request.getParameter("termo")!= null){
                    postagem = post.pesquisa(request.getParameter("termo"));
                }
                else{
                    postagem = post.postUser(user.getId());
                }
        %>
                <h1>Bem Vindo: <%= user.getLogin()%></h1>
                                
                <p>Nome: <%= user.getNome()%></p>
                
                <p>Endereço: <%= user.getEndereco()%></p>
                
                <p>Email: <%= user.getEmail()%></p>
                
                <small><a href="./Logout">logout</a></small>
                
                <p>Postagens:</p>
                
                <form action="./Restrito.jsp" method = "get">
                    Filtrar Postagens:<input type="text" name="termo"></form>
                
                <p><%= postagem.size()%> Registro(s) encontrado(s)</p>
                <% for(Postagem cadaPost : postagem){%>
                <p><%= cadaPost.getTitulo()%></p>
                <%}%>
        <%  } 
            else{ %>
 		<h1>Você não está logado, <a href="./Login.jsp">Faça seu login clicando aqui</a> </h1>
        <% } %>    
    </body>
</html>
