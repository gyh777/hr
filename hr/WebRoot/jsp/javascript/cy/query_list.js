/**
 * 
 */

function deleteHuman(obj){
	var frm = document.getElementById("Query");
	var id = $(obj).parent().siblings(":first").text();
	 frm.action = "/hr/humanfile/checkHuman?huf_id="+id;
     frm.submit();
}
