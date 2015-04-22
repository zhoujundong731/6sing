<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-2.1.1.min.js" language="javascript">
</script>
<script type="text/javascript">
	function isRightCode() {
		var code = $("#code").val();
	    code = "c=" + code;    
	    $.ajax({    
	        type:"POST",    
	        url:"Yanzheng",    
	        data:code,    
	        success:callback    
	    });   
	}
	function callback(data){    
	    $("#info").html(data);    
	}
	function changeImg() {
		var img=$("#imgObj");
		var src=img.attr("src");
		var newSrc=chgUrl(src);
		img.attr("src",newSrc); 
	}   
	function chgUrl(url){   
	    var timestamp = (new Date()).valueOf();       
	    urlurl = url + "?timestamp=" + timestamp;    
	    return urlurl;    
	}   
	//添加时间戳
	/* function timestamp(url){
	     //  var getTimestamp=Math.random();
	       var getTimestamp=new Date().getTime();
	      if(url.indexOf("?")>-1){
	        url=url+"&timestamp="+getTimestamp
	      }else{
	        url=url+"?timestamp="+getTimestamp
	      }
	      return url;
	    } */
	
</script>
</head>
<body>
	<form action="" method="post">
		<input id="code" type="text" value=""><br>
		<img id="imgObj" onclick="changeImg()" title="yanzhengma" alt="验证码" src="CodeServlet">
		<a href="#" onclick="changeImg()">看不清楚，换一张</a>
		<input type="button" value="验证" onclick="isRightCode()">
	</form>
	<div id="info"></div>
</body>
</html>