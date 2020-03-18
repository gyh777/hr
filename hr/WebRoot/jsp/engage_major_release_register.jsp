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
		<link rel="stylesheet" href="../jsp/table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="../jsp/javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="../jsp/javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/select.js"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript">
			function firstKindNameChange(obj){
				var firstKind = $(obj).find("option:selected").val();
				var firstId = firstKind.substring(0,firstKind.indexOf("/"));
				var firstName = firstKind.substring(firstKind.indexOf("/")+1);
				$.ajax({
					type : "post",
					url : "/hr/engageMajorRelease/selectSecondKindIdAndName?firstName="+firstName,
					dataType : "json",
					success:function(result){
						
					}
				});
			};
 		</script>
	</head>

	<body>
		<form name="majorReleaseForm" method="post" action="/hr/majorRelease.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
							onclick="window.location.href='register_choose_picture.jsp'">
						<input type="button" value="清除" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">I级机构</td>
					<td width="15%" class="TD_STYLE2">
						<select name="firstKindName" class="SELECT_STYLE1" 
								onchange="firstKindNameChange(this)">
							<option value="">&nbsp;</option>
							<c:forEach items="${firstKindAndMajorKind }" var="map">
								<c:if test="${map.key == 'firstValue' }">
									<c:forEach items="${map.value }" var="val">
										<option value="${val.first }/${val.second }">
											${val.first }/${val.second }
										</option>
                					</c:forEach>
								</c:if>
                			</c:forEach>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">II级机构</td>
					<td width="15%" class="TD_STYLE2">
						<select name="secondKindName" class="SELECT_STYLE1" onchange="">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">III级机构</td>
					<td width="15%" class="TD_STYLE2">
						<select name="thirdKindName" class="SELECT_STYLE1">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">招聘类型</td>
					<td width="15%" class="TD_STYLE2">
						<select name="engageType" class="SELECT_STYLE1">
							<option value="">&nbsp;</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">职位分类</td>
					<td width="15%" class="TD_STYLE2">
						<select name="majorKindName" onchange="" class="SELECT_STYLE1">
							<option value="">&nbsp;</option>
							<c:forEach items="${firstKindAndMajorKind }" var="map">
								<c:if test="${map.key == 'majorKindValue' }">
									<c:forEach items="${map.value }" var="val">
										<option value="${val.first }/${val.second }">${val.first }/${val.second }</option>
                					</c:forEach>
								</c:if>
                			</c:forEach>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">职位名称</td>
					<td class="TD_STYLE2">
						<select name="majorName" class="SELECT_STYLE1">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">招聘人数</td>
					<td width="15%" class="TD_STYLE2">
						<input type="text" name="humanAmount" value="" class="INPUT_STYLE2">
					</td>
					<td width="10%" class="TD_STYLE1">截止日期</td>
					<td width="15%" class="TD_STYLE2">
						<input type="text" name="deadline" value="" class="INPUT_STYLE2" id="date_end">
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">登记人</td>
					<td width="15%" class="TD_STYLE2">
						<input type="text" name="register" value="" class="INPUT_STYLE2">
					</td>
					<td width="10%" class="TD_STYLE1">登记时间</td>
					<td class="TD_STYLE2">
						<input type="text" name="registTime" value="" class="INPUT_STYLE2" id="date_start">
					</td>
					<td width="10%" class="TD_STYLE1"></td>
					<td width="15%" class="TD_STYLE2"></td>
					<td width="10%" class="TD_STYLE1"></td>
					<td width="15%" class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">职位描述</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="majorDescribe" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">招聘要求</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engageRequired" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	Calendar.setup ({
		inputField : "date_end",
		ifFormat : "%Y-%m-%d", 
		showsTime : false, 
		button : "date_end", 
		singleClick : true, 
		step : 1});
	</script>
</html>