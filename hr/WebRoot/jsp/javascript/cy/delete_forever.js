/**
 * 
 */

function deleteForever(obj){
	var frm = document.getElementById("forever");
	var id = $(obj).parent().siblings(":first").next().text();
	 frm.action = "/hr/humanfile/deleteForevertwo?human_name="+id;
     frm.submit();
}
