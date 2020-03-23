<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="table.css" type="text/css">
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
	</head>

	<body>
		<form method="post" action="/hr/jsp/question_second_kind_rigister.jsp">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--题库管理设置--试题II级分类设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="window.location.href='/hr/configQuestionFirstKind/getAllForTwo'" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						I级试题编号
					</td>
					<td width="20%" class="TD_STYLE1">
						I级试题名称
					</td>
					<td width="20%" class="TD_STYLE1">
						II级试题编号
					</td>
					<td width="20%" class="TD_STYLE1">
						II级试题名称
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
					<c:forEach var="configQuestionSecondKind" items="${configQuestionSecondKindList }">
						<tr>
							<td class="TD_STYLE1">
								${configQuestionSecondKind.first_kind_id }
							</td>
							<td class="TD_STYLE1">
								${configQuestionSecondKind.first_kind_name }
							</td>
							<td class="TD_STYLE1">
								${configQuestionSecondKind.second_kind_id }
							</td>
							<td class="TD_STYLE1">
								${configQuestionSecondKind.second_kind_name }
							</td>
							<td class="TD_STYLE1">
								<a href="/hr/configQuestionSecondKind/getByQfkIdForUpdate?qskId=${configQuestionSecondKind.qsk_id }">变更</a>
							</td>
							<td class="TD_STYLE1">
								<a href="/hr/configQuestionSecondKind/getByQfkIdForRemove?qskId=${configQuestionSecondKind.qsk_id }">删除</a>
							</td>
						</tr>
					</c:forEach>
				
			</table>
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="/hr/jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>


