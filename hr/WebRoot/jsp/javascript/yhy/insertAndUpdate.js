//加载一级机构和职位分类
function loadFirstAndKindName(){
	$.ajax({
		type : "post",
		url : "../engageMajorRelease/loadFirstKindAndMajorKind",
		dataType : "json",
		success:function(result){
			//添加firstKindName列
			var firstList = result["firstValue"];
			var firstAddList ="";
			for(var i in firstList){
				var firstAllName = firstList[i].first + "/" +firstList[i].second;
    			firstAddList += 
    				"<option value='"+firstAllName+"'>"+firstAllName+"</option>";
			};
			$("select[name='firstKindName']").append(firstAddList);
			//添加majorKindName列
			var majorList = result["majorKindValue"];
			var majorAddList ="";
			for(var i in majorList){
				var majorAllName = majorList[i].first + "/" +majorList[i].second;
    			majorAddList += 
    				"<option value='"+majorAllName+"'>"+majorAllName+"</option>";
			};
			$("select[name='majorKindName']").append(majorAddList);
		},error:function(error){
			alert("I级机构和职位分类加载失败！请刷新重试！");
		}
	});
};
function kindNameChange(obj){
	//获得当前元素的name
	var name = $(obj).attr("name");
	var kind = $(obj).find("option:selected").val();
	var firstId = kind.substring(0,kind.indexOf("/"));
	var firstName = kind.substring(kind.indexOf("/")+1);
	//初始化要跳转的url和要传的数据data以及要添加子元素的父元素的name
	var url = "/hr/engageMajorRelease/";
	var data = {"firstName" : firstName};
	var addName = "";
	var valueId = "";
	var valueName = "";
	
	if(name == "firstKindName"){
		$("select[name='thirdKindName']").children("option").not(":eq(0)").remove();
		url = url + "selectSecondKindIdAndName";
		addName = "secondKindName";
		valueId = "first_kind_id";
		valueName = "first_kind_name";
	}else if(name == "secondKindName"){
		var kinds = $("select[name='firstKindName']").val();
		var secondName = kinds.substring(kind.indexOf("/")+1);
		url = url + "selectThirdKindIdAndName";
		data = {"firstName" : secondName, "secondName" : firstName};
		addName = "thirdKindName";
		valueId = "second_kind_id";
		valueName = "second_kind_name";
	}else if(name == "thirdKindName"){
		url = "";
		valueId = "third_kind_id";
		valueName = "third_kind_name";
	}else if(name == "majorKindName"){
		url = url + "selectAllMajorIdAndName";
		addName = "majorName";
		valueId = "major_kind_id";
		valueName = "major_kind_name";
	}else if(name == "majorName"){
		url = "";
		valueId = "major_id";
		valueName = "major_name";
	}else if(name == "engageType"){
		url = "";
		valueId = "engage_id";
		valueName = "engage_type";
		firstName = kind;
		firstId = "0";
	};
	//清空所有下级元素的内容
	$("select[name='"+ addName +"']").children("option").not(":eq(0)").remove();
	$("input[name='"+ valueId +"']").val(firstId);
	$("input[name='"+ valueName +"']").val(firstName);
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		data: data,
		success:function(result){
			$.each(result, function (i, value) {
				var values = value.first +"/"+ value.second;
				var content = "<option value='"+values+"'>"+ values +"</option>";
            	$("select[name='"+ addName +"']").append(content);
        	});
		}
	});
};
function insertOrUpdateEngageRelease(type){
	var url = "";
	var successMessage = "";
	var errorMessage = "";
	if(type=="insert"){
		url = "../engageMajorRelease/addEngageMajorRelease";
		successMessage = "添加成功！";
		errorMessage = "添加失败！请刷新重试！";
	}else if(type=="update"){
		url = "../engageMajorRelease/";
		successMessage = "更改成功！";
		errorMessage = "更改失败！请重试！";
	};
	var firstKindId = $("input[name='first_kind_id']").val();
	var firstKindName = $("input[name='first_kind_name']").val();
	var secondKindId = $("input[name='second_kind_id']").val();
	var secondKindName = $("input[name='second_kind_name']").val();
	var thirdKindId = $("input[name='third_kind_id']").val();
	var thirdKindName = $("input[name='third_kind_name']").val();
	var engageType = $("input[name='engage_type']").val();
	var majorKindId = $("input[name='major_kind_id']").val();
	var majorKindName = $("input[name='major_kind_name']").val();
	var majorId = $("input[name='major_id']").val();
	var majorName = $("input[name='major_name']").val();
	var humanAmount = $("input[name='human_amount']").val();
	var deadline = $("input[name='deadline']").val();
	var register = $("input[name='register']").val();
	var registTime = $("input[name='regist_time']").val();
	var majorDescribe = $("textarea[name='major_describe']").val();
	var engageRequired = $("textarea[name='engage_required']").val();
	
	var data = {
		"firstKindId" : firstKindId,"firstKindName" : firstKindName,
		"secondKindId" : secondKindId,"secondKindName" : secondKindName,
		"thirdKindId" : thirdKindId,"thirdKindName" : thirdKindName,
		"majorKindId" : majorKindId,"majorKindName" : majorKindName,
		"majorId" : majorId,"majorName" : majorName,"engageType" : engageType,
		"humanAmount" : humanAmount, "deadline" : deadline,
		"register" : register,"registTime" : registTime,
		"majorDescribe" : majorDescribe,"engageRequired" : engageRequired
	};
	
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		data: data,
		success:function(result){
			if(result==true){
				//window.location="../engageMajorRelease/selectAllEngageMajorRelease"
				//S		+"?jumpPage=engage_major_release_change";
				alert(successMessage);
				window.location = "";
			}else{
				alert(errorMessage);
			};
		}
	});
};