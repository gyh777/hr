<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" href="../jsp/table.css" type="text/css">
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/select.js"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js"></script>
		<script type="text/javascript" src="../jsp/javascript/yhy/util.js"></script>
		<script type="text/javascript">
			var list = ${notCheckList };
			function loadMajorChange(){
				$("input[name='check_time']").val(getNowDate(2));
				$.each(${notCheckList }, function (i, value) {
					//审核状态：1为未审核，2为审核中，3位审核完毕
					var checkStatus = value.check_status;
					var checkStatusMessage = "";
					if(checkStatus=="1"){
						checkStatusMessage = "未审核";
					}else if(checkStatus=="2"){
						checkStatusMessage = "审核中";
					}else if(checkStatus=="3"){
						checkStatusMessage = "通过";
					}else if(checkStatus=="4"){
						checkStatusMessage = "不通过";
					};
					var content = 
					"<tr >"
						+"<td class='TD_STYLE2'>"+ value.mch_file_number +"</td>"
						+"<td class='TD_STYLE2'>"+ value.human_name +"</td>"
						+"<td class='TD_STYLE2'>"+ value.register +"</td>"
						+"<td class='TD_STYLE2'>"+ dateToStr(value.regist_time,2) +"</td>"
						+"<td class='TD_STYLE2'>"+ checkStatusMessage +"</td>"
						+"<td class='TD_STYLE2'>"
							+"<a href='javascript:void(0);'"
								+ " onclick='toCheck("+ i +")'>去审核</a>"
						+"</td>"
					+"</tr>";
					$("table#majorChangeList").append(content);
				});
			};
			function toLook(i){
				$("form[name='allMajorChangeForm']").css("display","none");
				$("form[name='majorChangeForm']").css("display","block");
				
				var value = list[i];
				$("input[name='mch_id']").val(value.mch_id);
				$("input[name='first_kind_id']").val(value.first_kind_id);
				$("input[name='first_kind_name']").val(value.first_kind_name);
				$("input[name='second_kind_id']").val(value.second_kind_id);
				$("input[name='second_kind_name']").val(value.second_kind_name);
				$("input[name='third_kind_id']").val(value.third_kind_id);
				$("input[name='third_kind_name']").val(value.third_kind_name);
				$("input[name='major_kind_id']").val(value.major_kind_id);
				$("input[name='major_kind_name']").val(value.major_kind_name);
				$("input[name='major_id']").val(value.major_id);
				$("input[name='major_name']").val(value.major_name);
				$("input[name='salary_sum']").val(value.salary_sum);
				$("input[name='salary_standard_id']").val(value.salary_standard_id);
				$("input[name='salary_standard_name']").val(value.salary_standard_name);
				
				$("input[name='new_first_kind_id']").val(value.new_first_kind_id);
				$("input[name='new_first_kind_name']").val(value.new_first_kind_name);
				$("input[name='new_second_kind_id']").val(value.new_second_kind_id);
				$("input[name='new_second_kind_name']").val(value.new_second_kind_name);
				$("input[name='new_third_kind_id']").val(value.new_third_kind_id);
				$("input[name='new_third_kind_name']").val(value.new_third_kind_name);
				$("input[name='new_major_kind_id']").val(value.new_major_kind_id);
				$("input[name='new_major_kind_name']").val(value.new_major_kind_name);
				$("input[name='new_major_id']").val(value.new_major_id);
				$("input[name='new_major_name']").val(value.new_major_name);
				$("input[name='new_salary_sum']").val(value.new_salary_sum);
				$("input[name='new_salary_standard_id']").val(value.new_salary_standard_id);
				$("input[name='new_salary_standard_name']").val(value.new_salary_standard_name);
				
				$("input[name='human_name']").val(value.human_name);
				$("input[name='mch_file_number']").val(value.mch_file_number);
				$("input[name='register']").val(value.register);
				$("input[name='regist_time']").val(dateToStr(value.regist_time,2));
				$("textarea[name='change_reason']").val(value.change_reason);
			};
			function toBack(){
				var mch_id = $("input[name='listId']").val();
				$.ajax({
					type : "post",
					url : "../majorChange/toUpdateCheckStatus",
					dataType : "json",
					data : {"mchId" : mch_id,"checkStatus" : "1"},
					success:function(result){
						if(result==true){
							$("form[name='allMajorChangeForm']").css("display","block");
							$("form[name='majorChangeForm']").css("display","none");
						};
					}
				});
			};
			function toCheck(i){
				var value = list[i];
				$.ajax({
					type : "post",
					url : "../majorChange/toUpdateCheckStatus",
					dataType : "json",
					data : {"mchId" : value.mch_id,"checkStatus" : "2"},
					success:function(result){
						if(result==true){
							$("form[name='allMajorChangeForm']").css("display","none");
							$("form[name='majorChangeForm']").css("display","block");
							toLook(i);
						}else{
							alert("请求失败！请刷新重试！");
						};
					}
				});
			};
			function toUpdateCheckResult(){
				var mch_id = $("input[name='mch_id']").val();
				var checker = $("input[name='checker']").val();
				var check_time = $("input[name='check_time']").val();
				var check_reason = $("textarea[name='check_reason']").val();
				var checkResult = $("input[name='checkResult']:checked").val();
				var checkStatus = "";
				if(checkResult=="通过"){
					checkStatus = "3";
				}else{
					checkStatus = "4";
				};
				$.ajax({
					type : "post",
					url : "../majorChange/toUpdateCheckResult",
					dataType : "json",
					data : {"mchId" : mch_id,"checkStatus" : checkStatus,"checkReason":check_reason,
							"checker" : checker,"checkTime" : check_time},
					success:function(result){
						if(result==true){
							alert("审核成功！");
							window.location = "../majorChange/toSelectNotChecked";
						}else{
							alert("请求失败！请刷新重试！");
						};
					}
				});
			};
 		</script>
	</head>

	<body onload="loadMajorChange()">
	
		<form method="post" action="" name="allMajorChangeForm">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动查询</font>
					</td>
				</tr>
				<tr>
					<td>
						<p>当前符合条件的员工总数：${fn:length(notCheckList) }例</p>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" id="majorChangeList">
				<tr>
					<td width="25%" class="TD_STYLE1">档案编号</td>
					<td width="15%" class="TD_STYLE1">姓名</td>
					<td width="15%" class="TD_STYLE1">登记人</td>
					<td width="25%" class="TD_STYLE1">登记时间</td>
					<td width="10%" class="TD_STYLE1">状态</td>
					<td width="10%" class="TD_STYLE1">操作</td>
				</tr>
			</table>
			<p>&nbsp;&nbsp;总数：${fn:length(notCheckList) }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="../jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
		
		<form method="post" action="" 
					name="majorChangeForm" style="display:none;">
			<table width="100%">
				<tr>
					<td align="right">
    					<input type="radio" name="checkResult" checked="checked" value="未通过"/>未通过
    					<input type="radio"  name="checkResult" value="通过"/>通过
						<input type="button" value="确认" class="BUTTON_STYLE1"
								onclick="toUpdateCheckResult()">
						<input type="reset" value="返回" class="BUTTON_STYLE1"
								onclick="toBack()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td width="10%" class="TD_STYLE1">档案编号</td>
					<td class="TD_STYLE2" colspan="7">
						<input type="hidden" name="mch_id">
						<input class="INPUT_STYLE3" type="text" 
								name="mch_file_number" readonly>
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">原I级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="first_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="first_kind_name" readonly>
					</td>
					
					<td width="10%" class="TD_STYLE1">原II级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="second_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="second_kind_name" readonly>
					</td>
					
					<td width="10%" class="TD_STYLE1">原III级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="third_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="third_kind_name" readonly>
					</td>
					
					<td width="10%" class="TD_STYLE1">姓名</td>
					<td width="15%" class="TD_STYLE2">
						<input class="INPUT_STYLE3" type="text" 
								name="human_name" readonly>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">原职位分类</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="major_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="major_kind_name" readonly>
					</td>
					
					<td class="TD_STYLE1">原职位名称</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="major_id">
						<input class="INPUT_STYLE3" type="text" 
								name="major_name" readonly>
					</td>
					
					<td class="TD_STYLE1">原薪酬标准</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="salary_standard_id">
						<input class="INPUT_STYLE3" type="text" 
								name="salary_standard_name" readonly>
						<input type="hidden" name="salary_sum">
					</td>
					
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">新I级机构</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="new_first_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="new_first_kind_name" readonly>
					</td>
					
					<td class="TD_STYLE1">新II级机构</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="new_second_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="new_second_kind_name" readonly>
					</td>
					
					<td class="TD_STYLE1">新III级机构</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="new_third_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="new_third_kind_name" readonly>
					</td>
					
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">新职位分类</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="new_major_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="new_major_kind_name" readonly>
						</select>
					</td>
					
					<td class="TD_STYLE1">新职位名称</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="new_major_id">
						<input class="INPUT_STYLE3" type="text" 
								name="new_major_name" readonly>
						</select>
					</td>
					
					<td class="TD_STYLE1" >新薪酬标准</td>
					<td class="TD_STYLE2" >
						<input type="hidden" name="new_salary_standard_id">
						<input class="INPUT_STYLE3" type="text" 
								name="new_salary_standard_name" readonly>
						<input type="hidden" name="new_salary_sum">
					</td>
					
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">登记人</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" class="INPUT_STYLE3" readonly>
					</td>
					<td class="TD_STYLE1">登记时间</td>
					<td class="TD_STYLE2">
						<input type="text" name="regist_time" class="INPUT_STYLE3" readonly>
					</td>
					<td class="TD_STYLE1">审核人</td>
					<td class="TD_STYLE2">
						<input type="text" name="checker" class="INPUT_STYLE3"
					</td>
					<td class="TD_STYLE1">审核时间</td>
					<td class="TD_STYLE2">
						<input type="text" name="check_time" class="INPUT_STYLE3" readonly>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">调动原因</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="change_reason" rows="4"
							 class="TEXTAREA_STYLE2" readonly></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">审核意见</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="check_reason" rows="4"
							 class="TEXTAREA_STYLE2"></textarea>
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>