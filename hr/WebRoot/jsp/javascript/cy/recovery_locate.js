/**
 * 
 */

function recoveryHuman(obj){
	var frm = document.getElementById("delete_human");
	var id = $(obj).parent().siblings(":first").text();
	 frm.action = "/hr/humanfile/recoveryHumantwo?huf_id="+id;
     frm.submit();
}
