
package com.doublechaintech.lsc.transaction;
import com.doublechaintech.lsc.EntityNotFoundException;

public class TransactionVersionChangedException extends TransactionManagerException {
	private static final long serialVersionUID = 1L;
	public TransactionVersionChangedException(String string) {
		super(string);
	}


}


