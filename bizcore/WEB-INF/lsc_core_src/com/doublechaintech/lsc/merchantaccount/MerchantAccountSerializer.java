package com.doublechaintech.lsc.merchantaccount;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class MerchantAccountSerializer extends LscObjectPlainCustomSerializer<MerchantAccount>{

	@Override
	public void serialize(MerchantAccount merchantAccount, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, merchantAccount, provider);
		
	}
}


