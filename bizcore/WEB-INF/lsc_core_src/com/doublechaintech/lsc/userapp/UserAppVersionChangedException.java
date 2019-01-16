
package com.doublechaintech.lsc.userapp;
import com.doublechaintech.lsc.EntityNotFoundException;

public class UserAppVersionChangedException extends UserAppManagerException {
	private static final long serialVersionUID = 1L;
	public UserAppVersionChangedException(String string) {
		super(string);
	}


}


