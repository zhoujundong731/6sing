package test;

import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends javax.mail.Authenticator {
	String userName;  
	String password;  
	public MyAuthenticator(){  

	}  
	public MyAuthenticator(String userName,String password){  
		this.userName=userName.trim();  
		this.password=password.trim();  
	}  
	protected PasswordAuthentication getPasswordAuthentication(){  
		return new PasswordAuthentication(userName, password);     
	}   
}
