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
		<link rel="stylesheet" href="<%=basePath%>jsp/table.css" type="text/css" />
		<script type="text/javascript" src="javascript/comm/comm.js"></script>
		<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../jsp/javascript/xy/nowDate.js" charset="UTF-8"></script>
		<title>无标题文档</title>
	</head>

<script type="text/javascript">
function mySubmit(){

var form = document.getElementById("salarystandardForm");

form.submit();

}

function nextId(){
$.ajax({
dataType:"json",
url:'/hr/salarystandard/nextId',
type:'POST',
contentType : 'application/json;charset=utf-8',
async: true,
success:function(date){
$('#standardId').val(date);//ssid

},
error:function(){alert("error")}
});
}

function out(){

var zero=$("#salaryStandardDetailszerosalary").val();
var one=$("#salaryStandardDetailsonesalary").val();
var two=$("#salaryStandardDetailstwosalary").val();
var three=$("#salaryStandardDetailsthreesalary").val();
var four=$("#salaryStandardDetailsfoursalary").val();
var five=$("#salaryStandardDetailsfivesalary").val();

var salarySum=parseInt(zero)+parseInt(one)+parseInt(two)+parseInt(three)+parseInt(four)+parseInt(five);
$("#salarySum").val(salarySum);
}

</script>

	<body onload="nextId();getNowDate()">
		<form name="salarystandardForm" id="salarystandardForm" method="post" action="/hr/salarystandard/register">
			
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
						<input type="text" name="standardId" id="standardId" value="" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td width="83" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="171" class="TD_STYLE2">
						<input type="text" name="standardName" value="1" class="INPUT_STYLE2">
					</td>
					<td width="170" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="salarySum" id="salarySum" readonly="readonly"  class="INPUT_STYLE2">
					</td>
					<td width="103" class="TD_STYLE1">
						&nbsp;
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						制定人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="designer" value="" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" value="better_wanghao" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						登记时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="registTime" id="time" value="2010-05-29 03:13:27" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						&nbsp;
					</td>
					<td class="TD_STYLE2">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr class="TD_STYLE1">
					<td align="center">
						序号
					</td>
					<td colspan="3">
						薪酬项目名称
					</td>
					<td>
						金额
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						1
						<input type="hidden" name="salaryStandardDetails[0].itemId" value="1">
					</td>
					<td colspan="3">
						出差补助
						<input type="hidden" name="salaryStandardDetails[0].itemName" value="出差补助">
					</td>
					<td>
						<input type="text" name="salaryStandardDetails[0].salary" id="salaryStandardDetailszerosalary" onblur="out()" value="0" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						2
						<input type="hidden" name="salaryStandardDetails[1].itemId" value="2">
					</td>
					<td colspan="3">
						交通补贴
						<input type="hidden" name="salaryStandardDetails[1].itemName" value="交通补贴">
					</td>
					<td>
						<input type="text" id="salaryStandardDetailsonesalary" value="0"  name="salaryStandardDetails[1].salary" onblur="out()" value="" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						3
						<input type="hidden" name="salaryStandardDetails[2].itemId" value="3">
					</td>
					<td colspan="3">
						住房补贴
						<input type="hidden" name="salaryStandardDetails[2].itemName" value="住房补贴">
					</td>
					<td>
						<input type="text" id="salaryStandardDetailstwosalary" value="0"  name="salaryStandardDetails[2].salary" onblur="out()" value="" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						4
						<input type="hidden" name="salaryStandardDetails[3].itemId" value="4">
					</td>
					<td colspan="3">
						基本工资
						<input type="hidden" name="salaryStandardDetails[3].itemName" value="基本工资">
					</td>
					<td>
						<input type="text" id="salaryStandardDetailsthreesalary" value="0"  name="salaryStandardDetails[3].salary" onblur="out()" value="" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						5
						<input type="hidden" name="salaryStandardDetails[4].itemId" value="5">
					</td>
					<td colspan="3">
						年终奖
						<input type="hidden" name="salaryStandardDetails[4].itemName" value="年终奖">
					</td>
					<td>
						<input type="text" id="salaryStandardDetailsfoursalary" value="0"  name="salaryStandardDetails[4].salary" onblur="out()" value="" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
				<tr class="TD_STYLE2">
					<td align="center">
						6
						<input type="hidden" name="salaryStandardDetails[5].itemId" value="6">
					</td>
					<td colspan="3">
						误餐补助
						<input type="hidden" name="salaryStandardDetails[5].itemName" value="误餐补助">
					</td>
					<td>
						<input type="text" id="salaryStandardDetailsfivesalary" value="0"  name="salaryStandardDetails[5].salary" onblur="out()" value="" class="INPUT_STYLE2">
					</td>
					<td colspan="3">
						&nbsp;
					</td>
				</tr>
				
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>




