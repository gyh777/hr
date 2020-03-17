/**
 * 
 */

function humanRig(){
	alert("提交成功");
	var frm = document.getElementById("human");
	frm.action = "/hr/humanfile/humanRigister";
    frm.submit();
}

