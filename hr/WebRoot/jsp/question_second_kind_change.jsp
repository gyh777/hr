<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="table.css" type="text/css">
<script type="text/javascript" src="javascript/comm/comm.js"></script>
</head>
<body>
<form name="configfilefirstkindForm" method="post" action="/hr/configQuestionSecondKind/update">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--题库管理设置--试题II级分类设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="submit" value="提交" class="BUTTON_STYLE1">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();"></td>
  </tr>
  </table>
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
  	<input type="hidden" value="${changeConfigQuestionSecondKind.qsk_id }" name="qsk_id">
  	<input type="hidden" value="${changeConfigQuestionSecondKind.first_kind_id }" name="first_kind_id">
  	<input type="hidden" value="${changeConfigQuestionSecondKind.first_kind_name }" name="first_kind_name">
  	<input type="hidden" value="${changeConfigQuestionSecondKind.second_kind_id }" name="second_kind_id">
    <td width="19%" class="TD_STYLE1">试题II级名称</td>
    <td width="81%" class="TD_STYLE2"><input type="text" name="second_kind_name" value="${changeConfigQuestionSecondKind.second_kind_name }" class="INPUT_STYLE1"></td>
  </tr>
</table>
</form>
</body>
</html>
