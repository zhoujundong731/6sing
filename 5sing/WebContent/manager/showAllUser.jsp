<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu_head">用户和歌手信息显示</p>
<table align="center" cellpadding="2px" cellspacing="0px">
	<tr class="menu_top">
		<td>账号</td>
		<td>姓名</td>
		<td>邮箱</td>
		<td>电话</td>
		<td>住址</td>
		<td>性别</td>
		<td>头像</td>
		<td>简介/个性签名</td>
		<td>状态</td>
		<td>身份</td>
		<td>操作</td>
	</tr>
	<c:if test="${!empty users}">
		<c:forEach items="${users}" var="user" varStatus="a">
			<c:if test="${a.index%2==0}">
				<tr class="tr_white">
					<td><c:if test="${empty user.uaccount}">暂无信息</c:if>${user.uaccount}</td>
					<td><c:if test="${empty user.uname}">暂无信息</c:if>${user.uname}</td>
					<td><c:if test="${empty user.uemail}">暂无信息</c:if>${user.uemail }</td>
					<td><c:if test="${empty user.uphone}">暂无信息</c:if>${user.uphone }</td>
					<td><c:if test="${empty user.uaddress}">暂无信息</c:if>${user.uaddress}</td>
					<td><c:if test="${user.usex==0}">男</c:if> <c:if
							test="${user.usex==1}">女</c:if></td>
					<td><c:if test="${empty user.uimage}">暂无信息</c:if> <c:if
							test="${!empty user.uimage}">
							<img alt="${user.uname}" src="../userimages/${user.uimage }"
								height="30px" width="30px">
						</c:if></td>
					<td><c:if test="${empty user.usign}">暂无信息</c:if>
						<div class="span_text">${user.usign }</div></td>
					<td><c:if test="${user.uflag==0}">锁定</c:if> <c:if
							test="${user.uflag==1}">正常</c:if></td>
					<td><c:if test="${user.upower==0}">用户</c:if> <c:if
							test="${user.upower==1}">歌手</c:if></td>
					<td><c:if test="${user.upower==0}">
							<a></a>&nbsp;&nbsp<a></a>
							<c:if test="${user.uflag==0}">
								<a href="UserServlet?temp=4&uid=${user.uid}">解锁</a>
							</c:if>
							<c:if test="${user.uflag==1}">
								<a href="UserServlet?temp=4&uid=${user.uid}">锁定</a>
							</c:if>
						</c:if> <c:if test="${user.upower==1}">
							<a href="UserServlet?temp=5&uid=${user.uid}">修改</a>&nbsp&nbsp
							<c:if test="${user.uflag==0}">
								<a href="UserServlet?temp=4&uid=${user.uid}">解锁</a>
							</c:if>
							<c:if test="${user.uflag==1}">
								<a href="UserServlet?temp=4&uid=${user.uid}">锁定</a>
							</c:if>
							<a href="UserServlet?temp=7&uid=${user.uid}" onclick="Del()">删除</a>
						</c:if></td>
				</tr>
			</c:if>
			<c:if test="${a.index%2==1}">
				<tr class="tr_2">
					<td><c:if test="${empty user.uaccount}">暂无信息</c:if>
						${user.uaccount}</td>
					<td><c:if test="${empty user.uname}">暂无信息</c:if>${user.uname}</td>
					<td><c:if test="${empty user.uemail}">暂无信息</c:if>${user.uemail }</td>
					<td><c:if test="${empty user.uphone}">暂无信息</c:if>${user.uphone }</td>
					<td><c:if test="${empty user.uphone}">暂无信息</c:if>${user.uphone }</td>
					<td><c:if test="${user.usex==0}">男</c:if> <c:if
							test="${user.usex==1}">女</c:if></td>
					<td><c:if test="${empty user.uimage}">暂无信息</c:if> <c:if
							test="${!empty user.uimage}">
							<img alt="${user.uname}" src="../userimages/${user.uimage }"
								height="30px" width="30px">
						</c:if></td>
					<td><c:if test="${empty user.usign}">暂无信息</c:if>
						<div class="span_text">${user.usign }</div></td>
					<td><c:if test="${user.uflag==0}">锁定</c:if> <c:if
							test="${user.uflag==1}">正常</c:if></td>
					<td><c:if test="${user.upower==0}">用户</c:if> <c:if
							test="${user.upower==1}">歌手</c:if></td>
					<td><c:if test="${user.upower==0}">
							<a></a>&nbsp;&nbsp<a></a>
							<c:if test="${user.uflag==0}">
								<a href="UserServlet?temp=4&uid=${user.uid}">解锁</a>
							</c:if>
							<c:if test="${user.uflag==1}">
								<a href="UserServlet?temp=4&uid=${user.uid}">锁定</a>
							</c:if>
						</c:if> <c:if test="${user.upower==1}">
							<a href="UserServlet?temp=5&uid=${user.uid}">修改</a>&nbsp&nbsp
							<c:if test="${user.uflag==0}">
								<a href="UserServlet?temp=4&uid=${user.uid}">解锁</a>
							</c:if>
							<c:if test="${user.uflag==1}">
								<a href="UserServlet?temp=4&uid=${user.uid}">锁定</a>
							</c:if>
							<a href="UserServlet?temp=7&uid=${user.uid}" onclick="Del()">删除</a>
						</c:if></td>
				</tr>
			</c:if>
		</c:forEach>
	</c:if>
	<tr>
		<td colspan="11">
			<div class="sub">
				<div class="sub1">
					<a href="UserServlet?temp=3&cp=1">首页</a>
				</div>
				<c:forEach begin="1" end="${subpage.totalPage}" var="i">
					<div class="sub1">
						<a href="UserServlet?temp=3&cp=${i}">${i }</a>
					</div>
				</c:forEach>
				<div class="sub1">
					<a href="UserServlet?temp=3&cp=${subpage.totalPage }">尾页</a>
				</div>
				<div class="sub2">当前第${subpage.currentPage }页/共${subpage.totalPage}页</div>
			</div>
		</td>
	</tr>
</table>