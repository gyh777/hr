/**
 * 
 */

function rigistSecondKind(){
	var frm = document.getElementById("Second");
	frm.action = "second_kind_rigister.jsp";
    frm.submit();
}

function changeSecondKind(){
	var frm = document.getElementById("Second");
	var id = $("#secondKindId").text();
         frm.action = "/hr/secondkindrigister/changerigister?secondKindId="+id;
         frm.submit();
}

function deleteSecondKind(){
	var frm = document.getElementById("Second");
	var id = $("#secondKindId").text();
	frm.action = "/hr/secondkindrigister/deleterigister?secondKindId="+id;
    frm.submit();
}
