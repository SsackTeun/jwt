package com.github.ssackteun.portal.jwt.utils.token;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JwtTokenSerializer extends StdSerializer<JwtToken> {

	public JwtTokenSerializer(){
		this(null);
	}

	public JwtTokenSerializer(Class<JwtToken> t) {
		super(t);
	}

	@Override
	public void serialize(JwtToken value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		//JWT - header
		gen.writeStringField("alg", value.getAlg()); // Algorithm
		gen.writeStringField("typ", value.getTyp()); // type (Hmac)
		gen.writeStringField("domain", value.getDomain()); //domain

		//JWT - payload
		gen.writeStringField("username",value.getAcct()); // Account
		gen.writeNumberField("iat", value.getIat()); //issued at
		gen.writeNumberField("exp", value.getExp()); // expiration

		//Permission need Array
		gen.writeStartArray("perms"); // Service Permisson
		for(String permission : value.getPerms()){
			gen.writeString(permission);
		}
		gen.writeEndArray();


	}
}
