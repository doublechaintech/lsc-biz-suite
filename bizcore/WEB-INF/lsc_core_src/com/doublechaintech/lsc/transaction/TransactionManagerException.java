
package com.doublechaintech.lsc.transaction;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransactionManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransactionManagerException(String string) {
		super(string);
	}
	public TransactionManagerException(Message message) {
		super(message);
	}
	public TransactionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


