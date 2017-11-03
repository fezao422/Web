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
                <div class="botoes">
                <input class="verde" type="submit" value="Cadastrar">
            </form>
                </div>
            </div>
        </div>
    </body>
</html>



                              