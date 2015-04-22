package Test;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import com.zhou.util.md5.MD5Util;

public class Tesy {
	public static void main(String[] args) {
		try {
			System.out.println(MD5Util.getMD5Encode(""));
		} catch (UnsupportedEncodingException e) {
			Logger log=Logger.getLogger("ss");
			log.info("chucuo ");
			e.printStackTrace();
		}
	}
}
