function dateToStr(datetime,dateformat){ 
	var year = parseInt(datetime.year)+1900;
	var month = datetime.month+1;//js从0开始取 
	var date = datetime.date; 
	var hour = datetime.hours; 
	var minutes = datetime.minutes; 
	var second = datetime.seconds;
	
	if(month<10){
		month = "0" + month;
	};
	if(date<10){
		date = "0" + date;
	};
	if(hour <10){
		hour = "0" + hour;
	};
	if(minutes <10){
	 	minutes = "0" + minutes;
	};
	if(second <10){
	 	second = "0" + second ;
	};
	 
	var time = "";
	if(dateformat=="1"){
		time = year+"-"+month+"-"+date;
	}else if(dateformat=="2"){
		time = year+"-"+month+"-"+date+" "+hour+":"+minutes+":"+second;
	};
	
	return time;
};
Calendar.setup ({
	inputField : "date_end",
	ifFormat : "%Y-%m-%d", 
	showsTime : false, 
	button : "date_end", 
	singleClick : true, 
	step : 1});
Calendar.setup ({
	inputField : "date",
	ifFormat : "%Y-%m-%d %H:%M:%S", 
	showsTime : false, 
	button : "date", 
	singleClick : true, 
	step : 1});
