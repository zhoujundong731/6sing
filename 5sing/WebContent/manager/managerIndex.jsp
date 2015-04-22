<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
<script type="text/javascript" language="javascript">
 	function cleck(ID){
		var classname=document.getElementById(ID).className;
		if(classname=="li_menu1"){
		document.getElementById(ID).className="li_menu2";
		}else{
			document.getElementById(ID).className="li_menu1";
			}
		} 
 	function Del() {
 		return confirm("确认删除？");
 	}

</script>
<link href="../style/managerIndex.css" type="text/css" rel="stylesheet" />
<link href="../style/showArt.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="hd">
		<%@ include file="header.jsp"%>
	</div>
	<div class="left">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="right">
		<c:if test="${!empty param.page}">
			<jsp:include page="${param.page}"></jsp:include>
		</c:if>
	</div>
</body>
<c:if test="${param.msg!=null&&param.msg!='null'}">
<script >alert("${param.msg}")</script>
</c:if>
</html>