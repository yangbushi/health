function verify() {
//	return false;
	$(".noNull").each(function() {
		return false;
		//var name = $(this).attr("name");
	    if($(this).val()=="") {
	    	var divshow = $("#showInfo");
            divshow.text("");
            //divshow.append("需要输入"+$(this).attr('notNull'));
	    	//alert($(this).attr('notNull')+"不能为空");
	    	return false;
	    }
	})
}