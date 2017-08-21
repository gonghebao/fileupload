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
		<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/css/images/title_arrow.gif" /> è®¢åèååè¡¨
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- ä¸»åå®¹åºåï¼æ°æ®åè¡¨æè¡¨åæ¾ç¤ºï¼ -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- è¡¨å¤´-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>èå</td>
					<td>åä»·</td>
					<td>æ°é</td>
				</tr>
			</thead>
			<!--æ¾ç¤ºæ°æ®åè¡¨ -->
			<tbody id="TableData">
				
			 		<tr height="60">
				 		<td>ç¤ä¹³çª</td>
				 		<td>68.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			 		<tr height="60">
				 		<td>ç¤ä¹³çª</td>
				 		<td>68.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			 		<tr height="60">
				 		<td>ç½åé¸¡</td>
				 		<td>68.0</td>
				 		<td>1</td>
			 		</tr>
			 	
			</tbody>
		</table>
		<div id="TableTail" align="center">
			 <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
	</div>
	</div>
</div>
<%@include file="bottom.jsp"%>
</html>
	

