<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/engageInterview/save">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--面试管理--面试结果登记
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
				<input type="hidden" value="${getByResIdForInterview.res_id }" name="resume_id">
				<input type="hidden" value="${getByResIdForInterview.human_major_kind_id }" name="human_major_kind_id">
				<input type="hidden" value="${getByResIdForInterview.human_major_kind_name }" name="human_major_kind_name">
				<input type="hidden" value="${getByResIdForInterview.human_major_id }" name="human_major_id">
				<input type="hidden" value="${getByResIdForInterview.human_major_name }" name="human_major_name">
				<tr>
					<td width="74" class="TD_STYLE1">
						姓名
					</td>
					<td width="168" class="TD_STYLE2">}
						${getByResIdForInterview.human_name }
					</td>
					<td width="83" class="TD_STYLE1">
						性别
					</td>
					<td width="171" class="TD_STYLE2">
						${getByResIdForInterview.human_sex }
					</td>
					<td width="170" class="TD_STYLE1">
						EMAIL
					</td>
					<td width="138" class="TD_STYLE2">
						${getByResIdForInterview.human_email }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						民族
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_race }
					</td>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_religion }
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_party }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_idcard }
					</td>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_age }
					</td>
					<td class="TD_STYLE1">
						毕业院校
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_college }
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_educated_degree }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td width="95" height="26" class="TD_STYLE2" colspan="3">
						${getByResIdForInterview.human_educated_years }
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_educated_major }
					</td>
					<td class="TD_STYLE1">
						薪酬要求
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.demand_salary_standard }
					</td>
					<td class="TD_STYLE1">
						注册时间
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.regist_time }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						特长
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_specility }
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.human_hobby }
					</td>
					<td class="TD_STYLE1">
						推荐人
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.checker }
					</td>
					<td class="TD_STYLE1">
						推荐时间
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						${getByResIdForInterview.check_time }
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
					<td colspan="7" class="TD_STYLE2">
						${engageResumeForUpdate.human_history_records }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						${engageResumeForUpdate.remark }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						推荐意见
					</td>
					<td colspan="7" class="TD_STYLE2">
						${engageResumeForUpdate.recomandation }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						面试次数
					</td>
					<td class="TD_STYLE2">
						第${engageInterview.interview_amount }次面试
					</td>
					<td class="TD_STYLE1">
						形象评价
					</td>
					<td class="TD_STYLE2">
						<select name="image_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						口才评价
					</td>
					<td class="TD_STYLE2">
						<select name="native_language_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						外语口语能力
					</td>
					<td class="TD_STYLE2">
						<select name="foreign_language_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						应变能力
					</td>
					<td class="TD_STYLE2">
						<select name="response_speed_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						EQ
					</td>
					<td class="TD_STYLE2">
						<select name="eq_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						IQ
					</td>
					<td class="TD_STYLE2">
						<select name="iq_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						综合素质
					</td>
					<td class="TD_STYLE2">
						<select name="multi_quality_degree">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						面试人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register"/>
					</td>
					<td class="TD_STYLE1">
						面试时间
					</td>
					<td class="TD_STYLE2">
						${engageInterview.registe_time }
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						面试评价
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="interview_comment" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>




