<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
int pid = (Integer)request.getAttribute("pid");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预案详情</title>
</head>
<frameset rows="40,316" cols="*">
  <frame src="fraghead_Servlet?pid=<%=pid %>" name="headFrame" scrolling="no" noresize="noresize"id="headFrame" title="headFrame"/>
  <frameset rows="*" cols="210,975">
    <frame src="fragleft_Servlet?pid=<%=pid %>" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame"/>
    <frameset rows="154,155">
      <frame src="" name="topFrame"  id="topFrame" title="topFrame"/>
      <frame src="" name="bottomFrame" id="bottomFrame" title="bottomFrame" />
    </frameset>
  </frameset>
<noframes><body>
</body></noframes>
</frameset>
</html>
