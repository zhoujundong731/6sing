<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
     //歌曲类型认证
 	function isStname(){
 	 		var txt= document.getElementById("stname").value;
 	 		if(txt.length==0){
 	 			document.getElementById("msg").innerHTML="请填写歌曲类型！";
 	 			return false;
 	 		}
 	 		if(txt.length > 6){
 				document.getElementById("msg").innerHTML="歌曲类型小于6位，重新输入！";
 				return false;	
 		}else{
 			document.getElementById("msg").innerHTML="";
 			return true;
 		}	
 	}
     </script>
<%String stname=new String(request.getParameter("stname").getBytes("iso-8859-1"),"utf-8");%>
<p class="menu_head">歌曲类型修改页面</p>

<form action="SongTypeServlet?temp=4" method="post" onsubmit="return isStname()">
<input type="text" name="stid" id="stid" hidden="true" value="${param.stid}"/>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr>
		<td>歌曲类型</td>
		<td><input type="text" id="stname" onblur="isStname()" name="stname" value="<%=stname%>"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<span id="msg"></span><br>
		<input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/></td>
	</tr>
</table>
</form>