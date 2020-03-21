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
		<script type="text/javascript" src="../jsp/javascript/calendar/cal.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/select.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/yhy/util.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/yhy/insertAndUpdate.js" charset="UTF-8"></script>
	</head>

	<body onload="loadFirstAndKindName()">
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="submit" value="提交" class="BUTTON_STYLE1"
							onclick="insertOrUpdateEngageRelease('insert')">
					<input type="reset" value="清除" class="BUTTON_STYLE1" name="clean">
				</td>
			</tr>
		</table>
		<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee
			class="TABLE_STYLE1">
			<tr>
				<td class="TD_STYLE1" width="10%">I级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="first_kind_id" value="">
					<input type="hidden" name="first_kind_name" value="">
					<select name="firstKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this,0)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">II级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="second_kind_id" value="">
					<input type="hidden" name="second_kind_name" value="">
					<select name="secondKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this,0)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">III级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="third_kind_id" value="">
					<input type="hidden" name="third_kind_name" value="">
					<select name="thirdKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this,0)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">招聘类型</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="engage_id" value="">
					<input type="hidden" name="engage_type" value="">
					<select name="engageType" class="SELECT_STYLE1" 
							onchange="kindNameChange(this,0)">
						<option value="">&nbsp;</option>
						<option value="校园招聘">校园招聘</option>
						<option value="社会招聘">社会招聘</option>
					</select>
				</td>
			</tr>
			<tr>
				<td width="10%" class="TD_STYLE1">职位分类</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="major_kind_id" value="">
					<input type="hidden" name="major_kind_name" value="">
					<select name="majorKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this,0)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">职位名称</td>
				<td class="TD_STYLE2">
					<input type="hidden" name="major_id" value="">
					<input type="hidden" name="major_name" value="">
					<select name="majorName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this,0)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">招聘人数</td>
				<td width="15%" class="TD_STYLE2">
					<input type="text" name="human_amount" value="" class="INPUT_STYLE2">
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
					<input type="text" name="time" value="" 
							class="INPUT_STYLE2" readonly>
				</td>
				<td width="10%" class="TD_STYLE1"></td>
				<td width="15%" class="TD_STYLE2"></td>
				<td width="10%" class="TD_STYLE1"></td>
				<td width="15%" class="TD_STYLE2"></td>
			</tr>
			<tr>
				<td class="TD_STYLE1">职位描述</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea name="major_describe" rows="4" class="TEXTAREA_STYLE1"></textarea>
				</td>
			</tr>
			<tr>
				<td class="TD_STYLE1">招聘要求</td>
				<td colspan="7" class="TD_STYLE2">
					<textarea name="engage_required" rows="4" class="TEXTAREA_STYLE1"></textarea>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript" charset="UTF-8">
		Calendar.setup ({
			inputField : "date_end",
			ifFormat : "%Y-%m-%d", 
			showsTime : false, 
			button : "date_end", 
			singleClick : true, 
			step : 1});
		Calendar.setup ({
			inputField : "date_start",
			ifFormat : "%Y-%m-%d %H:%M:%S", 
			showsTime : false, 
			button : "date_start", 
			singleClick : true, 
			step : 1});
	</script>
</html>