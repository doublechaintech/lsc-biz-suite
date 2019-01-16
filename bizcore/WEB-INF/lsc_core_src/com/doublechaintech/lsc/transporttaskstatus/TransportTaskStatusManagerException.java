
package com.doublechaintech.lsc.transporttaskstatus;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransportTaskStatusManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransportTaskStatusManagerException(String string) {
		super(string);
	}
	public TransportTaskStatusManagerException(Message message) {
		super(message);
	}
	public TransportTaskStatusManagerException(List<Message> messageList) {
		super(messageList);
	}

}


