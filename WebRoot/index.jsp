<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>首页</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
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
    <form id="form1" name="form1" method="post" action="">
      <!-- InstanceBeginEditable name="EditRegion4" -->
      <table width="100%" border="0">
        <tr>
          <td height="53" colspan="9">&nbsp;</td>
        </tr>
        <tr>
          <td width="6%" height="31">&nbsp;</td>
          <td width="2%" class="footer">&nbsp;</td>
          <td width="36%" class="footer">&nbsp;</td>
          <td width="2%" class="footer">&nbsp;</td>
          <td width="7%">&nbsp;</td>
          <td width="2%" class="footer">&nbsp;</td>
          <td width="36%" class="footer">&nbsp;</td>
          <td width="2%" class="footer">&nbsp;</td>
          <td width="7%">&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td><p align="center">欢迎使用应急预案协同编制平台，该平台设计用于大家探讨修改应急预案，同时该平台将能够保存所有修改的版本信息，您可以查阅任意时间修改的应急预案的版本，发挥所长，完善应各类型的应急预案，并运用到实际生活中。。。。。。。          </p></td>
          <td class="footer">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td><table width="100%" border="0">
            <tr>
              <td width="18%" height="42">&nbsp;</td>
              <td width="64%"><p>&nbsp;</p>
                <p>&nbsp;</p></td>
              <td width="18%">&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td class="header"><div align="center"><a href="list.html" target="_blank">查看&amp;修改预案</a></div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td class="header"><div align="center"><a href="planindex.jsp" target="_blank">发布新的预案</a></div></td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td><p>&nbsp;</p>
                <p class="header"><a href="account1_Servlet" target="_blank">我的账户</a></p>
                <p>&nbsp;</p></td>
              <td>&nbsp;</td>
            </tr>
          </table></td>
          <td class="footer">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td>&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td class="footer">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td colspan="9"><p>&nbsp;</p></td>
        </tr>
      </table>
      <!-- InstanceEndEditable -->
    </form>
  </div>
  <div class="footer">
    <p>copyright@应急预案后台管理人员</p>
    <!-- end .footer --></div>
  <!-- end .container --></div>
</body>
<!-- InstanceEnd --></html>
