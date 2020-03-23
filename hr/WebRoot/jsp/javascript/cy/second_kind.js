/**
 * 
 */

function rigistSecondKind(){
	var frm = document.getElementById("Second");
	frm.action = "/hr/jsp/second_kind_register.jsp";
    frm.submit();
}

function changeSecondKind(obj){
	var frm = document.getElementById("Second");
	var id = $(obj).parent().siblings(":first").text();
         frm.action = "/hr/secondkindrigister/changerigister?secondKindId="+id;
         frm.submit();
}

function deleteSecondKind(obj){
	var frm = document.getElementById("Second");
	var id = $(obj).parent().siblings(":first").text();
	frm.action = "/hr/secondkindrigister/deleterigister?secondKindId="+id;
    frm.submit();
}

function jumpPage(){
	var pageNo = $("#page").val();
    var pageSize = $("#pageSize").val();
    console.log(pageSize)
	$.ajax({
		url:"/hr/secondkindrigister/ajax",
	    type:"post",
	    
	    data:{"pageNo" : pageNo,
	    	   "pageSize" : pageSize},
	    success:function(data){
	    	var list = data.list;
	    	var str = `
	    	<table width="100%" border="1" cellpadding=0 cellspacing=1
			bordercolorlight=#848284 bordercolordark=#eeeeee
			class="TABLE_STYLE1" id="content">
			<tr >
			    <td width="14%" class="TD_STYLE1">
					II级机构编号
				</td>
				<td width="14%" class="TD_STYLE1">
					I级机构编号
				</td>
				<td width="14%" class="TD_STYLE1">
					I级机构名称
				</td>
				
				<td width="14%" class="TD_STYLE1">
					II级机构名称
				</td>
				
			     <td width="18%" class="TD_STYLE1">
					薪酬标准责任人编号
				</td>
				<td width="18%" class="TD_STYLE1">
					销售责任人编号
				</td>
			
				<td width="6%" class="TD_STYLE1">
					变更
				</td>
				<td width="5%" class="TD_STYLE1">
					删除
				</td>
			</tr>
			</table>
	    	`;
	    	var pagecount = data.configFileSecondKind.count%data.configFileSecondKind.pagesize==0?(data.configFileSecondKind.count/data.configFileSecondKind.pagesize):(data.configFileSecondKind.count/data.configFileSecondKind.pagesize+1);
	    	$("#content ").find("tr :first").siblings().empty();
	        if(list){
	        	list.forEach(function(u){
	        		str+=`
	        		<tr>
					<td id="secondKindId" class="TD_STYLE2">
						${u.second_kind_id}
					</td>
					<td id="firstKindId" class="TD_STYLE2">
						${u.first_kind_id}
					</td>
					
					<td class="TD_STYLE2">
						${u.first_kind_name }
					</td>
					
					<td class="TD_STYLE2">
						${u.second_kind_name }
					</td>
					<td class="TD_STYLE2">
				    	${u.second_salary_id }
				    </td>
					<td class="TD_STYLE2">
						${u.second_sale_id }
					</td>
					
					<td class="TD_STYLE2">
					     <input type="button" value="变更" class="BUTTON_STYLE1" onclick="changeSecondKind(this)">
					</td>
					<td class="TD_STYLE2">
						<input type="button" value="删除" class="BUTTON_STYLE1" onclick="deleteSecondKind(this)">
					</td>
				</tr>
	        		`;
	        	})
	        	$("#content ").html(str);
	        	$("#pageSize").val(data.configFileSecondKind.pagesize);
	        	$("#pageNo").val(data.configFileSecondKind.pageid);
	        	$("p").empty();
	        	var p = `
	        	  <p>&nbsp;&nbsp;总数`+data.configFileSecondKind.pagesize+`例 &nbsp;&nbsp;&nbsp;当前第`+data.configFileSecondKind.pageid+`页  &nbsp;&nbsp;&nbsp;共`+pagecount+` 页  &nbsp;&nbsp;&nbsp;跳到第 <input id="page" type="text" > 页&nbsp;&nbsp;<input type="button" value="跳转" width=18 height=18 border=0 onclick="jumpPage()">
	        	  `;
	        	  $("#content").parent().append(p);
	        	
	        }
	    }
	})
}