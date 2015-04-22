package entity;

import org.apache.log4j.Logger;

public class Log4jTest02 {
	public static void main(String[] args) {
		Logger log=Logger.getLogger(Log4jTest02.class);
		log.error("");
		log.debug("");
		log.info("");
	}
}
