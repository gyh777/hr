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
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript">
			function toDelete(delete_name,business){
				delete_name = encodeURI(encodeURI(delete_name));
				business = encodeURI(encodeURI(business));
				location.href="/hr/jsp/major_business_delete.jsp?delete_name="+delete_name+"&business="+business;
			};
		</script>
	</head>

	<body>
		<form method="post" action="configmajor.do">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--职位设置
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="添加" class="BUTTON_STYLE1"
							onclick="toAdd();">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="22%" class="TD_STYLE1">职位分类编号</td>
					<td width="23%" class="TD_STYLE1">职位分类名称</td>
					<td width="26%" class="TD_STYLE1">职位编号</td>
					<td width="24%" class="TD_STYLE1">职位名称</td>
					<td width="5%" class="TD_STYLE1">删除</td>
				</tr>
				<c:forEach items="${majorList}" var="list">
                    <tr>
                        <td class="TD_STYLE2">${list.major_kind_id }</td>
                        <td class="TD_STYLE2">${list.major_kind_name }</td>
                        <td class="TD_STYLE2">${list.major_id }</td>
                        <td class="TD_STYLE2">${list.major_name }</td>
						<td class="TD_STYLE2">
							<!-- <a href="javascript:void(0);" 
								onclick="toDelete(this,'${list.major_name }')">删除</a> -->
							<a href="javascript:void(0);" 
								onclick="toDelete('${list.major_name }','职位设置')">删除</a>
						</td>
                    </tr>
                </c:forEach>
			</table>
			<p>&nbsp;&nbsp;总数：${fn:length(majorList) }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="../jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
	</body>
</html>



