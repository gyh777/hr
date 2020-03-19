<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script type="text/javascript" src="javascript/comm/select.js"></script>
		<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
		<title>无标题文档</title>
	</head>

<script type="text/javascript">

window.onload=function(){
$.ajax({
dataType:"json",
url:'/hr/salarygrant/standardIdAndName',
type:'POST',
contentType : 'application/json;charset=utf-8',
async: true,
success:function(date){
alert(date);
$.each(date,function(index,item){
							$('#standardName').append("<option name='"+item.standardId+"'>"+item.standardName+"</option>");
                             $('#standardId').append("<option name='"+item.standardName+"'>"+item.standardId+"</option>");//往下拉菜单里添加元素
                         })

},
error:function(){alert(23)}
});
};

function mySubmit(){

var form = document.getElementById("salarygrantForm");

form.submit();

}



</script>

	<body>
		<form name="salarygrantForm" id="salarygrantForm" method="post" action="/hr/salarygrant/register">
			
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--薪酬标准管理--薪酬标准登记
						</font>
					</td>
				</tr>
				<tr>
					<td align="right">
					    <!-- <input type="button" value="提交" onclick="window.location.href='salarystandard_register_success.jsp'" class="BUTTON_STYLE1"> -->
						<input type="button" value="提交" onclick="mySubmit()">
						<input type="reset" value="清除" class="BUTTON_STYLE1" >
					</td>
				</tr>
			</table>
			
			
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="74" class="TD_STYLE1">
						薪酬标准编号
					</td>
					<td width="168" class="TD_STYLE2"><!-- 应该从数据库薪酬表取最大主键+1 -->
						<select name="standardId" id="standardId" class="SELECT_STYLE1" onchange="">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="83" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="171" class="TD_STYLE2">
					<select name="standardName" id="standardName" class="SELECT_STYLE1" onchange="">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="170" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="salaryStandardSum" value="0" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<!-- <td width="103" class="TD_STYLE1">
						制定人
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="designer" value="" class="INPUT_STYLE2">
					</td> -->
				</tr>
				<tr>
					
					
					<td class="TD_STYLE1" width="10%">I级机构</td>
					<td width="15%" class="TD_STYLE2">
						<select name="firstKindName" class="SELECT_STYLE1" onchange="">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">II级机构</td>
					<td width="15%" class="TD_STYLE2">
						<select name="secondKindName" class="SELECT_STYLE1" onchange="">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">III级机构</td>
					<td width="15%" class="TD_STYLE2">
						<select name="thirdKindName" class="SELECT_STYLE1">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td class="TD_STYLE1">
						人员总数
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="humanAmount" value="" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						总薪酬
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="salaryPaidSum" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" value="better_wanghao" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="registTime" value="2010-05-29 03:13:27" readonly="readonly" class="INPUT_STYLE2">
					</td>
					
					
				</tr>
				
				
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>




