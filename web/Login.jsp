<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vuejs.org</title>
        <link rel="stylesheet" href="style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="./js/loading.js"></script>
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
                    <div>
                        <h1>Login</h1>
                        <form action="Login" method="POST">
                            <label for="nome" name="nome">Login:</label>
                            <br>
                            <input type="text" name="login">
                            <br>
                            <br>
                            <label for="password" name="senha">Senha:</label>
                            <br>
                            <input type="password" name="senha">
                            <br>
                            <br>
                        <br>
                        <div class="botoes">
                            <input id="startAjax" class="branco" type="submit" value="LOGIN"> OU 
                            <a class="verde">CADASTRE-SE</a>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            var loading = $.loading();
            
            $("#startAjax").on("click", function(){
                $.get('./Restrito.jsp', function() {
                });
            });
            
        </script>
    </body>
</html>