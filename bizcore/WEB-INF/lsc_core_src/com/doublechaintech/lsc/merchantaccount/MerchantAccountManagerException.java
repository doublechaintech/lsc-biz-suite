
package com.doublechaintech.lsc.merchantaccount;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class MerchantAccountManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public MerchantAccountManagerException(String string) {
		super(string);
	}
	public MerchantAccountManagerException(Message message) {
		super(message);
	}
	public MerchantAccountManagerException(List<Message> messageList) {
		super(messageList);
	}

}


