<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
		<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src=""<%=basePath%>jsp/javascript/xy/nowDate.js" charset="UTF-8"></script>
		<script type="text/javascript">
		function doEdit(id)
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=change&id=" + id;
			document.forms[0].action = "/hr/salarystandard/changeAdopt";
			document.forms[0].submit();
		}
		</script>
	</head>

	<body onload="getNowDate()">
		<form action="salarystandard.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记变更</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="重新提交" class="BUTTON_STYLE1" onclick="doEdit(1)">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1" >
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="12%" class="TD_STYLE1">
						薪酬编号
					</td>
					<td width="15%" class="TD_STYLE2">
						
						<input type="text" name="standardId" value="${change.standardId}" class="INPUT_STYLE2">

					</td>
					<td width="12%" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="11%" class="TD_STYLE2">

						<input type="text" name="standardName" value="${change.standardName}" class="INPUT_STYLE2">

					</td>
					<td width="11%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="17%" class="TD_STYLE2">
						
						<input type="text" name="salarySum" value="${change.salarySum}" class="INPUT_STYLE2" readonly="readonly" >

					</td>
					<td width="12%" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="10%" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">

						<input type="text" name="designer" value="${change.designer}" class="INPUT_STYLE2">

					</td>
					<td class="TD_STYLE1">
						变更人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="item.changer" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						变更时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="changeTime" id="time" value="2010-05-29 03:38:31" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						序号
					</td>
					<td colspan="3" class="TD_STYLE1">
						薪酬项目名称
					</td>
					<td colspan="4" class="TD_STYLE1">
						金额
					</td>
				</tr>
				<c:forEach items="${change.salaryStandardDetails}" var="one">
				<input type="hidden" name="sdtId" value="${one.sdtId}" class="INPUT_STYLE2">
				<tr class="TD_STYLE2">
					<td>
						${one.itemId}
						<input type="hidden" name="itemId" value="1" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						
						<input type="text" name="itemName" value="${one.itemName}" class="INPUT_STYLE2">
					</td>
					<td colspan="4">
						<input type="text" name="salary" value="${one.salary}" class="INPUT_STYLE2">
					</td>
				</tr>
				</c:forEach>
				
				
			</table>
		</form>
	</body>
</html>














