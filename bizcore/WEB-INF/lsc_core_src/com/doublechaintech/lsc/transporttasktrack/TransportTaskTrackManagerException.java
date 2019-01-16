
package com.doublechaintech.lsc.transporttasktrack;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransportTaskTrackManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransportTaskTrackManagerException(String string) {
		super(string);
	}
	public TransportTaskTrackManagerException(Message message) {
		super(message);
	}
	public TransportTaskTrackManagerException(List<Message> messageList) {
		super(messageList);
	}

}


