
package com.doublechaintech.lsc.transportproject;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransportProjectManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransportProjectManagerException(String string) {
		super(string);
	}
	public TransportProjectManagerException(Message message) {
		super(message);
	}
	public TransportProjectManagerException(List<Message> messageList) {
		super(messageList);
	}

}


