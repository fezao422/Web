<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="model.Postagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>

    <head>
        <link rel="stylesheet" type="text/css" href="./style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VueJs</title>
    </head>
        <body>
        <nav>
            <div class="menuBotao"></div>
            <div class="titulo">
                <span>Vue.js</span>
            </div>
            <div class="menu">
                <ul>
                    <form>
                        <input type="text" name="termo">
                    </form>
                    
                </ul>
            </div>
        </nav>
        <div class="teste">
            <div class="header">
                <div class="texto">

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
                                <small>
                                    <div class="botoes">
                                        <a class="branco" href="./Logout">logout</a>
                                    </div>
                                </small>
                                
                                <p>Postagens:</p>
                                <form action="./Postagem" method = "post" enctype="multipart/form-data">
                                    Adicionar Nova Postagem:<br>
                                    <input type="hidden" name="usuario_id" value="<%=user.getId()%>"><br>
                                    Titulo:
                                    <input type="text" required="required" name="titulo"><br><br>
                                    Texto:
                                    <input type="text" required="required" name="texto"><br><br>
                                    Imagem:
                                    <input type="file" name="file"><input type="submit" value="NOVO">
                                </form>
                                    
                                <p><%= postagem.size()%> Registro(s) encontrado(s)</p>
                                
                                <% for(Postagem cadaPost : postagem){%>
                                    <div class="post">
                                    <h2><%= cadaPost.getTitulo()%></h2>
                                    <p><%= cadaPost.getTexto()%></p>
                                <%if(!cadaPost.getImagem().equals("")){%>
                                    <img src="<%=request.getContextPath()%>/<%=cadaPost.getImagem()%>" width="300" height="300"/>
                                <% }%> 
                                    <form action="./ApagaPost" method="post">
                                        <input type="hidden" name="id" value="<%= cadaPost.getId() %>">
                                        
                                    <div class="botoes">
                                        <input class="verde" value="Apagar" type="submit">
                                    </div>
                                    </form>
                                    </div>
                                <%}%>
                        <%  } 
                            else{ %>
                 		<h1>Você não está logado, <a href="./Login.jsp">Faça seu login clicando aqui</a> </h1>
                        <% } %>
                        </div> 
                        </div>
                        </div>
                        </body>
                        </html>