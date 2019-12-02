package org.kor.mv.auth.token;

import org.apache.shiro.authc.AuthenticationToken;

public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    public Object getPrincipal() {
		// TODO Auto-generated method stub
		return token;
	}

    public Object getCredentials() {
		// TODO Auto-generated method stub
		return token;
	}

}
