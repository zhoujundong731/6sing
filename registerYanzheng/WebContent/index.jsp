<%@page import="data.RegisterCon"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><%=application.getAttribute("test") %></div>
<%
	Map<String,String> map=(Map<String,String>)application.getAttribute(RegisterCon.RE_MAP);
String width=map.get(RegisterCon.RE_WIDTH);
%>
<%=width%>
<a href="register.jsp">注册</a>
<a href="updateRegiserConfiger">修改</a>
</body>
</html>