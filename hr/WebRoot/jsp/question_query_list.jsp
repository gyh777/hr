<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>
	</head>

	<body>
		<form method="post" action="salarystandard.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试题库管理--试题查询</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						符合条件的试题总数:
						${engageSubjectsFindList.size() }
						例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>I级试题分类名称</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>II级试题分类名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>制定人</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>题目</span>
					</td>
					<td class="TD_STYLE1" width="15%">
						<span>登记时间</span>
					</td>
				</tr>
					<c:forEach var="list" items="${engageSubjectsFindList }">
						<tr class="TD_STYLE2">
							<td class="TD_STYLE1">
								${list.first_kind_name }
							</td>
							<td class="TD_STYLE1">
								${list.second_kind_name }
							</td>
							<td class="TD_STYLE1">
								${list.register }
							</td>
							<td class="TD_STYLE1">
								${list.content }
							</td>
							<td class="TD_STYLE1">
								<fmt:formatDate type="both" value="${list.regist_time }"></fmt:formatDate>
							</td>
						</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：${engageSubjectsFindList.size() }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="/hr/jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
