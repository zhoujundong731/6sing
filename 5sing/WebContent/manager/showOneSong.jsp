<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_head">${song.sname}&nbsp;&nbsp;&nbsp;歌曲详情</p>
<div class="div_head">歌手：${song.user.uname}</div>
<c:if test="${empty song.album}">
	<div class="div_head">暂无专辑信息</div>
</c:if>
<c:if test="${!empty song.album}">
	<div class="div_head">专辑名：${song.album.bname}</div>
</c:if>
<table width="554" height="301" align="center" cellpadding="2px" cellspacing="0px">
			<tr>
				<td>歌曲姓名:</td>
				<td>${song.sname}</td>
			</tr>
			<tr>
				<td>请输入歌曲简介:</td>
				<td><textarea rows="" cols="" readonly="readonly">${song.stext}</textarea></td>
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
					<a href="ManagerSong?temp=7&sid=${song.sid}">修改</a>&nbsp;&nbsp;&nbsp;
					<a href="ManagerSong?temp=5&sid=${song.sid}" onclick="Del()">删除</a>
				</td>
			</tr>
		</table>