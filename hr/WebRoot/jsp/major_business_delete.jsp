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
	//业务名称和要删除的名字以及类型
	var business = decodeURI("${param.business}","utf-8");
	var delete_name = decodeURI("${param.delete_name}","utf-8");
	var delete_kind = decodeURI("${param.delete_kind}","utf-8");
	//要跳转到的controller
	var controller = "";
	if(business=="职位设置"){
		controller = "configMajor";
	}else if(business=="职位分类设置"){
		controller = "configMajorKind";
	}else if(business=="公共属性设置" || business=="职称设置"){
		controller = "configPublicChar";
	}
	
	var url = "/hr/"+ controller +"/toDelete?delete_name="+delete_name;
	//显示的信息
	var theMessage = delete_name;
	//处理现实的信息和URL地址
	if(business=="公共属性设置" || business=="职称设置"){
		theMessage = "[" + delete_kind + "]" + delete_name;
		url = url + "&delete_kind="+delete_kind;
	};
	function decode(){
		$("#business").html("您正在做的业务是：人力资源--客户化设置--人力资源档案管理设置--"+business);
		$("#delete_name").html(" 您确认删除 "+ theMessage +" 这条记录吗? ");
	};
	function toDelete(){
		$.ajax({
			type : "post",
			url : url,
			dataType : "json",
			success:function(result){
				if(result==false){
					alert("删除失败！");
				};
				if(business=="职称设置"){
					location.href="/hr/"+ controller +"/selectTheSameAttribute?attribute_kind=职称";
				}else{
					location.href="/hr/"+ controller +"/selectAll";
				};
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

