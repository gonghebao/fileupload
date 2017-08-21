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
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="/wirelessplatform/board.html" method="get">
		<input type="hidden" name="method" value="search">
		<input type="text" name="keyword" title="请输入餐桌名称">
		<input type="submit" value="搜索">
	</form>
</div>


<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>状态</td>
				<td>预定时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		
			<tr class="TableDetail1">
				<td align="center">1&nbsp;</td>
				<td align="center"> 纽约&nbsp;</td>
				<td align="center">预定</td>
				<td align="center">2014-12-08 23:31:12</td>
				<td>
					<a href="/wirelessplatform/board.html?method=update&id=1&isBook=0" class="FunctionButton">退桌</a>				
					<a href="/wirelessplatform/board.html?method=delete&id=1" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
        
			<tr class="TableDetail1">
				<td align="center">2&nbsp;</td>
				<td align="center"> 巴黎&nbsp;</td>
				<td align="center">空闲</td>
				<td align="center"></td>
				<td>
					<a href="/wirelessplatform/board.html?method=update&id=2&isBook=1" class="FunctionButton">预定</a>				
					<a href="/wirelessplatform/board.html?method=delete&id=2" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
        
			<tr class="TableDetail1">
				<td align="center">3&nbsp;</td>
				<td align="center"> 丹麦&nbsp;</td>
				<td align="center">空闲</td>
				<td align="center"></td>
				<td>
					<a href="/wirelessplatform/board.html?method=update&id=3&isBook=1" class="FunctionButton">预定</a>				
					<a href="/wirelessplatform/board.html?method=delete&id=3" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
        
			<tr class="TableDetail1">
				<td align="center">5&nbsp;</td>
				<td align="center"> 伦敦&nbsp;</td>
				<td align="center">空闲</td>
				<td align="center"></td>
				<td>
					<a href="/wirelessplatform/board.html?method=update&id=5&isBook=1" class="FunctionButton">预定</a>				
					<a href="/wirelessplatform/board.html?method=delete&id=5" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>
        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="saveBoard.html">添加</a></div>
    </div> 
</div>
	</div>
</div>
<%@include file="bottom.jsp"%>
</html>



