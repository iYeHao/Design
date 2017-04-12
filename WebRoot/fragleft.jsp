<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.MainField" %>
<%@ page import="com.example.demo.FieldBase" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<MainField> fields = (List<MainField>)request.getAttribute("fields");
int pid  = (Integer)request.getAttribute("pid");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<style type="text/css">
td {
	font-size: 18px;
}
</style>
</head>
<body>
<table width="334" height="250" border="0" align="left" cellpadding="0" cellspacing="0">
  <tbody>
    <tr>
      <td align="left" valign="top" >
        <TABLE cellSpacing=0 cellPadding=0 width="88%" border=0>
          <TBODY>
           <%for(int i = 0; i < fields.size(); i++) {
		    	MainField mf = fields.get(i);
		    	List<FieldBase> fbs = mf.getChildren();
		     %>
            <TR>
              <TD style="PADDING-LEFT: 20px" background="" height=23><IMG 
                  height=9 src="images/bit05.gif" width=8 
                  align=absMiddle> <A onclick=javascript:ShowFLT(<%=i+1 %>) 
                  href="javascript:void(null)"><%=mf.getFname() %></A></TD>
            </TR>
            <TR id=LM<%=i+1 %> style="DISPLAY: none">
              <TD><TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                  <TBODY>
                  <%for(int j = 0; j < fbs.size(); j++) {
		            	FieldBase fb = fbs.get(j);
		             %>
                    <TR>
                      <TD style="PADDING-LEFT: 40px" height=23><IMG height=7 
                        src="images/bit06.gif" width=8 align=absMiddle> <A
                        href="fragtop_Servlet?pid=<%=pid %>&fid=<%=fb.getFid() %>" 
                        target=topFrame><%=fb.getFname() %></A></TD>
                    </TR>
                    <%
                    }
                     %>
                  </TBODY>
                </TABLE></TD>
            </TR>   
            <%
            }
             %>        
          </TBODY>
        </TABLE>
        </td>
    </tr>
    <tr>
      
    </tr>
  </tbody>
</table>
<p>&nbsp;</p>
<p align="center">
<a href="plantotal_Servlet?pid=<%=pid%> " target="_blank" class="btn">生成最佳的预案 </a>
</p>
<p align="center">
<a href="planbest_Servlet?pid=<%=pid%> " target="_blank" class="btn">当前最佳的预案 </a>
</p>
</body>
<script language=javascript id=clientEventHandlersJS>
var number=13;

function LMYC() {
var lbmc;
//var treePic;
    for (i=1;i<=number;i++) {
        lbmc = eval('LM' + i);
        //treePic = eval('treePic'+i);
        //treePic.src = 'images/file.gif';
        lbmc.style.display = 'none';
    }
}
 
function ShowFLT(i) {
    lbmc = eval('LM' + i);
    //treePic = eval('treePic' + i)
    if (lbmc.style.display == 'none') {
        LMYC();
        //treePic.src = 'images/nofile.gif';
        lbmc.style.display = '';
    }
    else {
        //treePic.src = 'images/file.gif';
        lbmc.style.display = 'none';
    }
}
</script>
</html>
