<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试管理--考试答题</font>
					</td>
				</tr>
				<tr>
					<td>
						答题限定时间${ }
					</td>
				</tr>
				<tr>
					<td>
						答题已用时间<input type="text" name="" value="" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td>
						<input type="radio" name="" value="我要交卷">
						<input type="radio" name="" value="再检查一遍">
						<input type="submit" value="确认" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>试卷编号</span>
					</td>
					<td width="30%" class="TD_STYLE2">
						<span></span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>试题数量</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span></span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<td width="30%" class="TD_STYLE2">
						<span></span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>身份证号</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span></span>
					</td>
				</tr>
					<c:forEach var="list" items="${engageExamDtoList }">
						<tr class="TD_STYLE2">
							<td>
								${list.configMajor.major_kind_id }
							</td>
							<td>
								${list.configMajor.major_kind_name }
							</td>
							<td>
								${list.configMajor.major_id }
							</td>
							<td>
								${list.configMajor.major_name }
							</td>
							<td>
								${list.count}
							</td>
							<td>
								<a href="/hr/engageExam/createExam?major_name=${list.configMajor.major_name }">出题</a>
							</td>
						</tr>
					</c:forEach>
				
			</table>
		</form>
	</body>
</html>
