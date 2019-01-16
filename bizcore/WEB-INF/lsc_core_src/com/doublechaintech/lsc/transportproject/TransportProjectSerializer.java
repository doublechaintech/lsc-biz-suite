package com.doublechaintech.lsc.transportproject;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class TransportProjectSerializer extends LscObjectPlainCustomSerializer<TransportProject>{

	@Override
	public void serialize(TransportProject transportProject, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportProject, provider);
		
	}
}


