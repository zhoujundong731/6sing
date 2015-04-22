package register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Yanzheng
 */
@WebServlet("/Yanzheng")
public class Yanzheng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Yanzheng() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");        
         String validateC = (String) request.getSession().getAttribute("validateCode");        
         String veryCode = request.getParameter("c");        
         PrintWriter out = response.getWriter();
         if(veryCode==null||"".equals(veryCode)){        
             out.println("验证码为空");    
         }else{        
             if(validateC.equalsIgnoreCase(veryCode)){        
                 out.println("验证码正确");   
                 System.out.println("验证码正确");   
             }else{        
                 out.println("验证码错误"); 
                 System.out.println("验证码错误");  
             }        
         }        
         out.flush();        
         out.close();         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
