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
		<form id="questionForm" method="post" action="/hr/engageAnswer/save">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试管理--成绩查询筛选</font>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE1">
						${engageAnswer.human_name }
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE1">
						${engageAnswer.human_idcard }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						试卷编号
					</td>
					<td class="TD_STYLE1">
						${engageAnswer.exam_number }
					</td>
					<td class="TD_STYLE1">
						答题用时
					</td>
					<td class="TD_STYLE1">
						<fmt:formatNumber type="number" value="${engageAnswer.use_time/60/60 }" maxFractionDigits="0"></fmt:formatNumber>
						小时
						<fmt:formatNumber type="number" value="${engageAnswer.use_time/60%60 }" maxFractionDigits="0"></fmt:formatNumber>
						分钟
						<fmt:formatNumber type="number" value="${engageAnswer.use_time%60 }" maxFractionDigits="0"></fmt:formatNumber>
						秒
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<c:forEach var="list" items="${answerDetailsDtoList }" varStatus="s">
					<tr class="TD_STYLE2">
						<td class="TD_STYLE2">
							${s.index+1 }. &nbsp;&nbsp; ${list.engageSubjects.content }
						</td>
					</tr>
					<tr class="TD_STYLE2">
						<td class="TD_STYLE1">
							A.${list.engageSubjects.key_a } &nbsp;&nbsp; B.${list.engageSubjects.key_b } &nbsp;&nbsp;
							C.${list.engageSubjects.key_c } &nbsp;&nbsp; D.${list.engageSubjects.key_d } &nbsp;&nbsp;
							正确答案：${list.engageSubjects.correct_key } &nbsp;&nbsp; 应试者答案：${list.answer }
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>