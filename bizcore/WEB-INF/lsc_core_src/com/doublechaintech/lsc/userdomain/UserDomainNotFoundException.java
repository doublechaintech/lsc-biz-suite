
package com.doublechaintech.lsc.userdomain;
import com.doublechaintech.lsc.EntityNotFoundException;
public class UserDomainNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public UserDomainNotFoundException(String string) {
		super(string);
	}

}

