package com.doublechaintech.lsc.transaction;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class TransactionSerializer extends LscObjectPlainCustomSerializer<Transaction>{

	@Override
	public void serialize(Transaction transaction, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transaction, provider);
		
	}
}


