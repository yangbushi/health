<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/verifyNotNull.js"></script>
<script type="text/javascript">
$(document).ready(function(){
//	alert("ready");
	$(".noUsername")(function() {
		alert("ready");
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
	
// 	$("#login").validate({
// 		rules:{
// 			username:"required",
	
// 		}
// 	});
})
</script>
</head>

<body>
	<form id="login" action="send.html" method="post" >
		<div id="box">
			<ul>
				<li class="center">卫生云信息平台</li>
			</ul>
			<text id="showInfo"></text>
			<ul>
				<li class="left">账&nbsp;号：<input id="username" type="text" name="username" value="${username}" class="noUsername" notNull="账号"/></li>
			</ul>
			<ul>
				<li class="left">密&nbsp;码：<input type="password" name="password" value="${password}" class="noPassword" notNull="密码"/></li>
			</ul>
			<ul>
				<li class="left">验证码：<input type="text" name="code" /><img id="imgObj" onclick="javascript:changeImg()" src="code.html" /></li>
			</ul>
			<ul>
				<li class="left">后台返回数据：<input type="text" value="${info}" readonly="readonly"/></li>
			</ul>
			<input type="submit" id="send" value="登录"/>
		</div>
	</form>
    
    <script type="text/javascript"> 
	    function changeImg() { 
	        var imgSrc = $("#imgObj");
	        imgSrc.attr("src", chgUrl("code.html")); 
	    } 
	    function chgUrl(url) { 
	        var timestamp = (new Date()).valueOf(); 
	        if ((url.indexOf("&") >= 0)) { 
	            url = url + "×tamp=" + timestamp; 
	        } else { 
	            url = url + "?timestamp=" + timestamp; 
	        } 
	        return url; 
	    } 
	</script>
</body>
</html>