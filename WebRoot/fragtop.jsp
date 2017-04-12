<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.example.demo.Plan" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String links = (String)request.getAttribute("links");
request.setAttribute("links", links);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="js/echarts.min.js"></script>


<!-- InstanceBegin template="/Templates/Fourth.dwt" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- InstanceBeginEditable name="doctitle" -->
<title>版本管理</title>
<link href="css/style3.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/bootstrap1.css" rel="stylesheet" type="text/css" media="all" />

<script src="js/jquery.min.js"></script>
<!-- //js -->
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Eco Travel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
</head>

<body>
<div id="main" style="width: 100%;height:450px;"></div>
</body>
<script type="text/javascript">
var links = <%=links%>;
var grandParent, deepLink;
var linkMap = {};
var step = 10;
var setDepth = function(link, depth) {
	link.depth = depth;
	for(var i = 0; i < link.children.length; i++) {
		setDepth(link.children[i], depth + 1);
	}
}
for(var i = 0; i < links.length; i++) {
	linkMap[links[i]["vid"]] = links[i];
	if(links[i]["vparent"] == null) {
		grandParent = links[i];
	}
	links[i].children = [];
	var str = '版本' + (i + 1);
	links[i].name = str;
	linkMap[str] = links[i];
}
for(var i = 0; i < links.length; i++) {
	var link = links[i];
	var vparent = linkMap[link["vparent"]];
	if(vparent != undefined) {
		vparent.children.push(link);
		link.vparent = vparent;
	}
}

var index = 1;
var linkData = [], linkLine = [];
var calcPosition = function(item) {
	for(var i = 0; i < item.children.length; i++){
		calcPosition(item.children[i]);
		item.children[i].x = step * index++;
	}
	item.x = step * index;
}
var parseData = function() {
	for(var i = 0; i < links.length; i++) {
		linkData.push({
			name: links[i].name,
			x: links[i].x,
			y: links[i].depth * step,
			itemStyle: {
				normal: {
					color: '#6F7D94'
				}
			}
		});		
		for(var j = 0; j < links[i].children.length; j++) {
			linkLine.push({
				source: links[i].name,
				target: links[i].children[j].name
			});
		}
	}
	linkData[linkData.length - 1].itemStyle.normal.color = '#FF0000';
}
setDepth(grandParent, 1);
calcPosition(grandParent);
parseData();
option = {
    title: {
        text: '版本记录'
    },
    tooltip: {
    	formatter: function(params) {
    		var item = linkMap[params.name];
    		if(item != undefined) {
    			var vcomment = item.vcomment;
    		   if(item.vcomment.length > 10) {
    		   		vcomment = item.vcomment.substring(0, 10) + "...";
    		   }
    		   return '发布者:' + item.username + '<br />修改时间:' + item.createtime + '<br />修改理由:' + vcomment;
    		}
    	}
    },
    animationDurationUpdate: 1500,
    animationEasingUpdate: 'quinticInOut',
    series : [
        {
            type: 'graph',
            layout: 'none',
            symbolSize: 50,
            roam: true,
            label: {
                normal: {
                    show: true
                }
            },
            edgeSymbol: ['circle', 'arrow'],
            edgeSymbolSize: [4, 10],
            edgeLabel: {
                normal: {
                    textStyle: {
                        fontSize: 20
                    }
                }
            },
            data: linkData,
            // links: [],
            links: linkLine,
            lineStyle: {
                normal: {
                    opacity: 0.9,
                    width: 2,
                    curveness: 0
                }
            }
        }
    ]
};
 // 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));
myChart.setOption(option);
myChart.on('click', function(params) {
	var item = linkMap[params.name];
	if(item != undefined) {
		window.parent.frames["bottomFrame"].location.href = '<%=basePath%>' + 'fragbottom_Servlet?vid=' + item.vid;
	    //location.href = '<%=basePath%>' + 'fragout_Servlet?vid=' + item.vid;
	}
});
</script>
<!-- InstanceEnd --></html>
