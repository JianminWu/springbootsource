package com.resolver.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class MoneyJsonDeserializer extends StdDeserializer<Money> {
	public MoneyJsonDeserializer() {
		this(null);
	}

	public MoneyJsonDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Money deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		double  value = p.getValueAsDouble();
	    return new Money(value);
	}
	@Override
	public Class<Money> handledType() {
		return Money.class;
	}
}
