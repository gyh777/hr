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
	    <script type="text/javascript" src="<%=basePath%>jsp/javascript/cy/third_kind.js"></script>
	    <script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
	</head>

	<body >
		<form method="post" id="Third">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="rigistThirdKind()" />
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" id="content">
				<tr >
				    <td width="14%" class="TD_STYLE1">
						III级机构编号
					</td>
					<td width="14%" class="TD_STYLE1">
						I级机构编号
					</td>
					<td width="14%" class="TD_STYLE1">
						I级机构名称
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构编号
					</td>
					<td width="14%" class="TD_STYLE1">
						II级机构名称
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构编号
					</td>
					<td width="14%" class="TD_STYLE1">
						III级机构名称
					</td>
					
					<td width="18%" class="TD_STYLE1">
						销售责任人编号
					</td>
					<td width="18%" class="TD_STYLE1">
						是否零售
					</td>
					<td width="6%" class="TD_STYLE1">
						变更
					</td>
					<td width="5%" class="TD_STYLE1">
						删除
					</td>
				</tr>
				<c:forEach items="${requestScope.thirdList}" var="u">
					<tr>
						<td id="thirdKindId" class="TD_STYLE2">
							${u.third_kind_id}
						</td>
						<td id="firstKindId" class="TD_STYLE2">
							${u.first_kind_id}
						</td>
						
						<td class="TD_STYLE2">
							${u.first_kind_name }
						</td>
						<td class="TD_STYLE2">
							${u.second_kind_id }
						</td>
						<td class="TD_STYLE2">
							${u.second_kind_name }
						</td>
						<td class="TD_STYLE2">
							${u.third_kind_id }
						</td>
						<td class="TD_STYLE2">
							${u.third_kind_name }
						</td>
						<td class="TD_STYLE2">
							${u.third_kind_sale_id }
						</td>
						<td class="TD_STYLE2">
							${u.third_kind_is_retail }
						</td>
						<td class="TD_STYLE2">
						     <input type="button" value="变更" class="BUTTON_STYLE1" onclick="changeThirdKind(this)">
						</td>
						<td class="TD_STYLE2">
							<input type="button" value="删除" class="BUTTON_STYLE1" onclick="deleteThirdKind(this)">
						</td>
					</tr>
				 </c:forEach>
			</table>
			<input type="hidden" id="pageSize" display="none" value="${requestScope.pageSize}"></input>
			<input type="hidden" id="pageNo" display="none" value="${requestScope.pageNo}"></input>
			 <p>&nbsp;&nbsp;总数：${requestScope.pageSize}例 &nbsp;&nbsp;&nbsp;当前第 ${requestScope.pageNo} 页  &nbsp;&nbsp;&nbsp;共 ${requestScope.pageSum} 页  &nbsp;&nbsp;&nbsp;跳到第 <input id="page" type="text" > 页&nbsp;&nbsp;<input type="button" value="跳转" width=18 height=18 border=0 onclick="jumpPage()">
		</form>
	</body>
</html>


