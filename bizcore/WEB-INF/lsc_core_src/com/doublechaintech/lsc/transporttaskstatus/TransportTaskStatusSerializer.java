package com.doublechaintech.lsc.transporttaskstatus;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class TransportTaskStatusSerializer extends LscObjectPlainCustomSerializer<TransportTaskStatus>{

	@Override
	public void serialize(TransportTaskStatus transportTaskStatus, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportTaskStatus, provider);
		
	}
}


