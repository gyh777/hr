<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css">
<script type="text/javascript" src="/hr/jsp/javascript/comm/comm.js"></script>
</head>
<body>
	<form method="post" action="">
		<table width="100%" >
	 		<tr>
	    		<td width="49%">错误： ${msg }</td>
	    	</tr>
	  	</table>
	</form>
</body>
</html>