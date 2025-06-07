<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Chuyển hướng sang dist/index.html
    response.sendRedirect(request.getContextPath()+"/signin");
   //response.sendRedirect("dist/ui-elements/auth-signin.jsp"); 
%>
