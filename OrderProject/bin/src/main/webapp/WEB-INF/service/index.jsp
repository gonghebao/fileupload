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
		<%@include file="right.jsp"%>
	</div>
</div>
<%@include file="bottom.jsp"%>
</html>