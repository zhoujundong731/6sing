<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String atname=new String(request.getParameter("atname").getBytes("iso-8859-1"),"utf-8");%>
<p class="menu_head">歌手类型修改页面</p>

<form action="ArtTypeServlet?temp=4" method="post">
<input type="text" name="atid" id="atid" hidden="true" value="${param.atid}"/>
<table width="280" height="92" align="center" cellpadding="2px" cellspacing="0px">
	<tr>
		<td width="85">歌手类型</td>
		<td width="185"><input type="text" id="atname" name="atname" value="<%=atname %>"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/></td>
	</tr>
</table>
</form>