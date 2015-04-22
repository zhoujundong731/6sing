<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_head">所有歌曲信息显示页面</p>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td>歌曲名</td>
		<td>歌手</td>
		<td>歌手头像</td>
		<td>普通音乐</td>
		<td>高品质音乐</td>
		<td>MV</td>
		<td>简介</td>
		<td>点击量</td>
		<td>下载量</td>
		<td>收藏量</td>
		<td>操作</td>
	</tr>
	<c:if test="${!empty songs}">
		<c:forEach items="${songs}" var="song" varStatus="a">
			<c:if test="${a.index%2==0}">
				<tr class="tr_white">
					<td>${song.sname}</td>
					<td>${song.user.uname}</td>
					<td><c:if test="${empty song.user.uimage}">暂无信息</c:if> <c:if
								test="${!empty song.user.uimage}">
								<img alt="${song.user.uname}" src="../userimages/${song.user.uimage }" height="30px" width="30px">
						</c:if>
					</td>
					<td>
						<c:if test="${!empty song.smaddress}">有</c:if>
						<c:if test="${empty song.smaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.swaddress}">有</c:if>
						<c:if test="${empty song.swaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.svaddress}">有</c:if>
						<c:if test="${empty song.svaddress}">无</c:if>
					</td>
					<td><div class="span_text">${song.stext}</div></td>
					<td>${song.sclick }</td>
					<td>${song.sdown }</td>
					<td>${song.scnum }</td>
					<td><a href="ManagerSong?temp=6&sid=${song.sid}">查看详情</a></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1}">
				<tr class="tr_2">
					<td>${song.sname}</td>
					<td>${song.user.uname}</td>
					<td><c:if test="${empty song.user.uimage}">暂无信息</c:if> <c:if
								test="${!empty song.user.uimage}">
								<img alt="${song.user.uname}" src="../userimages/${song.user.uimage }" height="30px" width="30px">
						</c:if>
					</td>
					<td>
						<c:if test="${!empty song.smaddress}">有</c:if>
						<c:if test="${empty song.smaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.swaddress}">有</c:if>
						<c:if test="${empty song.swaddress}">无</c:if>
					</td>
					<td>
						<c:if test="${!empty song.svaddress}">有</c:if>
						<c:if test="${empty song.svaddress}">无</c:if>
					</td>
					<td><div class="span_text">${song.stext}</div></td>
					<td>${song.sclick }</td>
					<td>${song.sdown }</td>
					<td>${song.scnum }</td>
					<td><a href="ManagerSong?temp=6&sid=${song.sid}">查看详情</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
	<tr>
		<td colspan="11">
			<div class="sub">
				<div class="sub1">
					<a href="ManagerSong?temp=4&cp=1">首页</a>
				</div>
				<c:forEach begin="1" end="${subpage.totalPage}" var="i">
					<div class="sub1">
						<a href="ManagerSong?temp=4&cp=${i}">${i }</a>
					</div>
				</c:forEach>
				<div class="sub1">
					<a href="ManagerSong?temp=4&cp=${subpage.totalPage }">尾页</a>
				</div>
				<div class="sub2">当前第${subpage.currentPage }页/共${subpage.totalPage}页</div>
			</div>
		</td>
	</tr>
</table>