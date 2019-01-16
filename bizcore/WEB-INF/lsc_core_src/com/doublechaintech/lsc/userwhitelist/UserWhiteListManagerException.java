
package com.doublechaintech.lsc.userwhitelist;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class UserWhiteListManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public UserWhiteListManagerException(String string) {
		super(string);
	}
	public UserWhiteListManagerException(Message message) {
		super(message);
	}
	public UserWhiteListManagerException(List<Message> messageList) {
		super(messageList);
	}

}


