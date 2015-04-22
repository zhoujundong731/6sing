<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="div_userInfo_main">
	<div class="userInfo_top">
    	<div class="userInfo_left left">
        	<img alt="${user.uname }" src="../userimages/${user.uimage}" />
        </div>
        <div class="userInfo_middle left">
        	<span class="span_uaccount">账号：${user.uaccount}</span><br/><br />
        	<span class="span_uname">姓名：<c:if test="${empty user.uname}">暂无信息</c:if>${user.uname }</span><br/><br/><br />
        	<span class="span_usign">个性签名：
        	<c:if test="${empty user.usign }">暂无信息</c:if>${user.usign}</span><br/><br/>
        	<a href="userIndex.jsp?page=userInfo.jsp">个人信息详情>>>>></a>
        </div>
        <div class="userInfo_right left">
        	 <div  class="right_main">
        		<a href="userIndex.jsp?page=addSong.jsp"><div class="right_div1 left">
        		上传歌曲
        		</div></a>
        		<a href="UserIndex?temp=4&uid=${user.uid}"><div class="right_div2 left">
        		管理歌曲
        		</div></a>
        	</div> 
        </div>
    </div>
    <div class="userInfo_foot">
    	<c:if test="${!empty menus}">
    	<ul>
    		<c:forEach items="${menus}" var="menu">
    			<c:if test="${!empty menu.submenus}">
    				<c:forEach items="${menu.submenus}" var="sub">
    					<c:if test="${sub.isdirect==0}">
								<li><a href="${sub.supath}">${sub.suname}</a></li>
							</c:if>
							<c:if test="${sub.isdirect==1}">
								<li><a href="userIndex.jsp?page=${sub.supath }.jsp">${sub.suname}</a></li>
							</c:if> 
    				</c:forEach>
    			</c:if>
    		</c:forEach>
    	</ul>
    	</c:if>
    </div>
</div>