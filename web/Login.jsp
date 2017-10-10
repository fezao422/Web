<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Login</title>
    </head>
    <body>
        <div class="cadastro">
            <h1>Login</h1>
            <form action="Login" method="POST">
                <label for="nome" name="nome">Nome Completo:</label>
                <br>
                <input type="text" name="login">
                <br>
                <br>
                <label for="password" name="senha">Senha:</label>
                <br>
                <input type="password" name="senha">
                <br>
                <br>
                <input type="submit" value="Logar">
            </form>
            <br>
            <a href="./Cadastro.jsp">Se não tem um cadastro, clique aqui</a>
            <br>
        </div>
    </body>
</html>
