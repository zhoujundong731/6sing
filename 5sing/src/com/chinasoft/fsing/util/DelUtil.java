package com.chinasoft.fsing.util;

import java.io.File;

public class DelUtil {
	public static void DelFile(String filePath){
		File file=new File(filePath);
		if(file.exists()){
			file.delete();
		}
	}
}
