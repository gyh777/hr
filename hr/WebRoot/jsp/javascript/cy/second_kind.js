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

