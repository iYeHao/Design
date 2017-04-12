<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.PlanDetail" %>
<%@ page import="com.example.demo.PlanFieldDetail" %>
<%@ page import="com.example.demo.PlanFieldBaseDetail" %>
<%@ page import="com.example.demo.VersionDetail" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
PlanDetail planDetail = (PlanDetail)request.getAttribute("planDetail");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>片段修改</title>
<link href="css/style3.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap1.css" rel="stylesheet" type="text/css" media="all" />

<script src="js/jquery.min.js"></script>
<style type="text/css">
.container {
	width: 80%;
	max-width: 1260px;
	min-width: 780px;
	background-color: #FFF;
	margin: 0 auto; 
}
.bodyh7 {
	font-size: 12px;
	color: #333;
}
pre {
	white-space: pre-wrap;
	white-space: -moz-pre-wrap;
    white-space: -pre-wrap;
    white-space: -o-pre-wrap;
    word-wrap: break-word;  
}
</style>
</head>
<body>

<div class="banner-bdy con">
	<div class="container">
				<div class="search-box">
				  <h1 align="center" class="content"><strong><%=planDetail.getPname() %></strong></h1>
				  <p align="center">发布者: <a target="_blank" href="#"><%=planDetail.getUsername() %></a>&nbsp;&nbsp;&nbsp;&nbsp;发布时间：<%=planDetail.getPdate() %></p>
		  </div>
				
	  <div class="ui-box cf">
	   <%
	   List<PlanFieldDetail> fieldDetails = planDetail.getFieldDetails();
	   for(int i = 0; i < fieldDetails.size(); i++) {
		    	PlanFieldDetail fieldDetail = fieldDetails.get(i);
		    	List<PlanFieldBaseDetail> fieldBaseDetails = fieldDetail.getFieldBaseDetails();
		     %>
	    <table width="100%" border="0">
	    
	      <tr>
	        <td width="50%"><h2><%=i+1 %>. <%=fieldDetail.getFname() %></h2></td>
	        <td width="50%">&nbsp;</td>
          </tr>
          <%for(int j = 0; j < fieldBaseDetails.size(); j++) {
		            	PlanFieldBaseDetail fbd = fieldBaseDetails.get(j);
		            	List<VersionDetail> versionDetails = fbd.getVersionDetails();
		             %>
	      <tr>
	        <td height="47"><%=i+1 %>.<%=j+1 %> <%=fbd.getFname()%></td>
          </tr>
	      <tr>
	      	<%if(fbd.getVersionDetails().size() > 0) {
	      		VersionDetail vd = fbd.getVersionDetails().get(0); %>
	        	<td id="td_<%=i+1 %>_<%=j+1 %>" height="45" colspan="2" class="a">
	        	<pre>创建时间：<%=vd.getCreatetime() %><p></p>创建用户：<%=vd.getUsername() %><p></p>内容：<%=vd.getVtext() %></pre>
	        	</td>
	        <%} else { %>
	        	<td id="td_<%=i+1 %>_<%=j+1 %>" height="45" colspan="2" class="a"><pre>没有最佳版本</pre></td>
	        <%} %>
          </tr>
          <%} %>
        </table>  
             
	    <div class="ui-title-subcnt fn-right"></div>
	  
	   <%} %> 
	   
	  </div> 
	  <div align="right" style="margin-bottom: 40px;"> 
	  <a href="fragtotal_Servlet?pid=<%=planDetail.getPid() %>" class="btn">返回</a>
  </div>
</div>
</div>
</div>
<!-- //login-page -->
</body>
</center>
</html>
