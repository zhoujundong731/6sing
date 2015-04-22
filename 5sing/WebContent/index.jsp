<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>5sing首页</title>
<link href="style/index.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="script/index.js" language="javascript">
</script>
</head>
<body onload="changeImg()">

<c:if test="${empty info}">
<c:redirect url="Index"></c:redirect>
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
                	<a href="###">电台</a>
                </div>
                <div class="left">
                	<a href="UserSong?temp=1">照片墙</a>
                </div>
                <div class="left">
                	<a href="MV?temp=1">MV</a>
                </div>
                <div class="left">
                	<a href="###">音乐商城</a>
                </div>
            </div>
        </div>
        <div class="top_main_main3 left">
        	<div class="top_main_main3_m">
            	<form method="post" action="UserSong?temp=13">
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
                	<input class="top_input" name="sname" type="text" value="" maxlength="10" />
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
     	<div><a href="user/userIndex.jsp">个人中心</a></div>
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
<!--上部菜单-->
<div class="top_menu">
	<div class="top_menu_main">
        <div>
            <a href="index.jsp"><div class="top_div2">
            	<div class="left"><img src="images/top1.gif" /></div>
                <div class="left">首页</div>
            </div></a>
            <a href="UserSong?temp=4"><div class="top_div2">
                <div class="left"><img src="images/top2.gif"  /></div>
                <div class="left">原唱</div>
            </div></a>
            <a href="UserSong?temp=5"><div class="top_div2">
                 <div class="left"><img src="images/top3.gif" /></div>
                 <div class="left">翻唱</div>
            </div></a>
            <a href="index.jsp"><div class="top_div2">
                 <div class="left"><img src="images/top4.gif" /></div>
                 <div class="left">伴奏</div>
            </div></a>
            <a href="UserSong?temp=6"><div class="top_div2">
                 <div class="left"><img src="images/top5.gif" /></div>
                 <div class="left">榜单</div>
            </div></a>
            <div class="top_div2"><img src="images/top_1_tiao.gif" /></div>
            <a href="UserSong?temp=10"><div class="top_div2">
                 <div class="left"><img src="images/top6.gif" /></div>
                 <div class="left">音乐人</div>
            </div></a>
            <a href="photo.jsp"><div class="top_div2">
                 <div class="left"><img src="images/top7.gif" /></div>
                 <div class="left">照片墙</div>
            </div></a>
            <a href="MV?temp=1"><div class="top_div2">
                 <div class="left"><img src="images/top8.gif" /></div>
                 <div class="left">MV</div>
            </div></a>
            <a href="index.jsp"><div class="top_div2">
                 <div class="left"><img src="images/top9.gif" /></div>
                 <div class="left">活动</div>
            </div></a>
        </div>
    </div>
</div>
<!-- 导航栏结束 -->
<div class="top_bgpicture">
    <div class="lala">
       <div class="lala_left"><img src="images/tu3.jpg" id="tu" border="0"/></div>
       <div class="lala_right">
           <div class="lala_big">推荐资讯</div>
           <div>
               <ul class="lala_font">
                   <li><a href="gao1.html">【推荐】男神，都是，男神经……</a></li>
                   <li><a href="gao2.html">不售门票的"山蛙音乐节"周六西溪开幕</a></li>
                   <li><a href="gao3.html">【演出】陈乐基携杀手锏乐队</a></li>
                   <li><a href="gao4.html">首届酷狗动漫音乐节打造跨年狂欢</a></li>
                   <li><a href="gao1.html">【推荐】据说这届有CV大神？！</a></li>
               </ul>
           </div>
       </div>
    </div>
</div>
<!-- 顶部图片变换，公告 -->

<!-- 热门音乐人 -->
<div align="center" class="hot_music_people">
<!--热门音乐人left-->
  <div class="hot_left">
      <div class="left"><img src="images/hotmusic.gif"/></div>
      <div class="big_font left">热门音乐人</div>
      <a href="UserSong?temp=2&uid=${oneUser.uid}"><div class="hot_left_main">
      	 <img src="userimages/${oneUser.uimage }"/><br />
     	 <div class="h1">${oneUser.uname}</div>
     	 <div class="h2">音乐制作人</div>
      </div></a>
  </div>
