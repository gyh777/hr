/**
 * 
 */

function rigistFirstKind(){
	var frm = document.getElementById("First");
	frm.action = "/hr/jsp/first_kind_rigister.jsp";
    frm.submit();
}

function changeFirstKind(obj){
	var frm = document.getElementById("First");
	var id = $(obj).parent().siblings(":first").text();
         frm.action = "/hr/firstkindrigister/changerigister?firstKindId="+id;
         frm.submit();
}

function deleteFirstKind(obj){
	var frm = document.getElementById("First");
	var id = $(obj).parent().siblings(":first").text();
	frm.action = "/hr/firstkindrigister/deleterigister?firstKindId="+id;
    frm.submit();
}
