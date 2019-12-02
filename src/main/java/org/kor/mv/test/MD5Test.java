package org.kor.mv.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
public class MD5Test {

	public static void main(String[] args) {
		
		//Source
		String source ="123";
		
		//salt
		String salt = "qwerty";
		
		int hashIterations = 2;
		
		
		Md5Hash md5Hash = new Md5Hash(source,salt,hashIterations);
		
		
		String password_md5 = md5Hash.toString(); 
		
		System.out.println(password_md5);
		
		
		SimpleHash simpleHash = new SimpleHash("md5",source,salt,hashIterations);
		System.out.println(simpleHash.toString());
	}
}
