<%@page import="model.Usuario"%>
<%@page import="model.Postagem"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VueJs</title>
    </head>
    <body>
        <% if(session.getAttribute("logado")!=null) && session.getAttribute("logado".equals(new Boolean(true))){
        String userLogin = (String) session.getAttribute("user");
        Usuario user = Usuario.
    }






        %>
        
    </body>
</html>
