<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.Field" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<Field> flist =new ArrayList<Field>();
flist=(ArrayList<Field>)request.getAttribute("flist");
request.setAttribute("flist", flist);
String path1="img/cd-icon-picture.svg";
String path2="img/cd-icon-movie.svg";
String path3="img/cd-icon-location.svg";
ArrayList<String> plist=new ArrayList<String>();
plist.add(0, path1);
plist.add(1, path2);
plist.add(2, path3);
request.setAttribute("plist",plist);
ArrayList<String> clist=new ArrayList<String>();
clist.add(0, "Movie");
clist.add(1, "Picture");
request.setAttribute("clist", clist);
ArrayList<String> cclist=new ArrayList<String>();
cclist.add(0, "cd-timeline-img cd-movie");
cclist.add(1, "cd-timeline-img cd-picture");
request.setAttribute("cclist", cclist);
 %>
<html>
  <head>
<meta charset="utf-8">
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>回溯时间轴</title>
<link rel="stylesheet" href="css/tstyle.css" />
<style type="text/css">
h2.top_title{border-bottom:none;background:none;text-align:center;line-height:32px; font-size:20px}
h2.top_title span{font-size:12px; color:#666;font-weight:500}
</style>
</head>

<body>
<h2 class="top_title">版本回溯时间轴<br/></h2>
<section id="cd-timeline" class="cd-container">
<c:forEach  var="f" items="${flist}" varStatus="status">
	<div class="cd-timeline-block">
		<div class="${cclist[status.index%2]}">
			<img src="${plist[status.index%3] }" alt="${clist[status.index%2]}">
		</div>
		<div class="cd-timeline-content">
			<h2><c:out value="${f.fname}"></c:out></h2>
			<p><c:out value="${f.ftext }"></c:out></p>
			<a href="" class="cd-read-more" target="_blank">阅读全文</a>
			<span class="cd-date"><p>Time:<c:out value="${f.fdate}"></c:out></p>
			<p>Author:<c:out value="${f.author}"></c:out></p>
			<p>contribution:<c:out value="${f.contribution}"></c:out></p>
			</span>
			
		</div>
	</div>
	</c:forEach>
</section>

<div id="footer">
     <p align="center">copyright@应急预案后台管理人员</p>
</div>
</body>
</html>