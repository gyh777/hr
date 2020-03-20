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
						<font color="#0000CC">您正在做的业务是：招聘管理--简历管理--有效简历查询</font>
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
						<span>职位分类编号</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>职位分类名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>职位编号</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>职位名称</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>套题数量</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>出题</span>
					</td>
				</tr>
					<c:forEach var="list" items="${engageResumeFindList }">
						<tr class="TD_STYLE2">
							<td>
								${list.major_kind_id }
							</td>
							<td>
								${list.major_kind_name }
							</td>
							<td>
								${list.major_id }
							</td>
							<td>
								${list.major_name }
							</td>
							<td>
								1
							</td>
							<td>
								<a href="">出题</a>
							</td>
						</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：${engageResumeFindList.size() }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
