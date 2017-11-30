<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="model.Postagem"%>
<html>
    <head>
        <title>Vuejs.org</title>
        <link rel="stylesheet" href="./style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="./js/loading.js"></script>
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

        <nav>
            <div class="menuBotao"></div>
            <div class="titulo">
                <span>Vue.js</span>
            </div>
            <div class="menu">
                <ul>
                    <li>Guide</li>
                    <li>API</li>
                    <li>Examples</li>
                    <li>Ecosystem</li>
                    <li>Translations</li>
                    <li>Shop</li>
                </ul>
            </div>
        </nav>
        <div class="teste">
            <div class="header">
                <div class="logo">
                    
                    <h1>Bem Vindo: <%= user.getLogin()%></h1>
                    <p>Nome: <%= user.getNome()%></p>
                    <p>Endereço: <%= user.getEndereco()%></p>
                    <p>Email: <%= user.getEmail()%></p>
                    
                    <small>
                        <div class="botoes">
                            <a class="branco" href="./Logout">logout</a>                    
                        </div>
                    </small>
                    
                </div>
                <div class="texto botoes">
                    
                    <form action="./Postagem" method = "post" enctype="multipart/form-data">
                        Adicionar Nova Postagem:<br>
                        <input  type="hidden" name="usuario_id" value="<%=user.getId()%>"><br>
                        Titulo:<br>
                        <input  type="text" required="required" name="titulo"/><br><br>
                        Texto:<br>
                        <input  type="text" required="required" name="texto"><br><br>
                        Imagem:<br>
                        <input  type="file" name="file"><br>
                        <input id="startAjax" class="verde" type="submit" value="Adicionar">
                    </form>
                        
                </div>
            </div>
            <div class="teste1">
                <div class="destaques">
                    
                    <form action="./Restrito.jsp" method="GET">     
                        <input class="pesquisa" type="text" name="termo">
                    </form>
                    
                    <p><%= postagem.size()%> Registro(s) encontrado(s)</p>
                    
                     <% 
                         for(Postagem cadaPost : postagem){
                     %>
                    
                     <div class="cubo">
                        <span> __ </span>
                        
                        <%
                            if(!cadaPost.getImagem().equals("")){
                        %>
                        
                            <p><img src="<%=request.getContextPath()%>/<%=cadaPost.getImagem()%>" width="150" height="150"/></p>
                        
                        <% 
                            }
                        %>
                            
                        <h2><%= cadaPost.getTitulo()%></h2>
                        <p><%= cadaPost.getTexto()%></p>
                        
                        <form class="botoes" id="post-<%= cadaPost.getId() %>" action="./ApagaPost" method="post">
                            <input type="hidden" name="id" value="<%= cadaPost.getId() %>">
                            <input id="startAjax" class="branco" value="Apagar" type="submit">
                        </form>

                    </div>
                    <% 
                        }
                    %>
                </div>
            </div>
        </div>
                
        <script type="text/javascript">
            
           var loading = $.loading();
           $('#startAjax').on('click', function(){
               $.get('./Restrito.jsp', function(){
               });
           });
           
        </script>
        
        <%}
            else{
        %>
                <h1>Você não está logado, <a href="./Login.jsp">Faça seu login clicando aqui</a> </h1>
        <%   
            }
        %> 
    </body>
</html>