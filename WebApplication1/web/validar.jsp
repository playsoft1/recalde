<%@page import="rnegocio.funciones.FUsuario"%>
<%@page import="rnegocio.clases.Usuario"%>
<?xml version="1.0" encoding="UTF-8"?>
<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">

<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--
        int cod=Integer.parseInt(request.getParameter("codigo"));//para obtener el parametro request
        Estudiante miestudiante= FEstudiante.obtenerEstudiante(cod);
      --%>
        
        <%
            String nombre= request.getParameter("nombre");
            String cedula= request.getParameter("cedula");
            
       
        Usuario estudiantecel= FUsuario.obtenerEstudianteCedula(cedula);
        if(estudiantecel!=null){
           
            session.setAttribute("cel",estudiantecel);//creamos la sesion
            response.sendRedirect("faces/login.xhtml");
            }else
                response.sendRedirect("index.jsp");
        %>
    </body>
    
    
</html>
