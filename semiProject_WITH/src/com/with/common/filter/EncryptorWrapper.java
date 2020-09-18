package com.with.common.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptorWrapper extends HttpServletRequestWrapper {

	public EncryptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	// Write method that want to redefine
	@Override
	public String getParameter(String name) {
		// make password data encrypted
		String returnValue="";
		// should check both password and Password
		// can find password at sidebar.jsp
		// and Password at joinMember.jsp
		if(name.equals("Password")||name.equals("password")) {
			// encrypt and send
			String pw = super.getParameter(name);
			String encPw=getSha512(pw);
			returnValue =encPw;
		}else {
			returnValue=super.getParameter(name);
		}
		return returnValue;
	}
	
	private String getSha512(String value) {
		//store encrypted value
		String encPwd=null;
		//encrypting object 
		MessageDigest md = null;
		//Call encrypting algorithm
		try {
			md=MessageDigest.getInstance("SHA-512");
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// run encrypting process by using algorithm
		// Change password value into byte type.
		byte[] bytes=value.getBytes(Charset.forName("UTF-8"));
		// encrypt byte value by MessageDigest
		md.update(bytes);
		
		// Change encrypted value to String
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		// return result
		return encPwd;
	}
	

}
