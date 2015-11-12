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

function myVerify () {
//	alert("myveryf");
// 	alert($(".noUsername").attr("notNull"));
// 	alert($(".noUsername").val());
	if($(".noUsername").val() == "") {
//		alert("myveryf");
//		var divshow = $("#showInfo");
//        divshow.text("");
//        divshow.append("需要输入" + $(".noUsername").attr("notNull"));
		$("#showInfo").text("");
		$("#showInfo").text("需要输入" + $(".noUsername").attr("notNull"));
        return false;
	}
	
	if($(".noPassword").val() == "") {
//		alert("myveryf");
		var divshow = $("#showInfo");
        divshow.text("");
        divshow.append("需要输入" + $(".noPassword").attr("notNull"));
        return false;
	}
	
//	alert("M");
//	session.setAttribute("a",  "hehe");  //把b放到session里，命名为a，  
//	String M = session.getAttribute("a").toString(); //从session里把a拿出来，并赋值给M
//	alert(M);
//
//	
//	alert("before code");
/////	HttpSession session = request.getSession();
//	var code = request.getSession().getAttribute("code");
//	alert(code);


	//	var code = ""<%=Session["code"]%>""; // 取出你session里存的验证码
	//	HttpSession s = request.getSession(); 
//		HttpSession Session = request.getSession();
//		HttpSession session = request.getSession(); 
//		var code = Session.getAttribute("code");
//		alert(code);
//		var input = $('#verify').val(); // 通过jQuery获取用户在页面上输入的验证码
//		if (code != input) {
//			alert("validate code is incorrect");
//		}

	
//	alert("before send");
//	var url = "send";
//	$.get(url, null, callback);
}

function callback(data) {
	alert("callback");
	alert(data);
	var divshow = $("#showInfo");
	
    divshow.text("");
    divshow.append(data.getAttribute("error"));
}
