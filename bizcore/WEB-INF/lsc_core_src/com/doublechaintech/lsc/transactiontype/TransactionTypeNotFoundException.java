
package com.doublechaintech.lsc.transactiontype;
import com.doublechaintech.lsc.EntityNotFoundException;
public class TransactionTypeNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public TransactionTypeNotFoundException(String string) {
		super(string);
	}

}

