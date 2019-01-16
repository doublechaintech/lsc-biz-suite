package com.doublechaintech.lsc.transactiontype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class TransactionTypeSerializer extends LscObjectPlainCustomSerializer<TransactionType>{

	@Override
	public void serialize(TransactionType transactionType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transactionType, provider);
		
	}
}


