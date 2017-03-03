<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/First.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>首页登录</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
dl {
	background-color: #666;
}
dl {
	background-color: #666;
}
.td {
}
lg {
	text-align: center;
}
mg {
	color: #666;
}
.后 {
	font-family: "Courier New", Courier, monospace;
	color: #F00;
}
.mg {
	background-color: #333;
	background-repeat: no-repeat;
	border: thin none #000;
	color: #FFF;
	text-align: center;
}
mg {
	text-align: center;
}
ma {
	font-size: 24px;
}
.ma {
	font-size: 24px;
}
</style><!-- InstanceEndEditable -->
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
    <form id="loginform" name="form1" method="get" action="LoginServlet">
      <!-- InstanceBeginEditable name="EditRegion4" -->
      <table width="100%"  border="0">
        <tr>
          <td width="20%" height="114">&nbsp;</td>
          <td width="60%">&nbsp;</td>
          <td width="20%">&nbsp;</td>
        </tr>
        <tr>
          <td height="343">&nbsp;</td>
          <td bgcolor="#CCCCCC"><p>&nbsp;</p>
            <p class="ma">欢迎登录</p>
            <p>
              <label for="uname2">账户：</label>
              <input type="text" name="uname" id="uname2" />
            </p>
          <p>密码：
            <label for="ps"></label>
            <input type="password" name="upassword" id="ps" />
          </p>
          <p>
            <input style="margin-left:10%" type="submit" value="登录" />
            <a href="register.jsp"><input style="margin-left:10%"  type="button" value="注册" /></a>
          </p>
          <p>
            
          </p>
          <p>&nbsp;</p>
          <p>&nbsp; </p></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="112">&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <!-- InstanceEndEditable -->
    </form>
  </div>
  <div class="footer">
    <p>copyright@应急预案后台管理人员</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>

