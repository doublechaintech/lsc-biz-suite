package com.doublechaintech.lsc.merchanttype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class MerchantTypeSerializer extends LscObjectPlainCustomSerializer<MerchantType>{

	@Override
	public void serialize(MerchantType merchantType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, merchantType, provider);
		
	}
}


