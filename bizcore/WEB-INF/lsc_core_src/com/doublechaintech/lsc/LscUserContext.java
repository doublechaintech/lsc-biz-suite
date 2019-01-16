package com.doublechaintech.lsc;

public interface LscUserContext extends UserContext{
    //define the domain specific user model
	String getLocaleKey(String subject);
	void setChecker(LscChecker checker);
	LscChecker getChecker();
}

