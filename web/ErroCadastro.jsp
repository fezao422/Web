<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vuejs.org</title>
        <link rel="stylesheet" href="style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    </head>
    <body>
        <nav>
            <div class="menuBotao"></div>
            <div class="titulo">
                <span>Vue.js</span>
            </div>
            <div class="menu">
                <ul>
                    <input type="text">
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
                <div class="texto">
                
                <%if(request.getAttribute("cadastro").equals(true)){%>
            
            
                <h1>Preencha todos os campos!</h1>
                <div class="botoes">
                    <a class="verde" href="./Cadastro.jsp">Tente novamente</a>
                </div>
            
        
        <%}else{%>
            
            <div class="botoes">
                <h1>Login ou E-mail já existente!</h1>
                <a class="verde" href="./Cadastro.jsp">Tente novamente</a>
            </div>
 
        <%}%>    
                
                </div>
            </div>
        </div>
    </body>
</html>



                              