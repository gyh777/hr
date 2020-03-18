/**
 * 
 */

function checkHumanReg(obj){
	var frm = document.getElementById("check_human");
	var id = $(obj).parent().siblings(":first").text();
	 frm.action = "/hr/humanfile/checkHuman?huf_id="+id;
     frm.submit();
}
