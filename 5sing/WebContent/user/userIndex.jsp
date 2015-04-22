<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<script type="text/javascript" language="javascript">
 	function Del() {
 		return confirm("确认删除？");
 	}

</script>
<link href="../style/userIndex.css" type="text/css" rel="stylesheet">
<link href="../style/index.css" type="text/css" rel="stylesheet">
</head>
<body>
	<!-- 头部菜单栏 -->
	<div class="top_main">
		<div class="top_main_main">
			<div class="top_main_main1 left">
				<a href="../index.jsp"><img src="../images/center_logo.png" /></a>
			</div>
			<div class="top_main_main2 left">
				<img src="../images/top-1.gif" />
				<div class="top_main_main2_hide">
					<div class="left">
						<a href="">原创</a>
					</div>
					<div class="left">
						<a href="">翻唱</a>
					</div>
					<div class="left">
						<a href="">榜单</a>
					</div>
					<div class="left">
						<a href="">音乐人</a>
					</div>
					<div class="left">
						<a href="">电台</a>
					</div>
					<div class="left">
						<a href="">照片墙</a>
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
		                    	<a href="###" onclick="Stype('type1')"><div >
		                        	<span id="type1">hhhh</span>
		                        </div></a>
		                        <a href="###" onclick="Stype('type2')"><div >
		                        	<span id="type2">ssss</span>
		                        </div></a>
		                        <a href="###" onclick="Stype('type3')"><div >
		                        	<span id="type3">yyyyy</span>
		                        </div></a>
		                        <a href="###" onclick="Stype('type4')"><div >
		                        	<span id="type4">kkkkk</span>
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
					<a href="userIndex.jsp">个人主页</a>
				</div>
				<div>
					<a href="userIndex.jsp">${user.uaccount}</a>
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
	<!--顶部菜单栏结束-->
	<div class="div_top2">
		<div class="div_userInfo"><%@ include file="userTop.jsp"%></div>
	</div>
	<div class="foot">
		<div class="index_main">
			<jsp:include page="${param.page }"></jsp:include>
		</div>
	</div>
</body>
</html>
<c:if test="${param.msg!=null&&param.msg!='null'}">
	<script>alert("${param.msg}")</script>
</c:if>