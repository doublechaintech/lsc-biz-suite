
package com.doublechaintech.lsc.location;
import com.doublechaintech.lsc.EntityNotFoundException;

public class LocationVersionChangedException extends LocationManagerException {
	private static final long serialVersionUID = 1L;
	public LocationVersionChangedException(String string) {
		super(string);
	}


}


