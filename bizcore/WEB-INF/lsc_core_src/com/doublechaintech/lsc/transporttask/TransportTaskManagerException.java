
package com.doublechaintech.lsc.transporttask;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransportTaskManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransportTaskManagerException(String string) {
		super(string);
	}
	public TransportTaskManagerException(Message message) {
		super(message);
	}
	public TransportTaskManagerException(List<Message> messageList) {
		super(messageList);
	}

}


