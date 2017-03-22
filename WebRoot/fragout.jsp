<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.Plan" %>
<%@ page import="com.example.demo.VersionLink" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Plan plan = (Plan)request.getAttribute("plan");
VersionLink version = (VersionLink)request.getAttribute("version");
String fieldName = (String)request.getAttribute("fieldName");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<!-- InstanceBegin template="/Templates/First.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>片段修改</title>
<link href="css/style3.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap1.css" rel="stylesheet" type="text/css" media="all" />

<script src="js/jquery.min.js"></script>
<!-- //js -->
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eco Travel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- pop-up -->
<link rel="stylesheet" href="css/touchTouch.css" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
	   <script type="text/javascript">
			$(document).ready(function() {
				/*
				 *  Simple image gallery. Uses default settings
				 */

				$('.fancybox').fancybox();

			});
		</script>
<!-- pop-up -->
<style type="text/css">
.fragout-table-head {
	font-size: 14px;
	color: #000000;
	font-weight: normal;
}
</style>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<!-- InstanceEndEditable -->
<style type="text/css">
<!--
body {
	font: 100%/1.4 Verdana, Arial, Helvetica, sans-serif;
	background-color: #4E5869;
	margin: 0;
	padding: 0;
	color: #000;
}


ul, ol, dl { 
	padding: 0;
	margin: 0;
}
h1, h2, h3, h4, h5, h6, p {
	margin-top: 0;
	padding-right: 15px;
	padding-left: 15px;
	text-align: center;
}
a img {
	border: none;
}
a:link {
	color:#414958;
	text-decoration: underline; 
}
a:visited {
	color: #4E5869;
	text-decoration: underline;
}
a:hover, a:active, a:focus { 
	text-decoration: none;
}

.container {
	width: 80%;
	max-width: 1260px;
	min-width: 780px;
	background-color: #FFF;
	margin: 0 auto; 
}

.header {
	background-color: #6F7D94;
}

.content {
	padding: 10px 0;
	color: #000000;
	font-weight: bold;
	font-size: 16px;
}

.content ul, .content ol { 
	padding: 0 15px 15px 40px; 
}


.footer {
	padding: 10px 0;
	background-color: #6F7D94;
}


.fltrt { 
	float: right;
	margin-left: 8px;
}
.fltlft { 
	float: left;
	margin-right: 8px;
}
.clearfloat { 
	clear:both;
	height:0;
	font-size: 1px;
	line-height: 0px;
}

</style></head>

<body>

<div class="container">
  <div class="header"><a href="#"><img src="images/logo.jpg" alt="在此处插入徽标" name="Insert_logo" width="500" height="90" class="header" id="Insert_logo" style="background-color: #8090AB; display:block;" /></a> 
    <!-- end .header --></div>
  <div class="content">
    <form id="form1" name="form1" method="post" action="fragout_Servlet">
      <!-- InstanceBeginEditable name="EditRegion4" -->
     <div class="banner-bdy con">
	<div class="container">
	<div class="mainWrap cf">
				<div class="search-box">
				  <h1 align="center" class="content"><strong><%=plan.getPname() %></strong></h1>
				  <p align="center">发布者: <a target="_blank" href="#"><%=plan.getUsername() %></a>&nbsp;&nbsp;&nbsp;&nbsp;发布时间：<%=plan.getPdate() %></p>
		  </div>
				
		  <div class="ui-box cf">
		    <div class="ui-title">
			  <h1 class="ui-title-cnt fn-left"> <%=fieldName %></h1>
		    </div>
		    <div class="ui-title-subcnt fn-right"></div>
		    <table width="100%" border="0">
		      <tr>
		        <td width="17%" height="48">&nbsp;</td>
		        <td width="15%" class="fragout-table-head">修改者：</td>
		        <td width="51%" class="fragout-table-head"><%=version.getUsername() %></td>
		        <td width="17%">&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="46">&nbsp;</td>
		        <td class="fragout-table-head">修改时间：</td>
		        <td class="fragout-table-head"><%=version.getCreatetime() %></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="47">&nbsp;</td>
		        <td class="fragout-table-head">理由：</td>
		        <td class="fragout-table-head"><%=version.getVcomment() %></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="47">&nbsp;</td>
		        <td class="fragout-table-head">内容：</td>
		        <td class="fragout-table-head"><%=version.getVtext() %></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="97">&nbsp;</td>
		        <td class="fragout-table-head">新增理由：</td>
		        <td><label for="newreason"></label>
		          <input type="hidden" name="vid" id="vid" value="<%=version.getVid() %>" />
		          <textarea name="vcomment" cols="72" rows="5" class="fragout-table-head" id="vcomment"></textarea></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="142">&nbsp;</td>
		        <td class="fragout-table-head">新增内容：</td>
		        <td><label for="newtext"></label>
		          <textarea name="vtext" cols="72" rows="8" class="fragout-table-head" id="vtext"></textarea></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="40">&nbsp;</td>
		        <td class="fragout-table-head">&nbsp;</td>
		        <td><div align="right">
		          <input name="save" type="submit" class="btn" id="save" value="保存" />
		          <a name="reverse" href="timelineServlet?vid=<%=version.getVid() %>" class="btn" id="save2" ><input type="button" class="btn" value="溯源" /></a>
		          <a name="back" href="version_Servlet?pid=<%=version.getPid() %>&fid=<%=version.getFid() %>" class="btn" id="save3" ><input type="button" class="btn" value="返回" /></a>
		          </div></td>
		        <td>&nbsp;</td>
		        </tr>
		      </table>
		  </div>  
		</div>
</div>

<!-- //login-page -->
</div>
      <!-- InstanceEndEditable -->
    </form>
  </div>
  <div class="footer">
    <p>copyright@应急预案后台管理人员</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>

