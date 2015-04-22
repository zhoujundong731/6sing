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
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.RegisterCon;

public class CodeBiz {
	private static final long serialVersionUID = 1L;
	// 验证码图片的宽度。        
    private int width = 60;        
    // 验证码图片的高度。        
    private int height = 20;        
    // 验证码字符个数        
    private int codeCount = 4; 
    private int lineCount=1;
    private int x = 0;        
    // 字体高度        
    private int fontHeight;        
    private int codeY;        
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',        
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',        
            'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    
    public void initxuan(HttpServletRequest request) throws ServletException {  
    	HashMap<String, String> map=(HashMap<String, String>) request.getServletContext().getAttribute(RegisterCon.RE_MAP); 
    	//宽度
    	String strWidth =map.get(RegisterCon.RE_WIDTH);        
        // 高度        
        String strHeight =map.get(RegisterCon.RE_HEIGHT);        
        // 字符个数        
        String strCodeCount = map.get(RegisterCon.RE_CODECOUNT);
        //干扰线条数
        String strlineCount = map.get(RegisterCon.RE_LINECOUNT);
        // 将配置的信息转换成数值        
        try {        
            if (strWidth != null && strWidth.length() != 0) {        
                width = Integer.parseInt(strWidth);        
            }        
            if (strHeight != null && strHeight.length() != 0) {        
                height = Integer.parseInt(strHeight);        
            }        
            if (strlineCount != null && strlineCount.length() != 0) {        
                lineCount = Integer.parseInt(strlineCount);        
            }
            if(strCodeCount!=null && strCodeCount.length()!=0){
            	
            }
        } catch (NumberFormatException e) {        
        }        
        x = (width - width/10 )/ (codeCount);
        fontHeight = height-height/10;        
    }   
    
    public void getCode(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    	initxuan(request);
        // 定义图像buffer        
        BufferedImage buffImg = new BufferedImage(width, height,        
                BufferedImage.TYPE_INT_RGB);        
        Graphics2D g = buffImg.createGraphics(); 
        // 创建一个随机数生成器类        
        Random random = new Random();        
        // 将图像填充为白色        
        g.setColor(Color.WHITE);        
        g.fillRect(0, 0, width, height);        
        // 创建字体，字体的大小应该根据图片的高度来定。        
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);        
        // 设置字体。        
        g.setFont(font);        
        // 画边框。        
        g.setColor(Color.BLACK);        
        g.drawRect(0, 0, width - 1, height - 1);        
        // 随机产生10条干扰线，使图象中的认证码不易被其它程序探测到。        
        g.setColor(Color.BLACK); 
        
        //设置codeY的值
        FontMetrics fm=g.getFontMetrics();
        int ascent=fm.getAscent();
        int descent=fm.getDescent();
        codeY=height/2+(ascent-descent)/2;
        
        for (int i = 0; i < lineCount; i++) {        
            int x = random.nextInt(width);        
            int y = random.nextInt(height);        
            int xl = random.nextInt(height/2);        
            int yl = random.nextInt(height/2);        
            g.drawLine(x, y, x + xl, y + yl);        
        }        
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。        
        StringBuffer randomCode = new StringBuffer();        
        int red = 0, green = 0, blue = 0;        
        // 随机产生codeCount数字的验证码。        
        for (int i = 0; i < codeCount; i++) {        
            // 得到随机产生的验证码数字。        
            String strRand = String.valueOf(codeSequence[random.nextInt(36)]);        
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。        
            red = random.nextInt(255);        
            green = random.nextInt(255);        
            blue = random.nextInt(255);        
            // 用随机产生的颜色将验证码绘制到图像中。        
            g.setColor(new Color(red, green, blue));        
            g.drawString(strRand, (i * x)+width/20, codeY);  
            // 将产生的四个随机数组合在一起。        
            randomCode.append(strRand);        
        }        
        // 将四位数字的验证码保存到Session中。        
        HttpSession session = request.getSession();        
        session.setAttribute("validateCode", randomCode.toString());
        System.out.println(session.getAttribute("validateCode"));
        // 禁止图像缓存。        
        response.setHeader("Pragma", "no-cache");        
        response.setHeader("Cache-Control", "no-cache");        
        response.setDateHeader("Expires", 0);        
        response.setContentType("image/jpeg");
//        response.setStatus(302 );
//        response.setHeader("Location", "register.jsp");
        // 将图像输出到Servlet输出流中。      
        ServletOutputStream sos = response.getOutputStream();        
        ImageIO.write(buffImg, "jpeg", sos);        
        sos.close();   
    }
}
