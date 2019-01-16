
package com.doublechaintech.lsc.transportitem;
import com.doublechaintech.lsc.EntityNotFoundException;

public class TransportItemVersionChangedException extends TransportItemManagerException {
	private static final long serialVersionUID = 1L;
	public TransportItemVersionChangedException(String string) {
		super(string);
	}


}


