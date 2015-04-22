<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专辑页面</title>
 <link href="style/type.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!---z整个大的div-->
<div align="center" >
   <!--头部的开始-->
   <div class="top_type">
       <!--专辑图片-->
      <div class="type_picture">
          
         <img src="userimages/${album.bimage }"   alt="${album.bname }"/>
      </div>
      <!--专辑介绍-->
      <div class="type_name">
         <table width="200" border="0">
                   <tr>
                         <td height="37">专辑名:${album.bname }</td>
                   </tr>
                   <tr>
                        <td height="52">简介：${album.btext}</td>
                   </tr>
         </table>
      </div>
   </div>
   <!--主体表的开始-->
   <div>
   <table width="600" border="0" cellpadding="0px" cellspacing="0px" class="t1">
     <tr align="center" bgcolor="#663300" >
           <td width="100">歌曲名</td>
           <td width="100">歌曲简介</td>
           <td width="100">点击量</td>
           <td width="100">收藏量</td>
           <td width="100">下载量</td>
           <td width="100">操作</td>
    </tr>
    <c:if test="${!empty album.songs}">
     <c:forEach items="${album.songs }" var="song">
    <tr>
           <td width="100">${song.sname }</td>
           <td width="100"><div class="span_text">${song.stext}</div></td>
           <td width="100">${song.sclick }</td>
           <td width="100">${song.scnum}</td>
           <td width="100">${song.sdown}</td>
           <td width="100"><a href="UserSong?temp=3&sid=${song.sid}">试听</a></td>
  	</tr>
  	</c:forEach>
  	</c:if>
</table>

   </div>
</div>
</body>
</html>
