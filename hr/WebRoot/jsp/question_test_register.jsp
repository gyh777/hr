<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css" />
		<script type="text/javascript" src="/hr/jsp/javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/engageExam/save">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试管理--考试出题
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="提交" class="BUTTON_STYLE1">
						<input type="reset" value="清除" class="BUTTON_STYLE1" >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="74" class="TD_STYLE1">
						职位分类
					</td>
					<td width="168" class="TD_STYLE1">
						<input type="hidden" name="major_kind_id" value="${configMajor.major_kind_id }">
						<input type="hidden" name="major_kind_name" value="${configMajor.major_kind_name }">
						${configMajor.major_kind_name }
					</td>
				</tr>
				<tr>
					<td width="83" class="TD_STYLE1">
						职位名称
					</td>
					<td width="171" class="TD_STYLE1">
						<input type="hidden" name="major_id" value="${configMajor.major_id }">
						<input type="hidden" name="major_name" value="${configMajor.major_name }">
						${configMajor.major_name }
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="register" />
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<jsp:useBean id="now" class="java.util.Date" scope="page"/>
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh-mm-ss" />
					</td>
					<td class="TD_STYLE1">
						答题限时（分钟）
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="limite_time" />
					</td>
				</tr>
				<c:forEach var="list" items="${resList }" varStatus="s">
					<tr>
						<td class="TD_STYLE1">
							试题一级分类名称
						</td>
						<td class="TD_STYLE1">
							试题二级分类名称
						</td>
						<td class="TD_STYLE1">
							可用试题数量
						</td>
						<td class="TD_STYLE1">
							出题数量
						</td>
					</tr>
					<tr>
						<td class="TD_STYLE1">
							<input type="hidden" name="list[${s.index}].first_kind_id" value="${list.configQuestionSecondKind.first_kind_id }">
							<input type="hidden" name="list[${s.index}].first_kind_name" value="${list.configQuestionSecondKind.first_kind_name }">
							${list.configQuestionSecondKind.first_kind_name }
						</td>
						<td width="95" height="26" class="TD_STYLE1">
							<input type="hidden" name="list[${s.index}].second_kind_id" value="${list.configQuestionSecondKind.second_kind_id }">
							<input type="hidden" name="list[${s.index}].second_kind_name" value="${list.configQuestionSecondKind.second_kind_name }">
							${list.configQuestionSecondKind.second_kind_name }
						</td>
						<td class="TD_STYLE1">
							${list.count }
						</td>
						<td class="TD_STYLE1">
							<input type="text" name="list[${s.index}].question_amount">
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>