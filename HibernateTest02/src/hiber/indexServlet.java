package hiber;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.cfg.Configuration;

import SessionFactory.MySession;
import entity.HibernateTest;
import entity.TestMain;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Random random=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 random=new Random(1000);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	TestMain main=new TestMain();
		main.test();*/
		HibernateTest test=new HibernateTest();
		test.sethId((long) random.nextInt(1000));
		test.sethName("haha");
		test.sethNum(55D);
		test.sethAge(45);
		System.out.println(test.toString());
		MySession session=new MySession();
		if(session.test(test)){
			response.sendRedirect("11.jsp");
		}else{
			response.sendRedirect("index.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
