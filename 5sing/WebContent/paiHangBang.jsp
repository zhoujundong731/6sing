<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="phb"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>排行榜</title>
<link href="style/index.css" type="text/css" rel="stylesheet" />
<link href="style/bangDan.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="script/index.js" language="javascript">
</script>
</head>
<body>
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
                	<input type="text" name="stype" id="top_stype" value="原创"/>
                    <div class="top_stype_hide">
                    	<a href="###" onclick="Stype('type1')"><div >
                        	<span id="type1">伴奏</span>
                        </div></a>
                        <a href="###" onclick="Stype('type2')"><div >
                        	<span id="type2">翻唱</span>
                        </div></a>
                        <a href="###" onclick="Stype('type3')"><div >
                        	<span id="type3">时尚</span>
                        </div></a>
                        <a href="###" onclick="Stype('type4')"><div >
                        	<span id="type4">通俗</span>
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
    <phb:if test="${!empty user}">
     <div class="top_user left">
     	<div><a href="user/userIndex.jsp">个人中心</a></div>
        <div><a href="">${user.uaccount}</a></div>
        <div><a href="user/userIndex.jsp?page=userInfo.jsp">设置</a></div>
        <div><a href="TuiChu">安全退出</a></div>
     </div>
    </phb:if>
   <phb:if test="${empty user }">
	    <div class="top_main4 left">
	    	<div class="left">
	   	 		<a href="login.jsp">登陆</a>&nbsp;&nbsp;
	   			<a href="register.jsp">注册</a>&nbsp;&nbsp;  
	        </div>
	    </div>
    </phb:if>
    <div class="top_wen left"><img src="images/top--.gif"/>
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
<!--上部菜单-->

<!--榜单页面开始-->
<div class=" menu1 " align="center">
    <!--导航条的开始-->
    <div class="menu2">
       <!--绝对定位 定位导航 -->
       <div class="dao_hang">
          <div class="dao_fen1">
             <span class="dao_text">排行榜</span>
          
          </div>
          <div class="dao_fen dao_text1"><a href="UserSong?temp=6">原创音乐榜</a></div>
          <div class="dao_fen dao_text1"><a href="UserSong?temp=7">翻唱流行榜</a></div>
          <div class="dao_fen dao_text1"><a href="UserSong?temp=8">下载排行榜</a></div>
          <div class="dao_fen dao_text1"><a href="UserSong?temp=9">收藏排行榜</a></div>
       
       </div>
    
    
    
	</div>
    <!--榜单的歌曲页面 -->
    <div class="menu3">
       <!--榜单 歌曲页面top-->
       <div class="bang_top">
            <!--待定-->
            <div class="bang_top_1">${temp}<br />
            <!-- <a href="UserSong?temp=12">试听全部</a> --></div>
            <div class="bang_top_3 bang_top_3_text" align="center">
                <div class="bang_top_3_2">编号</div>
                <div class="bang_top_3_3">歌曲名</div>
                <div class="bang_top_3_4">音乐人</div>
                <div class="bang_top_3_5">热度</div>
                <div class="bang_top_3_6">操作</div>
            </div>
       </div>
       <!--榜单歌曲middle-->
       <div class="bang_middle">
       <phb:if test="${empty songs}">暂无歌曲</phb:if>
       <phb:if test="${!empty songs}">
       <phb:forEach items="${songs}" var="song">
         <div class="bang_middle_1">
                <div class="bang_top_3_2">${song.sid }</div>
                <div class="bang_top_3_3"><a href="">${song.sname }</a></div>
                <div class="bang_top_3_4"><a href=""></a>${song.user.uname}</div>
                <div class="bang_top_3_5">${song.sclick }次播放</div>
                <div class="bang_top_3_6">
                   <a href="UserSong?temp=3&sid=${song.sid}">试听</a>&nbsp;
                   <a href="UserSong?temp=3&sid=${song.sid}">下载</a>&nbsp;
                   <phb:if test="${empty user}">
                   		<a href="user/userIndex.jsp">评论</a>&nbsp;
                   </phb:if>
                   <phb:if test="${!empty user}">
                   		<a href="user/UserCollection?temp=5&sid=${song.sid }">评论</a>&nbsp;
                   </phb:if>                
                   <phb:if test="${empty user}">
                   		<a href="user/userIndex.jsp">收藏</a>
                   </phb:if>
                    <phb:if test="${!empty user}">
                   		<a href="user/UserCollection?temp=3&sid=${song.sid }">收藏</a>
                   </phb:if>
                </div>
         </div>
         </phb:forEach>
         </phb:if>
       </div>
    </div>
    
    


</div>



</body>
</html>