/**
 * 
 */




function checkAgree(){
	var frm = document.getElementById("humancheck");
	
	var first =$("#first").text();
	var second =$("#second").text();
	var third = $("#third").text();
	var majorKind = $("#majorKind").text();
	var major =  $("#major").text();
         frm.action = "/hr/humanfile/checkagree?firstKindName="+first+"&secondKindName="+second+"&thirdKindName="+third+"&humanMajorKindName="+majorKind+"&humanMajorName="+major;
         frm.method = "post";
        	 frm.submit();
}

//下拉框从数据库里面拿值
function selectPro(){
	var frm = document.getElementById("sex");
	var sex = frm.value;
		$(".SELECT_STYLE1 option[value='"+sex+"']").attr("selected",true)
	
}
