<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="<%=basePath%>jsp/table.css" type="text/css">
		<script type="text/javascript" src="<%=basePath%>jsp/javascript/comm/comm.js"></script>
		
	    <script type="text/javascript" src="<%=basePath%>jsp/javascript/cy/first_kind.js"></script>
		<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
	</head>

	<body >
		<form method="post" id="First">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--I级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="rigistFirstKind()" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="20%" class="TD_STYLE1">
						I级机构编号
					</td>
					<td width="20%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="25%" class="TD_STYLE1">
						薪酬发放责任人编号
					</td>
					<td width="25%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="5%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				<c:forEach items="${requestScope.map}" var="u">
					<tr>
						<td id="firstKindId" class="TD_STYLE2">
							${u.first_kind_id}
						</td>
						<td class="TD_STYLE2">
							${u.first_kind_name}
						</td>
						<td class="TD_STYLE2">
							${u.first_kind_salary_id }
						</td>
						<td class="TD_STYLE2">
							${u.first_kind_sale_id }
						</td>
						<td class="TD_STYLE2">
						     <input type="button" value="变更" class="BUTTON_STYLE1" onclick="changeFirstKind(this)">
						</td>
						<td class="TD_STYLE2">
							<input type="button" value="删除" class="BUTTON_STYLE1" onclick="deleteFirstKind(this)">
						</td>
					</tr>
				 </c:forEach>
			</table>
			<p>&nbsp;&nbsp;总数：1例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>


