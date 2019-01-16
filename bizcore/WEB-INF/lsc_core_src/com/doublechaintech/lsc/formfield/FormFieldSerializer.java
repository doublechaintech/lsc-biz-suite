package com.doublechaintech.lsc.formfield;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class FormFieldSerializer extends LscObjectPlainCustomSerializer<FormField>{

	@Override
	public void serialize(FormField formField, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, formField, provider);
		
	}
}


