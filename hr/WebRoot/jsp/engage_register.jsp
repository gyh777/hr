<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css">
		<script type="text/javascript" src="/hr/jsp/javascript/comm/comm.js"></script>
	</head>

	<body>
		<form method="post" action="configfilefirstkind.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--招聘考试题库管理--试题登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="登记" class="BUTTON_STYLE1"
							onclick="window.location.href='/hr/engageSubjects/save'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="10%" class="TD_STYLE1">
						试题I级分类
					</td>
					<td width="10%" class="TD_STYLE1">
						<input type="text" name="">
					</td>
					<td width="10%" class="TD_STYLE1">
						试题二级分类
					</td>
					<td width="10%" class="TD_STYLE1">
						<input type="text" name="">
					</td>
					<td width="10%" class="TD_STYLE1">
						登记人
					</td>
					<td width="10%" class="TD_STYLE1">
						<input type="text" name="">
					</td>
					<td width="10%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="10%" class="TD_STYLE1">
						<input type="text" name="">
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="10%" class="TD_STYLE1">
						<input type="text" name="">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


