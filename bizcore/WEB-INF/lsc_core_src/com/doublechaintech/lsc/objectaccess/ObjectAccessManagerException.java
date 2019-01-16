
package com.doublechaintech.lsc.objectaccess;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class ObjectAccessManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessManagerException(String string) {
		super(string);
	}
	public ObjectAccessManagerException(Message message) {
		super(message);
	}
	public ObjectAccessManagerException(List<Message> messageList) {
		super(messageList);
	}

}


