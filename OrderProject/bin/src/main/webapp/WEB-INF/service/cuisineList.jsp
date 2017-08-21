
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
					src="style/images/title_arrow.gif" /> 菜系列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/cuisine.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜系名称">
			<input type="submit" value="搜索">
		</form>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜系编号</td>
					<td>菜系名称</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				
					<tr>
						<td>1</td>
						<td>粤菜</td>
						<td>
							<a href="updateCuisine.html" class="FunctionButton">更新</a> 
							<a href="#" class="FunctionButton">删除</a>
						</td>
					</tr>
				
					<tr>
						<td>2</td>
						<td>川菜</td>
						<td>
							<a href="#" class="FunctionButton">更新</a> 
							<a href="#" class="FunctionButton">删除</a>
						</td>
					</tr>
				
					<tr>
						<td>3</td>
						<td>湘菜</td>
						<td>
							<a href="#" class="FunctionButton">更新</a> 
							<a href="#" class="FunctionButton">删除</a>
						</td>
					</tr>
				
					<tr>
						<td>4</td>
						<td>东北菜</td>
						<td>
							<a href="#" class="FunctionButton">更新</a> 
							<a href="#" class="FunctionButton">删除</a>
						</td>
					</tr>
				
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="saveCuisine.html">添加</a>
			</div>
		</div>
	</div>
	</div>
</div>
<%@include file="bottom.jsp"%>
</html>
