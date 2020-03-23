/**
 * 
 */

function rigistThirdKind(){
	var frm = document.getElementById("Third");
	frm.action = "/hr/jsp/third_kind_register.jsp";
    frm.submit();
}

function changeThirdKind(obj){
	var frm = document.getElementById("Third");
	var id = $(obj).parent().siblings(":first").text();
         frm.action = "/hr/thirdkindrigister/changerigister?thirdKindId="+id;
         frm.submit();
}

function deleteThirdKind(obj){
	var frm = document.getElementById("Third");
	var id = $(obj).parent().siblings(":first").text();
	frm.action = "/hr/thirdkindrigister/deleterigister?thirdKindId="+id;
    alert("删除成功" +
    		"")
	frm.submit();
}

function jumpPage(){
	var pageNo = $("#page").val();
    var pageSize = $("#pageSize").val();
    console.log(pageSize)
	$.ajax({
		url:"/hr/thirdkindrigister/ajax",
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
					III级机构编号
				</td>
				<td width="14%" class="TD_STYLE1">
					I级机构编号
				</td>
				<td width="14%" class="TD_STYLE1">
					I级机构名称
				</td>
				<td width="14%" class="TD_STYLE1">
					II级机构编号
				</td>
				<td width="14%" class="TD_STYLE1">
					II级机构名称
				</td>
				<td width="14%" class="TD_STYLE1">
					III级机构编号
				</td>
				<td width="14%" class="TD_STYLE1">
					III级机构名称
				</td>
				
				<td width="18%" class="TD_STYLE1">
					销售责任人编号
				</td>
				<td width="18%" class="TD_STYLE1">
					是否零售
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
	    	var pagecount = data.configFileThirdKind.count%data.configFileThirdKind.pagesize==0?(data.configFileThirdKind.count/data.configFileThirdKind.pagesize):(data.configFileThirdKind.count/data.configFileThirdKind.pagesize+1);
	    	$("#content ").find("tr :first").siblings().empty();
	        if(list){
	        	list.forEach(function(u){
	        		str+=`
	        		<tr>
					<td id="thirdKindId" class="TD_STYLE2">
						${u.third_kind_id}
					</td>
					<td id="firstKindId" class="TD_STYLE2">
						${u.first_kind_id}
					</td>
					
					<td class="TD_STYLE2">
						${u.first_kind_name }
					</td>
					<td class="TD_STYLE2">
						${u.second_kind_id }
					</td>
					<td class="TD_STYLE2">
						${u.second_kind_name }
					</td>
					<td class="TD_STYLE2">
						${u.third_kind_id }
					</td>
					<td class="TD_STYLE2">
						${u.third_kind_name }
					</td>
					<td class="TD_STYLE2">
						${u.third_kind_sale_id }
					</td>
					<td class="TD_STYLE2">
						${u.third_kind_is_retail }
					</td>
					<td class="TD_STYLE2">
					     <input type="button" value="变更" class="BUTTON_STYLE1" onclick="changeThirdKind(this)">
					</td>
					<td class="TD_STYLE2">
						<input type="button" value="删除" class="BUTTON_STYLE1" onclick="deleteThirdKind(this)">
					</td>
				</tr>
	        		`;
	        	})
	        	$("#content ").html(str);
	        	$("#pageSize").val(data.configFileThirdKind.pagesize);
	        	$("#pageNo").val(data.configFileThirdKind.pageid);
	        	$("p").empty();
	        	var p = `
	        	  <p>&nbsp;&nbsp;总数`+data.configFileThirdKind.pagesize+`例 &nbsp;&nbsp;&nbsp;当前第`+data.configFileThirdKind.pageid+`页  &nbsp;&nbsp;&nbsp;共`+pagecount+` 页  &nbsp;&nbsp;&nbsp;跳到第 <input id="page" type="text" > 页&nbsp;&nbsp;<input type="button" value="跳转" width=18 height=18 border=0 onclick="jumpPage()">
	        	  `;
	        	  $("#content ").parent().append(p);
	        	
	        }
	    }
	})
}

