<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="../jsp/table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="../jsp/javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="../jsp/javascript/calendar/cal.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/comm.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/comm/select.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../jsp/javascript/jquery-1.6.1.min.js" charset="UTF-8"></script>
		<script type="text/javascript" charset="UTF-8">
			function kindNameChange(obj){
				//获得当前元素的name
				var name = $(obj).attr("name");
				var kind = $(obj).find("option:selected").val();
				var firstId = kind.substring(0,kind.indexOf("/"));
				var firstName = kind.substring(kind.indexOf("/")+1);
				//初始化要跳转的url和要传的数据data以及要添加子元素的父元素的name
				var url = "/hr/engageMajorRelease/";
				var data = {"firstName" : firstName};
				var addName = "";
				var valueId = "";
				var valueName = "";
				
				if(name == "firstKindName"){
					$("select[name='thirdKindName']").children("option").not(":eq(0)").remove();
					url = url + "selectSecondKindIdAndName";
					addName = "secondKindName";
					valueId = "first_kind_id";
					valueName = "first_kind_name";
				}else if(name == "secondKindName"){
					var kinds = $("select[name='firstKindName']").val();
					var secondName = kinds.substring(kind.indexOf("/")+1);
					url = url + "selectThirdKindIdAndName";
					data = {"firstName" : secondName, "secondName" : firstName};
					addName = "thirdKindName";
					valueId = "second_kind_id";
					valueName = "second_kind_name";
					console.log(firstName);
				}else if(name == "thirdKindName"){
					url = "";
					valueId = "third_kind_id";
					valueName = "third_kind_name";
				}else if(name == "majorKindName"){
					url = url + "selectAllMajorIdAndName";
					addName = "majorName";
					valueId = "major_kind_id";
					valueName = "major_kind_name";
				}else if(name == "majorName"){
					url = "";
					valueId = "major_id";
					valueName = "major_name";
				}else if(name == "engageType"){
					url = "";
					valueId = "engage_id";
					valueName = "engage_type";
					firstName = kind;
					firstId = "0";
				};
				//清空所有下级元素的内容
				$("select[name='"+ addName +"']").children("option").not(":eq(0)").remove();
				$("input[name='"+ valueId +"']").val(firstId);
				$("input[name='"+ valueName +"']").val(firstName);
				$.ajax({
					type : "post",
					url : url,
					dataType : "json",
					data: data,
					success:function(result){
						$.each(result, function (i, value) {
							var values = value.first +"/"+ value.second;
							var content = "<option value='"+values+"'>"+ values +"</option>";
                        	$("select[name='"+ addName +"']").append(content);
                    	});
					}
				});
			};
			function insertEngageRelease(){
				var firstKindId = $("input[name='first_kind_id']").val();
				var firstKindName = $("input[name='first_kind_name']").val();
				var secondKindId = $("input[name='second_kind_id']").val();
				var secondKindName = $("input[name='second_kind_name']").val();
				var thirdKindId = $("input[name='third_kind_id']").val();
				var thirdKindName = $("input[name='third_kind_name']").val();
				var engageType = $("input[name='engage_type']").val();
				var majorKindId = $("input[name='major_kind_id']").val();
				var majorKindName = $("input[name='major_kind_name']").val();
				var majorId = $("input[name='major_id']").val();
				var majorName = $("input[name='major_name']").val();
				var humanAmount = $("input[name='human_amount']").val();
				var deadline = $("input[name='deadline']").val();
				var register = $("input[name='register']").val();
				var registTime = $("input[name='regist_time']").val();
				var majorDescribe = $("textarea[name='major_describe']").val();
				var engageRequired = $("textarea[name='engage_required']").val();
				
				var data = {
					"firstKindId" : firstKindId,"firstKindName" : firstKindName,
					"secondKindId" : secondKindId,"secondKindName" : secondKindName,
					"thirdKindId" : thirdKindId,"thirdKindName" : thirdKindName,
					"majorKindId" : majorKindId,"majorKindName" : majorKindName,
					"majorId" : majorId,"majorName" : majorName,"engageType" : engageType,
					"humanAmount" : humanAmount, "deadline" : deadline,
					"register" : register,"registTime" : registTime,
					"majorDescribe" : majorDescribe,"engageRequired" : engageRequired
				};
				
				$.ajax({
					type : "post",
					url : "../engageMajorRelease/addEngageMajorRelease",
					dataType : "json",
					data: data,
					success:function(result){
						console.log(result);
						if(result==true){
							window.location="../jsp/engage_major_release_select.jsp";
						}else{
							alert("添加失败！请刷新重试！");
						};
					}
				});
			};
 		</script>
	</head>

	<body>
		<table width="100%">
			<tr>
				<td>
					<font color="#0000CC">您正在做的业务是：人力资源--招聘管理--职位发布管理--职位发布登记 </font>
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="submit" value="提交" class="BUTTON_STYLE1"
							onclick="insertEngageRelease()">
					<input type="button" value="清除" class="BUTTON_STYLE1">
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
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
						<c:forEach items="${firstKindAndMajorKind }" var="map">
							<c:if test="${map.key == 'firstValue' }">
								<c:forEach items="${map.value }" var="val">
									<option value="${val.first }/${val.second }">
										${val.first }/${val.second }
									</option>
                				</c:forEach>
							</c:if>
                		</c:forEach>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">II级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="second_kind_id" value="">
					<input type="hidden" name="second_kind_name" value="">
					<select name="secondKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">III级机构</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="third_kind_id" value="">
					<input type="hidden" name="third_kind_name" value="">
					<select name="thirdKindName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">招聘类型</td>
				<td width="15%" class="TD_STYLE2">
					<input type="hidden" name="engage_id" value="">
					<input type="hidden" name="engage_type" value="">
					<select name="engageType" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
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
							onchange="kindNameChange(this)">
						<option value="">&nbsp;</option>
						<c:forEach items="${firstKindAndMajorKind }" var="map">
							<c:if test="${map.key == 'majorKindValue' }">
								<c:forEach items="${map.value }" var="val">
									<option value="${val.first }/${val.second }">${val.first }/${val.second }</option>
                				</c:forEach>
							</c:if>
                		</c:forEach>
					</select>
				</td>
				<td width="10%" class="TD_STYLE1">职位名称</td>
				<td class="TD_STYLE2">
					<input type="hidden" name="major_id" value="">
					<input type="hidden" name="major_name" value="">
					<select name="majorName" class="SELECT_STYLE1" 
							onchange="kindNameChange(this)">
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
				<td width="10%" class="TD_STYLE1">登记人</td>
				<td width="15%" class="TD_STYLE2">
					<input type="text" name="register" value="" class="INPUT_STYLE2">
				</td>
				<td width="10%" class="TD_STYLE1">登记时间</td>
				<td class="TD_STYLE2">
					<input type="text" name="regist_time" value="" class="INPUT_STYLE2" id="date_start">
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