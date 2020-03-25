

function outFocus(){
	var first_kind_id = $("#first_kind_id").val();
	var second_kind_id = $("#second_kind_id").val();
	var third_kind_id = $("#third_kind_id").val();
	$.ajax({
	dataType:"json",
	url:'/hr/salarygrant/humanIdAndName?firstKindId='+first_kind_id+'&secondKindId'+second_kind_id+'&thirdKindId'+third_kind_id,
	type:'POST',
	contentType : 'application/json;charset=utf-8',
	async: false,
	success:function(date){
		$('#humanFile').html("");
	$.each(date,function(index,item){
								
								$('#humanAmount').val(index+1);
								
								$('#humanFile').append("<tr>"
									+"<td width='14%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].humanId' value='"+item.human_id+"' readonly='readonly'/>"
									+"</td>"
									+"<td width='15%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].humanName' value='"+item.human_name+"' readonly='readonly'/>"
									+"</td>"
									+"<td width='14%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].bounsSum' id='mybounsSum"+index+"' onblur='myout("+index+")'/>"
									+"</td>"
									+"<td width='14%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].saleSum' id='mysaleSum"+index+"' onblur='myout("+index+")'/>"
									+"</td>"
									+"<td width='14%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].deductSum' id='mydeductSum"+index+"' onblur='myout("+index+")'/>"
									+"</td>"
									+"<td width='14%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].salaryStandardSum' id='mysalaryStandardSum"+index+"' onblur='myout("+index+")'/>"
									+"</td>"
									+"<td width='15%' class='TD_STYLE1'>"
										+"<input type='text' class='INPUT_STYLE2' name='salaryGrantDetails["+index+"].salaryPaidSum' id='mysalaryPaidSum"+index+"' onblur='myout("+index+")'/>"
									+"</td>"
										+"</tr>"
								);
	                            
	                         });

	},
	error:function(){alert("error")}
	});
}

function myout(index){
	var a="#mysalaryPaidSum"+index;
	var mybounsSum="#mybounsSum"+index;
	var mysaleSum="#mysaleSum"+index;
	var mydeductSum="#mydeductSum"+index;
	var mysalaryStandardSum="#mysalaryStandardSum"+index;
	var b=$(mybounsSum).val();
	var c=$(mysaleSum).val();
	var d=$(mydeductSum).val();
	var e=$(mysalaryStandardSum).val();
	var sum=parseInt(b)+parseInt(c)-parseInt(d)+parseInt(e);
	$(a).val(sum);
	mysumsum();
}

function mysumsum(){
	var salarySum = 0;
	var a=$('input[name$=".salaryPaidSum"]').map(function(){
		return {value:this.value,name:this.name}}).get();
	for(var i=0;i<a.length;i++){
	salarySum=salarySum+parseInt(a[i].value);
				}
	$("#salaryPaidSum").val(salarySum);
}

//加载一级机构和职位分类
function loadFirstAndKindName(){
	//设置登记或更改时间
	$("input[name='time']").val(getNowDate(2));
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
function kindNameChange(obj,type){
	
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
		if(type==0){
			$("select[name='thirdKindName']").children("option").eq(0).remove();
		};
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
	}else if(name == "salaryStandard"){
		url = "";
		valueId = "engage_id";
		valueName = "engage_type";
		firstName = kind;
		firstId = "0";
	};
	
	//清空所有下级元素的内容
	$("select[name='"+ addName +"']").children("option").not(":eq(0)").remove();
	if(type==0){
		$("select[name='"+ addName +"']").children("option").eq(0).remove();
	};
	$("input[name='"+ valueId +"']").val(firstId);
	$("input[name='"+ valueName +"']").val(firstName);
	
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		data: data,
		success:function(result){
			if(type==0){
				$("select[name='"+ addName +"']").append("<option value=''></option>");
			};
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
	var operator = "";
	var mreId = "";
	if(type=="insert"){
		url = "../engageMajorRelease/addEngageMajorRelease";
		successMessage = "添加成功！";
		errorMessage = "添加失败！请刷新重试！";
		operator = $("input[name='register']").val();
	}else if(type=="update"){
		url = "../engageMajorRelease/toChange";
		successMessage = "更改成功！";
		errorMessage = "更改失败！请重试！";
		operator = $("input[name='changer']").val();
		mreId = $("input[name='mre_id']").val();
	};
	var time = $("input[name='time']").val();
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
	var majorDescribe = $("textarea[name='major_describe']").val();
	var engageRequired = $("textarea[name='engage_required']").val();
	
	var data = {
		"firstKindId" : firstKindId,"firstKindName" : firstKindName,
		"secondKindId" : secondKindId,"secondKindName" : secondKindName,
		"thirdKindId" : thirdKindId,"thirdKindName" : thirdKindName,
		"majorKindId" : majorKindId,"majorKindName" : majorKindName,
		"majorId" : majorId,"majorName" : majorName,"engageType" : engageType,
		"humanAmount" : humanAmount, "deadline" : deadline,
		"operator" : operator,"time" : time,"mreId" : mreId,
		"majorDescribe" : majorDescribe,"engageRequired" : engageRequired
	};
	console.log(data);
	
	$.ajax({
		type : "post",
		url : url,
		dataType : "json",
		data: data,
		success:function(result){
			if(result==true){
				alert(successMessage);
				if(type=="insert"){
					window.location = "";
				}else if(type=="update"){
					window.location = "../engageMajorRelease/selectAllEngageMajorRelease" +
							"?jumpPage=engage_major_release_change";
				};
			}else{
				alert(errorMessage);
			};
		}
	});
};