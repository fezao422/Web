<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro de Login</title>
    </head>
    <body>
        
        <%if(request.getAttribute("login").equals(true)){%>
            
            <div class="cadastro">
                <p>Preencha todos os campos!</p>
                <p><a href="./Login.jsp">Tente novamente</a></p>
            </div>
        
        <%}else{%>
        
            <div class="cadastro">
                <p>Usuario não encontrado</p>
                <p><a href="./Login.jsp">Tente novamente</a></p>
                <p> OU </p>
                <p><a href="./Cadastro.jsp">Faça seu cadastro</a></p>
            </div>
        
        <%}%>
    </body>
</html>
