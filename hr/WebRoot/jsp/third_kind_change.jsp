<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">















<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="<%=basePath%>/jsp/table.css" type="text/css">
<script type="text/javascript" src="<%=basePath%>jsp/javascript/comm/comm.js"></script>
<script type="text/javascript" src="<%=basePath%>jsp/javascript/cy/second_kind_change.js"></script>
</head>
<body>
<form id="changeThird" name="configfilefirstkindForm" method="post">
<table width="100%" >
  <tr>
    <td> 
    <font color="#0000CC">您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--II级机构设置 </font></td>
  </tr>
  <tr>
    <td align="right"><input type="button" value="提交" class="BUTTON_STYLE1" onclick="changeThirdKind()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();"></td>
  </tr>
  </table>
  
<table width="100%"  border="1" cellpadding=0 cellspacing=1 bordercolorlight=#848284 bordercolordark=#eeeeee class="TABLE_STYLE1">
  <tr>
    <td width="19%" class="TD_STYLE1">III级机构编号</td>
    <td width="81%" class="TD_STYLE2"><input type="text" name="thirdKindId" value="${fileThirdKind.third_kind_id}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td width="19%" class="TD_STYLE1">I级机构编号</td>
    <td width="81%" class="TD_STYLE2"><input type="text" name="firstKindId" value="${fileThirdKind.first_kind_id}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">I级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="firstKindName" value="${fileThirdKind.first_kind_name}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
   <tr>
    <td width="19%" class="TD_STYLE1">I级机构编号</td>
    <td width="81%" class="TD_STYLE2"><input type="text" name="secondKindId" value="${fileThirdKind.second_kind_id}" readonly="readonly" class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">II级机构名称</td>
    <td class="TD_STYLE2"><input type="text" name="secondKindName" value="${fileThirdKind.second_kind_name}"  class="INPUT_STYLE1"></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">销售责任人编号（多个编号之间请用"半角逗号"加"一个空格"隔开，如", "）</td>
    <td class="TD_STYLE2"><textarea name="thirdKindSaleId" rows="4" class="TEXTAREA_STYLE1">${fileThirdKind.third_kind_sale_id}</textarea></td>
  </tr>
  <tr>
    <td class="TD_STYLE1">是否零售</td>
    <td class="TD_STYLE2"><textarea name="thirdKindIsRetail" rows="4" class="TEXTAREA_STYLE1">${fileThirdKind.third_kind_is_retail}</textarea></td>
  </tr>
</table>
</form>

</body>
</html>
