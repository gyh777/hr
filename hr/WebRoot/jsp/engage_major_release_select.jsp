<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" href="../jsp/table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="../jsp/javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="../jsp/javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/select.js"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript">
			
 		</script>
	</head>

	<body>
		<form method="post" action="">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布查询
						</font>
					</td>
				</tr>>
				<tr>
					<td>
						<p>当前职位发布总数：1例</p>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="15%" class="TD_STYLE1">职位名称</td>
					<td width="15%" class="TD_STYLE1">机构名称</td>
					<td width="15%" class="TD_STYLE1">招聘人数</td>
					<td width="30%" class="TD_STYLE1">发布时间</td>
					<td width="15%" class="TD_STYLE1">截止时间</td>
					<td width="10%" class="TD_STYLE1">申请职位</td>
				</tr>
				<c:forEach items="${releaseList }" var="list">
					<tr>	
						<td class="TD_STYLE2">${list.major_name }</td>
						<td class="TD_STYLE2">${list.first_kind_name }</td>
						<td class="TD_STYLE2">${list.human_amount }</td>
						<td class="TD_STYLE2" id="date">${list.deadline }</td>
						<td class="TD_STYLE2" id="dates">${list.regist_time }</td>
						<td class="TD_STYLE2">
							<a href="javascript:void(0);" 
								onclick="">申请职位</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<p>&nbsp;&nbsp;总数：8例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="../jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
	<script type="text/javascript" charset="UTF-8">
		Calendar.setup ({
			inputField : "date",
			ifFormat : "%Y-%m-%d", 
			showsTime : false, 
			button : "date", 
			singleClick : true, 
			step : 1});
		Calendar.setup ({
			inputField : "dates",
			ifFormat : "%Y-%m-%d %H:%M:%S", 
			showsTime : false, 
			button : "dates", 
			singleClick : true, 
			step : 1});
	</script>
</html>