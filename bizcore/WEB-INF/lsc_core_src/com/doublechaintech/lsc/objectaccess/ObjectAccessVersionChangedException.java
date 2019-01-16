
package com.doublechaintech.lsc.objectaccess;
import com.doublechaintech.lsc.EntityNotFoundException;

public class ObjectAccessVersionChangedException extends ObjectAccessManagerException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessVersionChangedException(String string) {
		super(string);
	}


}


