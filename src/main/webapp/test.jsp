<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.Collection" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>test</title>
</head>
<body>

<%
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
String[] bn = context.getBeanDefinitionNames();
for (String s : bn) {
    out.println(s + "<br/>");
}
%>

</body>
</html>
