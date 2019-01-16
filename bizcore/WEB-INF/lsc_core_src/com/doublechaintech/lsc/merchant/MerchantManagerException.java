
package com.doublechaintech.lsc.merchant;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class MerchantManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public MerchantManagerException(String string) {
		super(string);
	}
	public MerchantManagerException(Message message) {
		super(message);
	}
	public MerchantManagerException(List<Message> messageList) {
		super(messageList);
	}

}


