<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="../jsp/table.css" type="text/css">
<script type="text/javascript" src="javascript/comm/comm.js"></script>
<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js"></script>
<script type="text/javascript">
	var delete_names = decodeURI("${param.delete_name}","utf-8");
	var businesss = decodeURI("${param.business}","utf-8");
	function decode(){
		$("#business").html("您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--"+businesss);
		$("#delete_name").html(" 您确认删除 "+ delete_names +" 这条记录吗? ");
	};
	function toDelete(){
		var controller = "";
		if(businesss=="职位设置"){
			controller = "configMajor";
		}else if(businesss=="职位分类设置"){
			controller = "configMajorKind";
		}
		$.ajax({
			type : "post",
			url : "/hr/"+ controller +"/toDelete?delete_name="+delete_names,
			dataType : "json",
			success:function(result){
				if(result==false){
					alert("删除失败！");
				};
				location.href="/hr/"+ controller +"/selectAll";
			},
			error:function(error){
				alert("删除失败！");
			}
		});
	};
</script>
</head>
<body onload="decode()">
<form method="post" action="configprofessiondesign.do">
<table width="100%" >
  <tr>
    <td colspan="2"><font color="#0000CC" id="business"></font></td>
  </tr>
  <tr>
    <td width="49%" id="delete_name"></td>
    <td width="51%" align="right"><input type="button" value="删除" class="BUTTON_STYLE1" onclick="toDelete()">
      <input type="button" value="返回" class="BUTTON_STYLE1" onclick="history.back();"></td>
  </tr>
  </table>

</form>
</body>
</html>

