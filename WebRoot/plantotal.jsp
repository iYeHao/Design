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
	        <td>
	        <label for="select"></label>
	          <select name="select" class="btn" id="select">
	            <option id="opt_<%=i+1 %>_<%=j+1 %>" data-vtext="编制的目的是什么呢？" value="0" >请选择你喜欢的版本</option>
	            <%for(int k = 0; k < versionDetails.size(); k++) {
	            	VersionDetail versionDetail = versionDetails.get(k);
	             %>
	            <option id="opt_<%=i+1 %>_<%=j+1 %>" data-createtime="<%=versionDetail.getCreatetime() %>" data-username="<%=versionDetail.getUsername() %>" data-vtext="<%=versionDetail.getVtext() %>" value="<%=versionDetail.getVid() %>">版本<%=k+1 %></option>
	            <%
	            }
	             %>
            </select>
            </td>
          </tr>
	      <tr>
	        <td id="td_<%=i+1 %>_<%=j+1 %>" height="45" colspan="2" class="a"><pre>请选择你喜欢的版本</pre></td>
          </tr>
          <%} %>
        </table>  
             
	    <div class="ui-title-subcnt fn-right"></div>
	  
	   <%} %> 
	   
	  </div> 
	  <div align="right" style="margin-bottom: 40px;"> 
	  <form id="form1" name="form1" method="post" action="planclone_Servlet">
	  	<input type="hidden" name="pid" id="pid" value="<%=planDetail.getPid() %>" />
	  	<input type="hidden" name="vids" id="vids" />
	  	<input type="submit" name="save" class="btn" id="save" value="保存" />
	  </form>
  </div>
</div>
</div>
</div>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$("select").change(function() {
			var idx = this.selectedIndex;
			var opt = this.options[idx];
			var id = $(opt).attr('id');
			var td_id = '#td' + id.substring(3);
			var $opt = $(opt);
			var createtime = $opt.data('createtime');
			var username = $opt.data('username');
			var vtext = $opt.data('vtext');
			var out = '';
			if(createtime != undefined) {
				out += '<pre>创建时间：' + createtime + '<p>' +
				'</p>创建用户：' + username + '<p>' +
				'</p><div><p>内容：' + vtext + '</p></div></pre>';
			}
			else {
				out+= '<pre>' + vtext + '</pre>';
			}
			$(td_id).html(out);
		});
		$("#form1").submit(function() {
			var vids = [];
			$("select").each(function(index, element) {
				if($(this).val() !== '0') {
					vids.push($(this).val());
				}
			});
			$("#vids").val(vids);
			return true;
		});
	});
</script>
<!-- //login-page -->
</body>
</center>
</html>
