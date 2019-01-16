
package com.doublechaintech.lsc.userdomain;
import com.doublechaintech.lsc.EntityNotFoundException;

public class UserDomainVersionChangedException extends UserDomainManagerException {
	private static final long serialVersionUID = 1L;
	public UserDomainVersionChangedException(String string) {
		super(string);
	}


}


