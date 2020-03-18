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
						<font color="#0000CC">您正在做的业务是：招聘管理--简历管理--简历筛选</font>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						符合条件的简历总数:
						${engageResumeFindForEffectiveList.size() }
						例
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>职位分类</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>职位名称</span>
					</td>
					<td width="15%" class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>性别</span>
					</td>
					<td class="TD_STYLE1" width="15%">
						<span>电话</span>
					</td>
				</tr>
					<c:forEach var="list" items="${engageResumeFindForEffectiveList }">
						<tr class="TD_STYLE2">
							<td>
								${list.human_major_kind_name }
							</td>
							<td>
								${list.human_major_name }
							</td>
							<td>
								${list.human_name }
							</td>
							<td>
								${list.human_sex }
							</td>
							<td>
								${list.human_telephone }
							</td>
						</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>
