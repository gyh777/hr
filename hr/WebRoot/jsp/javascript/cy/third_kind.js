/**
 * 
 */

function rigistThirdKind(){
	var frm = document.getElementById("Third");
	frm.action = "/hr/jsp/third_kind_register.jsp";
    frm.submit();
}

function changeThirdKind(obj){
	var frm = document.getElementById("Third");
	var id = $(obj).parent().siblings(":first").text();
         frm.action = "/hr/thirdkindrigister/changerigister?thirdKindId="+id;
         frm.submit();
}

function deleteThirdKind(obj){
	var frm = document.getElementById("Third");
	var id = $(obj).parent().siblings(":first").text();
	frm.action = "/hr/thirdkindrigister/deleterigister?thirdKindId="+id;
    frm.submit();
}

function jumpPage(){
	var pageNo = $("#page").val();
    var pageSize = $("#pageSize").val();
    console.log(pageSize)
	$.ajax({
		url:"/hr/thirdkindrigister/ajax",
	    type:"post",
	    
	    data:{"pageNo" : pageNo,
	    	   "pageSize" : pageSize},
	    success:function(data){
	    	console.log(data);
	    }
	})
}