<!--热门音乐人left-->
<!--热门音乐人right-->
   <div class="hot_right">
      <div class="hot_right_top">
        <a href="UserSong?temp=10"><div class="right more">
          <img src="images/more.gif"/>
          <div class="right">More</div>
        </div></a>       
      </div>
      <!--More--> 
      <div class="hot_tight_picture" align="center">
      			<!--十个音乐人-->
      			<c:if test="${!empty tenUser}">
      				<c:forEach items="${tenUser }" var="user">
      					 <a href="UserSong?temp=2&uid=${user.uid}"><div class="left how">
             			 <img src="userimages/${user.uimage}"/>
            			 <div>${user.uname}</div>
            			 </div></a>
      				</c:forEach>
      			</c:if>
             
        
       </div>
       <!--图片-->
   </div>
<!--热门音乐人right-->
</div>
<!-- 热门音乐人结束 -->

<!--原唱、翻唱推荐-->
<div class="yuan">
<!--左边1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111-->
     <div class="left yuan2">
         <div class="yuan_top">
             <img src="images/yuan.gif"/>
             <div class="yuan_big_font">原创推荐</div>
             <div class="yuan_top_bo"><a href="UserSong?temp=4"><img src="images/bo.gif" /></a></div>
             <div class="yuan_top_huan"><a href=""><img src="images/huan.gif" /></a></div>
          </div>
       <!--歌名歌手-->
      <div class="xia">
      <!-- 原创 -->
      		<c:if test="${!empty tenYuan }">
      			<c:forEach items="${tenYuan }" var="song">
      				<div class="yuan_left1">
             			<div class="yuan_left left">${song.sname }</div>
             			<div class="yuan_middle left"><a href="UserSong?temp=2&uid=${song.user.uid}">${song.user.uname}</a></div>
             			<div class="yuan_right left">${song.sclick }次播放</div>
             			<div class="yuan_er left"><a href="UserSong?temp=3&sid=${song.sid }"><img src="images/er.gif"/></a></div>
           			</div>
      			</c:forEach>
      		</c:if>
           
        </div>
    <!--翻唱推荐-->
         <div class="yuan_top">
             <img src="images/yuan.gif"/>
             <div class="yuan_big_font">翻唱推荐</div>
             <div class="yuan_top_bo"><a href="UserSong?temp=5"><img src="images/bo.gif" border="0"/></a></div>
             <div class="yuan_top_huan"><a href=""><img src="images/huan.gif" border="0"/></a></div>
          </div>
         
       <!--歌名歌手-->
       
     <div class="xia">
     		<c:if test="${!empty tenFan}">
     			<c:forEach items="${tenFan }" var="song">
     				<div class="yuan_left1">
             			<div class="yuan_left left">${song.sname }</div>
             			<div class="yuan_middle left"><a href="UserSong?temp=2&uid=${song.user.uid}">${song.user.uname}</a></div>
             			<div class="yuan_right left">${song.sclick }次播放</div>
             			<div class="yuan_er left"><a href="UserSong?temp=3&sid=${song.sid}"><img src="images/er.gif"/></a></div>
           			</div>
     			</c:forEach>
     		</c:if>
        </div>
     </div>
