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
		<link rel="stylesheet" href="<%=basePath%>jsp/table.css" type="text/css" />
		<title>无标题文档</title>
		<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../jsp/javascript/xy/nowDate.js" charset="UTF-8"></script>
		<script type="text/javascript">
		function doEdit(checker,checkTime,checkComment)
		{
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=check&id=" + id;
			var checker = $("#checker").val();
			var checkTime = $("#time").val();
			var checkComment = $("#checkComment").val();
			var ssdId = $("#ssdId").val();
			
			window.location ="/hr/salarystandard/checkAdopt?checker="+checker+"&checkTime="+checkTime+"&checkComment="+checkComment+"&ssdId="+ssdId;
			//document.forms[0].submit();
		}
		</script>
	</head>

	<body onload="getNowDate()">
		<form action="salarystandard.do" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是:人力资源管理--薪酬标准管理--薪酬标准登记复核</font>
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<input type="button" value="复核通过" class="BUTTON_STYLE1" onclick="doEdit();">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
				
				<input type="hidden" name="ssdId" id="ssdId" value="${check.ssdId}" class="INPUT_STYLE2">
					<td width="12%" class="TD_STYLE1">
						薪酬编号
					</td>
					<td width="15%" class="TD_STYLE2">
					<input type="text" name="standardId" value="${check.standardId}" readonly="readonly" class="INPUT_STYLE2">
						
					</td>
					<td width="12%" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="11%" class="TD_STYLE2">
						<input type="text" name="standardName" value="${check.standardName}" class="INPUT_STYLE2">
					</td>
					<td width="11%" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="17%" class="TD_STYLE2">
						
						<input type="text" name="salarySum" value="${check.salarySum}" readonly="readonly" class="INPUT_STYLE2">
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
						<input type="text" name="designer" value="${check.designer}" class="INPUT_STYLE2" readonly="readonly">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checker" id="checker" value="better_wanghao" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checkTime" id="time" value="2010-05-29 03:27:14" readonly="readonly" class="INPUT_STYLE2">
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
						复核意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="checkComment" id="checkComment" rows="4" class="TEXTAREA_STYLE1"></textarea>
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
				<c:forEach items="${check.salaryStandardDetails}" var="one">
				<tr class="TD_STYLE2">
				    <input type="hidden" name="sdtId" value="${one.sdtId}" class="INPUT_STYLE2">
					<td align="center">
						
						<input type="text" name="itemId" value="${one.itemId}" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						
						<input type="text" name="itemName" value="${one.itemName}" class="INPUT_STYLE2">
					</td>
					<td>
						<input type="text" name="salary" value="${one.salary}" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				</c:forEach>
				
				
			
				
			</table>
		</form>
	</body>
</html>

