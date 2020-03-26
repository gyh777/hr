<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">






























<html>
	<head>
		
		
		
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<link rel="stylesheet" href="<%=basePath%>jsp/table.css" type="text/css">
		<link rel="stylesheet" type="text/css" media="all"
			href="<%=basePath%>jsp/javascript/calendar/calendar-win2k-cold-1.css">
		<script type="text/javascript" src="<%=basePath%>jsp/javascript/calendar/cal.js"></script>
		<script type="text/javascript" src="<%=basePath%>jsp/javascript/comm/comm.js"></script>
		<script language="javascript" src="<%=basePath%>jsp/javascript/winopen/winopenm.js"></script>
	    <script language="javascript" src="<%=basePath%>jsp/javascript/cy/human_check.js"></script>
	    <script src="<%=basePath%>jsp/javascript/cy/jquery-1.8.3.min.js"></script>
	</head>

	<body onload="selectPro()">
	
		<form id="humancheck" name="humanfileForm" method="post">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：人力资源--人力资源档案管理--人力资源档案复核 </font>
					</td>
				</tr>
				<tr>
					<td align="right">
						<input type="button" value="复核通过" class="BUTTON_STYLE1" onclick="checkAgree()">
						<input type="button" value="返回" class="BUTTON_STYLE1"
							onclick="history.back()">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<tr>
				<input type="hidden" name="hufId" value="1">
					<td class="TD_STYLE1" width="10%">
						档案编号
					</td>
					<td id="hufid"  colspan="6" class="TD_STYLE2">
						${human.huf_id}
					</td>
					<td rowspan="6" width="13%">
						<img src="">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1" width="10%">
						I级机构
					</td>
					<td id="first" width="13%" class="TD_STYLE2">
						${human.first_kind_name}
					</td>
					<td width="10%" class="TD_STYLE1">
						II级机构
					</td>
					<td id="second" width="13%" class="TD_STYLE2">
						${human.second_kind_name}
					</td>
					<td width="10%" class="TD_STYLE1">
						III级机构
					</td>
					<td id="third" class="TD_STYLE2" colspan="2" width="2%" >
						${human.third_kind_name}
					</td>
				</tr>
				<tr>
					<td  class="TD_STYLE1">
						职位分类
					</td>
					<td id="majorKind" class="TD_STYLE2">
						${human.human_major_kind_name }
					</td>
					<td class="TD_STYLE1">
						职位名称
					</td>
					<td id="major" class="TD_STYLE2">
						${human.human_major_name }
					</td>
					<td class="TD_STYLE1">
						职称
					</td>
					<td colspan="2" class="TD_STYLE2">
						<select name="humanProDesignation" class="SELECT_STYLE1"><option value="工程师">工程师</option>
							
								<option value="经理" selected="selected">经理</option>
							
								<option value="助理">助理</option>
							
								<option value="教授">教授</option>
							
								<option value="讲师">讲师</option>
							
								<option value="技术支持">技术支持</option></select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						姓名
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanName" value="${human.human_name }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						性别
					</td>
					<td class="TD_STYLE2">
					    <input type="hidden" id="sex" display="none" value="${human.human_sex}"></input>
						<select name="humanSex" class="SELECT_STYLE1"><option id="man" value="男">男</option>
							<option id="women" value="女"  >女</option></select>
					</td>
					<td class="TD_STYLE1">
						EMAIL
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanEmail" value="${human.human_email }" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						电话
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanTelephone" value="${human.human_telephone }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						QQ
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanQq" value="${human.human_qq }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						手机
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanMobilephone" value="${human.human_mobilephone }" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						住址
					</td>
					<td colspan="3" class="TD_STYLE2">
						<input type="text" name="humanAddress" value="${human.human_address }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						邮编
					</td>
					<td colspan="2" class="TD_STYLE2">
						<input type="text" name="humanPostcode" value="${human.human_postcode }" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						国籍
					</td>
					<td class="TD_STYLE2">
						<select name="humanNationality" class="SELECT_STYLE1"><option value="中国" selected="selected">中国</option>
							
								<option value="美国">美国</option></select>
					</td>
					<td class="TD_STYLE1">
						出生地
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanBirthplace" value="${human.human_birthplace }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						生日
					</td>
					<td width="13%" class="TD_STYLE2">
						<input type="text" name="str_humanBirthday" value="${human.human_birthday }" class="INPUT_STYLE2" id="date_start">
					</td>
					<td width="10%" class="TD_STYLE1">
						民族
					</td>
					<td class="TD_STYLE2">
						<select name="humanRace" class="SELECT_STYLE1"><option value="汉族" selected="selected">汉族</option>
							
								<option value="回族">回族</option></select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						宗教信仰
					</td>
					<td class="TD_STYLE2">
						<select name="humanReligion" class="SELECT_STYLE1"><option value="无" selected="selected">无</option>
							
								<option value="佛教">佛教</option></select>
					</td>
					<td class="TD_STYLE1">
						政治面貌
					</td>
					<td class="TD_STYLE2">
						<select name="humanParty" class="SELECT_STYLE1"><option value="党员" selected="selected">党员</option>
							
								<option value="群众">群众</option></select>
					</td>
					<td class="TD_STYLE1">
						身份证号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanIdCard" value="${human.human_id_card }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						社会保障号码
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanSocietySecurityId" value="${human.human_society_security_id }" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						年龄
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanAge" value="${human.human_age }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						学历
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedDegree" class="SELECT_STYLE1"><option value="本科" selected="selected">本科</option>
							
								<option value="大专">大专</option></select>
					</td>
					<td class="TD_STYLE1">
						教育年限
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedYears" class="SELECT_STYLE1"><option value="12">12</option>
							
								<option value="16" selected="selected">16</option></select>
					</td>
					<td class="TD_STYLE1">
						学历专业
					</td>
					<td class="TD_STYLE2">
						<select name="humanEducatedMajor" class="SELECT_STYLE1"><option value="生物工程" selected="selected">生物工程</option>
							
								<option value="计算机">计算机</option></select>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						薪酬标准
					</td>
					<td class="TD_STYLE2">
						<select name="salaryStandardName" class="SELECT_STYLE1"><option value="0/未定义">0/未定义</option></select>
					</td>
					<td class="TD_STYLE1">
						开户行
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanBank" value="${human.human_bank }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						帐号
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="humanAccount" value="${human.human_account }" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						复核人
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="checker" value="${human.checker }" readonly="readonly" class="INPUT_STYLE2">
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						复核时间
					</td>
					<td class="TD_STYLE2">
						<input type="text" name="str_checkTime" value="2010-05-29 02:24:36" readonly="readonly" class="INPUT_STYLE2">
					</td>
					<td class="TD_STYLE1">
						特长
					</td>
					<td class="TD_STYLE2">
						<select name="humanSpeciality" class="SELECT_STYLE1"><option value="数据库">数据库</option>
							
								<option value="java" selected="selected">java</option></select>
					</td>
					<td class="TD_STYLE1">
						爱好
					</td>
					<td class="TD_STYLE2">
						<select name="humanHobby" class="SELECT_STYLE1"><option value="篮球">篮球</option>
							
								<option value="舞蹈" selected="selected">舞蹈</option></select>
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
						档案附件
					</td>
					<td colspan="7" class="TD_STYLE2">
						<a href="javascript:winopenm('query.jsp?filename=')"></a>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						个人履历
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanHistroyRecords" rows="4" class="TEXTAREA_STYLE1">${ human.human_history_records}</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						家庭关系信息
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="humanFamilyMembership" rows="4" class="TEXTAREA_STYLE1">${human.human_family_membership}</textarea>
					</td>
				</tr>
				<tr>
					<td class="TD_STYLE1">
						备注
					</td>
					<td colspan="7" class="TD_STYLE2">
						<textarea name="remark" rows="4" class="TEXTAREA_STYLE1">${human.remark}</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
<script type="text/javascript">
Calendar.setup ({inputField : "date_start", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_start", singleClick : true, step : 1});
Calendar.setup ({inputField : "date_end", ifFormat : "%Y-%m-%d", showsTime : false, button : "date_end", singleClick : true, step : 1});
</script>
</html>



