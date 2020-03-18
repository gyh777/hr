<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css" />
		<link rel="stylesheet" type="text/css" media="all"
			href="javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="javascript/calendar/cal.js"></script>
		<title>无标题文档</title>
		<script type="text/javascript">
			function list()
			{
				//document.forms[0].action = document.forms[0].action + "?operate=list&status=1&method=query";
				document.forms[0].action ="/hr/engageSubjects/find";
				document.forms[0].submit();
			}
		</script>
	</head>

	<body>
		<form method="post" action="/hr/engageResume/find">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--简历管理--简历筛选 </font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="submit" value="查询" class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						请选择职位分类
					</td>
					<td class="TD_STYLE2">
						<select name="human_major_kind_id">
							<option value="" selected="selected">请选择</option>
							<c:forEach var="list" items="${configMajorList }">
								<option value="${list.major_kind_id }">${list.major_kind_name }</option>
							</c:forEach>
						</select>
						<select name="human_major_id">
							<option value="" selected="selected">请选择</option>
							<c:forEach var="list" items="${configMajorList }">
								<option value="${list.major_id }">${list.major_name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入关键字
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="keyWord" class="INPUT_STYLE1">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						请输入登记时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="start" value="" class="INPUT_STYLE1" id="date_start">
						至
						<input type="text" name="end" value="" class="INPUT_STYLE1" id="date_end">
						(YYYY-MM-DD)
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
	Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
	</script>
</html>

