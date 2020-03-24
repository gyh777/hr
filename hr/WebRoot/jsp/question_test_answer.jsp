<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/hr/jsp/table.css" type="text/css" />
		<title>无标题文档</title>
		<style type="text/css">
<!--
.style3 {color: #0000CC}
-->
</style>
	</head>

	<body>
		<form id="questionForm" method="post" action="/hr/engageAnswer/save">
			<table width="100%">
				<tr>
					<td>
						<font color="#0000CC">您正在做的业务是：招聘管理--招聘考试管理--考试答题</font>
					</td>
				</tr>
				<tr>
					<td class="BUTTON_STYLE1">
						<input type="hidden" id="limite_time" value="${engageExam.limite_time }">
						答题限定时间${engageExam.limite_time }分钟
					</td>
				</tr>
				<tr>
					<td class="BUTTON_STYLE1">
						答题已用时间
						<span id="id_H">00</span>：
						<span id="id_M">00</span>：
						<span id="id_S">00</span>
					</td>
				</tr>
				<tr>
					<td class="BUTTON_STYLE1">
						<input type="submit" value="交卷" class="BUTTON_STYLE1">
					</td>
				</tr>
			</table>
			<table width="100%" border="1" cellpadding=0 cellspacing=1
				bordercolorlight=#848284 bordercolordark=#eeeeee
				class="TABLE_STYLE1">
				<input type="hidden" name="exam_number" value="${engageExam.exam_number }">
				<input type="hidden" name="resume_id" value="${engageResume.res_id }">
				<input type="hidden" name="interview_id" value="${engageInterview.ein_id }">
				<input type="hidden" name="human_name" value="${engageResume.human_name }">
				<input type="hidden" name="human_idcard" value="${engageResume.human_idcard }">
				<input type="hidden" name="major_kind_id" value="${engageResume.human_major_kind_id }">
				<input type="hidden" name="major_kind_name" value="${engageResume.human_major_kind_name }">
				<input type="hidden" name="major_id" value="${engageResume.human_major_id }">
				<input type="hidden" name="major_name" value="${engageResume.human_major_name }">
				<input type="hidden" id="use_time" name="use_time" value="">
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>试卷编号</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>${engageExam.exam_number }</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>试题数量</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>${question.size() }</span>
					</td>
				</tr>
				<tr>
					<td width="20%" class="TD_STYLE1">
						<span>姓名</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>${engageResume.human_name }</span>
					</td>
					<td width="20%" class="TD_STYLE1">
						<span>身份证号</span>
					</td>
					<td width="30%" class="TD_STYLE1">
						<span>${engageResume.human_idcard }</span>
					</td>
				</tr>
					<c:forEach var="map" items="${question }" varStatus="s">
						<tr class="TD_STYLE1">
							<td class="TD_STYLE2">
								${s.index+1 }. &nbsp;&nbsp;  ${map.value.content }
								<input type="hidden" name="map[${s.index }].subject_id" value="${s.index+1 }">
							</td>
						</tr>
						<tr class="TD_STYLE1">
							<td class="TD_STYLE1">
								<input type="radio" value="a" name="map[${s.index }].answer">
								A.${map.value.key_a }
							</td>
						</tr>
						<tr class="TD_STYLE1">
							<td class="TD_STYLE1">
								<input type="radio" value="b" name="map[${s.index }].answer">
								B.${map.value.key_b }
							</td>
						</tr>
						<tr class="TD_STYLE1">
							<td class="TD_STYLE1">
								<input type="radio" value="c" name="map[${s.index }].answer">
								C.${map.value.key_c }
							</td>
						</tr>
						<tr class="TD_STYLE1">
							<td class="TD_STYLE1">
								<input type="radio" value="d" name="map[${s.index }].answer">
								D.${map.value.key_d }
							</td>
						</tr>
						<tr class="TD_STYLE1">
							<td class="TD_STYLE1">
								<input type="radio" value="e" name="map[${s.index }].answer">
								E.${map.value.key_e }
							</td>
						</tr>
					</c:forEach>
				
			</table>
		</form>
	</body>
</html>
<script type="text/javascript" src="/hr/jsp/javascript/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	window.onload = function() {
		var count = 0;
		var end = $("#limite_time").val() * 60;
		alert(end);
		timer = setInterval(function() {
            count++;
            $("#id_S").html(showNum(count % 60));
            $("#id_M").html(showNum(parseInt(count / 60) % 60));
            $("#id_H").html(showNum(parseInt(count / 60 / 60)));
            $("#use_time").val(count);
            if(count == end){
            	$("#questionForm").submit();
            }
        }, 1000);
		
		function showNum(num) {
            if (num < 10) {
                return '0' + num;
            }
            return num;
        }
		
		
	}
</script>