<!--左边1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111-->
      <div class="right yuan3">
          <div align="center" class="hao_top">
              <a href="UserSong?temp=6"><img src="images/hao.gif" /></a>
              <a href="UserSong?temp=6"><img src="images/bo.gif" /></a>
          </div>
          <div class="hao_1">
              <a href="###" onclick="changeSong(0)"><div class="hao_2" id="top0" align="center">翻唱排行</div></a>
              <a href="###" onclick="changeSong(1)"><div class="hao_2" id="top1" align="center">原创候选</div></a>
              <a href="###" onclick="changeSong(2)"><div class="hao_2" id="top2" align="center">原唱排行榜</div></a>
          </div>
          <div class="hao_table" id="min0">
          		<c:if test="${!empty fanPai }">
          		<c:forEach items="${fanPai }" var="song">
          		<div class="hao_middle">
	                 <div class="left"><a href=""><img src="userimages/${ song.user.uimage}"  width="40px" height="40px"/></a></div>
	                 <div class="left hao_big_font"><a href="UserSong?temp=3&sid=${song.sid }">《${song.sname }》</a></div>
	                 <br />
	                 <div>
	                     <div class="left hao_font"><a href="UserSong?temp=2&uid=${song.user.uid}">${song.user.uname}</a></div>
	                     <div class="left hao_font hao_right">${song.sclick}次播放</div>
	                 </div>
                 	 <a href="UserSong?temp=3&sid=${song.sid }"><div class="right hao_11"><img src="images/er.gif" /></div></a>
             	</div>
          		</c:forEach>
         		 </c:if>
            <!-- 第一条-->
          </div>
          <div class="hao_table" id="min1">
          		<c:if test="${!empty yuanHou }">
          	<c:forEach items="${yuanHou }" var="song">
          		<div class="hao_middle">
	                 <div class="left"><a href=""><img src="userimages/${ song.user.uimage}"  width="40px" height="40px"/></a></div>
	                 <div class="left hao_big_font"><a href="UserSong?temp=3&sid=${song.sid }">《${song.sname }》</a></div>
	                 <br />
	                 <div>
	                     <div class="left hao_font"><a href="UserSong?temp=2&uid=${song.user.uid}">${song.user.uname}</a></div>
	                     <div class="left hao_font hao_right">${song.sclick}次播放</div>
	                 </div>
                 	 <a href="UserSong?temp=3&sid=${song.sid }"><div class="right hao_11"><img src="images/er.gif" /></div></a>
             	</div>
          	</c:forEach>
          </c:if>
          		
          		
          		
          </div>
          <div class="hao_table" id="min2">
          		
          		<c:if test="${!empty yuanPai }">
          		<c:forEach items="${yuanPai }" var="song">
          		<div class="hao_middle">
	                 <div class="left"><a href=""><img src="userimages/${ song.user.uimage}"  width="40px" height="40px"/></a></div>
	                 <div class="left hao_big_font"><a href="UserSong?temp=3&sid=${song.sid }">《${song.sname }》</a></div>
	                 <br />
	                 <div>
	                     <div class="left hao_font"><a href="UserSong?temp=2&uid=${song.user.uid}">${song.user.uname}</a></div>
	                     <div class="left hao_font hao_right">${song.sclick}次播放</div>
	                 </div>
                 	 <a href="UserSong?temp=3&sid=${song.sid }"><div class="right hao_11"><img src="images/er.gif" /></div></a>
             	</div>
          		</c:forEach>
         		 </c:if>
          </div>
      
      </div>
</div>
<!--原唱、翻唱推荐-->  


