<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">



















































































	 






















<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath%>jsp/table.css" type="text/css">
<script type="text/javascript">
function list()
{
	document.forms[0].action = document.forms[0].action + "?operate=list&status=0&method=check";
	document.forms[0].submit();
}
</script>
</head>
<body>
<form method="post" action="salarystandard.do">
<table width="100%" >
  <tr>
    <td colspan="2"> 
    <font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准复核</font></td>
  </tr>
  <tr>
    <td width="49%"> 复核成功，谢谢！</td>
    <td width="51%" align="right">
    <input type="button" value="返回" class="BUTTON_STYLE1" onclick="javascript:list();"></td></tr>
  </table>

</form>
</body>
</html>

