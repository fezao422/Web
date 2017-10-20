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
                user = user.procura(userLogin);%>
                <h1>Bem Vindo: <%= user.getLogin()%></h1>
                                
                <p>Nome: <%= user.getNome()%></p>
                
                <p>Endereço: <%= user.getEndereco()%></p>
                
                <p>Email: <%= user.getEmail()%></p>
                
                <button><a href="./Logout">LOGOUT</a></button>
                
                <p>Postagens:</p>




                


     <% } else { %>
 		<h1>Você não está logado, <a href="./Login.jsp">Faça seu login clicando aqui</a> </h1>
        <% } %>    
    </body>
</html>
