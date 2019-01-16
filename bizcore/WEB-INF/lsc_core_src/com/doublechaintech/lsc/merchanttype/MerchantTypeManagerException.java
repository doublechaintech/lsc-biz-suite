
package com.doublechaintech.lsc.merchanttype;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class MerchantTypeManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public MerchantTypeManagerException(String string) {
		super(string);
	}
	public MerchantTypeManagerException(Message message) {
		super(message);
	}
	public MerchantTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


