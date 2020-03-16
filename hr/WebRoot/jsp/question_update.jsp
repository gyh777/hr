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
		<form name="salarystandardForm" method="post" action="/hr/engageSubjects/update">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试题库管理--试题变更
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
						试题I级分类
					</td>
					<td width="168" class="TD_STYLE2">
						<select name="first_kind_id">
							
						</select>
					</td>
					<td width="83" class="TD_STYLE1">
						试题II级分类
					</td>
					<td width="171" class="TD_STYLE2">
						<select name="second_kind_id">
							
						</select>
					</td>
					<td width="170" class="TD_STYLE1">
						改变人
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="changer" value="" class="INPUT_STYLE2">
					</td>
					<td width="103" class="TD_STYLE1">
						登记时间
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						题干
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="content" rows="4" class="TEXTAREA_STYLE1">${engageSubjects.content }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案a
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_a" rows="4" class="TEXTAREA_STYLE1">${engageSubjects.key_a }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案b
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_b" rows="4" class="TEXTAREA_STYLE1">${engageSubjects.key_b }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案c
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_c" rows="4" class="TEXTAREA_STYLE1">${engageSubjects.key_c }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案d
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_d" rows="4" class="TEXTAREA_STYLE1">${engageSubjects.key_d }</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案e
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_e" rows="4" class="TEXTAREA_STYLE1">${engageSubjects.key_e }</textarea>
					</td>
				</tr>
				<tr>
					<td width="74" class="TD_STYLE1">
						正确答案
					</td>
					<td width="168" class="TD_STYLE2">
						<input type="text" name="correct_key" value="${engageSubjects.correct_key }" class="INPUT_STYLE2">
					</td>
					<td width="83" class="TD_STYLE1">
						试题出处
					</td>
					<td width="171" class="TD_STYLE2">
						<input type="text" name="derivation" value="${engageSubjects.derivation }" class="INPUT_STYLE2">
					</td>
					<td width="170" class="TD_STYLE1">
						<input type="hidden" value="${engageSubjects.sub_id }" name="sub_id">
						<input type="hidden" value="${engageSubjects.first_kind_id }" name="first_kind_id">
						<input type="hidden" value="${engageSubjects.second_kind_id }" name="second_kind_id">
						<input type="hidden" value="${engageSubjects.register }" name="register">
					</td>
					<td width="138" class="TD_STYLE2">
						
					</td>
					<td width="103" class="TD_STYLE1">
						
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						
					</td>
				</tr>
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>




