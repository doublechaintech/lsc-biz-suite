package com.doublechaintech.lsc.merchant;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class MerchantSerializer extends LscObjectPlainCustomSerializer<Merchant>{

	@Override
	public void serialize(Merchant merchant, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, merchant, provider);
		
	}
}


