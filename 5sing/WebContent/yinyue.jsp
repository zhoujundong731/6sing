<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐播放的页面</title>
<link href="style/player.css" type="text/css" rel="stylesheet" />
<link href="style/index.css" type="text/css" rel="stylesheet" />
</head>
<!-- class="menu_body"  background="images/111111.jpg" -->
<body id="music">
	<!-- 头部菜单栏 -->
	<div class="top_main">
		<div class="top_main_main">
			<div class="top_main_main1 left">
				<a href="index.jsp"><img src="images/center_logo.png" /></a>
			</div>
			<div class="top_main_main2 left">
				<img src="images/top-1.gif" />
				<div class="top_main_main2_hide">
					<div class="left">
						<a href="UserSong?temp=4">原创</a>
					</div>
					<div class="left">
						<a href="UserSong?temp=5">翻唱</a>
					</div>
					<div class="left">
						<a href="UserSong?temp=6">榜单</a>
					</div>
					<div class="left">
						<a href="UserSong?temp=10">音乐人</a>
					</div>
					<div class="left">
						<a href="">电台</a>
					</div>
					<div class="left">
						<a href="UserSong?temp=1">照片墙</a>
					</div>
					<div class="left">
						<a href="">活动</a>
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
							<input type="image" src="images/sou.gif" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:if test="${!empty user}">
			<div class="top_user left">
				<div>
					<a href="user/userIndex.jsp">个人中心</a>
				</div>
				<div>
					<a href="">${user.uaccount}</a>
				</div>
				<div>
					<a href="user/userIndex.jsp?page=userInfo.jsp">设置</a>
				</div>
				<div>
					<a href="TuiChu">安全退出</a>
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
			<img src="images/top--.gif" />
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

	<div>
		<!--主页面-->
		<div class=" menu_song_player">
			<!--页面歌词-->
			<div class="menu_song_lrc" align="center">
				歌词显示<br />
				<textarea class="lrc_text" rows="" cols="">${song.slrc }</textarea>

			</div>
			<!--页面left-->
			<div class="menu_song_left">
				<!--播放时插入图片-->
				<div class=" menu_song_left_1">
					<img alt="${song.user.uname }" src="userimages/${song.user.uimage}">
				</div>
				<!--播放界面-->
				<div class="menu_song_left_2">
					<object id="mPlayer1" width=260px; height=60px;
						classid="CLSID:6BF52A52-394A-11D3-B153-00C04F79FAA6">
						<c:if test="${!empty song}">
							<param name="URL" value="file/${song.smaddress}">
						</c:if>
						<%-- <c:if test="${!empty sm}">
							<param name="URL" value="file/${sm}">
						</c:if> --%>
						<param name="rate" value="1">
						<param name="balance" value="0">
						<param name="currentPosition" value="0">
						<param name="defaultFrame" value>
						<param name="playCount" value="100">
						<param name="autoStart" value="1">
						<param name="currentMarker" value="0">
						<param name="invokeURLs" value="1">
						<param name="baseURL" value>
						<param name="volume" value="100">
						<param name="mute" value="0">
						<param name="uiMode" value="full">
						<param name="stretchToFit" value="0">
						<param name="windowlessVideo" value="0">
						<param name="enabled" value="1">
						<param name="enableContextMenu" value="1">
						<param name="fullScreen" value="0">
						<param name="SAMIStyle" value>
						<param name="SAMILang" value>
						<param name="SAMIFilename" value>
						<param name="captioningID" value>
						<param name="enableErrorDialogs" value="0">
						<param name="_cx" value="7779">
						<param name="_cy" value="1693">
					</object>
				</div>
			</div>
			<!--页面right-->
			<div class=" menu_song_right">
				<%-- <!-- 循环读出歌曲名称 -->
				<c:if test="${!empty songs}">
					<c:forEach items="${songs }" var="song">
						<div class="menu_song_list" align="center">
							<span class="menu_song_list_text"><a
								href="yinyue.jsp?sm=${song.smaddress}">${song.sname}</a></span>
						</div>
					</c:forEach>
				</c:if> --%>
				<c:if test="${!empty song}">
					<div class="menu_song_list" align="center">
						<div class="menu_song_list_text"><a href="###">${song.sname}</a></div>
						<div class="menu_song_list_text"><a href="UserSong?temp=2&uid=${song.user.uid}">${song.user.uname}</a></div>
						<div class="menu_song_list_text"><a
							href="file/${song.smaddress}">点击下载</a></div>
						<div class="menu_song_list_text"><c:if test="${empty user}">
							<a href="user/userIndex.jsp">收藏</a>
						</c:if>
						<c:if test="${!empty user}">
							<a href="user/UserCollection?temp=3&sid=${song.sid }">收藏</a>
						</c:if></div>
						<div class="menu_song_list_text"><c:if test="${empty user}">
							<a href="user/userIndex.jsp">评论</a>
						</c:if>
						<c:if test="${!empty user}">
							<a href="user/UserCollection?temp=5&sid=${song.sid }">评论</a>
						</c:if></div>
					</div>
				</c:if>
				<br>
			</div>
		</div>
	</div>
</body>
</html>