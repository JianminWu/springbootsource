package com.resolver.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class MoneyJsonSerializer extends JsonSerializer<Money> {
	
	@Override
	public void serialize(Money value, JsonGenerator jgen, SerializerProvider provider)	throws IOException,
			JsonProcessingException {
		jgen.writeNumber(value.getAmount());
	}
	
	@Override
	public Class<Money> handledType() {
		return Money.class;
	}
}
