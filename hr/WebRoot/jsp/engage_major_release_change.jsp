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
		<link rel="stylesheet" type="text/css" media="all"
			href="../jsp/javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="../jsp/javascript/calendar/cal.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/select.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/yhy/util.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/yhy/insertAndUpdate.js" charset="UTF-8"></script>
		<script type="text/javascript">
			function loadAll(){
				$.each(${releaseList }, function (i, value) {
					var content = 
						"<tr data->"
							+"<td class='TD_STYLE2'>"+value.major_name+"</td>"
							+"<td class='TD_STYLE2'>"+value.second_kind_name+"</td>"
							+"<td class='TD_STYLE2'>"+value.human_amount+"</td>"
							+"<td class='TD_STYLE2'>"+dateToStr(value.regist_time,2)+"</td>"
							+"<td class='TD_STYLE2'>"+dateToStr(value.deadline,1)+"</td>"
							+"<td class='TD_STYLE2'>"
								+"<a href='javascript:void(0);'" 
									+"onclick='toChange("+ i +")'>修改</a>"
							+"</td>"
							+"<td class='TD_STYLE2'>"
								+"<a href='javascript:void(0);'" 
									+"onclick='toDelete("+ value.mre_id +")'>删除</a>"
							+"</td>"
						+"</tr>";
					$("table#majorReleaseTable").append(content);
				});
			};
			function toDelete(mre_id){
				$.ajax({
					type : "post",
					url : "../engageMajorRelease/toDelete",
					dataType : "json",
					data: {"mreId" : mre_id},
					success:function(result){
						if(result==true){
						window.location = "";
						}else{
							alert("删除失败！请刷新重试！");
						};
					},error:function(error){
						alert("删除失败！请刷新重试！");
					}
				});
			};
			function toChange(i){
				$("input[name='time']").val(getNowDate(2));
				$("form[name='changing']").css("display","block");
				$("form[name='change']").css("display","none");
				var value = ${releaseList };
				var values = value[i];
				//window.location = "../jsp/engage_major_release_changing.jsp"
				//			+"?releaseList="+value[i];
				var allFirstName = values.first_kind_id + "/" + values.first_kind_name;
				var firstObj = $("select[name='firstKindName']");
				$(firstObj).children("option[value='"+ allFirstName +"']").prop("selected","selected");
				kindNameChange(firstObj,1);
				
				var allSecondName = values.second_kind_id + "/" + values.second_kind_name;
				var secondObj = $("select[name='secondKindName']");
				$(secondObj).children("option").eq(0).val(allSecondName);
				$(secondObj).children("option").eq(0).html(allSecondName);
				$(secondObj).children("option[value='"+ allSecondName +"']").prop("selected","selected");
				kindNameChange(secondObj,1);
				
				var allThirdName = values.third_kind_id + "/" + values.third_kind_name;
				var thirdObj = $("select[name='thirdKindName']");
				$(thirdObj).children("option").eq(0).val(allThirdName);
				$(thirdObj).children("option").eq(0).html(allThirdName);
				$(thirdObj).children("option[value='"+ allSecondName +"']").prop("selected","selected");
				kindNameChange(thirdObj,1);
				
				var engageTypeObj = $("select[name='engageType']");
				$(engageTypeObj).children("option[value='"+ value.engage_type +"']").prop("selected","selected");
				kindNameChange(engageTypeObj,0);
				
				var allMindKindName = values.major_kind_id + "/" + values.major_kind_name;
				var majorKindNameObj = $("select[name='majorKindName']");
				$(majorKindNameObj).children("option[value='"+ allMindKindName +"']").prop("selected","selected");
				kindNameChange(majorKindNameObj,1);
				
				var allMindName = values.major_id + "/" + values.major_name;
				var majorObj = $("select[name='majorName']");
				$(majorObj).children("option").eq(0).val(allMindName);
				$(majorObj).children("option").eq(0).html(allMindName);
				$(majorObj).children("option[value='"+ allMindName +"']").prop("selected","selected");
				kindNameChange(majorObj,1);
				
				$("input[name='mre_id']").val(values.mre_id);
				$("input[name='human_amount']").val(values.human_amount);
				$("input[name='deadline']").val(dateToStr(values.deadline,1));
				$("input[name='changer']").val(values.register);
				$("textarea[name='major_describe']").val(values.major_describe);
				$("textarea[name='engage_required']").val(values.engage_required);
			};
			function toBack(){
				$("form[name='changing']").css("display","none");
				$("form[name='change']").css("display","block");
			};
 		</script>
	</head>

	<body onload="loadAll();loadFirstAndKindName();">
		<form method="post" action="" name="change">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布变更
						</font>
					</td>
				</tr>>
				<tr>
					<td>
						<p>当前职位发布总数：${fn:length(releaseList) }例</p>
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1" id="majorReleaseTable">
				<tr>
					<td width="15%" class="TD_STYLE1">职位名称</td>
					<td width="15%" class="TD_STYLE1">机构名称</td>
					<td width="15%" class="TD_STYLE1">招聘人数</td>
					<td width="28%" class="TD_STYLE1">发布时间</td>
					<td width="15%" class="TD_STYLE1">截止时间</td>
					<td width="5%" class="TD_STYLE1">修改</td>
					<td width="5%" class="TD_STYLE1">删除</td>
				</tr>
				
			</table>
			<p>&nbsp;&nbsp;总数：${fn:length(releaseList) }例 &nbsp;&nbsp;&nbsp;当前第 1 页  &nbsp;&nbsp;&nbsp;共 1 页  &nbsp;&nbsp;&nbsp;跳到第 <input name=page type=text class=input1 size=1> 页&nbsp;&nbsp;<input type=image src="../jsp/images/go.bmp" width=18 height=18 border=0></p>
		</form>
		
		<form name="changing" method="post" action="" style="display:none;">
			<table width="100%">
				<tr>
					<td>
						<input type="hidden" name="mre_id" value="">
						<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布变更 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="submit" value="重新提交" class="BUTTON_STYLE1"
								onclick="insertOrUpdateEngageRelease('update')">
						<input type="reset" value="返回" class="BUTTON_STYLE1"
								onclick="toBack()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
					<td class="TD_STYLE1" width="10%">I级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="first_kind_id" value="">
						<input type="hidden" name="first_kind_name" value="">
						<select name="firstKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">II级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="second_kind_id" value="">
						<input type="hidden" name="second_kind_name" value="">
						<select name="secondKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">III级机构</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="third_kind_id" value="">
						<input type="hidden" name="third_kind_name" value="">
						<select name="thirdKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">招聘类型</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="engage_id" value="">
						<input type="hidden" name="engage_type" value="">
						<select name="engageType" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
							<option value="校园招聘">校园招聘</option>
							<option value="社会招聘">社会招聘</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">职位分类</td>
					<td width="15%" class="TD_STYLE2">
						<input type="hidden" name="major_kind_id" value="">
						<input type="hidden" name="major_kind_name" value="">
						<select name="majorKindName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">职位名称</td>
					<td class="TD_STYLE2">
						<input type="hidden" name="major_id" value="">
						<input type="hidden" name="major_name" value="">
						<select name="majorName" class="SELECT_STYLE1" 
								onchange="kindNameChange(this,0)">
							<option value="">&nbsp;</option>
						</select>
					</td>
					<td width="10%" class="TD_STYLE1">招聘人数</td>
					<td width="15%" class="TD_STYLE2">
						<input type="text" name="human_amount" value="" class="INPUT_STYLE2">
					</td>
					<td width="10%" class="TD_STYLE1">截止日期</td>
					<td width="15%" class="TD_STYLE2">
						<input type="text" name="deadline" value="" class="INPUT_STYLE2" id="date_end">
					</td>
				</tr>
				<tr>
					<td width="10%" class="TD_STYLE1">变更人</td>
					<td width="15%" class="TD_STYLE2">
						<input type="text" name="changer" value="" class="INPUT_STYLE2">
					</td>
					<td width="10%" class="TD_STYLE1">变更时间</td>
					<td class="TD_STYLE2">
						<input type="text" name="time" value=""
								 class="INPUT_STYLE2" readonly>
					</td>
					<td width="10%" class="TD_STYLE1"></td>
					<td width="15%" class="TD_STYLE2"></td>
					<td width="10%" class="TD_STYLE1"></td>
					<td width="15%" class="TD_STYLE2"></td>
				</tr>
				<tr>
					<td class="TD_STYLE1">职位描述</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="major_describe" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">招聘要求</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="engage_required" rows="4" class="TEXTAREA_STYLE1"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript" charset="UTF-8">
		Calendar.setup ({
			inputField : "date_end",
			ifFormat : "%Y-%m-%d", 
			showsTime : false, 
			button : "date_end", 
			singleClick : true, 
			step : 1});
		Calendar.setup ({
			inputField : "date_start",
			ifFormat : "%Y-%m-%d %H:%M:%S", 
			showsTime : false, 
			button : "date_start", 
			singleClick : true, 
			step : 1});
	</script>
</html>