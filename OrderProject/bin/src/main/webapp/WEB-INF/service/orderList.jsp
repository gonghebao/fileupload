<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无线点餐后台管理</title>
<style>
*{
	margin:0;
	padding:0;
}
	.index_left,.index_right{
		float:left;
	}
	.index_left{
		width:10%;
		background-color:#4386B7;
		height:700px;
	}
	.index_right{
		width:90%;
	}
	.clear{
		clear:both;
	}
	.margin_10{
		margin-top:-10px;
	}
</style>
</head>
<%@include file="top.jsp"%>
<div class="clear"></div>
<div class="margin_10">
	<div class="index_left">
		<%@include file="left.jsp"%>
	</div>
	<div class="index_right">
		<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				
			 		<tr height="60">
				 		<td>15375222</td>
				 		<td>纽约</td>
				 		<td>2014-12-08 23:29:18.0</td>
				 		<td>204.0</td>
				 			
				 				<td>未结账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 				</td>
				 		<td>
							<a href="toOrderDetail.do" class="FunctionButton">详细</a> 
				 				<a href="#" class="FunctionButton">结账</a>
				 			
				 		</td>
			 		</tr>
			 	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
	</div>
</div>
<%@include file="bottom.jsp"%>
</html>
	

