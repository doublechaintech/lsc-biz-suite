
package com.doublechaintech.lsc.transportitem;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransportItemManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransportItemManagerException(String string) {
		super(string);
	}
	public TransportItemManagerException(Message message) {
		super(message);
	}
	public TransportItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


