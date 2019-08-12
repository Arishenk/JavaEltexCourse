<%@page import="com.arishenk.Calculator"%>
<%
String header = "Apache Tomcat";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title><%= header %></title>
</head>
<body>
<p>Name: <%= request.getParameter("name") %></p>
<p>Today <%= new java.util.Date() %></p>
</body>
</html> 
