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
		<script type="text/javascript" src="../jsp/javascript/xy/insertAndUpdate.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/xy/nowDate.js" charset="UTF-8"></script>
		<script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
		<title>无标题文档</title>
		
		<script type="text/javascript">
function myoption1(){
var options=$("#standardId option:selected");
$("#standardName").val(options.attr("myvalue"));
$("#salaryStandardSum").val(options.attr("mysalarysum"));

}

function myoption2(){
var options=$("#standardName option:selected");
$("#standardId").val(options.attr("myvalue"));
$("#salaryStandardSum").val(options.attr("mysalarysum")); 
}

function standardIdAndName(){
$.ajax({
dataType:"json",
url:'/hr/salarygrant/standardIdAndName',
type:'POST',
contentType : 'application/json;charset=utf-8',
async: true,
success:function(date){
alert(date);
$.each(date,function(index,item){
							$('#standardName').append("<option myvalue='"+item.standardId+"' mysalarysum='"+item.salarySum+"'>"+item.standardName+"</option>");
                             $('#standardId').append("<option myvalue='"+item.standardName+"' mysalarysum='"+item.salarySum+"'>"+item.standardId+"</option>");//往下拉菜单里添加元素
                         })

},
error:function(){alert("error")}
});
};

function mySubmit(){

var form = document.getElementById("salarygrantForm");

form.submit();

}

function nextId(){
$.ajax({
dataType:"json",
url:'/hr/salarygrant/nextId',
type:'POST',
contentType : 'application/json;charset=utf-8',
async: true,
success:function(date){
alert(date);
$('#salaryGrantId').val(date);

},
error:function(){alert("error11")}
});
}



</script>
	</head>



	<body onload="loadFirstAndKindName();standardIdAndName();nextId();getNowDate()">
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
				<td class="TD_STYLE1">
						发放编号
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="salaryGrantId" id="salaryGrantId" value="" readonly="readonly" class="INPUT_STYLE2">
					</td>				
				<td class="TD_STYLE1" width="10%">I级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="first_kind_id" id="first_kind_id" value="">
					
					<select name="firstKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">II级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="second_kind_id" id="second_kind_id" value="">
					
					<select name="secondKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">III级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="third_kind_id" id="third_kind_id" value="">
					
					<select name="thirdKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
					</select>
				</td>
					<!-- 
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
					</td> -->
					
				</tr>
				
				<tr>
				
					<td width="74" class="TD_STYLE1">
						薪酬标准编号
					</td>
					<td width="168" class="TD_STYLE2"><!-- 应该从数据库薪酬表取最大主键+1 -->
						<select name="salaryStandardId" id="standardId" class="SELECT_STYLE1" onchange="myoption1()">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="83" class="TD_STYLE1">
						薪酬标准名称
					</td>
					<td width="171" class="TD_STYLE2">
					<select name="standardName" id="standardName" class="SELECT_STYLE1" onchange="myoption2()">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="170" class="TD_STYLE1">
						薪酬总额
					</td>
					<td width="138" class="TD_STYLE2">
						<input type="text" name="salaryStandardSum" id="salaryStandardSum" value="0" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						人员总数
					</td>
					
					<td class="TD_STYLE2">
						<input type="text" name="humanAmount" value="" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<!-- <td width="103" class="TD_STYLE1">
						制定人
					</td>
					<td width="95" height="26" class="TD_STYLE2">
						<input type="text" name="designer" value="" class="INPUT_STYLE2">
					</td> -->
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
						<input type="text" name="registTime" id="time" value="" readonly="readonly" class="INPUT_STYLE2">
					</td>
					
					
				</tr>
				</table>
				<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="14%" class="TD_STYLE1">
						职工id
					</td>
					<td width="15%" class="TD_STYLE1">
						职工姓名
					</td>
					<td width="14%" class="TD_STYLE1">
						奖金
					</td>
					<td width="14%" class="TD_STYLE1">
						销售绩效金额
					</td>
					<td width="14%" class="TD_STYLE1">
						应扣金额
					</td>
					<td width="14%" class="TD_STYLE1">
						薪酬
					</td>
					<td width="15%" class="TD_STYLE1">
						应付职工薪酬
					</td>
				</tr>
				</table>
				<table id="humanFile" width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				
				
				
				<!-- 
				$.each(date,function(index,item){
							$('#standardName').append("<option myvalue='"+item.standardId+"' mysalarysum='"+item.salarySum+"'>"+item.standardName+"</option>");
                             $('#standardId').append("<option myvalue='"+item.standardName+"' mysalarysum='"+item.salarySum+"'>"+item.standardId+"</option>");//往下拉菜单里添加元素
                         })

				}
				 -->
				
				
			</table>
			<p>
				&nbsp;
			</p>
		</form>
	</body>
</html>




