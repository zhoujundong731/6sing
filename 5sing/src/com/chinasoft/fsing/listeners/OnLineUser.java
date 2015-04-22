package com.chinasoft.fsing.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.chinasoft.fsing.vo.User;

/**
 * Application Lifecycle Listener implementation class OnLineUser
 *
 */
public class OnLineUser implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private int count=0;
	private List<String> onLineUser=null;
    /**
     * Default constructor. 
     */
    public OnLineUser() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        User user=(User)arg0.getSession().getAttribute("user");
        if(user!=null&&!"".equals(user)){
        	ServletContext application=arg0.getSession().getServletContext();
        	onLineUser=(List<String>)application.getAttribute("onLineUser");
        	if(!onLineUser.contains(user.getUaccount())){
        		count=(int)application.getAttribute("OnUserCount");
        		count++;
        		System.out.println("用户人数：（增）"+count);
        		application.setAttribute("OnUserCount", count);
        		onLineUser.add(user.getUaccount());
        		application.setAttribute("onLineUser", onLineUser);
        		System.out.println(onLineUser);
        	}
        	
        }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        ServletContext application=arg0.getServletContext();
        application.setAttribute("OnUserCount", count);
        onLineUser=new ArrayList<>();
        application.setAttribute("onLineUser", onLineUser);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	 User user=(User)arg0.getSession().getAttribute("user");
    	 if(user!=null&&!"".equals(user)){
         	ServletContext application=arg0.getSession().getServletContext();
         	onLineUser=(List<String>)application.getAttribute("onLineUser");
         	if(onLineUser.contains(user.getUaccount())){
         		count=(int)application.getAttribute("OnUserCount");
         		count--;
         		System.out.println("用户人数：（减）"+count);
         		application.setAttribute("OnUserCount", count);
         		onLineUser.remove(user.getUaccount());
         		application.setAttribute("onLineUser", onLineUser);
         		System.out.println(onLineUser);
         	}
         	
         }
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
