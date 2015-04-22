<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
     //歌手类型认证
 	function isAtname(){
 	 		var txt= document.getElementById("atname").value;
 	 		if(txt.length==0){
 	 			document.getElementById("msg").innerHTML="请填写歌手类型！";
 	 			return false;
 	 		}
 	 		if(txt.length> 6){
 				document.getElementById("msg").innerHTML="歌手类型小于6位，重新输入!";
 				return false;	
 		}else{
 			document.getElementById("msg").innerHTML="";
 			return true;
 		}	
 	}
     </script>
<p class="menu_head">添加歌手类型</p>
<form action="ArtTypeServlet?temp=1" method="post" onsubmit="return isAtname()">
<table width="433" height="85" align="center" cellpadding="0px" cellspacing="0px">
	<tr>
		<td>&nbsp&nbsp&nbsp请输入歌手类型:</td>
		<td><input type="text" name="atname" id="atname" onblur="isAtname()" value=""/></td>
	</tr>
	<tr>
		<td colspan="2">
		<span id="msg"></span><br/>
		<input type="submit" value="添加"/>
		&nbsp&nbsp&nbsp<input type="reset" value="重置"/></td>
	</tr>
</table>
</form>