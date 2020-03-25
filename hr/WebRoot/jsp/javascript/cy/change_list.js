/**
 * 
 */

function changeHuman(obj){
	var frm = document.getElementById("changeHuman");
	var id = $(obj).parent().siblings(":first").text();
	 frm.action = "/hr/humanfile/changeHuman?huf_id="+id;
     frm.submit();
}
