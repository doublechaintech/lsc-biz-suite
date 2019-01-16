
package com.doublechaintech.lsc.formfieldmessage;
//import com.doublechaintech.lsc.EntityNotFoundException;
import com.doublechaintech.lsc.LscException;
import com.doublechaintech.lsc.Message;
import java.util.List;

public class FormFieldMessageManagerException extends LscException {
	private static final long serialVersionUID = 1L;
	public FormFieldMessageManagerException(String string) {
		super(string);
	}
	public FormFieldMessageManagerException(Message message) {
		super(message);
	}
	public FormFieldMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


