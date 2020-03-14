<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="table.css" type="text/css">
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
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
					<td width="10%" class="TD_STYLE1">
						登记时间
					</td>
					<td width="10%" class="TD_STYLE1">
						<input type="text" name="">
					</td>
					</tr>
				
			</table>
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>


