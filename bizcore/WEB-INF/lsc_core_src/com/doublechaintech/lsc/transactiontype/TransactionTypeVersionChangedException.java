
package com.doublechaintech.lsc.transactiontype;
import com.doublechaintech.lsc.EntityNotFoundException;

public class TransactionTypeVersionChangedException extends TransactionTypeManagerException {
	private static final long serialVersionUID = 1L;
	public TransactionTypeVersionChangedException(String string) {
		super(string);
	}


}


