<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.VersionLink" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
<style type="text/css">
td, th {
	font-size: 16px !important;
}
</style>
</head>

<body>

    <form id="form1" name="form1" method="post" action="fragbottom_Servlet">
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
		          <textarea name="vcomment" cols="72" rows="3" class="fragout-table-head" id="vcomment"></textarea></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="142">&nbsp;</td>
		        <td class="fragout-table-head">新增内容：</td>
		        <td><label for="newtext"></label>
		          <textarea name="vtext" cols="72" rows="5" class="fragout-table-head" id="vtext"></textarea></td>
		        <td>&nbsp;</td>
		        </tr>
		      <tr>
		        <td height="40">&nbsp;</td>
		        <td class="fragout-table-head">&nbsp;</td>
		        <td><div align="right">
		          <input name="save" type="submit" class="btn" id="save" value="保存" />
		          </div></td>
		        <td>&nbsp;</td>
		        </tr>
		      </table>
    </form>
    <script type="text/javascript">
    	$("#form1").on('submit', function() {
    		$.ajax({
    			type: 'POST',
    			data: $(this).serialize(),
    			url: $(this).attr('action'),
    			success: function() {
    				location.href = "about:blank";
    				window.parent.frames['topFrame'].location.reload();
    			}
    		});
    		return false;
    	});
    </script>
</body>
<!-- InstanceEnd --></html>

