package register;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.RegisterCon;

/**
 * Servlet implementation class CodeServlet
 */
@WebServlet("/CodeServlet")
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 验证码图片的宽度。        
    private int width = 60;        
    // 验证码图片的高度。        
    private int height = 20;        
    // 验证码字符个数        
    private int codeCount = 4;        
    private int x = 0;        
    // 字体高度        
    private int fontHeight;        
    private int codeY;        
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',        
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',        
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };  
    public void initxuan(HttpServletRequest request) throws ServletException {  
    	HashMap<String, String> map=(HashMap<String, String>) request.getServletContext().getAttribute(RegisterCon.RE_MAP);
        // 从web.xml中获取初始信息        
        // 宽度        
        /*String strWidth ="100";        
        // 高度        
        String strHeight ="30";        
        // 字符个数        
        String strCodeCount = "4";*/  
    	String strWidth =map.get(RegisterCon.RE_WIDTH);        
        // 高度        
        String strHeight =map.get(RegisterCon.RE_HEIGHT);        
        // 字符个数        
        String strCodeCount = map.get(RegisterCon.RE_CODECOUNT);
        System.out.println("获取成功！");
        // 将配置的信息转换成数值        
        try {        
            if (strWidth != null && strWidth.length() != 0) {        
                width = Integer.parseInt(strWidth);        
            }        
            if (strHeight != null && strHeight.length() != 0) {        
                height = Integer.parseInt(strHeight);        
            }        
            if (strCodeCount != null && strCodeCount.length() != 0) {        
                codeCount = Integer.parseInt(strCodeCount);        
            }        
        } catch (NumberFormatException e) {        
        }        
        x = (width - width/10 )/ (codeCount);
        fontHeight = height-height/10;        
    }   
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			CodeBiz biz=new CodeBiz();
			biz.getCode(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
