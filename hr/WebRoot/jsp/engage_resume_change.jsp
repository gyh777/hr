<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css" />
		<script type="text/javascript" src="/hr/jsp/javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/engageResume/update">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--简历管理--简历筛选
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
				<input type="hidden" value="${engageResumeForUpdate.res_id }" name="res_id">
				<input type="hidden" value="${engageResumeForUpdate.register }" name="register">
				<input type="hidden" value="${engageResumeForUpdate.regist_time }" name="regist_time">
				<tr>
					<td width="74" class="TD_STYLE1">
						职位分类
					</td>
					<td width="168" class="TD_STYLE1">
						<select name="human_major_kind_name">
							<option value="${engageResumeForUpdate.human_major_kind_name }" selected="selected">${engageResumeForUpdate.human_major_kind_name }</option>
							<c:forEach var="list" items="${configMajorKindList }">
								<option value="${list.major_kind_name }" >${list.major_kind_name }</option>
							</c:forEach>
						</select>
					</td>
					<td width="83" class="TD_STYLE1">
						职位名称
					</td>
					<td width="171" class="TD_STYLE1">
						<select name="human_major_name">
							<option value="${engageResumeForUpdate.human_major_name }" selected="selected">${engageResumeForUpdate.human_major_name }</option>
							<c:forEach var="list" items="${configMajorList }">
								<option value="${list.major_name }" >${list.major_name }</option>
							</c:forEach>
						</select>
					</td>
					<td width="170" class="TD_STYLE1">
						招聘类型
					</td>
					<td width="138" class="TD_STYLE1">
						<select name="engage_type">
							<option value="${engageResumeForUpdate.engage_type }" selected="selected">${engageResumeForUpdate.engage_type }</option>
							<option value="社会招聘">社会招聘</option>
							<option value="校园招聘">校园招聘</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_name" value="${engageResumeForUpdate.human_name }"/>
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_sex">
							<option value="${engageResumeForUpdate.human_sex }" selected="selected">${engageResumeForUpdate.human_sex }</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_email" value="${engageResumeForUpdate.human_email }" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_telephone" value="${engageResumeForUpdate.human_telephone }" />
					</td>
					<td class="TD_STYLE1">
						家庭电话
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_homephone" value="${engageResumeForUpdate.human_homephone }">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_mobilephone" value="${engageResumeForUpdate.human_mobilephone }" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td width="95" height="26" class="TD_STYLE1" colspan="3">
						<input type="text" name="human_address" value="${engageResumeForUpdate.human_address }" />
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_postcode" value="${engageResumeForUpdate.human_postcode }" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_nationality">
							<option value="${engageResumeForUpdate.human_nationality }" selected="selected">${engageResumeForUpdate.human_nationality }</option>
							<option value="中国">中国</option>
							<option value="外国">外国</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_birthplace" value="${engageResumeForUpdate.human_birthplace }"/>
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_birthday" value="${engageResumeForUpdate.human_birthday }" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						民族
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_race">
							<option value="${engageResumeForUpdate.human_race }" selected="selected">${engageResumeForUpdate.human_race }</option>
							<option value="汉族">汉族</option>
							<option value="苗族">苗族</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_religion">
							<option value="${engageResumeForUpdate.human_religion }" selected="selected">${engageResumeForUpdate.human_religion }</option>
							<option value="无">无</option>
							<option value="佛教">佛教</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_party">
							<option value="${engageResumeForUpdate.human_party }" selected="selected">${engageResumeForUpdate.human_party }</option>
							<option value="无">无</option>
							<option value="党员">党员</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_idcard" value="${engageResumeForUpdate.human_idcard }">
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_age" value="${engageResumeForUpdate.human_age }">
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="human_college" value="${engageResumeForUpdate.human_college }">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_educated_degree">
							<option value="${engageResumeForUpdate.human_educated_degree }" selected="selected">${engageResumeForUpdate.human_educated_degree }</option>
							<option value="本科">本科</option>
							<option value="硕士">硕士</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_educated_years">
							<option value="${engageResumeForUpdate.human_educated_years }" selected="selected">${engageResumeForUpdate.human_educated_years }</option>
							<option value="16">16</option>
							<option value="12">12</option>
							<option value="9">9</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_educated_major">
							<option value="${engageResumeForUpdate.human_educated_major }" selected="selected">${engageResumeForUpdate.human_educated_major }</option>
							<option value="计算机">计算机</option>
							<option value="物理学">物理学</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<input type="text" name="demand_salary_standard" value="${engageResumeForUpdate.demand_salary_standard }">
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<fmt:formatDate type="both" value="${engageResumeForUpdate.regist_time }"></fmt:formatDate>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_specility">
							<option value="${engageResumeForUpdate.human_specility }" selected="selected">${engageResumeForUpdate.human_specility }</option>
							<option value="数据库">数据库</option>
							<option value="Java">Java</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<select name="human_hobby">
							<option value="${engageResumeForUpdate.human_hobby }" selected="selected">${engageResumeForUpdate.human_hobby }</option>
							<option value="篮球">篮球</option>
							<option value="足球">足球</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人信息
					</td>
					<td colspan="7" class="TD_STYLE1">
						<textarea name="human_history_records" rows="4" class="TEXTAREA_STYLE1">${engageResumeForUpdate.human_history_records }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE1">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1">${engageResumeForUpdate.remark }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td colspan="7" class="TD_STYLE1">
						<textarea name="recomandation" rows="4" class="TEXTAREA_STYLE1">${engageResumeForUpdate.recomandation }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						是否推荐面试
					</td>
					<td class="TD_STYLE1">
						<input type="radio" name="interview_status" value="2">
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>