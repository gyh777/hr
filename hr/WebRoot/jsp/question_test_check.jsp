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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css" />
		<script type="text/javascript" src="/hr/jsp/javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/engageAnswer/updateForTestCheck">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试管理--成绩查询筛选
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
						姓名
					</td>
					<td width="168" class="TD_STYLE1">
						${engageResume.human_name }
					</td>
					<td width="83" class="TD_STYLE1">
						性别
					</td>
					<td width="171" class="TD_STYLE1">
						${engageResume.human_sex }
					</td>
					<td width="170" class="TD_STYLE1">
						EMAIL
					</td>
					<td width="138" class="TD_STYLE1">
						${engageResume.human_email }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						民族
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_race }
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_religion }
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_party }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_idcard }
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_age }
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_college }
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_educated_degree }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_educated_years }
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_educated_major }
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.demand_salary_standard }
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<fmt:formatDate type="both" value="${engageResume.regist_time }"></fmt:formatDate>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_specility }
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.human_hobby }
					</td>
					<td class="TD_STYLE1">
						推荐人
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						${engageResume.checker }
					</td>
					<td class="TD_STYLE1">
						推荐时间
					</td>
					<td width="95" height="26" class="TD_STYLE1">
						<fmt:formatDate type="both" value="${engageResume.check_time }"></fmt:formatDate>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						档案附件
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人信息
					</td>
					<td colspan="7" class="TD_STYLE1">
						${engageResume.human_history_records }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE1">
						${engageResume.remark }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td colspan="7" class="TD_STYLE1">
						${engageResume.recomandation }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						考试次数
					</td>
					<td class="TD_STYLE1">
						参加${engageResume.test_amount }次考试
					</td>
					<td class="TD_STYLE1">
						成绩平均分
					</td>
					<td class="TD_STYLE1">
						${engageResume.total_points }
					</td>
					<td class="TD_STYLE1">
						筛选人
					</td>
					<td class="TD_STYLE1">
						<input type="hidden" value="${engageResume.res_id }" name="res_id">
						<input type="text" name="test_checker">
					</td>
					<td class="TD_STYLE1">
						筛选时间
					</td>
					<td class="TD_STYLE1">
						<jsp:useBean id="now" class="java.util.Date" scope="page"/>
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh-mm-ss" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						录用申请审核意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="pass_checkComment" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>