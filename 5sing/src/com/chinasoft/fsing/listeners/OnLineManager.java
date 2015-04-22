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

import com.chinasoft.fsing.vo.Manager;
import com.chinasoft.fsing.vo.User;

/**
 * Application Lifecycle Listener implementation class OnLineManager
 *
 */
public class OnLineManager implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
	private int count=0;
	private List<String> onLineMan;
    /**
     * Default constructor. 
     */
    public OnLineManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0) {
    	Manager man=(Manager)arg0.getSession().getAttribute("manager");
        if(man!=null&&!"".equals(man)){
        	ServletContext application=arg0.getSession().getServletContext();
        	onLineMan=(List<String>)application.getAttribute("onLineMan");
        	if(!onLineMan.contains(man.getMname())){
        		count=(int)application.getAttribute("OnManCount");
        		count++;
        		System.out.println("管理员人数：（增）:::"+count);
        		application.setAttribute("OnManCount", count);
        		onLineMan.add(man.getMname());
        		application.setAttribute("onLineMan", onLineMan);
        		System.out.println(onLineMan);
        	}
        	
        }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ServletContext application=arg0.getServletContext();
        application.setAttribute("OnManCount", count);
        onLineMan=new ArrayList<>();
        application.setAttribute("onLineMan", onLineMan);
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
    	Manager man=(Manager)arg0.getSession().getAttribute("manager");
        if(man!=null&&!"".equals(man)){
        	ServletContext application=arg0.getSession().getServletContext();
        	onLineMan=(List<String>)application.getAttribute("onLineMan");
        	if(onLineMan.contains(man.getMname())){
        		count=(int)application.getAttribute("OnManCount");
        		count--;
        		System.out.println("管理员人数：（减）:::"+count);
        		application.setAttribute("OnManCount", count);
        		onLineMan.remove(man.getMname());
        		application.setAttribute("onLineUser", onLineMan);
        		System.out.println("在线人"+onLineMan);
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
