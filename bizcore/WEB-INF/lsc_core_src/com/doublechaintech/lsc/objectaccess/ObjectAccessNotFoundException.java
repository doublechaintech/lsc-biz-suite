
package com.doublechaintech.lsc.objectaccess;
import com.doublechaintech.lsc.EntityNotFoundException;
public class ObjectAccessNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessNotFoundException(String string) {
		super(string);
	}

}

