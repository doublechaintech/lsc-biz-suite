package com.doublechaintech.lsc.transportitem;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class TransportItemSerializer extends LscObjectPlainCustomSerializer<TransportItem>{

	@Override
	public void serialize(TransportItem transportItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportItem, provider);
		
	}
}


