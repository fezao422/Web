
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vuejs.org</title>
        <link rel="stylesheet" href="style.css" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <script type="text/javascript" src="./js/jquery-3.2.1.min.js"></script>
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
                    <form>
                        <label for="nome">Nome Completo:</label>
                        <br>
                        <input type="text" name="nome" id="nome">
                        <br>
                        <br>
                        <label for="login">Login:</label>
                        <br>
                        <input type="text" name="login" id="login">
                        <br>
                        <br>
                        <label for="senha">Senha:</label>
                        <br>
                        <input type="password" name="senha" id="senha">
                        <br>
                        <br>
                        <label for="email">Email:</label>
                        <br>
                        <input type="text" name="email" id="email">
                        <br>
                        <br>
                        <label for="endereco">Endereço:</label>
                        <br>
                        <input type="text" name="endereco" id="endereco">
                        <br>
                        <br>
                        <label for="cep">CEP</label>
                        <br>
                        <input type="text" name="cep" id="cep" onblur="buscaCep()">
                        <br>
                        <br>
                        <label for="uf">UF:</label>
                        <br>
                        <input type="text" name="uf" id="uf">
                        <br>
                        <br>
                        <label for="cidade">Cidade:</label>
                        <br>
                        <input type="text" name="cidade" id="cidade">
                        <br>
                        <br>
                        <label for="fone">Telefone:</label>
                        <br>
                        <input type="text" name="fone" id="fone">
                        <br>
                        <br>
                        <div class="botoes">
                        <input id="cad" class="verde" type="submit" value="Cadastrar">
                        <img class="loading" src="./img/ajax-loading.gif">
                    </form>
                    </div>
                 </div>
            </div>
        </div>
        <script type="text/javascript" >
            
            
            $(document).ready(function(){
               $("#cad").click(function() {
                   $(".loading").css("display","block");
                   $.ajax({
                       type:"post",url:"./Cadastro", data:{ nome:$("#nome").val(),login: $("#login").val(),
                           senha: $("#senha").val(), email: $("#email").val(), endereco:$("#endereco").val(), 
                           fone:$("#fone").val(), cep:$("#cep").val(), uf:$("#uf").val(), cidade:$("#cidade").val()}
                   });
                   $(document).ajaxComplete(function (){
                        setTimeout(function(){
                            $(".loading").css("display", "none");}, 3000);
                        ///alert("Funcionou");
                   });
                   return false;
               }) ;
            });
            function buscaCep() {
                if ($.trim($("#cep").val()) != "") {
                    $.getJSON("http://cep.republicavirtual.com.br/web_cep.php?cep=" + $("#cep").val()
                              + "&formato=json", function (data) {
                        console.log(data);
                        if (data["resultado"]) {
                            $("#cidade").val(decodeURIComponent(data["cidade"]));
                            $("#uf").val(decodeURIComponent(data["uf"]));
                            $("#cidade").prop( "disabled", true );
                            $("#uf").prop( "disabled", true );
                            
                        }
                    });
                }
            }
        </script>
    </body>
</html>



                              