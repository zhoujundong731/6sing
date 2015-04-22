<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="style/photo.css" type="text/css" rel="stylesheet" />
</head>
<body>

<c:if test="${empty photo}">
<c:redirect url="UserSong?temp=1"></c:redirect>
</c:if>

<!-- 头部菜单栏 -->
<div class="top_main">
	<div class="top_main_main">
    	<div class="top_main_main1 left">
        	<a href="index.jsp"><img src="images/center_logo.png" /></a>
        </div>
        <div class="top_main_main2 left">
        <img src="images/top-1.gif"/>
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
                	<input type="text" name="stype" id="top_stype" value="原创"/>
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
                  <input type="image" src="images/sou.gif"  />
                </div>
                </form>
            </div>
        </div>
    </div>
    <c:if test="${!empty user}">
     <div class="top_user left">
     	<div><a href="user/userIndex.jsp">个人主页</a></div>
        <div><a href="">${user.uaccount}</a></div>
        <div><a href="user/userIndex.jsp?page=userInfo.jsp">设置</a></div>
        <div><a href="TuiChu">安全退出</a></div>
     </div>
    </c:if>
   <c:if test="${empty user }">
	    <div class="top_main4 left">
	    	<div class="left">
	   	 		<a href="login.jsp">登陆</a>&nbsp;&nbsp;
	   			<a href="register.jsp">注册</a>&nbsp;&nbsp;  
	        </div>
	    </div>
    </c:if>
    <div class="top_wen left"><img src="images/top--.gif"/>
    		<div class="top_wen_hide">
            	<div>
                	<a href="###">帮助中心</a>
                </div>
                <div>
                	<a href="###">常见问题</a>
                </div>
                <div>
                	<a href="###">教你录歌</a>
                </div>
                <div>
                	<a href="###">伴奏制作</a>
                </div>
                <div>
                	<a href="###">会员特权</a>
                </div>
            </div>
      </div>
</div>
<!-- 头部菜单栏结束 -->
    <div align="center">
        <!--顶部横条-->
        <!--导航栏-->
        <!--照片墙  --> 
        <div class="black">
            <div class="black_top">
                <div class="black_top_font_big">What do you think is the Best Song in the world?</div>
                <div class="black_top_join"><a href="register.jsp"><img src="images/join-us.gif"/></a></div>
                <div class="black_top_font_little">开始你的音乐之旅</div>
            </div>
            <div class="middle">
                <div class="wite_middle">
                
                	<c:if test="${!empty photo }">
                		<c:forEach items="${photo }" var="user">
                			<a href="###"><div class="photo">
                    			<img src="userimages/${user.uimage }"  width="120" height="120"/>
                    			<div class="pohto_hide">
                    			<div class="photo_h1">${user.uname }</div>
                    			<div class="photo_h2">${user.usign}</div>
                    		</div></a>
                    </div>
                		</c:forEach>
                	
                	</c:if>
                    <!-- <div class="photo">
                    	<img src="images/hot2-1.jpg"  width="120" height="120"/>
                    	<div class="pohto_hide">
                    		<div class="photo_h1">姓名</div>
                    		<div class="photo_h2">加的撒旦的时刻撒娇</div>
                    	</div>
                    </div> -->
                    
                </div>
            </div>
        </div>
        <!--照片墙  --> 
        <!--底部合作伙伴等-->
        <div class="bottom">
           <div class="bottom_font">
              <a href="###">关于我们</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="###">版权声明</a>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="###">站务论坛</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a href="###">5sing帮助</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="###">友情链接</a>	
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a href="###">热门歌曲</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="###">合作伙伴</a>
              
           </div>
        </div>
        <!--底部合作伙伴等-->
    </div>     
</body>
</html>