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
		<link rel="stylesheet" href="table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<title>无标题文档</title>
	</head>

	<body>
		<form name="salarystandardForm" method="post" action="/hr/engageSubjects/save">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试题库管理--试题登记
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
						<select>
							<c:forEach var="list" items="${configQuestionSecondKindList }">
								<option value="${list.first_kind_name }">${list.first_kind_name }</option>
							</c:forEach>
						</select>
					</td>
					<td width="83" class="TD_STYLE1">
						试题II级分类
					</td>
					<td width="171" class="TD_STYLE2">
						<select name="second_kind_name">
							<c:forEach var="list" items="${configQuestionSecondKindList }">
								<option value="${list.qsk_id }">${list.second_kind_name }</option>
							</c:forEach>
						</select>
					</td>
					<td width="170" class="TD_STYLE1">
						登记人
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="register" value="" class="INPUT_STYLE2">
					</td>
					<td width="103" class="TD_STYLE1">
						登记时间
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<jsp:useBean id="now" class="java.util.Date" scope="page"/>
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh-mm-ss" />
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						题干
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="content" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案a
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_a" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案b
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_b" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案c
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_c" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案d
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_d" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						答案e
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="key_e" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td width="74" class="TD_STYLE1">
						正确答案
					</td>
					<td width="168" class="TD_STYLE2">
						<input type="text" name="correct_key" value="" class="INPUT_STYLE2">
					</td>
					<td width="83" class="TD_STYLE1">
						试题出处
					</td>
					<td width="171" class="TD_STYLE2">
						<input type="text" name="derivation" value="" class="INPUT_STYLE2">
					</td>
					<td width="170" class="TD_STYLE1">
						
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




