<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_head">${song.sname}&nbsp;&nbsp;&nbsp;歌曲详情</p>
<div class="div_head">歌手：${user.uname}</div>
<table width="579" height="300" align="center" cellpadding="2px" cellspacing="0px">
			<tr>
				<td width="122">歌曲姓名:</td>
				<td width="434">${song.sname}</td>
			</tr>
			<tr>
				<td>请输入歌曲简介:</td>
				<td><textarea readonly="readonly" rows="" cols="">${song.stext}</textarea></td>
			</tr>
			<tr>
				<td>MP3地址:</td>
				<td>
					<c:if test="${empty song.smaddress}">
						暂无信息
					</c:if>${song.smaddress}
				</td>
			</tr>
			<tr>
				<td>高品质音乐地址</td>
				<td><c:if test="${empty song.swaddress}">暂无信息
					</c:if>${song.swaddress}
				</td>
			</tr>
			<tr>
				<td>MV地址</td>
				<td>
					<c:if test="${empty song.svaddress}">暂无信息
					</c:if>${song.svaddress}
				</td>
			</tr>
			<tr>
				<td>歌词:</td>
				<td><textarea rows="7" cols="40" name="slrc" readonly="readonly">${song.slrc}</textarea></td>
			</tr>
			<tr>
				<td>歌曲类型:</td>
				<td>
					<c:if test="${!empty song.songtypes }">
						<c:forEach items="${song.songtypes }" var="st">
							${st.stname}&nbsp;&nbsp;&nbsp;
						</c:forEach>
					</c:if>
					<c:if test="${empty song.songtypes }">
						暂无类型信息
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="UserIndex?temp=6&sid=${song.sid}">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="UserIndex?temp=7&sid=${song.sid}" onclick="Del()">删除</a>
				</td>
			</tr>
		</table>