<!--底部歌单等-->
<div class="bottom" >
    <div class="bottom_left left">
           <div class="bottom_left_top">
               <div class="bottom_top_div_color" id="g">
               		<a href="###"  onclick="gd('gd','zj','g','z')"><div class="bottom_top_font" >歌单</div></a>
               </div>
               <div class="bottom_top_div_color2"  id="z">
              	    <a href="###" onclick="gd('zj','gd','z','g')"><div class="bottom_top_font" >专辑</div></a>
               </div>
           </div>
           <!--歌单头部-->
               <div id="gd" class="bottom_left_bottom" align="center">
               		
               			<c:if test="${!empty tenSui }">
          				<c:forEach items="${tenSui }" var="song">
          					<a href="UserSong?temp=3&sid=${song.sid}"><div class="left">
                       		<div class="bottom_img"><img src="userimages/${song.user.uimage}" width="116" height="116"/></div>
                       		<div calss="bottom_img_text"><div class="span_text">${song.sname}</div></div>
                    		</div></a>
          				</c:forEach>
         				 </c:if>
               </div>
           <!--歌单图片-->
          <!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
          <div id="zj" class="bottom_left_bottom2" align="center">
          
          
         		 <c:if test="${!empty tenAlbums }">
          				<c:forEach items="${tenAlbums }" var="album">
          					<a href="UserSong?temp=11&bid=${album.bid}"><div class="left">
                       		<div class="bottom_img"><img src="userimages/${album.bimage}" width="116" height="116"/></div>
                       		<div calss="bottom_img_text">${album.bname}</div>
                    		</div></a>
          				</c:forEach>
         		</c:if>
             </div>
           <!--歌单图片-->
    </div>
   <!-- 歌单、专辑-->
    <div class="bottom_right left">
        <div class="fen">
            <a href="###" onclick="changeFen(0)"><div class="fen_top" id="fen0">下载最多</div></a>
            <a href="###" onclick="changeFen(1)"><div class="fen_top" id="fen1">收藏最多</div></a>
        </div>
        <div class="fen_big" id="fman0">
        
        
        	<c:if test="${!empty topDown }">
          		<c:forEach items="${topDown }" var="song">
          			<div class="fen_little">
                	 <a href="UserSong?temp=3&sid=${song.sid }"><div class="left fen_img"><img src="userimages/${song.user.uimage}" /></div>
                	 <div class="left fen_font">${song.sname}</div></a>
                 	<br />
                 	<div class="left fen_little_font"><div class="span_text">${song.stext}</div></div>
                 	<a href="UserSong?temp=3&sid=${song.sid }"><div class="right fen_little_ting"><img src="images/er.gif" /></div></a>
            		</div>
          		</c:forEach>
         	</c:if>
        <!--  第一条！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-->
            <!-- <div class="fen_little">
                 <a href="###"><div class="left fen_img"><img src="images/fen1.jpg" /></div>
                 <div class="left fen_font">古风—【天龙八部之回目曲】</div></a>
                 <br />
                 <div class="left fen_little_font">—ssssssss裂天—</div>
                 <a href=""><div class="right fen_little_ting"><img src="images/er.gif" /></div></a>
            </div> -->
      <!--  第一条！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-->
        </div>
        <div class="fen_big" id="fman1">
        	<c:if test="${!empty topCum }">
          		<c:forEach items="${topCum }" var="song">
          			<div class="fen_little">
                	 <a href="UserSong?temp=3&sid=${song.sid }"><div class="left fen_img"><img src="userimages/${song.user.uimage}" /></div>
                	 <div class="left fen_font">${song.sname}</div></a>
                 	<br />
                 	<div class="left fen_little_font"><div class="span_text">${song.stext}</div></div>
                 	<a href="UserSong?temp=3&sid=${song.sid }"><div class="right fen_little_ting"><img src="images/er.gif" /></div></a>
            		</div>
          		</c:forEach>
         	</c:if>
        </div>
    
    </div>
</div>
<!--底部歌单等-->
<!--底部赞助商商标等-->
<div class="di">
  <div class="di_left">
    <div><img src="images/bottom_logo.gif" /></div>
    <div class="di_div">
        <ul class="di_ul">
           <li><a href="">关于我们</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="">权利声明</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">商务合作</a></li>
           <li><a href="">合作伙伴</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href="">诚聘英才</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">联系我们</a></li>
        </ul>
    </div>
  </div>
<!-- 底部左边-->
<div class="di_middle">
    <div class="di_he_font">合作伙伴</div>
    <br />
    <a href=""><img src="images/logo1.gif" /></a>&nbsp;
    <a href=""><img src="images/logo2.gif" /></a>&nbsp;
    <a href=""><img src="images/logo3.gif" /></a>&nbsp;
    <a href=""><img src="images/logo4.gif" /></a>
</div>
<!-- 底部中间-->
<div class="di_right">
     <div class="di_he_font">实用话题</div>
     <div class="di_right_font">
     1、警方提醒：警惕短信诈骗&nbsp;&nbsp;&nbsp;2、申请网站推荐歌手和明星..<br />
     3、投诉建议请到此处跟贴&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4、申请网站推荐歌曲
     </div>
</div>
 <!--底部右边-->
   <div class="di_bottom" align="center">
      网络文化经营许可证： 文网文2010-175号 增值电信业务经营许可证粤B2-20060339 粤ICP备09017694号 网络视听许可证1910564号
    </div>
</div>
<!--底部赞助商商标等-->


<!--顶部菜单栏结束-->
</body>
</html>