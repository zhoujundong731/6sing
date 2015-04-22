<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>歌曲评论页面</title>
<link href="../style/comment.css" rel="stylesheet" type="text/css" />
<link href="../style/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<!-- 头部菜单栏 -->
	<div class="top_main">
		<div class="top_main_main">
			<div class="top_main_main1 left">
				<a href="../index.jsp"><img src="../images/center_logo.png" /></a>
			</div>
			<div class="top_main_main2 left">
				<img src="images/top-1.gif" />
				<div class="top_main_main2_hide">
					<div class="left">
						<a href="../UserSong?temp=4">原创</a>
					</div>
					<div class="left">
						<a href="../UserSong?temp=5">翻唱</a>
					</div>
					<div class="left">
						<a href="../UserSong?temp=6">榜单</a>
					</div>
					<div class="left">
						<a href="../UserSong?temp=10">音乐人</a>
					</div>
					<div class="left">
						<a href="">电台</a>
					</div>
					<div class="left">
						<a href="../UserSong?temp=1">照片墙</a>
					</div>
					<div class="left">
						<a href="">MV</a>
					</div>
					<div class="left">
						<a href="">音乐商城</a>
					</div>
				</div>
			</div>
			<div class="top_main_main3 left">
				<div class="top_main_main3_m">
					<form method="post">
						<div class="top_main_main3_m_left left">
							<input type="text" name="stype" id="top_stype" value="原创" />
							<div class="top_stype_hide">
								<a href="###" onclick="Stype('type1')"><div>
										<span id="type1">伴奏</span>
									</div></a> <a href="###" onclick="Stype('type2')"><div>
										<span id="type2">翻唱</span>
									</div></a> <a href="###" onclick="Stype('type3')"><div>
										<span id="type3">时尚</span>
									</div></a> <a href="###" onclick="Stype('type4')"><div>
										<span id="type4">时尚</span>
									</div></a>
							</div>
						</div>
						<div class="top_main_main3_m_middle left">
							<input class="top_input" type="text" value="" maxlength="10" />
						</div>
						<div class="top_main_main3_m_right left">
							<input type="image" src="../images/sou.gif" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:if test="${!empty user}">
			<div class="top_user left">
				<div>
					<a href="userIndex.jsp">个人中心</a>
				</div>
				<div>
					<a href="">${user.uaccount}</a>
				</div>
				<div>
					<a href="userIndex.jsp?page=userInfo.jsp">设置</a>
				</div>
				<div>
					<a href="../TuiChu">安全退出</a>
				</div>
			</div>
		</c:if>
		<c:if test="${empty user }">
			<div class="top_main4 left">
				<div class="left">
					<a href="login.jsp">登陆</a>&nbsp;&nbsp; <a href="register.jsp">注册</a>&nbsp;&nbsp;
				</div>
			</div>
		</c:if>
		<div class="top_wen left">
			<img src="../images/top--.gif" />
			<div class="top_wen_hide">
				<div>
					<a href="">帮助中心</a>
				</div>
				<div>
					<a href="">常见问题</a>
				</div>
				<div>
					<a href="">教你录歌</a>
				</div>
				<div>
					<a href="">伴奏制作</a>
				</div>
				<div>
					<a href="">会员特权</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 头部菜单栏结束 -->
	<div class="com_top">
		<div>
			<div class="com_top_left">歌曲名: ${song.sname }</div>
			<div class="com_top_left">歌手: ${song.user.uname}</div>
			<div class="com_top_left">
				<img alt="${song.user.uname }" src="userimages${song.user.uimage}">
			</div>
			<div class="com_top_left">歌曲简介：${song.stext}</div>
		</div>
	</div>
	<div class="lishi">
		历史评论信息
	</div>
	<c:if test="${!empty comments}">
		<c:forEach items="${comments }" var="com">
			<div class="lp">
				<div class="lp_top">用户：${com.user.uname }</div>
				<div class="lp_min">内容：<c:if test="${!empty com.ctext}">${com.ctext }</c:if> </div>
				<div class="lp_foot">时间：${com.ctime}</div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${empty comments}">
			<div class="lp">
				<div class="lp_top">暂无评论</div>
			</div>
	</c:if>
	<div class="ping">
	 <form action="UserCollection?temp=6" method="post">
	发表评论：
		<input type="hidden" name="sid" value="${song.sid}">
		<textarea rows="6" cols="100" name="ctext">	
		</textarea>
		<input type="submit" value="评论">
	</form>
	</div>
</body>
</html>
<c:if test="${!empty param.msg&&param.msg!='null'}">
	<script>alert("${param.msg}")</script>
</c:if>