
package com.doublechaintech.lsc.loginhistory;
import com.doublechaintech.lsc.EntityNotFoundException;

public class LoginHistoryVersionChangedException extends LoginHistoryManagerException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryVersionChangedException(String string) {
		super(string);
	}


}


