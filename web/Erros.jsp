<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link rel=stylesheet href=style.css type=text/css>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ErroLogin</title>
    </head>
    <body>
        <c:if test="${verify_erro == 1}">
            <div class=cadastro>
                <p>Preencha todos os campos!</p>
                <p><a href=./Login.jsp>Tente novamente</a></p>
            </div>
        </c:if>
            
        <c:if test="${verify_erro == 2}">
            <div class=cadastro>
            <p>Usuario não encontrado</p>
            <p><a href=./Login.jsp>Tente novamente</a></p>
            <p> OU </p>
            <p><a href=./Cadastro.jsp>Faça seu cadastro</a></p>
            </div>
        </c:if>    
    </body>
</html>