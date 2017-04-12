<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.HttpSession " %>
<%@ page import="com.example.demo.Register " %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Register form = new Register();
form=(Register)request.getAttribute("form");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/First.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>注册界面</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
mg {
	font-size: 24px;
}
mg {
	font-size: 24px;
	color: #000;
}
rg {
	font-size: 24px;
	color: #FFF;
	background-color: #333;
}
mg {
	font-size: 24px;
	color: #000;
}
mg {
	font-size: 24px;
	color: #333;
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
    <form id="registerform" name="form1" method="post" action="RegisterServlet">
      <!-- InstanceBeginEditable name="EditRegion4" -->
      <table width="100%" border="0">
        <tr>
          <td width="26%" height="326">&nbsp;</td>
          <td width="60%">
          <table width="120%" border="1"  style="middle%">
            <tr>
              <td><h2>注册</h2>
                <p>
                  <label for="name"><em>*</em>用户名：&nbsp;&nbsp;</label>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="username" type="text" id="name" value="${form.uname }"/>${form.errors.uname}
                </p>
                <p><em>*</em>性&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="usersex" id="boy" value="男" />
                  <label for="boy">男</label>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="usersex" id="girl" value="女" />
                  <label for="girl">女</label>
                </p>
                <p>
                  <label for="age"> &nbsp; 年&nbsp;&nbsp;&nbsp;龄： &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</label>
                  <input name="userage" type="text" id="age"value="${form.uage}"/>${form.errors.uage}
  &nbsp;</p>
                <p><em>*</em>邮&nbsp;&nbsp;&nbsp;箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <label for="email"></label>
                  <input name="useremail" type="text" id="email"value="${form.uemail}"/>${form.errors.uemail}
                </p>
                <p> <em>*</em>等&nbsp;&nbsp;&nbsp;级：              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <label for="zw"></label>
                  <input name="userlevel" type="text" id="zw" value="${form.ulevel}"/>${form.errors.ulevel}
                </p>
                <p><em>*</em> 密&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <label for="ps"></label>
  &nbsp;
  <input name="userpassword" type="password" id="ps" value="${form.upassword}"/>

                </p>
                <p><em>*</em>确定密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <label for="pst"></label>
                  <input name="cuserpassword" type="password" id="pst" value="${form.cpassword}"/>${form.errors.cpassword}
                </p>
                <p>&nbsp;</p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="register" type="submit" class="header" id="register" value="提交注册" />&nbsp;&nbsp;
                   <a href="login.jsp">
  					<input name="register" type="button" class="header" id="register" value="已有账号" />
  					 </a></p>
                <p></p></td>
            </tr>
          </table></td>
          <td width="26%">&nbsp;</td>
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

