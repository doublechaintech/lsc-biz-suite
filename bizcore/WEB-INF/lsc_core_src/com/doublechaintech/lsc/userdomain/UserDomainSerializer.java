package com.doublechaintech.lsc.userdomain;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.lsc.LscObjectPlainCustomSerializer;
public class UserDomainSerializer extends LscObjectPlainCustomSerializer<UserDomain>{

	@Override
	public void serialize(UserDomain userDomain, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userDomain, provider);
		
	}
}


