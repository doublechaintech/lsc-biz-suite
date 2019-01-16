
package com.doublechaintech.lsc.transactiontype;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class TransactionTypeManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public TransactionTypeManagerException(String string) {
		super(string);
	}
	public TransactionTypeManagerException(Message message) {
		super(message);
	}
	public TransactionTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


