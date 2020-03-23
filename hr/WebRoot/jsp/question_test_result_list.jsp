<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<form method="post" action="">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试管理--成绩查询筛选</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>身份证号码</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>试卷编号</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>答题用时</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>试卷详情</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>筛选</span>
					</td>
				</tr>
					<c:forEach var="list" items="${EngageAnswerList }">
						<tr class="TD_STYLE1">
							<td class="TD_STYLE1">
								${list.human_name }
							</td>
							<td class="TD_STYLE1">
								${list.human_idcard }
							</td>
							<td class="TD_STYLE1">
								${list.exam_number }
							</td>
							<td class="TD_STYLE1">
								<fmt:formatNumber type="number" value="${list.use_time/60/60 }" maxFractionDigits="0"></fmt:formatNumber>
								小时
								<fmt:formatNumber type="number" value="${list.use_time/60%60 }" maxFractionDigits="0"></fmt:formatNumber>
								分钟
								<fmt:formatNumber type="number" value="${list.use_time%60 }" maxFractionDigits="0"></fmt:formatNumber>
								秒
							</td>
							<td class="TD_STYLE1">
								<a href="/hr/engageAnswer/getByAnsId?ans_id=${list.ans_id }">试卷详情</a>
							</td>
							<td class="TD_STYLE1">
								<a href="/hr/engageAnswer/getByAnsIdForCheck?ans_id=${list.ans_id }">筛选</a>
							</td>
						</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：${EngageAnswerList.size() }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="/hr/jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
