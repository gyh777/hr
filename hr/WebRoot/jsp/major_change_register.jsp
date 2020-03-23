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
		<script type="text/javascript" src="../jsp/javascript/yhy/insertAndUpdate.js"></script>
		<script type="text/javascript">
			function loadHumanFile(){
				$.each(${humanFileList }, function (i, value) {
					//var fileNumber = value.first_kind_id+value.second_kind_id
					//		+value.third_kind_id+value.human_major_kind_id
					//		+value.human_major_id+value.huf_id+value.human_id;
					var fileNumber = getNowDate(3)+value.human_id;
					var content = 
					"<tr >"
						+"<td class='TD_STYLE2'>"+fileNumber+"</td>"
						+"<td class='TD_STYLE2'>"+value.human_name+"</td>"
						+"<td class='TD_STYLE2'>"
							+ value.second_kind_name + ">" + value.third_kind_name
						+"</td>"
						+"<td class='TD_STYLE2'>"
							+ value.human_major_kind_name + ">" + value.human_major_name
						+"</td>"
						+"<td class='TD_STYLE2'>"+value.salary_standard_name+"</td>"
						+"<td class='TD_STYLE2'>"
							+"<a href='javascript:void(0);'"
								+ " onclick='changeRegister("+i+","+fileNumber+")'>调动登记</a>"
						+"</td>"
					+"</tr>";
					$("table#humanFileList").append(content);
				});
			};
			function loadSalaryStandard(){
				$.ajax({
					type : "post",
					url : "../majorChange/toSelectSalaryStandard",
					dataType : "json",
					success:function(result){
						$.each(result, function (i, value) {
							var allSalaryStandardName = value.standardId+"/"+value.salarySum;
							var salaryStandard = 
									"<option value='"+allSalaryStandardName+"'>"+value.standardName+"</option>";
							$("select[name='salaryStandard']").append(salaryStandard);
						});
					}
				});
			};
			function salaryStandardChange(obj){
				var allSalaryStandard = $(obj).find("option:selected").val();
				var salaryStandardId = 
					allSalaryStandard.substring(0,allSalaryStandard.indexOf("/"));
				var salarySum = 
					allSalaryStandard.substring(allSalaryStandard.indexOf("/")+1);
				var salaryStandardName = $(obj).find("option:selected").html();
				$("input[name='salary_standard_id']").val(salaryStandardId);
				$("input[name='salary_sum']").val(salarySum);
				$("input[name='salary_standard_name']").val(salaryStandardName);
			};
			function toBack(){
				$("input[name='time']").val("");
				$("form[name='majorChangeSelect']").css("display","block");
				$("form[name='majorChangeSubmit']").css("display","none");
			};
			function changeRegister(i,fileNumber){
				$("input[name='time']").val(getNowDate(2));
				$("form[name='majorChangeSelect']").css("display","none");
				$("form[name='majorChangeSubmit']").css("display","block");
				var value = ${humanFileList };
				value = value[i];
				
				//填入数据
				$("input[name='listId']").val(i);
				$("input[name='mch_file_number']").val(fileNumber);
				$("input[name='old_first_kind_id']").val(value.first_kind_id);
				$("input[name='old_first_kind_name']").val(value.first_kind_name);
				$("input[name='old_second_kind_id']").val(value.second_kind_id);
				$("input[name='old_second_kind_name']").val(value.second_kind_name);
				$("input[name='old_third_kind_id']").val(value.third_kind_id);
				$("input[name='old_third_kind_name']").val(value.third_kind_name);
				$("input[name='human_name']").val(value.human_name);
				$("input[name='old_major_kind_id']").val(value.human_major_kind_id);
				$("input[name='old_major_kind_name']").val(value.human_major_kind_name);
				$("input[name='old_major_id']").val(value.human_major_id);
				$("input[name='old_major_name']").val(value.human_major_name);
				$("input[name='old_salary_sum']").val(value.salary_sum);
				$("input[name='old_salary_standard_id']").val(value.salary_standard_id);
				$("input[name='old_salary_standard_name']").val(value.salary_standard_name);
			};
			function majorChangeSubmits(){
				var i = $("input[name='listId']").val();
				var value = ${humanFileList };
				var data = value[i];
				if(data.salary_sum==""){
					data.salary_sum = "0";
				};
				data.huf_id = data.huf_id + "";
				console.log(data);
				//获得值
				var mch_file_number = $("input[name='mch_file_number']").val();
				data.mch_file_number = mch_file_number;
				var new_first_kind_id = $("input[name='first_kind_id']").val();
				data.new_first_kind_id = new_first_kind_id;
				var new_first_kind_name = $("input[name='first_kind_name']").val();
				data.new_first_kind_name = new_first_kind_name;
				var new_second_kind_id = $("input[name='second_kind_id']").val();
				data.new_second_kind_id = new_second_kind_id;
				var new_second_kind_name = $("input[name='second_kind_name']").val();
				data.new_second_kind_name = new_second_kind_name;
				var new_third_kind_id = $("input[name='third_kind_id']").val();
				data.new_third_kind_id = new_third_kind_id;
				var new_third_kind_name = $("input[name='third_kind_name']").val();
				data.new_third_kind_name = new_third_kind_name;
				var new_major_kind_id = $("input[name='major_kind_id']").val();
				data.new_major_kind_id = new_major_kind_id;
				var new_major_kind_name = $("input[name='major_kind_name']").val();
				data.new_major_kind_name = new_major_kind_name;
				var new_major_id = $("input[name='major_id']").val();
				data.new_major_id = new_major_id;
				var new_major_name = $("input[name='major_name']").val();
				data.new_major_name = new_major_name;
				var new_salary_standard_id = $("input[name='salary_standard_id']").val();
				data.new_salary_standard_id = new_salary_standard_id;
				var new_salary_standard_name = $("input[name='salary_standard_name']").val();
				data.new_salary_standard_name = new_salary_standard_name;
				var new_salary_sum = $("input[name='salary_sum']").val();
				data.new_salary_sum = new_salary_sum;
				var register = $("input[name='register']").val();
				data.register = register;
				var time = $("input[name='time']").val();
				data.time = time;
				var change_reason = $("textarea[name='change_reason']").val();
				data.change_reason = change_reason;
				//设置审核状态，1为未审核，2为审核中，3位不通过，4未通过
				data.check_status = "1";
				
				$.ajax({
					type : "post",
					url : "../majorChange/toInsertAll",
					dataType : "json",
					data : data,
					success:function(result){
					//0为成功，1为职员档案状态更改失败，2为调动失败
						if(result==0){
							alert("调动成功！");
							window.location = "../majorChange/toSelectNormalHumanFile";
						}else{
							alert("调动失败！请重试！");
						};
					}
				});
			};
 		</script>
	</head>

	<body onload="loadHumanFile();loadSalaryStandard();loadFirstAndKindName();">
		<form method="post" action="" name="majorChangeSelect">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--调动管理--调动登记</font>
					</td>
				</tr>
				<tr>
					<td>
						<p>当前符合条件的员工总数：${fn:length(humanFileList) }例</p>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" id="humanFileList">
				<tr>
					<td width="22%" class="TD_STYLE1">档案编号</td>
					<td width="10%" class="TD_STYLE1">姓名</td>
					<td width="22%" class="TD_STYLE1">所在机构</td>
					<td width="22%" class="TD_STYLE1">所任职位</td>
					<td width="14%" class="TD_STYLE1">薪酬标准</td>
					<td width="10%" class="TD_STYLE1">调动登记</td>
				</tr>
			</table>
			<p>&nbsp;&nbsp;总数：${fn:length(humanFileList) }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="../jsp/images/go.bmp" width=18 height=18 border=0>
		</form>
		
		<form method="post" action="" name="majorChangeSubmit" style="display:none;">
			<table width="100%">
				<tr>
					<td align="right">
						<input type="button" value="提交" class="BUTTON_STYLE1"
								onclick="majorChangeSubmits()">
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
						<input type="hidden" name="listId">
						<input class="INPUT_STYLE3" type="text" 
								name="mch_file_number" readonly>
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">原I级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="old_first_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="old_first_kind_name" readonly>
					</td>
					
					<td width="10%" class="TD_STYLE1">原II级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="old_second_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="old_second_kind_name" readonly>
					</td>
					
					<td width="10%" class="TD_STYLE1">原III级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="old_third_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="old_third_kind_name" readonly>
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
						<input type="hidden" name="old_major_kind_id">
						<input class="INPUT_STYLE3" type="text" 
								name="old_major_kind_name" readonly>
					</td>
					
					<td class="TD_STYLE1">原职位名称</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="old_major_id">
						<input class="INPUT_STYLE3" type="text" 
								name="old_major_name" readonly>
					</td>
					
					<td class="TD_STYLE1">原薪酬标准</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="old_salary_standard_id">
						<input class="INPUT_STYLE3" type="text" 
								name="old_salary_standard_name" readonly>
						<input type="hidden" name="old_salary_sum">
					</td>
					
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">新I级机构</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="first_kind_id">
						<input type="hidden" name="first_kind_name">
						<select name="firstKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					
					<td class="TD_STYLE1">新II级机构</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="second_kind_id">
						<input type="hidden" name="second_kind_name">
						<select name="secondKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					
					<td class="TD_STYLE1">新III级机构</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="third_kind_id">
						<input type="hidden" name="third_kind_name">
						<select name="thirdKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">新职位分类</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="major_kind_id">
						<input type="hidden" name="major_kind_name">
						<select name="majorKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					
					<td class="TD_STYLE1">新职位名称</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="major_id">
						<input type="hidden" name="major_name">
						<select name="majorName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					
					<td class="TD_STYLE1" >新薪酬标准</td>
					<td class="TD_STYLE2" >
						<input type="hidden" name="salary_standard_id">
						<input type="hidden" name="salary_standard_name">
						<input type="hidden" name="salary_sum">
						<select name="salaryStandard" class="SELECT_STYLE1" 
								onchange="salaryStandardChange(this)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">登记人</td>
					<td class="TD_STYLE2">
						<input type="text" name="register" class="INPUT_STYLE3">
					</td>
					<td class="TD_STYLE1">登记时间</td>
					<td class="TD_STYLE2">
						<input type="text" name="time" class="INPUT_STYLE3" readonly>
					</td>
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
					<td class="TD_STYLE1"></td>
					<td class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">调动原因</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="change_reason" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>