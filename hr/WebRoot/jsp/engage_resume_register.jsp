<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="../jsp/table.css" type="text/css" />
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/engageResume/save">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--简历管理--简历登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="提交" class="BUTTON_STYLE1">
						<input type="reset" value="清除" class="BUTTON_STYLE1" >
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="74" class="TD_STYLE1">
						职位分类
					</td>
					<td width="168" class="TD_STYLE2">
						<select name="human_major_kind_name">
							<c:forEach var="list" items="${configMajorKindList }">
								<option value="${list.major_kind_name }" >${list.major_kind_name }</option>
							</c:forEach>
						</select>
					</td>
					<td width="83" class="TD_STYLE1">
						职位名称
					</td>
					<td width="171" class="TD_STYLE2">
						<select name="human_major_name">
							<c:forEach var="list" items="${configMajorList }">
								<option value="${list.major_name }" >${list.major_name }</option>
							</c:forEach>
						</select>
					</td>
					<td width="170" class="TD_STYLE1">
						招聘类型
					</td>
					<td width="138" class="TD_STYLE2">
						<select name="engage_type">
							<option value="社会招聘" selected="selected">社会招聘</option>
							<option value="校园招聘">校园招聘</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_name" />
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_sex">
							<option selected="selected" value="男">男</option>
							<option value="女">女</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_email" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_telephone" />
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_homephone">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_mobilephone" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td width="95" height="26" class="TD_STYLE2" colspan="3">
						<input type="text" name="human_address" />
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_postcode" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_nationality">
							<option value="中国" selected="selected">中国</option>
							<option value="外国">外国</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_birthplace" />
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_birthday" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						民族
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_race">
							<option value="汉族" selected="selected">汉族</option>
							<option value="苗族">苗族</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_religion">
							<option value="无" selected="selected">无</option>
							<option value="佛教">佛教</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_party">
							<option value="无" selected="selected">无</option>
							<option value="党员">党员</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_idcard">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_age">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="human_college">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_educated_degree">
							<option value="本科" selected="selected">本科</option>
							<option value="硕士">硕士</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_educated_years">
							<option value="16" selected="selected">16</option>
							<option value="12">12</option>
							<option value="9">9</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_educated_major">
							<option value="计算机" selected="selected">计算机</option>
							<option value="物理学">物理学</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="demand_salary_standard">
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<jsp:useBean id="now" class="java.util.Date" scope="page"/>
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh-mm-ss" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_specility">
							<option value="数据库" selected="selected">数据库</option>
							<option value="Java">Java</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<select name="human_hobby">
							<option value="篮球" selected="selected">篮球</option>
							<option value="足球">足球</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="human_history_records" rows="4" class="TEXTAREA_STYLE1"></textarea>
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
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>




