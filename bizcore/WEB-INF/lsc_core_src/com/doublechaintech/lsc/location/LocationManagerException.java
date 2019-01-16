
package com.doublechaintech.lsc.location;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class LocationManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public LocationManagerException(String string) {
		super(string);
	}
	public LocationManagerException(Message message) {
		super(message);
	}
	public LocationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


