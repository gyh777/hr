/**
 * 
 */

function deleteHuman(obj){
	var frm = document.getElementById("delete_human");
	var id = $(obj).parent().siblings(":first").text();
	 frm.action = "/hr/humanfile/deleteHuman?huf_id="+id;
     frm.submit();
}
