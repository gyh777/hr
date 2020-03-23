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
		<script type="text/javascript" src="../jsp/javascript/xy/nowDate.js" charset="UTF-8"></script>
		<script type="text/javascript">
		function doEdit()
		{alert("222");
			//document.forms[0].action = document.forms[0].action + "?operate=doEdit&method=check&id=" + id;
			var checker = $("#checker").val();
			var checkTime = $("#time").val();
			var sgrId = $("#sgrId").val();
			
			alert(checker+"-"+checkTime+"-"+"sgrId");
			window.location ="/hr/salarygrant/checkAdopt?checker="+checker+"&checkTime="+checkTime+"&sgrId="+sgrId;
			
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
							<input type="button" value="确认发放" class="BUTTON_STYLE1" onclick="doEdit();">
							<input type="button" value="返回" onclick="history.back();" class="BUTTON_STYLE1">
						</div>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				<tr>
					
					<input type="hidden" value="${check.sgrId}" id="sgrId"/>
					<td class="TD_STYLE1">
						一级机构
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="firstKindName" value="${check.firstKindName}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						二级机构
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="secondKindName" value="${check.secondKindName}" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						三级机构
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="thirdKindName" value="${check.thirdKindName}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						人员总数
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="humanAmount" value="${check.humanAmount}" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td width="74" class="TD_STYLE1">
						薪酬标准编号
					</td>
					<td width="168" class="TD_STYLE2"><!-- 应该从数据库薪酬表取最大主键+1 -->
						<input type="text" name="standardId" value="${check.salaryStandardId}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td width="83" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="171" class="TD_STYLE2">
						<input type="text" name="standardName" value="${standard.standardName}" class="INPUT_STYLE2">
					</td>
					<td width="170" class="TD_STYLE1">
						薪酬
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="salaryStandardSum" value="${check.salaryStandardSum}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						总薪酬
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="salaryPaidSum" value="${check.salaryPaidSum}" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" value="${check.register}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="registTime" value="${check.registTime}" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="checker" id="checker" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checkTime" id="time" value="" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				
				
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="14%" class="TD_STYLE1">
						职工id
					</td>
					<td width="15%" class="TD_STYLE1">
						职工姓名
					</td>
					<td width="14%" class="TD_STYLE1">
						奖金
					</td>
					<td width="14%" class="TD_STYLE1">
						销售绩效金额
					</td>
					<td width="14%" class="TD_STYLE1">
						应扣金额
					</td>
					<td width="14%" class="TD_STYLE1">
						薪酬
					</td>
					<td width="15%" class="TD_STYLE1">
						应付职工薪酬
					</td>
				</tr>
				</table>
				<table id="humanFile" width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<c:forEach items="${requestScope.human}" var="one">
				
					<tr>
					<td width="14%" class="TD_STYLE1">
						${one.humanId}
					</td>
					<td width="15%" class="TD_STYLE1">
						${one.humanName}
					</td>
					<td width="14%" class="TD_STYLE1">
						${one.bounsSum}
					</td>
					<td width="14%" class="TD_STYLE1">
						${one.saleSum}
					</td>
					<td width="14%" class="TD_STYLE1">
						${one.deductSum}
					</td>
					<td width="14%" class="TD_STYLE1">
						${one.salaryStandardSum}
					</td>
					<td width="15%" class="TD_STYLE1">
						${one.salaryPaidSum}
					</td>
				</tr>
				</c:forEach>
				</table>
		</form>
	</body>
</html>

