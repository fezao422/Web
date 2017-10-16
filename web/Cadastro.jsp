<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type ="text/css" href="style.css"/>
        <title>Cadastro</title>
    </head>
    <body>
        <div class ="cadastro">
            <h1>Cadastre-se</h1>
            <form action="Cadastro" method="POST">
                <label for="nome" name="nome">Nome Completo:</label>
                <br>
                <input type="text" name="nome">
                <br>
                <br>
                <label for="login" name="login">Login:</label>
                <br>
                <input type="text" name="login">
                <br>
                <br>
                <label for="senha" name="senha">Senha:</label>
                <br>
                <input type="password" name="senha">
                <br>
                <br>
                <label for="email" name="email">Email:</label>
                <br>
                <input type="text" name="email">
                <br>
                <br>
                <label for="endereco" name="endereco">Endereço:</label>
                <br>
                <input type="text" name="endereco">
                <br>
                <br>
                <label for="fone" name="fone">Telefone:</label>
                <br>
                <input type="text" name="fone">
                <br>
                <br>
                <input type="submit" value="Cadastrar">
            </form>
            <br>
            <p>Se já tem um login, <a href="./Login.jsp">clique aqui</a> </p>
            <br>
        </div>
    </body>
</html>
