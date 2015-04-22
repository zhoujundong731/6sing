<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="showAlbum">
	<p class="menu_head">${album.bname}&nbsp;&nbsp;专辑详情页面</p>
	<div class="showA1">
		<table align="center" cellpadding="0px" cellspacing="0px">
			<tr>
				<td>专辑名字</td>
				<td>${album.bname }</td>
			</tr>
			<tr>
				<td>专辑简介:</td>
				<td><textarea rows="4" cols="" name="btext">${album.btext}</textarea></td>
			</tr>
			<tr>
				<td>专辑图片:</td>
				<td><img alt="${album.bname}"
					src="../userimages/${album.bimage}" width="100px" height="100px;"></td>
			</tr>
			<tr>
				<td>操作</td>
				<td><a href="ManagerAlbum?temp=6&bid=${album.bid }">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="ManagerAlbum?temp=5&bid=${album.bid }" onclick="Del()">删除</a></td>
			</tr>
		</table>
	</div>
	<div class="showA2">
		<c:if test="${!empty album.songs}">
			<table align="center" cellpadding="0px" cellspacing="0px">
				<tr class="menu_top">
					<td>歌曲名</td>
					<td>简介</td>
					<td>点击量</td>
					<td>下载量</td>
					<td>收藏量</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${album.songs}" var="song" varStatus="a">
					<c:if test="${a.index%2==0}">
						<tr class="tr_white">
							<td>${song.sname}</td>
							<td>${song.stext }</td>
							<td>${song.sclick }</td>
							<td>${song.sdown }</td>
							<td>${song.scnum }</td>
							<td><a href="ManagerSong?temp=9&sid=${song.sid }&bid=${album.bid}" onclick="Del()">删除</a></td>
						</tr>
					</c:if>
					<c:if test="${a.index%2==1}">
						<tr>
							<td>${song.sname}</td>
							<td>${song.stext }</td>
							<td>${song.sclick }</td>
							<td>${song.sdown }</td>
							<td>${song.scnum }</td>
							<td><a href="ManagerSong?temp=9&sid=${song.sid }&bid=${album.bid}" onclick="Del()">删除</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty album.songs}">
	暂无歌曲信息
	</c:if>
	</div>
</div>