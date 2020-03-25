<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath%>jsp/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>

<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>

	</head>

	<body>
		<form method="post" action="salarystandard.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						当前等待复核的薪酬标准总数:
						
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="18%" class="TD_STYLE1">
						<span>薪酬标准编号</span>
					</td>
					<td width="19%" class="TD_STYLE1">
						<span>薪酬标准名称</span>
					</td>
					<td width="16%" class="TD_STYLE1">
						<span>制定人</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>登记时间</span>
					</td>
					<td width="13%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="4%" class="TD_STYLE1">
						复核
					</td>
				</tr>
				
				<c:forEach items="${requestScope.list}" var="one">
					<tr class="TD_STYLE2">
						<td>
							${one.standardId}
						</td>
						<td>
							${one.standardName}
						</td>
						
						<td>
							${one.designer}
						</td>
						
						<td>
							${one.registTime}
						</td>
						<td>
							${one.salarySum}
						</td>
						<td>
							<a
								href="/hr/salarystandard/check?ssdId=${one.ssdId}">复核</a>
						</td>
					</tr>
				
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：3例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
