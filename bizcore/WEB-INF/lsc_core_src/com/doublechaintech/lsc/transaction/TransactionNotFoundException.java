
package com.doublechaintech.lsc.transaction;
import com.doublechaintech.lsc.EntityNotFoundException;
public class TransactionNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public TransactionNotFoundException(String string) {
		super(string);
	}

}

