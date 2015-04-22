<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<p class="menu_head">管理员信息显示</p>
<c:if test="${!empty manager}">
	<table width="417" height="167" align="center" cellpadding="0px" cellspacing="0px" class="table_m">
		<tr>
			<td width="104" class="tr_left">管理员账号</td>
			<td width="256">${manager.mname}</td>
		</tr>
		<tr>
			<td  class="tr_left">管理员电话</td>
			<td><c:if test="${empty manager.mphone}">暂无信息</c:if>${manager.mphone}</td>
		</tr>
		<tr>
			<td  class="tr_left">管理员邮箱</td>
			<td><c:if test="${empty manager.memail}">暂无信息</c:if>${manager.memail}</td>
		</tr>
		
		<tr>
			<td class="tr_left">操作</td>
			<td><a href="managerIndex.jsp?page=updateManagerInfo.jsp">修改</a></td>
		</tr>
	</table>

</c:if>
<c:if test="${empty manager}">

</c:if>