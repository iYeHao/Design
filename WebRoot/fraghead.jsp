<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.Plan" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Plan plan = (Plan)request.getAttribute("plan");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>æ æ é¢ææ¡£</title>
<style type="text/css">
body {
	background-color: #6F7D94;
}
</style>
</head>

<body>
<h1><%=plan.getPname() %></h1>

</body>
</html>
