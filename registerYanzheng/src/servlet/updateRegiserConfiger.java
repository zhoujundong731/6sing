package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.RegisterCon;

/**
 * Servlet implementation class updateRegiserConfiger
 */
@WebServlet("/updateRegiserConfiger")
public class updateRegiserConfiger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateRegiserConfiger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, String> map=(HashMap<String, String>) request.getServletContext().getAttribute(RegisterCon.RE_MAP); 
    	/*//宽度
    	String strWidth =map.get(RegisterCon.RE_WIDTH);        
        // 高度        
        String strHeight =map.get(RegisterCon.RE_HEIGHT);        
        // 字符个数        
        String strCodeCount = map.get(RegisterCon.RE_CODECOUNT);
        //干扰线条数
        String strlineCount = map.get(RegisterCon.RE_LINECOUNT);*/
		map.put(RegisterCon.RE_WIDTH, "300");
		 request.getServletContext().setAttribute(RegisterCon.RE_MAP, map);
		 System.out.println("修改完成");
		 response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
