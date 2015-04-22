<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	//管理员验证
 	function isMname(){
 		var user = document.getElementById("mname").value;
 		if(user.length==0){
 			document.getElementById("msg").innerHTML="请填写用户名！";
 			return false;
 		}
 		if(user.length > 8){
			document.getElementById("msg").innerHTML="用户位数小于8位，重新输入!";
			return false;	
	}else{
		document.getElementById("msg").innerHTML="";
		return true;
	}	
}
	//邮箱验证
function isMemail(){
	var va=document.getElementById("memail").value;
	var mail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; 
		if(!mail.test(va)){
		document.getElementById("msg").innerHTML="你的输入的邮箱不正确，请重新输入！";
		return false;
		}	
		if(va==""){
			document.getElementById("msg").innerHTML="请输入邮箱号！";
			return false;
			}else{
	    	  <!-- document.getElementById("msg4").value="";-->
			   document.getElementById("msg").innerHTML="";
					return true;
		}
	}	
//电话验证
function isMphone(){
	var vaphone=document.getElementById("mphone").value;
	var  phone= /^(((13[0-9]{1})|134|135|136|137|138|139|150|151|152|157|158|159|183|153|187|188|130|131|132|155|156|185|186|)+\d{8})$/; 
	if(vaphone.length==0){
		document.getElementById("msg").innerHTML="请输入手机号！";
		return false;
		}
	if(vaphone.length!==11){
		document.getElementById("msg").innerHTML="输入的手机位数不够！";
		return false;
		}
    if(!phone.test(vaphone)){
		document.getElementById("msg").innerHTML="输入有效手机号!";
		return false;		
	}else{
		document.getElementById("msg").innerHTML="";
		return true;
	}	
	}	
function isAll() {
	if (isMname() == false) {
		return false;
	} else if (isMemail() == false) {
		return false;
	}else if (isMphone() == false) {
		return false;
	}
	return true;
}
</script>
	
<p class="menu_head">管理员信息修改</p>
<form action="UpdateManager" method="post" onsubmit="return isAll()">
	<table width="378" height="185" align="center" cellpadding="2px" cellspacing="0px">
		<input type="hidden" name="mid" value="${manager.mid}"/>
		<input type="hidden" name="mpower" value="${manager.mpower}"/>
		<input type="hidden" name="mflag" value="${manager.mflag}"/>
		<tr>
			<td width="80" class="tr_left">管理员账号</td>
			<td width="198"><input type="text" name="mname" id="mname" onblur="isMname()" value="${manager.mname}"
				readonly="readonly" /></td>
		</tr>
		<tr>
			<td class="tr_left">管理员电话</td>
			<td><input type="text" name="mphone" id="mphone" onblur="isMphone()" value="${manager.mphone}" /></td>
		</tr>
		<tr>
			<td class="tr_left">管理员邮箱</td>
			<td><input type="text" name="memail" id="memail" onblur="isMemail()" value="${manager.memail}" /></td>
		</tr>
		<tr>
			
			<td colspan="2">
			<span id="msg"></span><br>
			<input type="submit" value="修改" />&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="重置" /></td>
		</tr>
	</table>
</form>